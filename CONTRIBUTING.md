# Contributing

1. Confirm the current pinned stage in `AGENTS.md`.
2. Create a short-lived branch and keep the change focused.
3. Add or update tests, contracts, documentation, telemetry, and rollback notes for the change.
4. Run `./mvnw --batch-mode clean verify` and then `bash scripts/verify-repository-policy.sh`.
5. Open a pull request using the repository template and attach evidence.

Use Conventional Commit subjects such as `feat:`, `fix:`, `test:`, `docs:`, `build:`, or `chore:`. Never commit secrets or production data. Material architectural choices require an ADR under `docs/decisions/`.
