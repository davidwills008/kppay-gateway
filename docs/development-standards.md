# Development standards

These rules are mandatory for this template and every generated KPPay Java service.

## Code and architecture

- Java 25 selected through `JAVA_HOME`, Spring Boot 4.1, and the checksum-pinned Maven Wrapper are the toolchain.
- Dependencies point inward: adapters to application to domain.
- Domain code is framework-independent; ArchUnit enforces the boundary.
- Compiler warnings, Checkstyle violations, failed tests, or insufficient coverage fail the build.
- Secrets, credentials, customer data, and provider payloads must never appear in source or logs.

## Testing

- `*Tests` are fast unit or architecture tests run by Surefire.
- `*IT` are integration tests run by Failsafe during `verify`.
- Changed behavior requires success, failure, authorization, and retry/idempotency tests where applicable.
- The minimum line-coverage gate is 80%; coverage never replaces behavior-focused assertions.
- External dependencies use Testcontainers, fakes, or contract tests rather than shared mutable test systems.

## Changes and delivery

- Use a short-lived branch and a reviewed pull request.
- Keep API and event contracts backward compatible unless a reviewed migration exists.
- Record material architectural choices in an ADR.
- CI is the source of release evidence; local success does not replace required remote checks.
- Artifacts are immutable, scanned, signed, traceable to a commit, and accompanied by an SBOM.

## Definition of done

A change is done when code, tests, contracts, documentation, telemetry, security impact, rollback behavior, and operational ownership are complete for its scope and all required checks pass.
