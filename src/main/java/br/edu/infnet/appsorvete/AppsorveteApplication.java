package br.edu.infnet.appsorvete;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AppsorveteApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppsorveteApplication.class, args);
	}

}
