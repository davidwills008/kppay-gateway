# GitHub control evidence — 2026-08-06

Repository: `https://github.com/davidwills008/kppay-gateway`

## Repository and baseline

- Visibility: public, explicitly confirmed by the user.
- Default branch: `main`.
- Baseline commit: `8a5210af080215ca0ea74c9e5b730b9ba963b379`.
- Repository Administrator access: create, admin, maintain, push, triage, and pull verified for `davidwills008`.

## Main branch protection

GitHub's protection readback confirmed:

- strict required checks: `verify`, `dependency-review`, and `codeql`;
- two approving reviews;
- code-owner review and approval after the last push;
- stale-review dismissal and conversation resolution;
- administrator enforcement and linear history;
- force pushes and branch deletion disabled.

The applied policy is versioned at `config/github/main-branch-protection.json`. Completion remains blocked until the bootstrap CODEOWNERS change reaches `main`, a second eligible approver is named, and the two-review acceptance test passes.

## Security controls

GitHub's repository readback confirmed:

- Advanced Security available for the public repository;
- secret scanning enabled;
- secret-scanning push protection enabled;
- Dependabot vulnerability alerts enabled;
- Dependabot automated security updates enabled;
- private vulnerability reporting enabled.

The mutable security settings are versioned at `config/github/security-and-analysis.json`.

## Automation evidence

- Foundation CI on baseline: `https://github.com/davidwills008/kppay-gateway/actions/runs/31102958185` — success.
- Latest Foundation CI on `main`: `https://github.com/davidwills008/kppay-gateway/actions/runs/31103737323` — success.
- Latest Security analysis on `main`: `https://github.com/davidwills008/kppay-gateway/actions/runs/31103737267` — success.
- Dependabot created and the user merged Maven and SHA-pinned GitHub Action updates after their Foundation CI checks passed.

Dependency-review jobs created while the repository was private failed because GitHub Advanced Security was unavailable at that time. A new pull request after public activation must prove dependency review and CodeQL together before `E-006` can become PASS.
