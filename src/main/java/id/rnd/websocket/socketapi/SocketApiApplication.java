package id.rnd.websocket.socketapi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@Slf4j
@SpringBootApplication
public class SocketApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocketApiApplication.class, args);
	}

	@Bean
	public RestTemplate newRestTemplate(){
		log.info("inisiate new restemplate.");
		return new RestTemplate();
	}
}
