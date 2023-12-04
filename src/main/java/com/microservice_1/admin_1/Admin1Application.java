package com.microservice_1.admin_1;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Admin1Application {

	@GetMapping("/admin1")
	public String admin1(@RequestParam String numeroRuc) throws URISyntaxException, IOException, InterruptedException {
		HttpRequest getRequest = HttpRequest.newBuilder()
				.uri(new URI("https://srienlinea.sri.gob.ec/sri-catastro-sujeto-servicio-internet/rest/ConsolidadoContribuyente/existePorNumeroRuc?numeroRuc=" + numeroRuc))
				.build();

		HttpClient httpClient = HttpClient.newHttpClient();

		HttpResponse<String> getResponse = httpClient.send(getRequest, BodyHandlers.ofString());
		return getResponse.body();
	}
	// .\mvnw clean package && docker build -t springservice_1 . && docker run -it --rm -p 3001:8080 --name mymicroservice_1 springservice_1
	public static void main(String[] args) {
		SpringApplication.run(Admin1Application.class, args);
	}

}
