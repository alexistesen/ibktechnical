package com.ibk.ibktechnical.service.impl;

import com.ibk.ibktechnical.builder.UserBuilder;
import com.ibk.ibktechnical.model.api.UserRequest;
import com.ibk.ibktechnical.model.api.UserResponse;
import com.ibk.ibktechnical.repository.UserRepository;
import com.ibk.ibktechnical.service.UserService;
import com.ibk.ibktechnical.util.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  public Mono<UserResponse> createUser(UserRequest userRequest) {
    return Mono.just(Utils.generateRandomId())
        .flatMap(id -> userRepository.findByDocumentNumber(id).hasElement()
            .flatMap(exists -> {
              if (exists) {
                return createUser(userRequest);
              } else {
                return userRepository.save(UserBuilder.builderUserEntity(userRequest, id))
                    .map(UserBuilder::builderUserResponse);
              }}));
  }

  @Override
  public Flux<UserResponse> listUsers(int page, int size) {
    int skip = page * size;
    return userRepository.findAllByOrderByMongoIdAsc()
        .skip(skip)
        .take(size)
        .map(UserBuilder::builderUserResponse);
  }

  @Override
  public Mono<UserResponse> updateUser(String documentNumber, UserRequest userRequest) {
    return userRepository.findByDocumentNumber(documentNumber)
        .flatMap(reg -> {
          reg.setDocumentType(userRequest.getDocumentType().name());
          reg.setDocumentNumber(userRequest.getDocumentNumber());
          reg.setName(userRequest.getName());
          reg.setLastNameFather(userRequest.getLastNameFather());
          reg.setLastNameMother(userRequest.getLastNameMother());
          return userRepository.save(reg);
        })
        .switchIfEmpty(Mono.error(new RuntimeException("Usuario no encontrado")))
        .map(UserBuilder::builderUserResponse);
  }

}
