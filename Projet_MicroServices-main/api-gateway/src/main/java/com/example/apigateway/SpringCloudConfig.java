package com.example.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r->r.path("/api/comments/**")
                        .uri("http://comment:8085/"))

                .route(r -> r.path("/api/posts/**")
                        .uri("http://post:8090/")

                )
                .route(r -> r.path("/api/quiz/**")
                .uri("http://quizz:8009/")

        )
                .route(r -> r.path("/api/events/**")
                        .uri("http://events:3000/")

                )
                .route(r -> r.path("/api/cours/**")
                        .uri("http://cours:8082/")
                )

                 .route(r -> r.path("/api/categories/**")
                        .uri("http://category:8093/") 
                )

                .route(r -> r.path("/api/forum/**")
                        .uri("http://forum:8086/")

                )
                .build();
               // .route(r->r.path("/api/comments/**")
                 //       .uri("http://localhost:8081/")
                //)
                //.build();
//Micro-service 2
//                .route(r -> r.path("/consumer/**")
//                        .uri("http://localhost:8082/")
//                       .id("consumerModule"))

    }

}
