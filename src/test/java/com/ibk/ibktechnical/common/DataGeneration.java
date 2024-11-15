package com.ibk.ibktechnical.common;

import com.ibk.ibktechnical.enums.DocumentType;
import com.ibk.ibktechnical.model.api.UserRequest;
import com.ibk.ibktechnical.model.api.UserResponse;

public class DataGeneration {

  public static UserResponse userResponseMock() {
    return UserResponse.builder()
        .id("9876543210")
        .documentType("DNI")
        .documentNumber("123456789")
        .fullname("Gomez Lopez Pedro")
        .build();
  }

  public static UserRequest userRequestMock() {
    return UserRequest.builder()
        .documentType(DocumentType.DNI)
        .documentNumber("123456789")
        .lastNameFather("Gomez")
        .lastNameMother("Lopez")
        .name("Pedro")
        .build();
  }

}
