package com.ibk.ibktechnical;

import com.ibk.ibktechnical.builder.UserBuilder;
import com.ibk.ibktechnical.model.api.UserResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class IbktechnicalApplication {

    public static void main(String[] args) {
        SpringApplication.run(IbktechnicalApplication.class, args);
    }

}
