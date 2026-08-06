# Service runbook template

Complete this document before a generated service reaches production. Any remaining `TBD` is a failed production gate.

## Ownership

- Owning team: **TBD**
- Product owner: **TBD**
- On-call rotation: **TBD**
- Escalation channel: **TBD**

## Service objectives

- Availability SLO: **TBD**
- Latency SLO: **TBD**
- Recovery time objective: **TBD**
- Recovery point objective: **TBD**

## Dashboards and alerts

- Service dashboard: **TBD**
- Trace search: **TBD**
- Alert definitions: **TBD**

## Standard procedures

Every procedure must identify the detection signal, safe diagnostic steps, containment action, customer impact, recovery action, verification signal, escalation point, and evidence location.

At minimum, document:

- startup and deployment failure;
- dependency or provider outage;
- elevated errors or latency;
- queue backlog and poison messages;
- credential compromise, revocation, and rotation;
- rollback and forward recovery;
- data reconciliation and recovery;
- regional or platform recovery.

## Incident lifecycle

1. Acknowledge the page and assign an incident commander.
2. Classify severity and record customer, merchant, money-movement, and data impact.
3. Contain safely; never alter ledger or payment state manually without an approved procedure.
4. Communicate on the defined cadence and preserve a timestamped decision log.
5. Recover through the tested rollback, retry, reconciliation, or failover procedure.
6. Verify service indicators and business invariants before closing.
7. Complete a blameless review with owned corrective actions and deadlines.

## Exercises

- Last rollback exercise: **TBD**
- Last secret-revocation exercise: **TBD**
- Last dependency-outage exercise: **TBD**
- Open follow-up actions: **TBD**
