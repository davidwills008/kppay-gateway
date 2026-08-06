package com.kppay.platform.template;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
		properties = "debug=false")
class SecurityBaselineIT {

	@LocalServerPort
	private int port;

	private final HttpClient httpClient = HttpClient.newHttpClient();

	@Test
	void exposesHealthWithoutCredentials() throws IOException, InterruptedException {
		HttpResponse<String> response = get("/actuator/health");

		assertThat(response.statusCode()).isEqualTo(200);
		assertThat(response.body()).contains("\"status\":\"UP\"");
	}

	@Test
	void deniesApplicationEndpointsUntilJwtIsConfigured() throws IOException, InterruptedException {
		HttpResponse<String> response = get("/");

		assertThat(response.statusCode()).isEqualTo(403);
	}

	@Test
	void protectsNonHealthManagementEndpoints() throws IOException, InterruptedException {
		HttpResponse<String> response = get("/actuator/info");

		assertThat(response.statusCode()).isEqualTo(403);
	}

	private HttpResponse<String> get(String path) throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder(URI.create("http://localhost:" + port + path)).GET().build();
		return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
	}
}
