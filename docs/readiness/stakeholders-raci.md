# Stakeholder and RACI matrix

RACI means Responsible, Accountable, Consulted, and Informed. Each activity has exactly one accountable role. Named people and GitHub team handles remain blocked by decision `D-008`.

## Role assignments

| Role | Required named assignment | Current state |
|---|---|---|
| Product Owner | Person approving product risk and service objectives | BLOCKED |
| Architecture Owner | Person approving Stage 1 exit and architecture exceptions | BLOCKED |
| Platform Engineering | Team implementing build, registry, and deployment controls | Role assigned; named lead BLOCKED |
| Security Engineering | Team approving identity, secrets, scanning, and signing | Role assigned; named lead BLOCKED |
| SRE / Operations | Team owning telemetry, on-call, incidents, and recovery | Role assigned; named lead BLOCKED |
| Repository Administrator | GitHub administrator for rules, teams, and security settings | BLOCKED |
| Service Owner | Team accountable for the generated payment service | BLOCKED |

## RACI

| Activity | Product | Architecture | Platform | Security | SRE | Repository Admin | Service Owner |
|---|---|---|---|---|---|---|---|
| GitHub repository and branch governance | I | C | C | C | I | A/R | I |
| CI/CD and dependency automation | I | C | R | C | I | A | C |
| Identity provider and secrets lifecycle | I | C | C | A/R | C | I | C |
| Logs, metrics, traces, dashboards, and alerts | I | C | C | C | A/R | I | C |
| Registry, signing, deployment, and rollback | I | C | A/R | C | R | I | C |
| SLOs, on-call, runbook, and incident exercises | C | C | C | C | R | I | A |
| Operational Stage 1 approval | C | A | R | C | C | I | C |
