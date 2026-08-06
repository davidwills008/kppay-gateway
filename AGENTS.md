# KPPay Gateway — Pinned Delivery Sequence

This implementation sequence is the project's standing engineering priority. All planning and implementation work must follow it in order. Do not skip, reorder, or bypass a stage unless the user explicitly approves the change and the reason is documented.

1. Establish service templates, CI/CD, secrets, and observability.
2. Define payment states, API contracts, and event governance.
3. Provision reliable messaging and outbox support.
4. Implement the Payment Orchestrator, Ledger, and one provider connector.
5. Validate complete success, pending, and failure scenarios.
6. Add routing, risk, reconciliation, refunds, and notifications.
7. Add more provider connectors only after the first path is operationally proven.

When proposing or performing work, identify the current stage and ensure its exit criteria are satisfied before advancing to the next stage.
