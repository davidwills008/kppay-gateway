# Delivery and supply-chain standard

CI must build once and promote the same immutable artifact between environments. Every released image requires:

- a commit and template revision;
- a CycloneDX SBOM;
- vulnerability scanning against the approved severity policy;
- a registry digest instead of a mutable deployment tag;
- a verifiable signature and build provenance;
- environment approvals and separation of duties;
- automated health verification and a tested rollback path.

The repository currently creates the application artifact and SBOM. Registry, signing, provenance, deployment, and rollback evidence remain external Stage 1 controls.
