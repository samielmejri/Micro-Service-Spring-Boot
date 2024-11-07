package tn.lastdance.quizz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class QuizzApplication {
    public static void main(String[] args) {
        SpringApplication.run(QuizzApplication.class, args);
    }

}
