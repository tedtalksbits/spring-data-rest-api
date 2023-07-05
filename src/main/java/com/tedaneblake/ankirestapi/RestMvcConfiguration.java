package com.tedaneblake.ankirestapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.tedaneblake.ankirestapi.models.Deck;
import com.tedaneblake.ankirestapi.models.Flashcard;
import com.tedaneblake.ankirestapi.models.User;

@Configuration
class RestMvcConfiguration {

  @Bean
  public RepositoryRestConfigurer repositoryRestConfigurer() {

    return new RepositoryRestConfigurer() {

      @Override
      public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.setBasePath("/api");
        config.exposeIdsFor(Flashcard.class);
        config.exposeIdsFor(Deck.class);
        config.exposeIdsFor(User.class);
      }
    };
  }
}