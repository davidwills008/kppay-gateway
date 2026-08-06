# Secrets standard

Never commit credentials, tokens, certificates, private keys, merchant secrets, provider secrets, or production connection strings.

Services consume secrets through workload identity or a managed secret store. Mounted secrets can be exposed as Spring configuration files beneath `/run/secrets`. Environment variables are acceptable for local development and platform-injected references, but must not be printed or included in diagnostic endpoints.

Every production secret requires:

- a named owner;
- least-privilege access;
- separate values per service and environment;
- an automated rotation procedure;
- audited access;
- an emergency revocation procedure.

## Environment rules

- Local development uses synthetic credentials and ignored `.env` files only.
- CI uses short-lived identity federation where possible; long-lived repository secrets require an approved exception.
- Production workloads authenticate to the managed secret store through workload identity.
- Applications fail closed when a required secret is absent and must never fall back to a packaged value.
- Rotation and emergency revocation are tested before Stage 1 exit and after material identity changes.
