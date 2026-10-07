# Structural reports and namespace boundaries — proposed design

Status: proposed whole-card planning; no checker implementation or readiness.
Owner: octave-commons/shx. Source/base:
`f4ee133dcf1650c7eafb623ef084f62417252477`, the existing personal synchronization
PR 1 head, remains unqualified and unmerged. Foresight's declared Shx pin
`6cd0ce366c66ac50dfa3ec55bdd8e55eb021bcaa` is separate routing provenance.
No project drift or common-law promotion follows from that difference.

## Original outcome and authority

Existing UUID `structural-smells-and-boundary-check` retains Incoming / P2 /
five points, its original body and history byte prefix. The six original criteria
require domain I/O rejection; law-to-infra require rejection; both new blocking
sections running clean on the actual tree; forms rather than text; HARD/boundary
failures in normal and strict modes; and the documentation table/current absence
section updated. The two specific original manual mutations remain required:
`(clojure.java.io/file "x")` in `src/shx/domain/merge.clj`, and an
`[shx.infra.fs]` require in `src/shx/law/ir.clj`. They run only in independent
implementation fixtures, then revert, with actual native Rheos results recorded
when admitted. No hostile mutation has run for this proposal.

Current `docs/static-analysis.md` still marks both checks absent. Accepted
`bin/analyze`, `bb.edn`, existing configurations and source/test/workflow bytes
remain untouched by this planning diff. Donor Truth/Epiphany/Clio paths in the
original card are historical reference points, not execution authority or a
permission to copy foreign source, macros, runtime, thresholds or approval.

## Pure decisions and effect adapters

Propose `.cljc` for normalized analysis data, metric definitions, threshold
comparison, boundary decisions, deterministic findings and verdict composition.
Keep Malli input/finding contracts in `shx.law`, pure computation in `shx.domain`,
report morphisms in `shx.shape`, and reader/file/process/CLI effects in
`shx.infra` or an explicitly reviewed outer tooling adapter. `law` stays contracts
only; neither pure metrics nor schemas may depend inward on infra, JVM/Node
objects, process state or live filesystem APIs. These are proposed placements,
not a silent broad port of current namespaces. Review the original JVM/CLJC
question and the hexis plan for compatibility before ending breakdown.

The adapter captures clj-kondo's complete EDN analysis to an owned file and keeps
the original process exit distinct from the export's parse/shape/result. Validate
all replaceable inputs. An unsuccessful capture, empty/malformed export, missing
required analysis sections or unavailable reader is an unavailable check and a
nonzero gate, never zero smells. A valid warning-bearing export does not itself
become a structural breach: the existing kondo section handles its findings,
while the smell rules evaluate the valid analysis. Preserve diagnostic provenance
and the original capture exit rather than recreate the referenced PIPESTATUS bug.

Completeness is a reviewed input contract, not merely nonempty EDN or section
keys. Bind the selected source/test inventory and bytes to the pinned producer
version/schema and a supported coverage attestation showing those sources were
analyzed. Review the actual clj-kondo export surface before choosing fields; do
not invent a producer completeness flag. A manifest/hash alone does not prove
that definitions/usages were exported. Require the supported namespace/definition/
usage evidence appropriate to each selected input, with an explicit rule for
legitimate empty/comment-only fixtures. A valid-shaped export whose rows are
empty or which omits a known selected source/definition must be refused, with
negative fixtures proving the refusal. Do not silently shrink the corpus to the
rows that happened to arrive.

The form reader operates without evaluating source or reader-eval, and preserves
file and line information. Select and pin a reader with actual support for
`.clj`, future `.cljc`, aliases, metadata, quoted forms and reader conditionals;
the choice needs review and tests. No custom text-grep boundary or unverified
universal reader. Specify which executable branches are analyzed and fail closed
on unsupported relevant reader features instead of silently skipping a branch.

## Metrics, calibration and rule shape

Current source count at the pinned base: nine `.clj` files, 620 physical lines,
maximum file 122 lines. Historical 784-line wording is retained as original
context, not a current metric claim. Physical size is not definition count,
complexity, executable span, arity or dependency fan-out. A future calibration
artifact must enumerate those actual values with source identities and count
rules before choosing HARD thresholds. Distinguish source and test populations;
report both without quietly exempting test boundary violations.

Use a reviewed data table for god namespaces (definition count/size and fan-out),
mega-functions (source span and a reviewed structural complexity rule), parameter
bloat (fixed and variadic arities counted explicitly), and unique namespace
fan-out (dependencies rather than repeated call count). Specify multimethods,
multiple arities, generated definitions, self edges and test fixtures. The table
must include actual current maxima, chosen limits and reasons appropriate to this
small tree. Do not copy Truth's large-tree limits or select infinity/always-green
numbers. Review each limit with positive at-limit and negative over-limit cases;
HARD findings are blocking in both modes. If calibration finds current violations,
repair or explicitly review a per-site rationale before admitting the check;
no ratchet widening or advisory completion path. Threshold configuration is
versioned and testable input, not a model judgment at runtime.

Boundary findings are form-aware: resolve aliases/refers and fully qualified
symbols; reject effectful calls in domain/shape/law and forbidden law-to-infra
requires. The reviewed rule set must name filesystem/process/environment/network
and mutable host effects, direct JVM/JS interop, and transitive/indirect call
limitations. The two original cases are mandatory, not the only supported input.
Reject `utils`/`helpers` junk-drawer namespaces; explicitly review top-level CLI
adapters and legitimate test use of infra without globally exempting tests.
Comments, docstrings, inert quoted data and examples are positive controls.
Do not claim static analysis proves all runtime purity, especially dynamic
resolution/macros; expose unsupported/dynamic cases and their reviewed handling
rather than silently treating them as safe. No Truth-specific macro hook import.

A finding is ordinary Clojure data with rule ID, file identity, source range,
layer, observed metric/dependency and expected limit/allowed edge. Deterministic
sorting and stable rule IDs make reporting inspectable. The report adapter emits
readable diagnostics and a structured result; malformed report input or an
unavailable stage cannot be formatted into a success. No local receipt, event or
Rheos semantics are added to these schemas.

## Red, green and discovery verification

Future red begins with pure rule/threshold fixtures and adapter command fixtures
which fail under the existing absence of the checks. Use actual parser inputs and
kondo exports with version/source provenance, not a mirror of the implementation.
Positive programs pass; aliased and qualified I/O, forbidden requires, junk-drawer
names, every metric boundary, wrong schema and reader-conditional hostile
branches fail with the expected rule/location. Strings/comments/docstrings and
quoted data containing `io/file` pass. Reader-eval is rejected without executing
a marker side effect. Missing tool, capture nonzero, partial/empty export,
malformed forms and malformed report data return nonzero unavailable outcomes.
Test the independent original kondo exit as well as smell verdict. Include a
valid-shaped but empty analysis and an omitted selected-file/definition export
against a known nonempty corpus; both must be unavailable failures.

Green implements shapes/laws first, then pure decisions and outer adapters. Wire
both sections into the one `bin/analyze` gate and add separate `bb.edn` tasks;
normal and `--strict` execute the same blocking rules. Assert command discovery
and analyzer sections against an isolated copy of the real gate, using successful
other analyzers only for failure-semantics fixtures. Such fixtures never stand in
for the actual seven-tool run. Extend actual test discovery/paths for new
namespaces and `.cljc`, and review kondo, cljfmt, duplication and typed selectors
so added code is analyzed rather than accidentally omitted. Preserve the existing
`test/analyze_regression.sh` contract; run the real scripts with closed private
contexts and verify deliberate errors affect process exit.

Required implementation checks remain `bin/analyze` and `bin/analyze --strict`,
including kondo, Splint, cljfmt, LSP, jscpd, typed.clojure and Kaocha; add both new
blocking sections and require zero findings. Run pure laws on JVM and a practical
second portable host with exact versions and complete discovery, or explicitly
hold an unsupported host before claiming portability. If domain/law/shape changes,
run `bb mutate` and inspect genuine survivors and uncovered sites. Run both
original hostile source mutations by hand at least once in separate owned
fixture trees, preserve nonzero output/location, revert and prove source equality.
Future Rheos comment records actual results, not this proposal. Update tool table
and “What is not here yet” only as implementation matches reality.

## Dependencies, sizing and non-goals

Personal PR 2 (`698efc86a3749db0fdc4ce62e1dac2ec71f1f5a5`) owns emitter/CLI/Bash
coverage; PR 3 (`e271747deae46bd2f50d77d3a7b8d4b8f0d4ca00`) owns the complete
emitted runtime. These proposals have no native planning qualification and are
not adopted. Coordinate future analyzer/selector/test overlap at fresh base/head
and tested merge candidate; preserve emitted-runtime tests and envm's separate
PATH contract. No fabricated UUID dependency or approval transfer. Existing CLJC
port/hexis/sibling static-analysis cards remain context, with placement and
composition decisions reviewed here before implementation. No second umbrella
card, package migration, raw-expression execution, macro hook port, JS interop
inventory or foreign workflow change.

The complete two-check outcome remains five points. Reader behavior, calibration,
dual-host law discovery, real command fixtures and mutation evidence may justify
a lawful breakdown after review; propose that decision explicitly before code,
retaining all six criteria and both hostile checks. This proposal creates no
children, estimate changes or lifecycle transitions.

## Admission and observed preparation limits

Planning review, decisions above, lawful Rheos readiness, synchronization ancestry
qualification and required exact-head/base/merge-candidate checks remain held.
Installed eta-mu 1.1.1 bundles the stale JSON-only Rheos artifact. Its authoritative
Shx EDN read refused the config; current owner source already supports EDN and
existing [Eta Mu 239](https://github.com/open-hax/eta-mu/issues/239) tracks published
artifact consumption. No JSON diagnostic mirror, alternate board parser or
readiness inference. The original Incoming value is preserved source metadata.

The unchanged existing `bin/analyze --strict` preparation result and launch-only
private isolation are recorded in the owned verification note with raw streams.
A baseline run cannot establish either absent checker, future hostile cases,
mutation coverage, portable laws or a board transition. Only local planning
mechanics and that baseline are authorized here; no new checker/backend/provider,
shared service or CI execution.
