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

Authoritative EDN native read fails with the installed Rheos JSON config reader;
the deprecated JSON mirror reads 31 tasks, zero ready, six todo, 17 incoming,
one breakdown, one review, four done, one icebox, one archived. Mirror results are
diagnostic only; no transitions or gate validation. This proposal neither duplicates
Rheos nor files a new upstream gap without checking the actual owner EDN contract.

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
not repeated. Native review, breakdown, authoritative Rheos compatibility and lawful
ready admission remain outstanding. The separate source-sync candidate preserves
accepted history; no fresh gate execution on that candidate is inferred.

Private tool copies match pinned kondo/LSP/bb versions; official Clojure CLI
1.12.3.1577 archive SHA256 matches the existing bootstrap's pinned digest. Node
24.14.1 and Java21 were verified. JVM/native/Node heaps are bounded, JVM2processors;
Maven, Gitlibs, npm, analyzer, JVM-user, XDG and temp paths are private. HOME was
not repurposed, no watcher/server/port was started, and no global config was written.
Raw stdout/stderr, complete argv/environment scope, time/exit and source/tool pins
are losslessly captured.
