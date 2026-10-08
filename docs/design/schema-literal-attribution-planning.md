# Schema-literal attribution decision: complete planning proposal

## Authority and observed source

This proposal belongs to existing UUID `heretic-schema-literal-attribution`,
Incoming / P2 / 2 points, at owning Shx main
`f4ee133dcf1650c7eafb623ef084f62417252477`. It preserves the complete 6,455-byte
card prefix, all five options, all four original acceptance criteria and the
historical comment. The 2026-08-10 measurements and instability reproductions are
historical source evidence; this preparation did not reproduce them or measure a
new baseline. Current source inspection establishes file contents, not runtime
behavior. No decision is adopted and no native comment or transition is performed.

`src/shx/law/config.clj` defines Malli data plus `valid-config?` and
`explain-config`; `src/shx/law/ir.clj` defines schema/registry data plus
`valid-node?`, `valid-program?` and `explain-program`. They remain pure validation
boundaries; no schema relocation or effectful adapter is proposed. `heretic.edn`
currently excludes only CLI/infra files, instruments domain/law/shape and uses
`:standard`. All test namespaces remain included; config-test reaches law
validation through `read-fragment-tree`. A whole-file exclusion therefore removes
more than load-time literal sites from mutation discovery. Unchanged exclusions
are not evidence that external input no longer needs validation.

`docs/mutation-testing.md` describes `.clj` discovery and a retained sandbox;
`bin/mutate` routes `collect` to Heretic, and `status` / `clean` through the
retained-sandbox cache helper. The reported `.clj` discovery capability is a source
statement; extension/host behavior must be tested before any `.cljc` consumption.
The fixed Heretic source recorded in `deps.edn` and current cache/config/source
identities must accompany any future run. Do not substitute current upstream
head or reuse a foreign writable sandbox, JVM cache or dependency store.

## Outcome and proposed disposition

Deliver a reviewed, recorded attribution policy with an honest partition of
named sites and an explicit account of unmeasured schema constraints and executable
law functions. **Recommend B provisionally, with D investigated alongside it.**
Keep the current scope and document the partition until attribution support can
be demonstrated. No automatic score threshold or inferred test-quality percentage
is proposed. The recommendation does not claim that B repairs Heretic or prevents
lost attribution; the limitation remains visible.

| Original option | Complete disposition proposed for review | Cost / evidence required |
| --- | --- | --- |
| A: exclude law files | Runner-up, not selected here. Whole-file exclusion includes executable validation/explanation functions. | If chosen, review and disclose both schema and executable-law loss, retain independent assertions and meaningful law evidence, apply only the adopted config and actually remeasure. A does not eliminate remaining lost attribution. |
| B: retain sites and document partition | Provisional preferred choice, keeping current discovery scope. | Headline remains mixed; reachable prose must distinguish measured sites, genuine gaps, unattributed schema forms and demonstrated or uncertain lost attribution. Do not claim the partition is automatic or exhaustive. |
| C: reshape schema evaluation | Preserve as a considered option; reject contorting canonical contracts solely for measurement. | Any later reconsideration needs a semantic justification independent of the tool, shape-law equivalence and review; no namespace move or builder function is implemented here. |
| D: upstream load-time / lost-attribution support | Investigate bounded actual upstream ownership and capability after review. | No issue is filed or link invented. If selected, link the actual issue and preserve both load-time and unrelated-edit loss cases; unavailable support is an explicit dependency. |
| E: suppress no-coverage reporting | Reject as a proposed choice. | It hides real gap signals and does not satisfy honest reporting. No local filter or percentage-only report is introduced. |

The original A-now recommendation remains historical provenance. A newly reviewed
choice must state why it differs and name the runner-up. Record the final decision
in `docs/mutation-testing.md` > Scope and through an authorized canonical Rheos
comment. Until then this document is proposed planning input, not an operational
comment or accepted policy.

## All four original acceptance criteria

| Original obligation | Required future evidence; unchanged contract |
| --- | --- |
| Decision, runner-up and reason in Scope and card comment | Exact adopted text linked from mutation docs plus canonical comment output/readback/event. Preserve original body/comment and all event prefixes. No self-authored proposal is the decision record. |
| If A, law exclusion and remeasured baseline | Reviewed exact exclusion/config diff and actual full output bound to source/config/tests/runner/cache state. Report any executable-law exclusions and independent law evidence. No hand-edited totals or inferred denominator. |
| If D, upstream issue link | Actual canonical upstream issue identifier/body/link with load-time and lost-attribution scope, existing-owner dedup and current disposition. A plan or hypothetical link does not satisfy it. |
| Real gaps versus lost attribution remains after exclusion | Reachable documentation names both causes and unresolved classifications; examples include historical shape/quote loss separately from genuine emitter gaps. Excluding law does not make the remaining headline a single trustworthy category. |

## Verification matrix: future controls, not executed claims

| Family | Positive / meaningful negative controls | Required observation |
| --- | --- | --- |
| Executable law | Known valid and invalid IR/config plus a deliberate validator-result mutation or guard change; schema data unchanged. | An asserting test fails for the intended changed decision; executable law appears in the actual discovered/mutated inventory, or its exclusion is explicitly accounted for if A is chosen. No green suite alone proves a kill. |
| Load-time literal | Historical empty argv / minimum-cardinality example with an actual literal mutation in a disposable copy; an equivalent or inert control is distinguished. | Named source form, selected tests and actual outcome; if index cannot associate tests, retain unattributed classification rather than imply missing assertions or a kill. No form-shape change to flatter the tool. |
| Real gap | Use the separately owned emitter/CLI/Bash site's scope and a genuinely unasserted form as a reporting control. | Gap stays visible. This decision does not close those tests or appropriate PR 2's work. |
| Lost attribution | Compare a known asserting quote test before/after a controlled unrelated test edit, restore all source/test bytes, and recollect according to actual project-versus-sandbox routing. | Full outputs and source/cache identities; reproduced loss, no loss or unavailable observation recorded. Historical loss is not a promised modern reproduction. |
| Index and discovery | Clean selected disposable sandbox versus stale index; unknown/missing namespace and unmatched file selector; instrumented source versus excluded source. | Actual discovered sites and test mapping, stale-state/refusal behavior visible. Empty selection is not a pass or a baseline. Do not build a second Heretic evaluator. |
| Extension and host | Current `.clj` baseline; after separately reviewed PR 5 implementation, actual `.cljc` discovery and executable-law controls on each supported host. | Full selector/instrumentation inventories, source/pin/host identities and relevant actual kills. JVM evidence cannot establish NBB/CLJS instrumentation capability; unsupported hosts remain explicit. |
| Failure and scope | Missing Heretic/ClojureStorm/JVM/rsync prerequisites, timeout, nonzero exit, incomplete output and absent upstream issue. | Preserve actual stderr/exit/warnings/timeout and retained partial evidence; no unavailable action promoted to success, no score ratchet or silent omission. |

Future baseline commands are the unchanged owner surfaces, in an independently
owned source/sandbox/home/dependency cache: `bin/mutate collect`,
`bin/mutate mutate`, `bin/mutate survivors`, `bin/mutate no-coverage`, and the
supported per-file `bin/mutate mutate --files ...`. `bin/mutate status` and
`clean` describe or mutate the retained sandbox, not a fallback project snapshot;
verify its identity before interpreting their output. Record the exact command,
working directory, selected file set, source/config/test/tool hashes, cache source,
full stdout/stderr and truthful exit. Proposed hostile cases are not current RED
or GREEN evidence. No candidate hooks, credentials or shared services are used.

For any later implemented source/test/config change, the complete existing
`bin/analyze --strict` gate remains mandatory: clj-kondo, splint, cljfmt, dead code,
jscpd, typed.clojure and Kaocha. Zero findings, no skipped checks, actual exit and
counts must remain visible. Mutation remains an experimental observation outside
that deterministic gate. Documentation preparation here is checked by source
preservation, exact references and Git range hygiene; no backend or JVM test run
is claimed.

## Coordination, boundaries, sizing and risks

Personal PR 2 owns complete emitter/CLI/Bash tests, PR 3 the isolated shx.core
runtime, PR 4 structural/boundary gates and PR 5 the complete portable-core plan.
PR 5 expressly retains this independent policy decision. No unmerged proposal,
review or measurements are adopted from those branches. Coordinate discovery and
executable-law evidence with PR 5 before implementation; the current `.clj` source
is authoritative until its reviewed successor is actually consumed.

The two-point Incoming estimate is retained, not re-estimated as completed work.
It covers the decision and reviewed rationale; implementing uncertain upstream
support is not silently packed into it. Review must resolve the chosen option,
partition method, A's executable-law cost, actual D route, extension/host support,
recording operations and fair sizing before lawful Ready. If the work grows,
review explicit decomposition on the existing outcome rather than inventing an
unrelated umbrella or claiming a small measured result completes the whole card.

Non-goals: implement a tool fix, change schemas/namespace semantics or Heretic
configuration, hide no-coverage, raise preset, close other gap cards, deploy,
activate controllers, merge the synchronization PR or mutate board lifecycle.
The historical broken-attribution observations are uncertainty to retain, not
license to disable evidence or assert every unattributed site is covered.

The prospective personal planning PR stacks on synchronization PR 1 branch
`codex/shx-sync-upstream-f4ee133` at exact f4ee; the parent remains unqualified.
DRAFT / blocked / auto-merge off is the proposed publication posture, subject to
root's fresh head/base/fork and transitive receiving checks. Draft quality jobs can
still execute candidate code with the documented read-only boundary; this proposal
supplies no general DRAFT safety, hosted approval, Ready, merge or release credit.
