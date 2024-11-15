package com.ibk.ibktechnical.model.api;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserResponse {
  private String id;
  private String documentType;
  private String documentNumber;
  private String fullname;
}
