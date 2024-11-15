package com.ibk.ibktechnical.controller;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

import com.ibk.ibktechnical.common.DataGeneration;
import com.ibk.ibktechnical.service.impl.UserServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

  @Mock
  private UserServiceImpl userService;

  @InjectMocks
  private UserController userController;

  @Test
  @DisplayName("validate user controller get create user succesfull")
  public void validateUserControllerGetCreateUserSuccesfull() {
    String consumerId = "APP";
    String traceparent = "00-4bf92f3577b34da6a3ce929d0e0e4736-00";
    String deviceType = "AND";
    String deviceId = "12345";

    when(userService.createUser(any()))
        .thenReturn(Mono.just(DataGeneration.userResponseMock()));

    StepVerifier.create(userController.createUser(consumerId, traceparent, deviceType, deviceId,
        DataGeneration.userRequestMock()))
        .expectNextMatches(userResponse -> userResponse.getId().equals("9876543210"))
        .verifyComplete();
  }

}
