package com.bally;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MillionRandomNumbersApplication {

    public static void main(String[] args) {
        SpringApplication.run(MillionRandomNumbersApplication.class, args);
        System.out.println("Million Random Number Service Started");

    }
}
