package com.klg.client.repository;

import com.klg.client.model.CommandResponseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandResponseRepository extends JpaRepository<CommandResponseEntity, String> {

}
