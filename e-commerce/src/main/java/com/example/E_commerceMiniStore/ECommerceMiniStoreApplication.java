package com.example.E_commerceMiniStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ECommerceMiniStoreApplication {
	public static void main(String[] args) {

        SpringApplication.run(ECommerceMiniStoreApplication.class, args);
	}
}
