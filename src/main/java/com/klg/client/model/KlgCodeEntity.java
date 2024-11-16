package com.klg.client.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "klg_code")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class KlgCodeEntity {
  @Id
  String id;
  @Column(name = "content")
  private String content;
  @Column(name = "content_binary")
  private byte[] contentBinary;
}
