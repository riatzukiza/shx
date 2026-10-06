---
uuid: "shx-kanban-shx-core-runtime-missing"
title: "shape/bb emits calls to a shx.core runtime that does not exist"
status: "incoming"
priority: P1
labels: ["tasks","shx","debt","5sp"]
created_at: "2026-08-10T05:44:12.012Z"
source: "shx/kanban/shx-core-runtime-missing.md"
category: "tasks"
points: 5
---

# shx.core does not exist

`shx.shape.bb` generates calls to `set-env!`, `path-prepend!`, `path-append!`,
`defalias`, `source-bash`, and `test` on a `shx.core` namespace that is not in
the repo. Generated bb code is therefore not runnable for shell-state effects.

Either implement `shx.core` or narrow what the bb emitter claims to support.

## Proposed complete-runtime refinement — 2026-10-06

This is a planning proposal against accepted upstream
`f4ee133dcf1650c7eafb623ef084f62417252477`, stacked on personal fork sync
[PR1](https://github.com/riatzukiza/shx/pull/1). The original choice above remains
open. Prefer implementing a complete, explicitly bounded runtime for **all six**
emitted symbols, rather than reducing support to fit existing tests. This preference
is not an accepted decision. Keep this card incoming/P1/five points with its exact
UUID, write-id, original body and event history; planning review must decide whether
five points fits or whether lawful breakdown is needed. No child cards or hard
dependencies are invented here.

### Context and proposed outcome

`src/shx/shape/bb.clj` emits `set-env!`, `path-prepend!`, `path-append!`, `defalias`,
`source-bash` and `test`; no `shx.core` namespace exists in accepted source.
`emit-program` requires only babashka.process and clojure.java.io. Direct `p/shell`
process calls currently cannot consume a future runtime's process-local environment
or alias context automatically. The proposed outcome is a generated bb program
whose six runtime calls resolve, whose downstream exec/pipe/capture operations use
that program's context, and whose errors have observable nonzero script exits.
The [complete proposed contract](../docs/notes/shx-core-runtime-plan.md) states the
laws, host seams, supported source/test behavior and adversarial fixtures.

### Scope

- Define Clojure-shaped context/operation/result/error contracts and pure updates
  in practical portable `.cljc` law/shape/domain namespaces; keep filesystem,
  Bash/BB child execution, process status and mutable run context in outer adapters.
- Provide every named runtime function, explicit generated requires/run lifecycle,
  and context-aware process invocation for exec, pipelines, capture and raw-host
  operations. Review all current emitter branches; do not silently leave a
  known disconnected `p/shell` branch behind.
- Define aliases as validated argv-prefix data; define sourced exported-environment
  deltas and unsupported Bash-only state explicitly. Define `test` true/false/error
  separately, including current inline `-d` behavior and malformed tests.
- Keep process-local context separate from the invoking parent shell and other
  runs. Do not reinterpret envm's existing render-time PATH filtering or IR's
  runtime guards. No shell/profile integration or provider/service adapter work.

### Acceptance criteria for the preferred option

1. All six emitted symbols resolve in a generated hermetic bb script through
   explicit requires. Validate operation shapes before effects and assert exact
   context updates/results, including invalid argument and unsupported-operation
   refusal. Preserve the original implement-or-narrow alternative for review.
2. Export/PATH updates reach subsequent exec, pipe and capture children, with
   per-node env precedence and alias argv forwarding/quoting proven. The original
   parent environment and an independent second run remain unchanged; reset and
   exceptional completion release context without cross-run leakage.
3. Source evaluates a named fixture only in an isolated Bash child; successful
   exported variable additions/updates/unsets are admitted as a validated delta.
   Alias/function/working-directory changes are not silently imported. Unsupported
   state, malformed/missing completion evidence, syntax/child failure and missing
   Bash fail closed without partially applying the delta or logging environment
   values. Source is executable input, not a security sandbox.
4. `test` returns boolean true for status0 and false for status1; malformed or
   unsupported syntax/statuses produce a named failure. False is a valid `:if`
   decision rather than a script infrastructure failure. Keep `-d` filesystem
   checks in the host adapter and preserve current conditional behavior.
5. Generated-script fixtures cover each symbol and every context-consuming
   emitter branch, positive/negative/reset/error/paired-isolation cases, special
   characters and multiple sequential updates. Assert a deliberately failing
   child/runtime fixture makes the **official test command and generated script**
   nonzero. No mock-only or emitted-string-only result supplies runtime proof.
6. Required `bin/analyze --strict` completes all seven checks with no blocking
   findings; inspect actual test assertions and nonzero paths. For changed pure
   law/shape/domain code run mutation checks and inspect killed/surviving/no-coverage
   sites, naming any upstream attribution limitation rather than claiming a score
   proves coverage. This is future implementation evidence, not this proposal's
   observed qualification.

### Verification and boundaries

Future red/green commands, proposed test namespaces and exact fixture obligations
are in the design note. Existing personal [PR2](https://github.com/riatzukiza/shx/pull/2)
retains its full bb emitted-string, CLI and Bash-test/mutation scope; those outcomes
are distinct and are not claimed complete here. Do not transplant or rewrite its
branch. No new `.core` runtime code, new tests, status transition, events, source
execution, env/profile writes or deployment is part of this planning change.

Review must adjudicate the proposed complete runtime, source/alias/test semantics,
coverage of all emitter paths and whether five points is adequate. If a breakdown
is needed, propose it explicitly and use reviewed Rheos operations later. Historic
main/PR qualification does not make this new proposal ready. Native planning
qualification and a lawful Rheos ready transition precede implementation.
