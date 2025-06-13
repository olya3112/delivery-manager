package org.example.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Delivery-manager Api",
                description = "API моего деливери менеджера",
                version = "1.0.0",
                contact = @Contact(
                        name = "Пухова Ольга",
                        email = "ovp3112@struchkov.dev"
                )
        )
)
public class OpenApiConfig {
    // Конфигурация для Swagger
}