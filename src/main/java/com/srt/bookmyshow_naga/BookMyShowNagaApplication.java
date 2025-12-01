package com.srt.bookmyshow_naga;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BookMyShowNagaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookMyShowNagaApplication.class, args);
    }

}
