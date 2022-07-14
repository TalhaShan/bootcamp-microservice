package com.example.cloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class CloudgatewayBootcamp2Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudgatewayBootcamp2Application.class, args);
    }

}
