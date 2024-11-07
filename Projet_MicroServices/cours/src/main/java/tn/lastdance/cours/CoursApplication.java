package tn.lastdance.cours;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class CoursApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoursApplication.class, args);
    }

}
