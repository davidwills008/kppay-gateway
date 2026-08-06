package com.kppay.platform.template.configuration;

import org.springframework.boot.security.autoconfigure.actuate.web.servlet.EndpointRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Provides a deny-by-default baseline. A generated service cannot accidentally
 * expose application endpoints before its identity provider is configured.
 */
@Configuration(proxyBeanMethods = false)
public class SecurityConfiguration {

	@Bean
	SecurityFilterChain apiSecurity(
			HttpSecurity http,
			KppaySecurityProperties securityProperties) throws Exception {

		http
			.csrf(AbstractHttpConfigurer::disable)
			.httpBasic(AbstractHttpConfigurer::disable)
			.formLogin(AbstractHttpConfigurer::disable)
			.logout(AbstractHttpConfigurer::disable)
			.requestCache(AbstractHttpConfigurer::disable)
			.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.authorizeHttpRequests(authorize -> {
				authorize.requestMatchers(EndpointRequest.to("health")).permitAll();
				if (securityProperties.jwtEnabled()) {
					authorize.anyRequest().authenticated();
				} else {
					authorize.anyRequest().denyAll();
				}
			});

		if (securityProperties.jwtEnabled()) {
			http.oauth2ResourceServer(resourceServer -> resourceServer.jwt(Customizer.withDefaults()));
		}

		return http.build();
	}
}
