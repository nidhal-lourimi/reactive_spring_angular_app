package com.linkedinlearning.reactivespring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoReactiveAutoConfiguration;

@SpringBootApplication()
public class ReactivespringApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactivespringApplication.class, args);
    }

}
