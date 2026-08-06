# Stage 1 escalation register

| ID | Blocked decision/action | Decision authority | Required by | Impact if unresolved | Next escalation | Status |
|---|---|---|---|---|---|---|
| X-001 | Restore secure authentication for approved account `davidwills008` and create the approved private repository | Repository Administrator | 2026-08-07 | Resolved: authentication verified and private remote created | None | PASS |
| X-002 | Name all accountable people, GitHub teams, and on-call chain | Product Owner | 2026-08-07 | No valid ownership, approvals, paging, or Stage 1 sign-off | Architecture Owner on next working day | BLOCKED |
| X-003 | Select hosting, environments, regions, registry, and deployment runtime | Architecture Owner | 2026-08-10 | Identity, secrets, telemetry, delivery, and recovery cannot be provisioned | Product Owner on next working day | BLOCKED |
| X-004 | Select identity, secret, telemetry, signing, and evidence-retention platforms | Security Engineering and SRE | 2026-08-10 | Security and operational controls remain untestable | Architecture Owner on next working day | BLOCKED |
| X-005 | Approve SLO, RTO, RPO, incident tooling, severity, and paging targets | Service Owner | 2026-08-12 | Alerts, capacity, recovery, and incident exercises have no acceptance threshold | Product Owner on next working day | BLOCKED |

Escalation never authorizes a control bypass. Exceptions require an ADR, named risk owner, expiration date, compensating control, and Architecture Owner approval.
