package com.klg.client.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "client_settings")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class SettingsEntity {
  @Id
  String id;
  @Column(name = "auto_destroy")
  private Boolean autoDestroy;
  @Column(name = "flush_buffer")
  private Boolean flushBuffer;
}
