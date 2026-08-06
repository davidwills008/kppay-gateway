#!/usr/bin/env bash
set -euo pipefail

required_files=(
  AGENTS.md
  CONTRIBUTING.md
  SECURITY.md
  README.md
  pom.xml
  .mvn/wrapper/maven-wrapper.properties
  .github/workflows/ci.yml
  .github/workflows/security.yml
  docs/architecture.md
  docs/development-standards.md
  docs/evidence/foundation-audit-2026-08-06.md
  docs/evidence/github-controls-2026-08-06.md
  docs/evidence/readiness-discovery-2026-08-06.md
  docs/production-readiness.md
  docs/readiness/README.md
  docs/readiness/stakeholders-raci.md
  docs/readiness/access-matrix.md
  docs/readiness/decision-register.md
  docs/readiness/remediation-backlog.md
  docs/readiness/evidence-register.md
  docs/readiness/escalations.md
  docs/readiness/discovery-questions.md
  docs/runbook.md
  docs/secrets.md
)

for required_file in "${required_files[@]}"; do
  if [[ ! -s "${required_file}" ]]; then
    printf 'repository-policy=FAIL missing=%s\n' "${required_file}" >&2
    exit 1
  fi
done

if ! git rev-parse --is-inside-work-tree >/dev/null 2>&1; then
  printf 'repository-policy=FAIL control=local-git-required\n' >&2
  exit 1
fi

required_controls=(
  "pom.xml|maven-enforcer-plugin"
  "pom.xml|maven-checkstyle-plugin"
  "pom.xml|jacoco-maven-plugin"
  "pom.xml|archunit-junit5"
  ".mvn/wrapper/maven-wrapper.properties|distributionSha256Sum="
  "src/main/resources/application-prod.yml|jwt-enabled: true"
  "src/main/resources/application-prod.yml|issuer-uri: \${KPPAY_SECURITY_JWT_ISSUER_URI}"
  "src/main/resources/application-prod.yml|audiences: \${KPPAY_SECURITY_JWT_AUDIENCES}"
  ".github/workflows/ci.yml|verify-repository-policy.sh"
)

for required_control in "${required_controls[@]}"; do
  file="${required_control%%|*}"
  value="${required_control#*|}"
  if ! grep -Fq "${value}" "${file}"; then
    printf 'repository-policy=FAIL file=%s control=%s\n' "${file}" "${value}" >&2
    exit 1
  fi
done

if grep -REq 'uses: [^ ]+@(main|master|v[0-9])' .github/workflows; then
  printf 'repository-policy=FAIL control=github-actions-must-use-immutable-sha\n' >&2
  exit 1
fi

for number in {1..11}; do
  printf -v id 'D-%03d' "${number}"
  if ! grep -Fq "${id}" docs/readiness/decision-register.md; then
    printf 'repository-policy=FAIL missing-decision=%s\n' "${id}" >&2
    exit 1
  fi
done

for number in {1..13}; do
  printf -v id 'R-%03d' "${number}"
  if ! grep -Fq "${id}" docs/readiness/remediation-backlog.md; then
    printf 'repository-policy=FAIL missing-remediation=%s\n' "${id}" >&2
    exit 1
  fi
done

for number in {1..14}; do
  printf -v id 'E-%03d' "${number}"
  if ! grep -Fq "${id}" docs/readiness/evidence-register.md; then
    printf 'repository-policy=FAIL missing-evidence=%s\n' "${id}" >&2
    exit 1
  fi
done

for number in {1..5}; do
  printf -v id 'X-%03d' "${number}"
  if ! grep -Fq "${id}" docs/readiness/escalations.md; then
    printf 'repository-policy=FAIL missing-escalation=%s\n' "${id}" >&2
    exit 1
  fi
done

mkdir -p target/foundation-evidence
printf 'repository-policy=PASS\n' | tee target/foundation-evidence/repository-policy.txt
