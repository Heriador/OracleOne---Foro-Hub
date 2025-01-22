package com.OracleOne.ForoHub.infrastructure.springDocs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocsConfiguration {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Foro Hub API")
                        .description("API Rest del proyecto Foro Hub, una plataforma para gestionar temas de discusión.")
                        .version("1.0.0"));
    }
}
