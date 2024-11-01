package com.klg.client.service;

import com.klg.client.model.KeyloggerData;
import com.klg.client.model.KeyloggerEntity;
import com.klg.client.repository.ClientLogsRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ClientService {

  private final ClientLogsRepository repository;

  @Transactional
  public void keyloggerData(KeyloggerData keyloggerData) {
    repository.save(new KeyloggerEntity(UUID.randomUUID().toString(), keyloggerData.content()));
  }
}
