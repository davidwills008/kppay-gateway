# Foundation architecture

## Purpose

This project is the reusable Java starting point for KPPay services. It establishes cross-cutting behavior while leaving bounded-context decisions to each generated service.

## Dependency policy

Allowed dependency direction:

```text
adapter.in -> application -> domain
adapter.out -> application.port.out -> domain
configuration -> adapters and application
```

Forbidden dependencies include:

- domain to Spring or Jakarta transport APIs;
- domain to persistence or messaging clients;
- inbound adapters calling outbound adapters directly;
- one service reading another service's database;
- shared libraries containing service business rules.

## Runtime defaults

- Stateless HTTP execution
- Deny-by-default application security
- Public liveness, readiness, and health endpoints only
- Graceful shutdown
- Structured ECS console logs
- Micrometer observations and OpenTelemetry trace propagation
- OTLP export disabled until explicitly configured
- Secrets loaded externally rather than packaged in the application

## Decision boundary

The template does not select PostgreSQL access style, broker technology, caching, API gateway, deployment platform, or provider SDKs. Record those decisions in service-specific ADRs when their requirements are known.
