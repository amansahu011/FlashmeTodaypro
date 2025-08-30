package com.takeuforward;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;


        @SpringBootApplication
        public class TakeUForwardprojectssssdevApplication {

            public static void main(String[] args) {
                // Load .env file
                Dotenv dotenv = Dotenv.load();

                // Set system properties so Spring can use them
                System.setProperty("MONGO_URI", dotenv.get("MONGO_URI"));
                System.setProperty("MAIL_HOST", dotenv.get("MAIL_HOST"));
                System.setProperty("MAIL_PORT", dotenv.get("MAIL_PORT"));
                System.setProperty("MAIL_USERNAME", dotenv.get("MAIL_USERNAME"));
                System.setProperty("MAIL_PASSWORD", dotenv.get("MAIL_PASSWORD"));

                SpringApplication.run(TakeUForwardprojectssssdevApplication.class, args);
            }
        }
