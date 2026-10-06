# Current Shx emitter test planning

Planning only at accepted `f4ee133dcf1650c7eafb623ef084f62417252477`.
Existing incoming card [shx-kanban-shx-bb-cli-untested](../../kanban/shx-bb-cli-untested.md)
is refined in its body, preserving original body/frontmatter and historical engine
comment bytes. No second umbrella card is created. Proposed first story `c402b8c1-4274-4648-b783-abbc85f2b1fc`
(three points) covers pure emitted text/forms, public IR validation and measured
mutation effectiveness. Original CLI and Bash requirements remain and require
separate reviewed stories; proposed total eight points is not an engine estimate.

Fresh intake found no upstream or personal open Shx issues/PRs. Closed upstream
PR1/2/3 are merged board/gate/supervisor work; the existing test card has one
creation commit `c3214b8e9e8543c2c16662666f5c4888362b350a`, no later scope implementation.
No bb/CLI test files exist at the current source. This does not establish fresh
mutation totals or complete absence of indirect execution in other tests.

Mapped personal `riatzukiza/shx` has parent/source `octave-commons/shx`, default
main. Fork main `c3a6631a39e57d88898c3ba52cd62573e4b9ecf9` is strictly 45 accepted commits
behind upstream, zero fork-only. Separate ordinary sync candidate points to exact
accepted upstream `f4ee133dcf1650c7eafb623ef084f62417252477`; this planning candidate stacks
on that head. No direct main push or history rewrite is proposed. Sync is terminal
source preservation, not a feature/deploy admission. Root peer reviews both before
publication; all native reviews/qualification remain outstanding.

Current `.github/workflows/eta-mu-evidence-review.yml` uses a read-only caller and
same-repository/non-draft condition, reusable pin `45ec644c2d15ed511e9bc1e797d1b4073b63dbfc`,
Muse `0b9a91492c8355e6933dc2164d35668cb76d9e60`, skills `7fd3252e7663ad5e68be5e90429d126aa66c38c8`.
It maps only ETA_MU_APP_ID / ETA_MU_APP_PRIVATE_KEY for the publisher; visibility is
not tested here and no credential failure is inferred. Static-analysis/test workflows
are checks. No eager auto-merge, release/deploy/signing caller was found in the three
committed workflows. Automatic merge must remain off; no settings or workflows change.

Authoritative EDN native read fails with stale `@eta-mu/rheos`0.1.0 bundled
by installed eta-mu1.1.1;
the deprecated JSON mirror reads 31 tasks, zero ready, six todo, 17 incoming,
one breakdown, one review, four done, one icebox, one archived. Mirror results are
diagnostic only; no transitions or gate validation. Current accepted Rheos `ef3c4abf1ea75199486f693e9470df3fec88dd49` already
implements/documents EDN. Root canonical shape/config API evidence preserves
`:extends` / `:build-gate-commands` in unchanged Shx EDN. Existing
[Eta Mu239](https://github.com/open-hax/eta-mu/issues/239) tracks stale distribution
predating EDN PR158. Canonical private CLI build/help/authoritative EDN readback
now pass as attributed below. Qualified published artifact consumption remains
held; no new source implementation issue or readiness is inferred.

Verification is documentary scope/preservation plus the actual upstream Receipt
River consumer on the new owned receipt(s). Existing Shx has no local receipt
consumer; upstream RR source is pinned in the private evidence note. Historical
ledger validity is not claimed. No new implementation or mutation suite, native review, ready event, paid
capacity, source adoption or live service operation is claimed. The required existing
baseline analyzer gate is recorded below separately from the proposed future tests. Raw evidence is losslessly encoded; original receipts/events
remain exact, and no original archived note needs to be captured or evaluated.

## Required existing baseline gate — 2026-10-06

Shx AGENTS requires `bin/analyze` before reporting work done. Planning is not
exempt from that explicit obligation. Actual unmodified `bin/analyze --strict`
ran once at planning head `44aa8ebe5ef491f4f6619edd7a0f03c811bd00a8`,
2026-10-06T19:45:06Z through 19:47:56Z, exit0. All seven blocking checks passed:
clj-kondo0errors/0warnings, Splint14files/0stylewarnings, cljfmtclean, LSPunused
publicvarsnone, jscpd0clones, typed.clojureOK, Kaocha19tests/46assertions/0failures.
The existing integer-object-ID deprecation message remains visible, as already
identified in `docs/design/shx1-qualification-constraints.md`; no zero-output-warning
claim is made. No suppression, ratchet, tool pin or source fix was introduced.

This is existing baseline qualification, not execution of the proposed bb/CLI/Bash
implementation tests or mutation experiments. The staged source/config/test/tool-policy
inputs remain unchanged across the evidence-only successor commit, so this gate is
not repeated. Native review, breakdown, qualified published Rheos artifact
consumption and lawful ready admission remain outstanding. The separate source-sync candidate preserves
accepted history; no fresh gate execution on that candidate is inferred.

Private tool copies match pinned kondo/LSP/bb versions; official Clojure CLI
1.12.3.1577 archive SHA256 matches the existing bootstrap's pinned digest. Node
24.14.1 and Java21 were verified. JVM/native/Node heaps are bounded, JVM2processors;
Maven, Gitlibs, npm, analyzer, JVM-user, XDG and temp paths are private. HOME was
not repurposed, no watcher/server/port was started, and no global config was written.
Raw stdout/stderr, complete argv/environment scope, time/exit and source/tool pins
are losslessly captured.

## Distribution attribution correction

The earlier preparation accurately captured a JSON.parse refusal but imprecisely
routed it toward owning source implementation. Source/API support is already
present at the accepted Rheos pin above. Current Git source and fresh open issue239
confirm the distribution distinction; root's canonical API probe is cited as
root-owned evidence. A new supported `:adjudication` receipt preserves the earlier
record and corrects this attribution. At this correction point full CLI
build/readback remained unverified; subsequent attributed evidence below records
that result. No board transition is claimed, and no alternate config/parser/
workflow is added.
Existing required gate remains bound to actual44aa8ebe with unchanged gate inputs.

## Attributed accepted-source canonical CLI observation

Rheos owner-lane execution at accepted source
`ef3c4abf1ea75199486f693e9470df3fec88dd49` built the unchanged canonical CLI:
exit0, 106files/47compiled/0compilerwarnings. The immutable artifact is
2,114,115bytes, SHA256
`33efe2e97202abe7df28b65fb20fbabb78fd910049ed60f301d112a895c7633b`.
Native CLI help and authoritative unchanged copied Shx EDN `read-board` both
exit0; board total31. Fixture source is earlier planning head
`44aa8ebe5ef491f4f6619edd7a0f03c811bd00a8`; all33 fixture files remain exact and
the authoritative EDN bytes equal this candidate. This does not claim the latest
authored card body has acquired planning admission.

Compiled canonical `load-config` / `resolve-configured-projects` / `resolve-fsm`
APIs retain keyword `:build-gate`, commands `["bin/analyze --strict"]`,
`:extends :promethean` and the private fixture cwd. No configured gate command,
lifecycle transition, installed distribution replacement, publication or consumer
pin update ran. Node24.14.1 is local preparation; Node22 release qualification is
not supplied. The initial diagnostic-build exit1 and separate corrected private
probe-build exit0 are both retained; the latter's shadow-cljs installation warning
is preserved. No blanket all-command or all-output-warning PASS is asserted.

Root independently verified80 raw streams/40 commands, fixture equality and
tracked owner source diff0. This lane independently verified their hashes/sizes
and copied six selected command pairs, original encoded containers, decoded raw
streams, full original manifest, fixture manifests and provenance into lossless
captures. Exactly one terminal LF in an original base64 container is permitted
for decode; decoded raw bytes are preserved. Attribution and exact argv/cwd/exit
are recorded in `accepted-rheos-selected-proof.json` within the capture container.
Root peer proof provenance is
`/home/err/.codex/parallel-goal/personal-root-20261006/pr115-current-binding/.ημ/verification/backlog-advance-20261006-1929/rheos-ef3-shx-root-peer.json`.
This lane did not execute owner scripts/artifacts or mutate that lane.

The former local full-CLI-readback hold is resolved. Existing
[Eta Mu239](https://github.com/open-hax/eta-mu/issues/239) still owns qualified
published-artifact distribution/consumption. Native planning review, reviewed
breakdown and lawful ready admission remain held. Historical installed-CLI
refusal, previous receipts and all79 prior captures remain exact. The existing
strict gate stays bound to actual44aa8ebe; unchanged tracked gate inputs require
no repeat. An appended owning-package-supported `:observation` records this
chronological update without changing operational frontmatter or event bytes.
