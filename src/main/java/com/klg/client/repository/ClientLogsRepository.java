package com.klg.client.repository;

import com.klg.client.model.KeyloggerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientLogsRepository extends JpaRepository<KeyloggerEntity, String> {

}
