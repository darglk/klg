package com.klg.client.repository;

import com.klg.client.model.KlgCodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KlgCodeRepository extends JpaRepository<KlgCodeEntity, String> {

}
