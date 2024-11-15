package com.ibk.ibktechnical.model.entity;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Data
@Builder
public class UserEntity {

  @Id
  private String mongoId;

  private String id;

  private String documentType;

  private String documentNumber;

  private String name;

  private String lastNameFather;

  private String lastNameMother;

  @CreatedDate
  private LocalDateTime createdAt;

  private String status;

}
