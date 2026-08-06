package com.kppay.platform.template.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Security switches supplied by the deployment environment.
 *
 * @param jwtEnabled whether application endpoints authenticate JWT bearer tokens
 */
@ConfigurationProperties("kppay.security")
public record KppaySecurityProperties(boolean jwtEnabled) {
}
