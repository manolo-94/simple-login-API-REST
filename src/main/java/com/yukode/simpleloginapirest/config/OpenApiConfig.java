package com.yukode.simpleloginapirest.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    
    @Bean
    public OpenAPI CustomOpenApi(){
        
        return new OpenAPI()
                .info(new Info()
                        .title("Login API REST")
                        .description("Simple User Login API REST")
                        .version("1.0.0")
                );
    }
    
}
