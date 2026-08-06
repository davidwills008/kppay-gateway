# Prioritized remediation backlog

| ID | Priority | Executable task | Accountable role | Due | Dependencies | Acceptance / evidence | Status |
|---|---|---|---|---|---|---|---|
| R-001 | P0 | Initialize local Git with `main` as the default branch | Platform Engineering | 2026-08-06 | None | `E-002` | PASS |
| R-002 | P0 | Reauthenticate the approved `davidwills008` GitHub account without exposing its token | Repository Administrator | 2026-08-07 | D-001, D-008 | `E-003` | PASS |
| R-003 | P0 | Select/create the remote, create the reviewed baseline commit, and push `main` | Repository Administrator | 2026-08-10 | R-002, D-001 | `E-004` | PASS |
| R-004 | P0 | Add valid CODEOWNERS; require two approvals and all CI/security checks on `main` | Repository Administrator | 2026-08-10 | R-003, D-002, D-011 | `E-005` | BLOCKED |
| R-005 | P0 | Run CI, CodeQL, dependency review, Dependabot, and secret scanning | Repository Administrator | 2026-08-10 | R-003, R-004, D-011 | `E-006` | PASS |
| R-006 | P0 | Create the non-production identity application; validate issuer, audience, claims, and key rotation | Security Engineering | 2026-08-17 | D-003, D-004 | `E-007` | BLOCKED |
| R-007 | P0 | Provision managed secrets and workload identity; test read, rotation, audit, and revocation | Security Engineering | 2026-08-17 | D-003, D-005 | `E-008` | BLOCKED |
| R-008 | P0 | Deploy the collector; receive logs, metrics, and traces; test mandatory alerts | SRE | 2026-08-17 | D-003, D-006 | `E-009` | BLOCKED |
| R-009 | P0 | Publish immutable image; scan, sign, attest, retain SBOM, and verify at deployment | Platform Engineering | 2026-08-20 | D-003, D-007, R-005 | `E-010` | BLOCKED |
| R-010 | P0 | Deploy to non-production with health checks, approvals, network policy, and tested rollback | Platform Engineering | 2026-08-20 | R-006 through R-009 | `E-011` | BLOCKED |
| R-011 | P0 | Name all RACI owners and activate the on-call/escalation schedule | Product Owner | 2026-08-10 | D-008 | `E-012` | BLOCKED |
| R-012 | P0 | Approve SLO/RTO/RPO targets; complete runbook and execute rollback, revocation, and outage drills | Service Owner | 2026-08-20 | D-009, R-008, R-010, R-011 | `E-013` | BLOCKED |
| R-013 | P0 | Hold Stage 1 exit review and record approval or rejected controls | Architecture Owner | 2026-08-21 | R-001 through R-012 | `E-014` | BLOCKED |

Work is pulled in numeric order unless a dependency prevents it. A blocked task is escalated through `escalations.md`; it is never silently skipped.
