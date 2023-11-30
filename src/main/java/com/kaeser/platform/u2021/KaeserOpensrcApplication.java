package com.kaeser.platform.u2021;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class KaeserOpensrcApplication {

    public static void main(String[] args) {
        SpringApplication.run(KaeserOpensrcApplication.class, args);
    }

}
