# Acceptance and evidence register

Evidence must be immutable or access-controlled, timestamped, attributable to a named owner, and free of credentials or customer data.

| ID | Proves | Required evidence | Current state |
|---|---|---|---|
| E-001 | Repository quality baseline | Clean build, test, coverage, SBOM, policy results and artifact hashes | PASS — `docs/evidence/foundation-audit-2026-08-06.md` |
| E-002 | Local source-control initialization | `git rev-parse --is-inside-work-tree=true` and branch `main` | PASS — `docs/evidence/readiness-discovery-2026-08-06.md` |
| E-003 | Approved GitHub authentication | Redacted successful `gh auth status`, account name, least-privilege scope review | PASS — `docs/evidence/readiness-discovery-2026-08-06.md` |
| E-004 | Remote and baseline | Remote URL, baseline commit SHA, successful push | READY — private remote created; baseline commit and push pending |
| E-005 | Ownership and branch policy | Valid CODEOWNERS path, ruleset URL/export, two-approval test, bypass list | MISSING |
| E-006 | Remote automation | Green CI/CodeQL/dependency-review URLs, secret-scanning status, Dependabot evidence | MISSING |
| E-007 | Identity integration | Issuer/audience/claim configuration, authorized/unauthorized tests, rotation record | Local baseline PASS; external proof MISSING |
| E-008 | Secrets lifecycle | Redacted IAM policy, successful workload read, audit event, rotation and revocation records | MISSING |
| E-009 | Observability | Collector deployment, log/metric/trace links, dashboard and alert-fire/resolve tests | MISSING |
| E-010 | Supply chain | Image digest, vulnerability result, SBOM link, signature verification, provenance attestation | MISSING |
| E-011 | Deployment and recovery | Deployment revision, health verification, approvals, network policy, rollback timestamps | MISSING |
| E-012 | Named ownership | Named RACI, GitHub teams, on-call schedule, escalation channel and acknowledgement test | MISSING |
| E-013 | Objectives and exercises | Approved SLO/RTO/RPO, completed runbook, rollback/revocation/outage drill records | MISSING |
| E-014 | Stage 1 approval | Signed review record listing all controls PASS and any accepted exceptions | MISSING |

CI evidence retention is 14 days for pull-request artifacts. Release evidence, signatures, provenance, drill records, and Stage 1 approval require the longer retention period selected in `D-007` and `D-009`.
