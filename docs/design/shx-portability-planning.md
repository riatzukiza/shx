# Complete Shx portable-core planning

Status: proposed full-scope refinement of the existing eight-point Todo card. No software port, lifecycle change, current-head approval or common-law promotion is established.

## Original outcome and decomposition

The original `kanban/port-shx-to-cljc.md`, UUID `shx-kanban-port-shx-to-cljc`, is preserved byte-for-byte, including frontmatter Todo/P1/8, labels and all original Context/Blocked-by/Note text. It has no numbered acceptance or verification section; the criteria here are new proposed completion contracts, not recovered historical ones. Shx AGENTS freezes card bodies after breakdown, so this proposal does not rewrite its established contract.

The complete outcome is runtime-neutral `.cljc` law/shape/domain usable from NBB and compiled shadow-cljs while preserving JVM semantics and pushing JVM-only effects behind externs. The Clio precedent and reusable Truth/Epiphany claim remain historical routing context, not accepted imports, destination approval, a child-wide port or permission to execute captured examples. The original “blocked-by nothing” text remains intact; current source-bound prerequisites below qualify future execution without inventing an engine dependency edit.

Propose three first-class Incoming stories, 3 + 3 + 2 = 8, linked to the original UUID. Review must decide the unchanged task’s epic role and whole sizing through Rheos before admission; no new umbrella or covert type conversion is authored. If complete host/adapter qualification does not fit two points, revise the full decomposition through review, never close the parent on a smaller fixture-only outcome.

## Current source-to-contract crosswalk

| Current source | Pure contract or effect | Proposed complete treatment |
|---|---|---|
| `law/config.clj` | Malli 0.16.4 open Fragment/Config, EvalEntry and validation/explanation | `.cljc` portable declarations and equivalent valid/invalid supplied-data fixtures; preserve optional/open-map behavior |
| `law/ir.clj` | Recursive twelve-head IR, nonempty Program, Exec argv/env/dir and validation | `.cljc` registry/public ABI with cross-host fixtures; review supervisor shared Exec seam first |
| `shape/quote.clj` | String morphisms plus `^:typed.clojure`/t annotations | `.cljc` with reviewed host-conditional annotation loading, retain JVM typed gate and all escaping/spacing |
| `shape/bash.clj` | Pure dispatch/string emission, validation then ex-info | `.cljc` exact payload/unknown-head/raw/failure parity; no command execution in pure tests |
| `shape/bb.clj` | Pure Clojure-string emission | `.cljc`; JVM/process symbols inside emitted strings are payload, not emitter imports; shx.core remains absent |
| `domain/merge.clj` | Pure fragment/host folds and documentation annotations | `.cljc`, preserve mixed-type fallback and both distinct precedence laws, not a new supervisor merge implementation |
| `infra/config.clj` | File/EDN/env/home/hostname/warnings/process exit and recursive traversal | JVM extern boundary plus compatibility facade; validation decisions consume Clojure data; trusted read effects remain outer |
| `infra/fs.clj` | Filesystem directory facts and envm filtering | JVM extern fact acquisition, stable pure filtering/order law where practical |
| `cli.clj` | Actual `:run` entrypoint, shell/env diff and print/exit | Retain JVM adapter ABI; extract render decisions only over supplied facts. No invented Node CLI parity or runtime API implementation |

This inventory is nine JVM source namespaces, six intended portable namespaces and three effect/entry namespaces. Host reader conditions isolate JVM-only imports and annotations; portable branches must not load java.io, System, Runtime, clojure.java.* or typed.clojure JVM dependencies. Host-specific values convert at the outer boundary, never become pure contract authority. A form/resolution-driven lint checks actual selected forms and branches; the plan does not implement a copied Clio validator, regex authority or second board engine.

## Semantics that cannot change during the port

Malli validation remains external admission. Preserve recursive IR and nonempty argv/programs, validation at emit-program rather than per-node emit, invalid-program exception type/explanation, Bash’s lack of a default and BB’s current unsupported placeholder/raw distinction. Do not introduce unsupported strict failures under the name of portability; PR2’s proposal must explicitly reconcile any future change. All twelve heads and nested operands are exercised, including emitted quoting/cwd/env/pipe/capture/test text. Generated code mentioning babashka.process, clojure.java.io or shx.core is emitted data and does not prove a runnable runtime.

Fragment merge remains maps shallow later-wins, vectors concatenated, everything else later-wins; folds distinguish later-in-sequence from closer-to-root tree precedence. Preserve unknown host behavior and stripping `:hosts`. Keep the raw escape hatch and fallback ratio contract. No canonical reordering, eval semantics, shell expansion policy or supervisor prototypes/mixins is introduced.

Config still fails the mandatory top-level file with exit 1 and warns/degrades a broken/cyclic fragment instead of wedging login. Preserve canonical cycle identity and actual relative include behavior, path expansion, directory existence/order/dedup, actual render/check/emit/validate arguments and unsupported target exits. envm filters directories at render time into one PATH assignment; IR emits per-entry runtime guards. Their convergence remains a separate design decision.

## Predecessor and ownership holds

Personal Shx PR1 is an unqualified terminal upstream sync at f4ee, not feature approval. PR2 owns the whole emitter/CLI/Bash testing outcome; PR3 owns all six generated runtime symbols and process-local effects; PR4 owns the complete structural/boundary report. This plan neither adopts their pending source nor supersedes their estimates/full criteria. Current source has no shx.core, no BB/CLI unit suite and no structural checker. Baseline and future port fixtures must distinguish present code from required qualified successors. Review fresh merge/file overlap and exact ABI before editing those seams; a pending PR’s earlier approval cannot approve this plan.

Existing supervisor-ir-law proposes a shared portable Exec schema and complete supervisor contract, while supervisor merge owns its separate fold. Reconcile registry ownership before extracting Exec; do not implement those additions here or pretend their future namespace exists. ADR absorption and qualification addenda require admitted consumer/version/replay contracts and preserve original captures, so portability alone authorizes no constellation merge or migration.

The Heretic literal-attribution decision remains Incoming and requires independent policy adjudication. Current discovery is documented as `.clj` only; `.cljc` migration must obtain meaningful executable-law mutation discovery/kill evidence without silently excluding all law files, weakening ratchets or claiming schema literals have runtime attribution. A missing upstream capability is a named owner hold, not permission to normalize away survivors.

## Red/green and complete verification

Before red, review exact Malli CLJS/NBB and compiled dependency support plus reader/typed strategy, a real pinned consumer for each target and runner/ABI/discovery commands. Current source has no NBB/shadow runner; do not present invented aliases as already operational. Commit reviewed runner/dependency wiring as part of the future implementation, with deterministic discovery reporting every six portable namespaces and a nonzero set of tests/assertions. JVM Clojure 1.12.3, Malli 0.16.4 and typed.clj 1.4.0 remain current pins until deliberately reviewed; record actual NBB/shadow/Node/compiler versions rather than silently using an old profile.

Red supplies shared positive/negative Clojure data fixtures and exact expected string payloads: all twelve heads/nesting/raw behavior, invalid input/error data, quote escapes/spacing, map/vector/mixed fallbacks, tree/sequence/host precedence, injected inward host references, missing namespace discovery, and a deliberately wrong law/test case that makes each official runner exit nonzero. A test that only loads a namespace or mirrors the implementation is insufficient. Compare outputs on JVM and NBB plus compiled shadow execution; compiled output must actually run/assert, not merely build. No eval of arbitrary configs/provider responses and no real shell home is involved.

Green first implements `.cljc` schemas/pure decisions, then externs/facades and scoped host runners. Preserve all existing five JVM test namespaces and config I/O tests; add meaningful law/config and portable shared fixtures where coverage is currently incidental. Reader-conditional test namespaces use clojure.test/cljs.test appropriately without disabling either host’s assertions. Discovery omission, zero tests, failed analyzer/compiler and unexplained unsupported dependency refuse success.

Retain unchanged `bin/analyze --strict` and all seven blocking checks, exact pins and zero-warning/clone contracts. Future migrated filenames must remain selected by kondo, Splint, cljfmt, LSP, typed quote checking, Kaocha autodiscovery and CI. Add appropriate explicit host runner coverage without weakening the JVM gate. Run `bb mutate` after pure-layer changes, read real survivors/no-coverage and prove `.cljc` selection with killed executable negative controls; report unavailable mutation support and literal attribution separately. Existing `bash test/analyze_regression.sh`, `bash test/mutate_regression.sh` and `node --test test/review_evidence_regression.cjs` retain their purposes and failures.

Adapters use private temporary fixtures and controlled child env/working directories: missing/malformed top-level config, bad/cyclic fragments, directory facts, CLI invalid target, pure render equivalence and two independent runs with no parent-shell/global file effects. A reviewed human script imports the pinned portable API on both required consumers and runs scoped JVM CLI inputs; it records commands/versions/exits/source hashes and preserves absent predecessor/runtime support honestly. No services, provider traffic, login-shell changes, env secrets or global installs are permitted.

## Admission and qualification limits

The actual source-built ef3 Rheos artifact can read authoritative EDN tasks; this is private source-bound visibility, not npm distribution, transition/gate dispatch or Ready qualification. Existing Eta Mu239 and Rheos5 distribution/read-only aggregate holds remain; direct task reads are not aggregate-board completeness proof. Native original Todo and proposed Incoming records retain their distinct lifecycle evidence. Planning review, lawful hierarchy/sizing and Ready remain prerequisites to any implementation. Current review quota/cooldown, signing App, trust/staging and parent qualification are observed independently by the coordinator; no local baseline supplies native approval or a merge gate waiver.
