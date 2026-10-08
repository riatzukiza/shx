---
category: "kanban"
labels: "decision, mutation, tooling"
type: "task"
write-id: "1786347840837-0.iwo7s7e45xhj2dejd8z"
points: "2"
title: "DECISION: how to mutation-test malli schema literals"
priority: "P2"
status: "incoming"
uuid: "heretic-schema-literal-attribution"
created_at: "2026-08-10T07:35:46.076Z"
---

# DECISION: how to mutation-test malli schema literals

## The question

Heretic cannot attribute a mutation inside a top-level `def` to any test, so
every malli schema constraint in `law/` reports as "no coverage" forever — do we
exclude `law/` from mutation, keep the noise and document it, or fix the
attribution?

## Why it needs deciding now

`bin/mutate` was wired up on 2026-08-10 and its very first report is 77%
"no coverage" (23 of 30 sites). **12 of those 23 are schema literals in
`law/config.clj` and `law/ir.clj`** — unattributable by construction, not
untested. The remaining 11 are honest gaps.

A number that is half artefact is a number people stop reading, and this tool's
whole value is that its output cannot be faked. Left as is, the first honest
signal gets buried in the first false one.

Concretely: `law/ir.clj:26` is `[:argv [:vector {:min 1} :string]]`. Mutating
`{:min 1}` to `{:min 0}` *would* be killed — `law.ir-test:28` asserts
`[:exec {:argv []}]` is rejected — but heretic never runs that test, because the
`def` evaluates at namespace load and the test-to-code index only records forms
executed *during* a test.

## Constraints

- Removing schema-literal artefacts must not hide remaining attribution bugs.
  Keep real test gaps distinct from covered sites whose attribution was lost.
- No lying by omission. If schema constraints are not mutation-covered, that fact
  has to be visible somewhere a reader will hit it.
- Heretic is pre-1.0 and experimental. A fix that depends on upstream behaviour
  is a bet.
- `law/` is, by namespace law, malli contracts and nothing else — so whatever is
  decided applies to the whole layer, cleanly.

## Options

### Option A — exclude `src/shx/law/*.clj` via `:exclude-files`

Same mechanism already used for `cli.clj` and `infra/`. Report becomes 18 sites,
5 killed, 2 survived, 11 no-coverage in the first-run baseline. Excluding `law/`
removes the schema-literal artefacts, but the remaining no-coverage list can still
include lost attributions such as `shape/quote.clj:18` in later measurements.

Costs: schema constraints are then never mutation-tested, and nothing in the
report says so. Requires a line in `docs/mutation-testing.md` and a note in
`heretic.edn` to stay honest.

### Option B — keep them in, document the partition

Status quo as of 2026-08-10. Nothing to build.

Costs: the headline no-coverage figure stays wrong in a way only the prose fixes,
and every future reader re-learns it. Grows worse as `law/` grows.

### Option C — make the constraints test-attributable

Move the mutable parts of a schema out of the `def` and behind a function the
tests call — e.g. a `min-argv` var or a schema-building fn — so the forms
evaluate inside a test's trace.

Costs: contorting the contracts to suit the measurement tool, which inverts the
relationship. Probably disqualified by that alone, but worth stating so it is
rejected deliberately rather than never considered.

### Option D — upstream: attribute load-time forms

File it with heretic: forms with no recorded covering test could optionally fall
back to running the whole suite, which is affordable here (the suite is
sub-second).

Costs: unbounded timeline, and it is a bet on a pre-1.0 tool. Not exclusive with
A — A can be reverted if D lands.

### Option E — do nothing, and stop reporting no-coverage

Not viable. The 11 real gaps in `shape/bb` and `shape/bash` are the most useful
output of the tool so far.

## Recommendation

**A now, D filed alongside it.** Moderate confidence. A removes the known `law/`
schema-literal artefacts with a one-line config change and is trivially reversible;
D must address both load-time attribution and lost attribution. C is rejected:
the schemas are the contract, and they do not get reshaped to flatter a measurement.

The cost of A — "schema constraints are not mutation-covered" — is worth stating
in `docs/mutation-testing.md` under Scope, next to the `cli`/`infra` exclusion it
would join.

The historical note below is retained as evidence. Its claim that A makes the
printed number mean one thing is superseded: the remaining no-coverage list can
still mix real gaps with covered sites such as `shape/quote.clj:18`. Keep that
limitation visible and do not ratchet on the score.

## Acceptance criteria

- [ ] The decision, its runner-up, and the reason it lost are recorded in
      `docs/mutation-testing.md` › Scope, and in a comment on this card
- [ ] If A: `heretic.edn` `:exclude-files` covers `src/shx/law/`, and
      `docs/mutation-testing.md`'s baseline block is re-measured, not edited by hand
- [ ] If D: the upstream issue is linked here
- [ ] `docs/mutation-testing.md` retains the distinction between real gaps and
      lost attributions in the remaining no-coverage sites after excluding `law/`

## Verification

```bash
bin/mutate mutate            # the printed totals match the documented baseline
grep -n "exclude-files" -A6 heretic.edn
```

## Out of scope

- Closing the 11 real no-coverage sites. That is
  `shx-kanban-shx-bb-cli-untested`.
- Raising `:preset` above `:standard`. Not until the survivor list is at zero.

---
New evidence for this decision, found while re-measuring on 2026-08-10.

Heretic does not only fail to attribute load-time forms — it can LOSE a correct attribution. Adding one deftest to test/shx/law/ir_test.clj (form registry 99 -> 100 forms) moved src/shx/shape/quote.clj:18 from killed to no-coverage. quote.clj was not touched, and shape.quote-test/dq-test asserts on dq's exact output three times, so the site is genuinely covered. Reproduced across three runs and two clean recollects.

This does not change the recommendation (A now, D filed) but it sharpens D and adds a constraint the options section should carry: the killed/no-coverage split is not stable under unrelated edits, so no option here can end with 'ratchet on the score'. Option A remains the only one that makes today's printed number mean one thing.

Recorded in docs/mutation-testing.md > 'The score is not stable'. Fold this into the body before this card leaves breakdown.
---

## Proposed current-source planning refinement (not an adopted decision)

This append is a planning proposal against owning Shx source
`f4ee133dcf1650c7eafb623ef084f62417252477`. The original card, five options,
four acceptance criteria and historical comment above remain intact. Incoming /
P2 / 2 points is unchanged; no Rheos transition, operational comment, decision
adoption, mutation measurement or configuration edit is performed here.

### Outcome and recommendation for review

Record a reviewed policy that distinguishes genuine test gaps, unattributed
load-time schema forms and lost attribution without silently removing executable
law verification. Proposed recommendation: **B now, with D investigated as a
separate upstream support path**. Keep the present mutation scope while documenting
the partition and its uncertainty. This is a proposal, not a decision or a claim
that an upstream issue/support route already exists.

A is the runner-up because it is small and reversible, but its original
file-level exclusion also covers `valid-config?`, `explain-config`, `valid-node?`,
`valid-program?` and `explain-program` in the current law files. It cannot be
adopted on the premise that those files contain only schema literal forms.
Retain the original conditional A acceptance criterion: if review nevertheless
chooses A, explicitly disclose this executable-law cost, preserve independent
law assertions and measured evidence, apply the reviewed exclusion and actually
remeasure the baseline. Do not hand-edit totals. C remains a reviewed alternative,
not permission to reshape contracts to flatter the tool. E would discard real-gap
signals and remains unsuitable. Review may choose a different option with recorded
reasoning; the historical A-now recommendation above is not erased.

### Scope, non-goals and ownership

This decision covers the full law-layer attribution policy and how readers see
remaining real gaps versus lost attribution. The design and complete option / AC /
verification matrix are in `docs/design/schema-literal-attribution-planning.md`.
A future adopted decision must be recorded in `docs/mutation-testing.md` > Scope
and a canonical Rheos comment, including its runner-up and why it lost.

No implementation, schema/configuration rewrite, score ratchet, preset increase,
closure of the separate emitter/CLI test gaps, new report parser, duplicate board
engine, operational comment or lifecycle change is included. Existing personal
PR 2 owns emitter/CLI/Bash testing; PR 3 owns the isolated shx.core runtime;
PR 4 owns structural/boundary gates; PR 5 owns the portable-core proposal and
explicitly retains this independent attribution-policy decision. None supplies
approval or adopted semantics for this card.

### Verification and remaining questions

The four original acceptance criteria remain mandatory, including both
conditional branches: A requires reviewed exclusion plus real remeasurement;
D requires an actual upstream issue link. The proposal adds controls for
executable-law coverage, schema constraints, an unrelated-test attribution
perturbation, stale indexes, selector incompleteness and missing tools. The matrix
preserves historical source/site references as dated evidence, not current counts.

Current docs describe `.clj` discovery. PR 5 proposes `.cljc` law/domain/shape:
its reviewed selector/instrumentation plan must demonstrably discover those files,
keep executable-law mutants visible and distinguish host-dependent attribution.
No pending `.cljc` behavior is borrowed into the current baseline.

Before Ready, reviewers must settle the chosen option, the partition's observation
method, any actual upstream D ownership/link, executable-law evidence retained
under A, extension/host discovery and two-point sizing. Implementation follows
planning review and lawful Rheos readiness. Later source/test/config changes
require the entire unchanged seven-check `bin/analyze --strict` gate and meaningful
mutation cases in a private sandbox; missing tools or unavailable attribution
support remain explicit refusals. This proposal runs neither gate nor mutation.
