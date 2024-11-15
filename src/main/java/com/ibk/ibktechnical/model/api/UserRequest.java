package com.ibk.ibktechnical.model.api;

import com.ibk.ibktechnical.enums.DocumentType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {

  private DocumentType documentType;

  private String documentNumber;

  private String name;

  private String lastNameFather;

  @NotNull(message = "El apellido materno no puede ser no nulo")
  private String lastNameMother;

}

