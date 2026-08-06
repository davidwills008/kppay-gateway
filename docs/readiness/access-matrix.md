# Access and permissions matrix

All access is least privilege, named, time-bounded where possible, auditable, and removable. Credentials must be entered only through the selected platform's secure authentication flow.

| System | Required access | Role | Current finding | Status | Validation and revocation evidence |
|---|---|---|---|---|---|
| Local Git | Initialize and inspect repository | Platform Engineering | Empty repository initialized on `main` at matching checkout path `davidwills008/kppay-gateway` | PASS | `git rev-parse` and branch output; delete access not granted |
| GitHub account | Authenticate approved account | Repository Administrator | `davidwills008` authenticated through GitHub's device flow with `repo`, `workflow`, and `read:org` access | PASS | Redacted successful `gh auth status` recorded in `docs/evidence/readiness-discovery-2026-08-06.md`; revocation exercise remains part of `R-012` |
| GitHub repository | Admin for rules/settings; write for engineers | Repository Administrator | New private repository `davidwills008/kppay-gateway` created and connected as `origin`; baseline push and rules remain | READY | Repository URL, collaborator/team list, permission test |
| GitHub security | Manage CodeQL, dependency review, secret scanning, advisories | Security Engineering | Workflow files ready; features not activated | READY | Green check URLs and enabled-setting screenshots/links |
| Identity provider | Configure non-production application, claims, audience, and rotation | Security Engineering | Provider and tenant unknown | BLOCKED | Issuer metadata, client/app ID, token tests, rotation record |
| Secret manager | Administer policy; workload read access only | Security Engineering | Product and account unknown | BLOCKED | IAM policy, audit event, rotation and revocation records |
| OpenTelemetry platform | Configure collector/export; dashboard read for engineers | SRE | Backend and endpoints unknown | BLOCKED | Collector config, dashboard link, trace and alert test |
| Container registry | CI push; deployment pull; security scan/verify | Platform Engineering | Registry unknown | BLOCKED | Repository URL, digest, scan, signature and access test |
| Signing/provenance service | CI sign/attest; deployment verify | Security Engineering | Tool and trust root unknown | BLOCKED | Signature verification and provenance record |
| Deployment platform | Non-production deploy; production approval separated | Platform Engineering | Platform/environments unknown | BLOCKED | IAM/RBAC export, deployment, approval, rollback record |
| Incident platform | Manage schedules; responders acknowledge pages | SRE | Paging and escalation tools unknown | BLOCKED | Schedule link, page acknowledgement and escalation test |
