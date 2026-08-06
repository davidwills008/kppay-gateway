package com.kppay.platform.template;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.jwt;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(properties = {
		"debug=false",
		"kppay.security.jwt-enabled=true",
		"spring.security.oauth2.resourceserver.jwt.jwk-set-uri=https://identity.invalid/jwks.json"
})
@AutoConfigureMockMvc
class JwtSecurityIT {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void requiresAuthenticationWhenJwtIsEnabled() throws Exception {
		mockMvc.perform(get("/actuator/info"))
			.andExpect(status().isUnauthorized());
	}

	@Test
	void acceptsAValidJwtWhenJwtIsEnabled() throws Exception {
		mockMvc.perform(get("/actuator/info").with(jwt()))
			.andExpect(status().isOk());
	}
}
