package com.linkedinlearning.reactivespring.config;

import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile(value = "local")
@Import(EmbeddedMongoAutoConfiguration.class)
public class DataConfig {
}
