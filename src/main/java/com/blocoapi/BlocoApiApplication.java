package com.blocoapi;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlocoApiApplication {

	public static void main(String[] args) {
		loadDotenv();
		SpringApplication.run(BlocoApiApplication.class, args);
	}

	private static void loadDotenv() {
		Dotenv dotenv = Dotenv.configure()
				.ignoreIfMissing()
				.load();

		dotenv.entries().forEach(entry -> {
			String key = entry.getKey();
			String value = entry.getValue();

			if (System.getProperty(key) == null && System.getenv(key) == null) {
				System.setProperty(key, value);
			}
		});
	}

}
