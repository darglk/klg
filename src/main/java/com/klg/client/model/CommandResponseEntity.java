package com.klg.client.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "command_responses")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CommandResponseEntity {
  @Id
  String id;
  @Column(name = "response")
  private String response;
}
