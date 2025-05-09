package com.example.socketLockGate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.integration.annotation.IntegrationComponentScan;

@SpringBootApplication
@IntegrationComponentScan
public class SocketLockGateApplication {

    public static void main(String[] args) {
        SpringApplication.run(SocketLockGateApplication.class, args);
    }

}
