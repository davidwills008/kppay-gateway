# External infrastructure required for Stage 1

The repository cannot provision these controls without platform selection, credentials, and administrative access.

Open decisions and executable tasks are tracked under `docs/readiness/`.

| External decision or access | Required result | Evidence needed |
|---|---|---|
| GitHub organization and repository | Private remote, protected `main`, required CI/security checks, valid team-based CODEOWNERS | Repository and ruleset URLs |
| Identity provider | Issuer/JWKS, audience, claims, key rotation, non-production tenant | Successful JWT tests and rotation record |
| Managed secret store | Workload identity, per-environment secrets, audit, rotation and emergency revocation | Policy and audit-event links |
| OpenTelemetry platform | Collector endpoint, logs/metrics/traces backend, retention, dashboards and alerts | Dashboard, trace and alert-test links |
| Container registry | Immutable digests, vulnerability policy, signing, provenance and retention | Image digest, scan and attestation |
| Deployment platform | Network policy, workload identity, health probes, autoscaling, rollout and rollback | Deployment and rollback records |
| Incident platform | Named on-call, escalation path, paging integration and post-incident workflow | Completed runbook and exercise record |

Do not place credentials in this document. Store only platform names, non-secret identifiers, and links to controlled evidence.
