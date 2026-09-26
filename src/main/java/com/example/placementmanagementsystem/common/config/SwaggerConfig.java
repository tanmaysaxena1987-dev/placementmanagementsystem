package com.example.placementmanagementsystem.common.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info().title("Placement Management System").description("Placement Management System").version("0.0.1-SNAPSHOT"))
                .servers(List.of(new Server().url("http://localhost:8081").description("Placement Management System")));

    }
}
