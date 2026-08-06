# Stakeholder and RACI matrix

RACI means Responsible, Accountable, Consulted, and Informed. Each activity has exactly one accountable role. The user confirmed that `davidwills008` is the only current manager, so the account is the interim holder of every role. This bootstrap assignment does not satisfy independent review, separation of duties, or on-call escalation; those remain blocked by `D-008`.

## Role assignments

| Role | Required named assignment | Current state |
|---|---|---|
| Product Owner | Person approving product risk and service objectives | Interim: `davidwills008`; independent production owner BLOCKED |
| Architecture Owner | Person approving Stage 1 exit and architecture exceptions | Interim: `davidwills008`; independent approval BLOCKED |
| Platform Engineering | Team implementing build, registry, and deployment controls | Interim lead: `davidwills008`; team assignment BLOCKED |
| Security Engineering | Team approving identity, secrets, scanning, and signing | Interim lead: `davidwills008`; independent security approval BLOCKED |
| SRE / Operations | Team owning telemetry, on-call, incidents, and recovery | Interim lead: `davidwills008`; on-call chain BLOCKED |
| Repository Administrator | GitHub administrator for rules, teams, and security settings | `davidwills008` |
| Service Owner | Team accountable for the generated payment service | Interim: `davidwills008`; production team assignment BLOCKED |

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
