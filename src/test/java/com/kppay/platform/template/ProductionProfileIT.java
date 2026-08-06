package com.kppay.platform.template;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.kppay.platform.template.configuration.KppaySecurityProperties;

@ActiveProfiles("prod")
@SpringBootTest(properties = {
		"debug=false",
		"KPPAY_SECURITY_JWT_ISSUER_URI=https://identity.invalid",
		"KPPAY_SECURITY_JWT_AUDIENCES=kppay-api",
		"OTEL_EXPORTER_OTLP_METRICS_ENDPOINT=http://localhost:4318/v1/metrics",
		"OTEL_EXPORTER_OTLP_TRACES_ENDPOINT=http://localhost:4318/v1/traces",
		"spring.security.oauth2.resourceserver.jwt.jwk-set-uri=https://identity.invalid/jwks.json",
		"management.tracing.export.enabled=false",
		"management.otlp.metrics.export.enabled=false"
})
class ProductionProfileIT {

	@Autowired
	private KppaySecurityProperties securityProperties;

	@Test
	void enablesJwtInProduction() {
		assertThat(securityProperties.jwtEnabled()).isTrue();
	}
}
