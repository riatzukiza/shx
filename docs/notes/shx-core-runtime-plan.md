# Proposed complete bb runtime contract

Status: Proposed planning refinement; no runtime implementation or readiness.
Existing card: `shx-kanban-shx-core-runtime-missing` (incoming, P1, five points).
Accepted source: octave-commons/shx@f4ee133dcf1650c7eafb623ef084f62417252477.
Development base: personal [sync PR1](https://github.com/riatzukiza/shx/pull/1).

## Decision and source authority

The original card says either implement shx.core or narrow the bb emitter's
claimed support. Keep that choice visible. Prefer the complete six-symbol runtime
below; planning review must accept, amend or reject that preference. Do not choose
narrowing merely to fit current tests. Five points remains the existing estimate;
review should decide whether this coherent end-to-end outcome fits or needs an
explicit lawful breakdown. No implementation stories, dependency UUIDs, estimate
changes or board transitions are fabricated by this note.

Current entry points are `src/shx/shape/bb.clj`, `src/shx/law/ir.clj`,
`src/shx/shape/quote.clj` and `test/shx/shape/bash_test.clj`. `emit-program` has
p/io requires without shx.core, and exec/pipe/capture/raw branches directly invoke
babashka.process. The schema admits general nested nodes for pipe/capture/test;
unsupported compositions must be identified and rejected before effects, with a
reviewed error contract. A valid broad IR shape is not proof of backend capability.
This does not silently delete schema variants or claim every schema-valid program
already has a meaningful BB execution.

## Proposed pure contracts and host boundary

Proposed paths (not existing implementation): `src/shx/law/bb_runtime.cljc` for
context, operation, environment-delta and result/error contracts;
`src/shx/shape/bb_runtime.cljc` for plain-data normalization;
`src/shx/domain/bb_runtime.cljc` for deterministic environment/PATH updates,
alias lookup and argv planning. Preserve Clojure maps/vectors/scalars at these
boundaries. Per-run context contains an explicit environment map, argv aliases and
run identity. Validate names (including NUL/invalid '='), string values, nonempty
argv, supported operator arity and host result shapes before admission.

Proposed `src/shx/infra/bb_runtime.clj` owns dynamic run binding, process handles,
filesystem predicates, child spawning, bounded source-result collection and exit
handling. A thin `src/shx/core.clj` is the BB-facing effect facade, not a pure
semantic namespace. Java objects, ProcessBuilder/babashka.process results, Bash
output and mutable atoms do not become domain authority. Pure logic stays `.cljc`
where practical; this plan does not force all host effects into `.cljc`.

A fresh generated program begins its own context from a caller-supplied/snapshotted
environment, requires the facade explicitly, and closes/reset its binding in
finally. It cannot modify the already-running invoking shell. Global `System`
environment mutation, shared atoms, dotfiles or persistent profile writes are not
allowed. Separate simultaneous/sequential programs receive independent contexts;
child requests receive immutable snapshots. Reset is explicit and exception-safe.

## Six emitted symbols

| Symbol | Preferred observable contract | Refusal/edge contract |
| --- | --- | --- |
| `set-env!` | Validate then replace one process-local env value; downstream children observe the update. | Invalid name/value leaves context unchanged and yields a named error. Never mutate parent/global environment. |
| `path-prepend!` | Prepend one nonempty path segment to the context PATH using the admitted platform separator; preserve order and repeated entries. | Reject ambiguous embedded separators/NUL; absent/empty PATH has a defined single-segment result. Runtime `:dir-exists` guard remains an adapter check. |
| `path-append!` | Append the segment under the same rules, including absent/empty PATH. | Same refusal and no parent/global mutation; never substitute envm render-time filtering. |
| `defalias` | Store a validated nonempty argv prefix; a matching command head expands once, followed by caller args without shell re-parsing. | Reject invalid name/argv and alias cycles; quote-sensitive args retain bytes. An alias is argv data, not an imported Bash function. |
| `source-bash` | Execute the given fixture/file in an isolated Bash child seeded by context; admit a complete validated exported-env delta after successful completion. | Fail closed on child/syntax/protocol error, unsupported state or missing Bash. No partial delta, automatic cwd import, secret-value logging or parent mutation. |
| `test` | Observe Bash-compatible test status:0 true,1 false; apply that boolean to `:if`. Preserve supported current `-d` behavior. | Status2/unknown/malformed syntax is a named error, not false or success; filesystem evaluation remains effectful. |

These contracts need review rather than an inferred acceptance. Full source/test
operator compatibility and platform expectations must be named in implementation
fixtures. Source's portable export delta includes additions, changed values and
unsets. Collect child state through a separate bounded protocol channel with
unambiguous framing, not stdout text or a shell-output eval. Keep source stdout,
stderr, original exit and protocol validity distinct. Do not accidentally import
child-only aliases/functions, non-exported variables or cwd. Detect unsupported
requested state changes and refuse instead of pretending they were propagated.
Bash's process-internal exported bookkeeping must have an explicit documented
policy; exported function records are not ordinary env names. Side effects inside
a sourced file are real execution; this runtime is not a sandbox or authorization
engine. Fixtures use only owned fictional files and no network/service/contact.

`test` may use a host Bash-test adapter where exact operator compatibility demands
it: pass argv without interpolation and validate the result/status. The pure layer
classifies its status and operator contract; filesystem/process observations stay
at the edge. Current inline `-d` generation must either keep its equivalent edge
behavior or call this facade with regression evidence. Unsupported host capabilities
are explicit errors; they do not become a boolean false that hides failure.

## Generated imports and process propagation

The complete program needs an explicit shx.core require and run lifecycle. Every
exec/pipe/capture branch must receive planned argv, context environment and node
options through a context-aware facade/adapter. Alias resolution happens before
child launch and exactly once. Per-node `:env` overrides the current context for
that child only; `:dir` is child-local. Pipelines use one context snapshot while
preserving staged exit statuses and resource cleanup. Capture separates stdout
from success/failure and retains primary failure even if cleanup also fails.

Audit `:raw` and Clojure/raw escape paths too: trusted raw code executes inside the
same explicit run binding, and language subprocesses receive context through the
adapter. Preserve raw fallback semantics; do not claim it is portable or secure.
`:set` and `:if` still compose ordinary values/booleans; errors do not silently
become truthy map values. Unhandled node/backend combinations refuse before
partial execution. Review whether such capability validation belongs beside
existing Program validation; no second IR schema/authority or evaluator is added.

Nonzero `:exec`, pipeline, capture/source infrastructure and unsupported runtime
failures cause a nonzero generated-script exit while retaining original primary
error/status. A false valid `test` is different: it selects the else branch and
can still complete successfully. This proposed behavior must be reconciled against
current `:continue true` branches explicitly, with compatibility fixtures and
review; removing an error is not an acceptable way to preserve a green test exit.

## Future red and green evidence

Proposed files: `test/shx/domain/bb_runtime_test.cljc`,
`test/shx/infra/bb_runtime_test.clj`, and
`test/shx/shape/bb_runtime_program_test.clj`. Final reviewed paths may change, but
use the owning Kaocha test command and inspect all assertions and statuses.

```bash
# Future implementation only; namespaces below do not yet exist.
clojure -M:test --focus shx.domain.bb-runtime-test
clojure -M:test --focus shx.infra.bb-runtime-test
clojure -M:test --focus shx.shape.bb-runtime-program-test
bin/analyze --strict
bb mutate
bin/mutate mutate --files src/shx/domain/bb_runtime.cljc
```

Red: generated programs fail first because the six symbols/imports/runtime context
are missing, and contract tests fail for named unimplemented behavior. Retain real
assertion counts and exit statuses. Green: implement pure contracts/decisions first,
then outer adapters/import/propagation, and rerun the same fixtures. Adjust mutation
file selectors only to the final reviewed source paths. Inspect surviving and
no-coverage sites explicitly; a clean percentage is not complete attribution.

Hermetic generated-script fixtures must actually execute BB with a closed env,
owned temp cwd/files and fake/owned process commands. Positive cases exercise all
six functions, export/PATH before downstream exec, aliases with quotes/spaces,
source add/update/unset, test true/false, sequential calls and exec/pipe/capture/raw
propagation. Negative cases include malformed env/alias input, missing/syntax/error
source, incomplete/oversized source protocol, unsupported Bash state, invalid test,
missing adapter capability, nonzero children/pipeline stages and cleanup failure.
No actual shell profiles, backend, model, provider, shared port or service is used.

Paired contexts with different sentinel env/aliases run concurrently and after
reset; assert no cross-run or invoking-parent leakage. Force one runtime/child
fixture to fail and prove both its generated script and the **official owning test
runner** exit nonzero before restoring it. Mocked host results can test admission
laws, but cannot replace actual generated-script/import/child-context evidence.

Required baseline is all seven `bin/analyze --strict` checks: pinned clj-kondo,
Splint, cljfmt, clojure-lsp, pinned jscpd, typed.clojure and Kaocha. Missing/skipped
or failed checks remain blockers. Runtime changes require meaningful mutation
checks of touched pure layers. The current planning gate observes only unchanged
accepted source; it cannot demonstrate any of these future runtime fixtures.

## Scope, overlaps and admission holds

Existing [personal PR2](https://github.com/riatzukiza/shx/pull/2) owns the emitted
string tests, full historical CLI/Bash obligations and their proposed breakdown.
This proposal does not rewrite that branch, count its tests as runnable runtime
proof, or narrow its umbrella. The two outcomes may share emitter entry points
only through serialized future ownership and explicit review; parallel overlapping
implementation is prohibited. No invented hard UUID dependency on PR2 is needed
to discuss the missing runtime, but actual implementation must reconcile its
accepted tests and any newly accepted source first.

Non-goals: envm PATH redesign, supervisor/clobber ports, shell/profile integration,
IR language expansion, archive normalization, new board/parser/validator/gate,
provider/session/identity policy, deployment, settings and historical rewrites.
Do not execute captured inbox examples. Read AGENTS, writing-cards and SHX1
qualification constraints as the current source/safety boundaries.

Implementation remains held for current-head native planning qualification,
reviewed semantics/size, lawful Rheos readiness and independently admitted tool
artifacts. No board state, UUID, write-id, comments or event has changed. Source
supports EDN through accepted Rheos ef3; published-distribution consumption remains
the existing eta-mu239 scope, not permission to add a local parser or infer a
transition/gate qualification from a read.
