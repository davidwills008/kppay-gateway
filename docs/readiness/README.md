# Stage 1 readiness control center

This directory is the working control center for converting every remaining Stage 1 blocker into an owned, scheduled, executable, and evidenced task.

## Registers

- `stakeholders-raci.md` — responsibility and accountability.
- `access-matrix.md` — required least-privilege access and validation.
- `decision-register.md` — platform and policy decisions with their current status.
- `remediation-backlog.md` — prioritized executable tasks.
- `evidence-register.md` — proof required to close each task.
- `escalations.md` — resolved and unresolved decisions that need authority or external action.
- `discovery-questions.md` — minimum questions that still require user or stakeholder answers.

## Operating rules

1. Review this control center twice weekly until Stage 1 exits.
2. Every task has one accountable role, one deadline, dependencies, acceptance criteria, and an evidence ID.
3. A named person must replace each role assignment before operational approval.
4. Record links and non-secret identifiers only; never store credentials here.
5. Change status to `PASS` only after the evidence register contains verifiable proof.
6. Unresolved deadlines are escalated on the next working day.

Statuses follow `docs/production-readiness.md`: `PASS`, `READY`, and `BLOCKED`.
