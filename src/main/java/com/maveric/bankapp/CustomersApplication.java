package com.maveric.bankapp;

import com.maveric.bankapp.config.JpaConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * Hello world!
 *
 */
@Import(JpaConfiguration.class)
@SpringBootApplication(scanBasePackages={"com.maveric.bankapp"})
public class CustomersApplication
{
    public static void main(String[] args) {
        SpringApplication.run(CustomersApplication.class, args);
    }
}
