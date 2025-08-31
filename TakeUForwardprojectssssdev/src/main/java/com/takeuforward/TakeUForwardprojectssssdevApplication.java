package com.takeuforward;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class TakeUForwardprojectssssdevApplication {

    public static void main(String[] args) {
        // Try to load .env file but ignore if missing
        Dotenv dotenv = Dotenv.configure()
                              .ignoreIfMissing()
                              .load();

        // Prefer system environment variables (Render) if available
        System.setProperty("MONGO_URI", getenvOrDotenv("MONGO_URI", dotenv));
        System.setProperty("MAIL_HOST", getenvOrDotenv("MAIL_HOST", dotenv));
        System.setProperty("MAIL_PORT", getenvOrDotenv("MAIL_PORT", dotenv));
        System.setProperty("MAIL_USERNAME", getenvOrDotenv("MAIL_USERNAME", dotenv));
        System.setProperty("MAIL_PASSWORD", getenvOrDotenv("MAIL_PASSWORD", dotenv));

        SpringApplication.run(TakeUForwardprojectssssdevApplication.class, args);
    }

    private static String getenvOrDotenv(String key, Dotenv dotenv) {
        String value = System.getenv(key);  // Render Env vars
        return (value != null) ? value : dotenv.get(key);
    }
}
