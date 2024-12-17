package com.escaperoomcoders.escaperoom;

import com.escaperoomcoders.escaperoom.utils.GameProgress;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EscaperoomApplication {

	public static void main(String[] args) {

		GameProgress.resetProgress();
		SpringApplication.run(EscaperoomApplication.class, args);
	}

}
