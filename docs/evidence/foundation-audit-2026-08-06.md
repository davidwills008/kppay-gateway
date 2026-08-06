# Foundation audit evidence — 2026-08-06

Scope: repository-level controls for Stage 1 of `AGENTS.md`.

## Verified results

| Check | Result |
|---|---|
| Repository policy script | PASS |
| XML, YAML, and shell syntax | PASS |
| Toolchain | Maven 3.9.16 on Eclipse Temurin Java 25.0.1 |
| Maven Enforcer | Java, Maven, dependency convergence, duplicate dependency, and plugin-version rules passed |
| Checkstyle | 0 violations |
| Unit and architecture tests | 5 passed |
| Integration, security, and production-profile tests | 6 passed |
| Total tests | 11 passed; 0 failures, 0 errors, 0 skipped |
| Enforced line coverage | 17/17 lines, 100%; minimum gate 80% |
| SBOM | CycloneDX 1.6 JSON generated with 96 components |
| Clean build | BUILD SUCCESS |

Command used:

```bash
JAVA_HOME=/Library/Java/JavaVirtualMachines/temurin-25.jdk/Contents/Home \
  ./mvnw --batch-mode clean verify
bash scripts/verify-repository-policy.sh
```

Artifact SHA-256 at audit time:

- Application JAR: `382bcea5f2f237c901f09987c6c5110735b3c5254509a00ad878fb86d197f9dd`
- CycloneDX SBOM: `06e2f93d38400e29394545a43488b1cbf2a23434fba712990052d417cd5050b1`

Generated evidence is available locally under `target/surefire-reports/`, `target/failsafe-reports/`, `target/site/jacoco/`, `target/classes/META-INF/sbom/`, and `target/foundation-evidence/`. CI is configured to retain these as workflow artifacts.

## Remaining operational blockers

- Remote `davidwills008/kppay-gateway` and baseline `8a5210a` now exist; Foundation CI and main-branch CodeQL passed, and repository security features are enabled.
- GitHub rejected branch protection while the repository was private, then reported a change to public visibility at 12:56 UTC. The user confirmed public visibility; a second approver and final team-based ownership still remain required.
- Identity provider, managed secret store, OpenTelemetry collector/backend, registry, signing, provenance, deployment, and rollback controls require platform choices and access.
- Named people, on-call rotation, SLOs, escalation channel, and incident exercises remain required.

Decision: **repository foundation PASS; operational Stage 1 BLOCKED**. Do not begin Stage 2 until the blocker evidence required by `docs/production-readiness.md` is complete.
