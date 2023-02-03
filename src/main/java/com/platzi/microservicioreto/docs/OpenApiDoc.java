package com.platzi.microservicioreto.docs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;


@Configuration
public class OpenApiDoc {
	@Bean
    public OpenAPI getOpenApi(){
        return new OpenAPI()
                .components(new Components())
                .info(
                        new Info()
                                .title("MicroServicio de Clientes")
                                .description("Implementacion de un Microservicio en Spring boot")                                
                );
    }
}
