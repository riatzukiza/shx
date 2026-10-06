---
category: "tasks"
labels: ["tasks", "shx", "tests", "3sp"]
write-id: "1786347840437-0.i0i2osjpb7ckswdzlyr"
points: "3"
source: "shx/kanban/shx-bb-cli-untested.md"
title: "shape/bb and cli have no tests"
priority: "P1"
status: "incoming"
uuid: "shx-kanban-shx-bb-cli-untested"
created_at: "2026-08-10T05:44:12.012Z"
---

# Untested namespaces

Covered: `shape/bash`, `shape/quote`, `law/ir`, `domain/merge`, `infra/config`.
Uncovered: `shape/bb`, `cli`.

This matters more than usual because `shape/bb/emit` has a `:default` method
returning nil, which `emit-program` turns into a
`# bb emit not implemented for <head>` placeholder. It degrades silently and
will not fail the build.


## Proposed refinement for planning review — 2026-10-06

### Outcome

The existing broad test gap has a current, reviewable decomposition. Its first
independent slice specifies tests for the pure Babashka emitter without running
generated shell/process effects or implementing the missing `shx.core` runtime.
This proposal does not close the original card: CLI coverage and the historical
Bash mutation gaps remain explicit obligations.

### Context and sizing

At accepted upstream `f4ee133dcf1650c7eafb623ef084f62417252477`,
`src/shx/shape/bb.clj` has twelve named emitter methods, a default returning nil,
and `emit-program` validation/header/ordering behavior. No `test/shx/shape/bb_test.clj`
or `test/shx/cli_test.clj` exists. These are source observations, not a fresh
mutation result. The 2026-08-10 measurements below remain historical facts;
line numbers and totals must be recollected at the implementation revision.

The frontmatter's existing three-point estimate is retained as history. The
combined scope needs a reviewed breakdown: propose an eight-point epic with
three vertical stories, rather than pretending all CLI/effect/coverage work fits
one three-point implementation. The following UUIDs are proposal identities only;
no child card, parent/dependency field, epic type, point change or transition has
been admitted. Before implementation, review the breakdown, author the scoped
incoming child cards, perform required metadata operations through Rheos, and
obtain qualified planning plus lawful ready events.

| Proposed story | Proposed UUID | Points | Independently observable outcome |
| --- | --- | --- | --- |
| Assert pure bb emitter output and rejection contracts | `c402b8c1-4274-4648-b783-abbc85f2b1fc` | 3 | Emitted text/forms and invalid-program diagnostics are tested without evaluation |
| Cover CLI decisions at injected process/filesystem boundaries | `5d2c36c1-f2d3-4222-bbd5-fa849e6ec297` | 3 | CLI output, errors and effect intent are tested with private fixtures and replacement boundaries |
| Close current Bash emitter mutation gaps | `8fa26bd8-5c85-4d7b-a345-7b670fc636d7` | 2 | Current relevant mutants are killed with behavior assertions; historical sites are reconciled explicitly |

The first story has no semantic dependency on implementing `shx.core`; emitted
qualified symbols are data, not a promise that generated shell-state code runs.
The runtime choice remains owned by `shx-kanban-shx-core-runtime-missing`.
No hard dependency on Clio, Muse, supervisor stories, or the proposed portability
migration is created. The CLI story needs its own reviewed effect-boundary plan;
its instrumentation exclusions must not be removed to claim mutation coverage.

### First story scope and acceptance criteria

Future target: `test/shx/shape/bb_test.clj`, following existing `clojure.test`
style and `test/shx/shape/bash_test.clj`. Reference contracts:
`src/shx/shape/bb.clj`, `src/shx/law/ir.clj`, `src/shx/shape/quote.clj`,
`heretic.edn`, `bin/analyze`, and `bin/mutate`.

- Given every currently implemented head (`:export`, `:path/prepend`,
  `:path/append`, `:alias`, `:source`, `:exec`, `:pipe`, `:capture`, `:set`,
  `:if`, `:test`, `:raw`), assert independently chosen expected output/forms.
  Cover guarded/unguarded paths, both directory/environment option presence
  and absence, multi-stage pipes, both if arities, directory/generic tests,
  Clojure raw passthrough and foreign-language raw process text. Include quotes,
  backslashes and embedded newlines so argument-boundary regressions are caught.
- Assert exact symbolic references to the missing runtime for shell-state forms;
  never require that namespace, `eval` generated output, start a child process,
  source a shell file, inspect real host directories, or mutate the operator env.
  Parse representative generated Clojure forms as data with evaluation disabled;
  compare complete expected forms rather than substrings copied from production.
- At the public `emit-program` boundary, malformed or empty IR must throw
  `ExceptionInfo` with `:type :shx/invalid-program` and a nonempty explanation
  before output. Assert nonempty program order and exactly one standard require
  header. Per-node `emit` continues to assume valid input; do not invent per-node
  validation or silently change that boundary.
- Exercise default dispatch separately and establish whether a schema-lawful
  currently unsupported program exists. If no such node exists in the current
  registry, record that fact instead of inventing a new node or claiming public
  fallback reachability. A stubbed test may characterize `emit-program` fallback
  mechanics, but must be labelled a replacement-boundary fixture. The current
  single-`#` placeholder is not asserted to be readable or executable Clojure.
- Recollect current mutation coverage and inspect survivors at the exact test
  revision. New assertions must catch relevant mutations, not merely execute
  forms. Classify default/fallback attribution honestly if Heretic does not
  generate a site; do not promise all legacy sites disappear without measuring.
  The separate Bash and schema-literal attribution obligations remain open.
- A test-only slice may pass the baseline: do not fake a red phase. Introduce an
  isolated intentional output/branch mutation to demonstrate a specific failing
  assertion, then restore it. Any real defect needs its own reproduced law/test
  red evidence, bounded repair after this plan is qualified, and new green proof;
  do not freeze known wrong behavior or silently expand into a runtime redesign.

### Verification and readiness hold

Future implementation commands, from its new private checkout with private Maven,
Gitlibs, analyzer and Heretic cache/sandbox roots:

```sh
clojure -M:test --focus shx.shape.bb-test
bin/mutate
bin/mutate survivors
bin/mutate no-coverage
bin/analyze --strict
```

Capture exact source SHA, installed tool versions, raw exit statuses, Kaocha
counts, current site lists and intentional-mutation failure. Run all seven
blocking checks; missing or skipped tools are failures. Keep current deps,
compiler and mutation pins, zero duplication threshold, exclusions and warning
policy unchanged. No proposed implementation or mutation command has run.
The required existing baseline `bin/analyze --strict` was run separately at
planning head `44aa8ebe5ef491f4f6619edd7a0f03c811bd00a8`: exit0, all seven
blocking checks passed, Kaocha19tests/46assertions/0failures. Its existing
typed.clojure deprecation output is retained. This is local baseline evidence,
not native planning approval, reviewed breakdown or lawful ready admission.

The installed Rheos 1.1.1 rejects the authoritative `openhax.kanban.edn` via
`JSON.parse` (exit1). Reading `openhax.kanban.json` succeeds as a diagnostic mirror
of the same task directory; it omits the authoritative build-gate extension.
That read does not validate EDN discovery, the build gate, lifecycle transitions
or readiness. Do not add a Shx config parser, board engine, alternate gate or
workflow shim. Resolve current authoritative engine/config compatibility through
the owning Rheos implementation before any operational transition. Native
planning qualification, reviewed breakdown and lawful child ready admission are
still missing; incoming state and historical events remain unchanged.

### Non-goals and risks

No source/test/config/workflow/dependency implementation, JVM-to-CLJC migration,
`shx.core`, CLI effects, model/provider/session semantics, shell env evaluation,
PM2/Compose/systemd/Kubernetes operation, port, service or deployment change.
Existing CLI and Bash obligations are retained, not silently marked complete.
The broader test contract needs new review; historical merged PR1/2/3 and historic
analyzer totals provide context, not current planning qualification. Estimates
remain provisional until review; if the bb slice exceeds three points, re-scope
or split it explicitly before ready. Full original frontmatter, body and engine
comment bytes are preserved around this authored body addition.

---
Mutation evidence, 2026-08-10 (first bin/mutate run in this repo).

heretic now measures the pure layers. Of 30 mutation sites, 11 are honest no-coverage gaps and both live in this card's territory:

  src/shx/shape/bb.clj   9 sites — lines 14, 20, 26, 39, 64, 69, 85, 86
  src/shx/shape/bash.clj 2 sites — lines 13, 26

So this is no longer 'bb and cli have no tests' in the abstract: those are the specific forms where a mutation would never be run because no indexed test reaches them. bb.clj's :default-returning-nil path is exactly the silent-degradation risk the body already names, and it is unreached.

cli.clj is NOT in that count — it is excluded from mutation in heretic.edn because it is not instrumented (mutating the process boundary is low-signal), so heretic can say nothing about it either way. Its lack of tests is real and still belongs to this card; it just will not show up in a mutation report.

Verification for whoever picks this up: bin/mutate no-coverage should stop listing shape/bb.clj and shape/bash.clj. Score is killed/(killed+survived) and ignores no-coverage, so watch the site list, not the percentage.

Remaining 12 no-coverage sites are law/ schema literals — a heretic attribution limitation, not a gap. Carded separately as heretic-schema-literal-attribution. See docs/mutation-testing.md.

Correction to the previous comment's arithmetic, after re-measuring on a clean recollect.

The 11 honest gaps are unchanged and still yours: shape/bb.clj 9 sites (14, 20, 26, 39, 64, 69, 85, 86) and shape/bash.clj 2 sites (13, 26).

The remainder is 13, not 12: 12 law/ schema literals plus one lost attribution at shape/quote.clj:18. Totals are now 30 sites, 4 killed, 2 survived, 24 no-coverage, score 66.7% — see docs/mutation-testing.md > 'The score is not stable'. Nothing about this card's scope changes.
---