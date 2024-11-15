package com.ibk.ibktechnical.repository;

import com.ibk.ibktechnical.model.entity.UserEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveMongoRepository<UserEntity, String> {

  Mono<UserEntity> findByDocumentNumber(String documentNumber);

  Flux<UserEntity> findAllByOrderByMongoIdAsc();

}
