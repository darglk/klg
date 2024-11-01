package com.klg.client.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "client_logs")
@NoArgsConstructor
@AllArgsConstructor
public class KeyloggerEntity{
  @Id String id;
  @Column(name = "content") String content;
}
