package com.ibk.ibktechnical.builder;

import com.ibk.ibktechnical.enums.Status;
import com.ibk.ibktechnical.model.api.UserRequest;
import com.ibk.ibktechnical.model.api.UserResponse;
import com.ibk.ibktechnical.model.entity.UserEntity;
import java.time.LocalDateTime;

public class UserBuilder {

  public static UserEntity builderUserEntity(UserRequest userRequest, String id) {
    return UserEntity.builder()
        .id(id)
        .documentType(userRequest.getDocumentType().name())
        .documentNumber(userRequest.getDocumentNumber())
        .name(userRequest.getName())
        .lastNameFather(userRequest.getLastNameFather())
        .lastNameMother(userRequest.getLastNameMother())
        .createdAt(LocalDateTime.now())
        .status(Status.ACTIVO.name())
        .build();
  }

  public static UserResponse builderUserResponse(UserEntity userEntity) {
    return UserResponse.builder()
        .id(userEntity.getId())
        .documentType(userEntity.getDocumentType())
        .documentNumber(userEntity.getDocumentNumber())
        .fullname(userEntity.getLastNameFather().concat(userEntity.getLastNameMother()).concat(userEntity.getName()))
        .build();
  }

}
