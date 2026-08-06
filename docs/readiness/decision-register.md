# Platform and policy decision register

Deadlines are proposed control dates from the Stage 1 roadmap and require acceptance under `D-010`.

| ID | Required decision | Accountable role | Due | Dependencies | Status |
|---|---|---|---|---|---|
| D-001 | Repository name, visibility, and whether it is new or existing under confirmed owner `davidwills008` | Repository Administrator | 2026-08-07 | None | PASS |
| D-002 | GitHub administrator, platform, security, and service-owner team handles | Repository Administrator | 2026-08-07 | D-001, D-008 | BLOCKED |
| D-003 | Hosting platform, deployment runtime, environments, regions, and network boundary | Architecture Owner | 2026-08-10 | D-008 | BLOCKED |
| D-004 | Identity provider, tenant, issuer, audiences, claims, and rotation policy | Security Engineering | 2026-08-10 | D-003 | BLOCKED |
| D-005 | Managed secret store, workload-identity method, rotation, and revocation policy | Security Engineering | 2026-08-10 | D-003 | BLOCKED |
| D-006 | OpenTelemetry collector, backend, retention, dashboards, and alert destinations | SRE | 2026-08-10 | D-003 | BLOCKED |
| D-007 | Registry, vulnerability threshold, signing tool, trust root, and provenance store | Security Engineering | 2026-08-10 | D-003 | BLOCKED |
| D-008 | Named people/teams for every role in the RACI and the on-call escalation chain | Product Owner | 2026-08-07 | None | BLOCKED |
| D-009 | Availability, latency, error-rate, RTO, RPO, paging, and incident-severity targets | Service Owner | 2026-08-12 | D-003, D-006, D-008 | BLOCKED |
| D-010 | Accept or replace the proposed Stage 1 milestone dates | Architecture Owner | 2026-08-07 | D-008 | BLOCKED |

Decision accepted 2026-08-06 by the user acting as Repository Administrator: create a new private repository at `davidwills008/kppay-gateway`, use the `davidwills008` account, and organize the local checkout as `davidwills008/kppay-gateway`. This resolves `D-001` and affects `R-002` through `R-005`.

Each accepted decision requires its date, decision maker, rationale, constraints, and affected backlog IDs. Material architectural choices also require an ADR in `docs/decisions/`.
