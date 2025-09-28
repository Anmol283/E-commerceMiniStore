package com.example.api_gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                // Route all /api/** requests to your main ecommerce service
                .route("ecommerce-service", r -> r
                        .path("/api/**")
                        .filters(f -> f
                                .circuitBreaker(config -> config
                                        .setName("ecommerce-service")
                                        .setFallbackUri("forward:/fallback/ecommerce"))
                                .retry(config -> config.setRetries(3)))
                        .uri("lb://ecommerce-service"))

                // Route for any other patterns your app might have
                .route("ecommerce-service-all", r -> r
                        .path("/**")
                        .filters(f -> f
                                .circuitBreaker(config -> config
                                        .setName("ecommerce-service-all")
                                        .setFallbackUri("forward:/fallback/ecommerce"))
                                .retry(config -> config.setRetries(3)))
                        .uri("lb://ecommerce-service"))
                .build();
    }
}