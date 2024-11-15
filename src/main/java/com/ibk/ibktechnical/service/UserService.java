package com.ibk.ibktechnical.service;

import com.ibk.ibktechnical.model.api.UserRequest;
import com.ibk.ibktechnical.model.api.UserResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

  Mono<UserResponse> createUser(UserRequest userRequest);

  Flux<UserResponse> listUsers(int page, int size);

  Mono<UserResponse> updateUser(String documentNumber, UserRequest userRequest);

}
