# Testing standard

The single build gate is:

```bash
./mvnw --batch-mode clean verify
```

It runs style checks, toolchain enforcement, compilation with warnings treated as errors, unit tests, architecture tests, integration tests, coverage enforcement, packaging, and SBOM generation.

Test naming:

- `*Tests` — unit and architecture tests.
- `*IT` — integration, HTTP security, persistence, broker, and provider-boundary tests.

The line-coverage minimum is 80%. New payment behavior must additionally prove complete success, pending/timeout, deterministic failure, duplicate delivery, retry, and recovery paths when those concerns enter scope.
