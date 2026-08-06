# Service generation standard

## Foundation provenance

The original Spring scaffold was generated from `https://start.spring.io` with the official Spring CLI:

```bash
spring init \
  --boot-version=4.1.0 \
  --java-version=25 \
  --build=maven \
  --packaging=jar \
  --language=java \
  --group-id=com.kppay.platform \
  --artifact-id=kppay-service-template \
  --name=kppay-service-template \
  --description="KPPay production Java microservice golden-path foundation" \
  --package-name=com.kppay.platform.template \
  --dependencies=web,validation,actuator,security,oauth2-resource-server,testcontainers \
  kppay-service-template
```

The Initializr output was then hardened with the files in this repository. Initializr alone is not the KPPay production standard.

## Efficient reuse

Publish this repository as the approved template after review. New services should be created from the reviewed template revision rather than rerunning Initializr and manually recreating the hardening changes.

For every generated service:

1. Record the template revision used.
2. Replace the template coordinates, package, application class, and service name.
3. Assign an owner and complete the runbook.
4. Add only the capabilities required by that bounded context.
5. Keep shared platform configuration separate from domain behavior.
6. Run `./mvnw clean verify` before the first commit.

Changes to Java, Spring Boot, Maven, test, security, or telemetry baselines must be made in this foundation first and then propagated deliberately to generated services.
