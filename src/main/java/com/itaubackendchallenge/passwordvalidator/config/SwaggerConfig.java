package com.itaubackendchallenge.passwordvalidator.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("password-validator")
                .pathsToMatch("/v01/**")
                .build();
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Password Validator API")
                        .description("<b>API to validate passwords.</b><br/><br/>Developed by Luiz Roberto Oliveira for the Itaú Jr. Back-end Challenge.")
                        .version("v1.0.0")
                        .contact(new Contact()
                                .name("Luiz Roberto Oliveira")
                                .email("dev.luiz.oliveira@gmail.com")
                                .url("https://github.com/luizrobertoao")));
    }
}
