# KPPay Java Service Foundation

Production-oriented golden path for KPPay Java microservices. The repository was generated with the official Spring Initializr and then hardened with KPPay-wide defaults for security, observability, testing, and delivery.

This repository is currently at **Stage 1: service foundation**. It deliberately contains no payment business logic, persistence model, provider SDK, or message broker. Those decisions belong to later pinned stages in [AGENTS.md](AGENTS.md).

## Baseline

- Java 25 LTS
- Spring Boot 4.1.x
- Maven Wrapper
- Spring MVC and Jakarta Validation
- Spring Security OAuth2 Resource Server
- Spring Boot Actuator
- Micrometer metrics and OpenTelemetry tracing over OTLP
- JUnit 5 and Testcontainers support

## Run locally

Prerequisites: a Java 25 JDK selected through `JAVA_HOME`. The Maven Wrapper downloads and checksum-verifies the approved Maven version.

```bash
export JAVA_HOME=$(/usr/libexec/java_home -v 25) # macOS, when multiple JDKs are installed
./mvnw clean verify
./mvnw spring-boot:run
```

The foundation starts in deny-by-default mode:

- `GET /actuator/health` is public.
- Readiness and liveness paths beneath `/actuator/health` are public.
- Every other application and management endpoint is denied until JWT security is enabled and configured.

Build an OCI image with Cloud Native Buildpacks:

```bash
./mvnw spring-boot:build-image \
  -Dspring-boot.build-image.imageName=kppay/kppay-service-template:local
```

## Configuration

Configuration is externalized through environment variables and optional files mounted under `/run/secrets`. Copy `.env.example` only for local, non-secret settings.

To enable JWT authentication, set:

```text
KPPAY_SECURITY_JWT_ENABLED=true
SPRING_SECURITY_OAUTH2_RESOURCESERVER_JWT_ISSUER_URI=https://identity.example.com
SPRING_SECURITY_OAUTH2_RESOURCESERVER_JWT_AUDIENCES=kppay-api
```

Alternatively, provide `SPRING_SECURITY_OAUTH2_RESOURCESERVER_JWT_JWK_SET_URI` outside the production profile. The production profile requires `KPPAY_SECURITY_JWT_ISSUER_URI` and `KPPAY_SECURITY_JWT_AUDIENCES`; startup fails if they are absent.

OTLP metrics and trace export are disabled locally. Enable them explicitly in a deployed environment after configuring the collector endpoints.

## Architecture rule

The codebase uses ports and adapters:

```text
adapter.in -> application -> domain
                         -> application.port.out <- adapter.out
```

- `domain` contains framework-independent business behavior.
- `application` contains use cases and ports.
- `adapter.in` translates HTTP or messages into use-case calls.
- `adapter.out` implements persistence, messaging, and provider integrations.
- `configuration` contains Spring wiring and cross-cutting configuration.

Dependencies must point inward. The domain must not import Spring, HTTP, database, broker, or provider SDK classes.

## Turning the foundation into a service

Create a repository from this golden path, then make one intentional identity change:

1. Set the Maven `artifactId`, project name, and description.
2. Rename `com.kppay.platform.template` to the bounded-context package.
3. Rename the application class.
4. Set `SERVICE_NAME` and the owning team.
5. Add the service's OpenAPI and event contracts before business implementation.
6. Add persistence or messaging dependencies only when the service requires them.
7. Replace the runbook placeholders and define service SLOs before production.

Do not copy provider libraries, database entities, or business events into the shared foundation.

The exact Initializr input and the repeatable generation policy are documented in [docs/generation.md](docs/generation.md).

## Engineering governance

- [Development standards](docs/development-standards.md)
- [Production-readiness plan](docs/production-readiness.md)
- [Stage 1 readiness control center](docs/readiness/README.md)
- [Testing standard](docs/testing.md)
- [External Stage 1 infrastructure](docs/external-infrastructure.md)
- [Delivery and supply-chain standard](docs/delivery.md)
- [Latest foundation audit](docs/evidence/foundation-audit-2026-08-06.md)
- [Latest readiness discovery](docs/evidence/readiness-discovery-2026-08-06.md)
- [Contribution rules](CONTRIBUTING.md)

## Verification

The required local and CI command is:

```bash
./mvnw --batch-mode clean verify
bash scripts/verify-repository-policy.sh
```

CI runs the same command on Java 25. A service is not production-ready until ownership, contracts, alerts, secrets, recovery, and deployment-specific controls are completed.
