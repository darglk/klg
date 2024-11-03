package com.klg.client.repository;

import com.klg.client.model.SyncedCommandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SyncedCommandRepository extends JpaRepository<SyncedCommandEntity, String> {

}
