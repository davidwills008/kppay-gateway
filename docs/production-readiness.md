# Production-readiness execution plan

Last reviewed: 2026-08-06
Current stage: **Stage 1 — service foundation**
Accountable role: **KPPay Platform Engineering**

## Goal and boundary

This plan closes engineering-foundation gaps in the order required by `AGENTS.md`. It does not authorize Stage 2 payment-state, API, or event work. A control is complete only when its acceptance criterion has objective evidence.

Detailed ownership, access, decisions, tasks, evidence, and escalations are maintained in `docs/readiness/`.

Status meanings:

- **PASS** — implemented and verified.
- **READY** — repository implementation is complete; external activation is required.
- **BLOCKED** — requires an owner, credential, platform, or remote repository that is not available locally.

## Implementation order and milestones

Dates below are proposed control dates. The accountable people must accept them when the remote repository and platform access are provided.

| Order | Milestone | Accountable role | Target | Exit evidence |
|---:|---|---|---|---|
| 1 | Repository quality baseline | Platform Engineering | 2026-08-06 | Local policy and Maven verification pass |
| 2 | GitHub controls activated | Repository Administrator | 2026-08-10 | Protected `main`, required checks, CODEOWNERS |
| 3 | Identity, secrets, and telemetry connected | Security Engineering and SRE | 2026-08-17 | Rotation test, authenticated startup, telemetry received |
| 4 | Artifact delivery and recovery validated | Platform Engineering and SRE | 2026-08-20 | Signed image, scan, deployment and rollback evidence |
| 5 | Stage 1 exit review | Architecture Owner | 2026-08-21 | Every mandatory row below is PASS |

## Control tracker

| Control | Owner | Status | Acceptance criterion | Evidence |
|---|---|---|---|---|
| Approved Spring service template | Platform Engineering | PASS | Initializr provenance and reuse rules documented | `docs/generation.md` |
| Local Git repository | Platform Engineering | PASS | Repository initialized with `main` as the default branch | `docs/readiness/evidence-register.md` (`E-002`) |
| Build toolchain integrity | Platform Engineering | PASS | Java 25 and Maven 3.9.16 enforced; wrapper checksum verified | `docs/evidence/foundation-audit-2026-08-06.md` |
| Static style and architecture rules | Architecture Owner | PASS | Checkstyle and ArchUnit fail invalid changes | Maven test reports |
| Unit/integration separation and coverage | Service Owner | PASS | Surefire/Failsafe run and line coverage is at least 80% | JaCoCo and test reports |
| Software bill of materials | Security Engineering | PASS | CycloneDX SBOM produced for every build | `target/classes/META-INF/sbom/` |
| Pull-request and security automation | Repository Administrator | PASS | CI, dependency review, CodeQL, and Dependabot run successfully | `docs/evidence/github-controls-2026-08-06.md` |
| Branch governance and code ownership | Repository Administrator | BLOCKED | Protected `main`, two-person review for critical changes, valid CODEOWNERS | GitHub ruleset URL |
| Secrets lifecycle | Security Engineering | BLOCKED | Managed store, workload identity, audit, rotation and revocation tested | Secret-manager audit record |
| Authentication baseline | Security Engineering | PASS | Production profile requires JWT; authorized and unauthorized tests pass | Failsafe report |
| Central logs, metrics, and traces | SRE | BLOCKED | Collector receives all three signals and required alerts fire in test | Dashboard, trace, and alert links |
| Artifact registry and supply-chain controls | Platform Engineering | BLOCKED | Immutable image, vulnerability scan, signature and provenance retained | Registry digest and attestation |
| Incident and recovery readiness | SRE and Service Owner | BLOCKED | Named on-call, SLOs, rollback and recovery exercise completed | Completed runbook and exercise record |

## Automated quality gates

Every pull request must pass:

1. `./mvnw --batch-mode clean verify`.
2. `bash scripts/verify-repository-policy.sh`.
3. Checkstyle and compiler warnings-as-errors.
4. Unit, integration, security, and ArchUnit tests.
5. JaCoCo line coverage of at least 80%.
6. CycloneDX SBOM generation.
7. CodeQL and dependency review once GitHub security features are enabled.

No administrator bypass is permitted for payment, security, ledger, provider, contract, or event-governance changes. Emergency bypasses require a linked incident and a follow-up review within one working day.

## Stage 1 exit decision

Stage 1 remains **BLOCKED** until every control above is PASS. Repository work can make a control READY, but only evidence from the selected GitHub, identity, secret, observability, registry, and deployment platforms can complete the operational controls.
