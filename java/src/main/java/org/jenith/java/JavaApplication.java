package org.jenith.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
/*(exclude = {DataSourceAutoConfiguration.class })*/
public class JavaApplication {

    public static void main(String[] args) {
        System.out.println("Jenith Testing");
        SpringApplication.run(JavaApplication.class, args);

    }

}
