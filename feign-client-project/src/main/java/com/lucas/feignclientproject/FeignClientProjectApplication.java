package com.lucas.feignclientproject;

import com.lucas.feignclientproject.integration.error.FeignClientProjectError;
import feign.codec.ErrorDecoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class FeignClientProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignClientProjectApplication.class, args);
    }

    @Bean
    public ErrorDecoder errorDecoder() { return new FeignClientProjectError();}

}
