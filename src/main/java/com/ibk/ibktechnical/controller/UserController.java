package com.ibk.ibktechnical.controller;

import com.ibk.ibktechnical.config.AnalyticsService;
import com.ibk.ibktechnical.model.api.UserRequest;
import com.ibk.ibktechnical.model.api.UserResponse;
import com.ibk.ibktechnical.service.UserService;
import com.ibk.ibktechnical.util.Utils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

  private final UserService userService;
  private final AnalyticsService analyticsService;

  @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<UserResponse> createUser(
      @RequestHeader("consumerId") String consumerId,
      @RequestHeader("traceparent") String traceparent,
      @RequestHeader("deviceType") String deviceType,
      @RequestHeader("deviceId") String deviceId,
      @Valid @RequestBody UserRequest userRequest) {
    return userService.createUser(userRequest)
        .doOnSuccess(userResponse -> {
          String in = Utils.toJson(userRequest);
          String out = Utils.toJson(userResponse);
          analyticsService.sendAnalytics(consumerId, traceparent, in, out, userResponse.getId(), 200);
        });
  }

  @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
  public Flux<UserResponse> listUsers(
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "5") int size) {
    return userService.listUsers(page, size);
  }

  @PutMapping(value = "/update/{documentNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<UserResponse> updateUser(
      @RequestHeader("consumerId") String consumerId,
      @RequestHeader("traceparent") String traceparent,
      @RequestHeader("deviceType") String deviceType,
      @RequestHeader("deviceId") String deviceId,
      @PathVariable String documentNumber,
      @Valid @RequestBody UserRequest userRequest) {
    return userService.updateUser(documentNumber, userRequest)
        .doOnSuccess(userResponse -> {
          String in = Utils.toJson(userRequest);
          String out = Utils.toJson(userResponse);
          analyticsService.sendAnalytics(consumerId, traceparent, in, out, userResponse.getId(), 200);
        });
  }

}
