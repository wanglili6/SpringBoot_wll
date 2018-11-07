package com.wll.itdream.wll_sping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication
public class WllSpingApplication {

    public static void main(String[] args) {
        SpringApplication.run(WllSpingApplication.class, args);
    }
}
