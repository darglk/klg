package com.klg.client.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@Slf4j
public class ReqFilter extends OncePerRequestFilter {

  @Value("${api.key.username}")
  private String apiKeyUsername;
  @Value("${api.key.password}")
  private String apiKeyPassword;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {
    var header = request.getHeader("x-api-key");
    if (header == null) {
      log.error("Api key is null");
      response.setStatus(401);
      return;
    }
    try {
      var apiKey = new String(Base64.getDecoder().decode(header));
      var apiKeyValues = apiKey.split(":");
      if (apiKeyValues.length != 2) {
        logger.error("Invalid api key after split");
        response.setStatus(401);
        return;
      }
      var username = apiKeyValues[0];
      var pass = apiKeyValues[1];
      if (!apiKeyUsername.equals(username) || !apiKeyPassword.equals(pass)) {
        logger.error("Invalid api key creds");
        response.setStatus(401);
        return;
      }
    } catch (IllegalArgumentException e) {
      log.error("Api key is not in base64");
      response.setStatus(401);
      return;
    }

    filterChain.doFilter(request, response);
  }
}
