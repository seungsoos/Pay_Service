package org.example.bankingservice;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        Info info = new Info()
                .title("결제 서비스")
                .version("v1.0")
                .description("결제 서비스 입니다.");
        return new OpenAPI()
                .components(new Components())
                .info(info);
    }

}