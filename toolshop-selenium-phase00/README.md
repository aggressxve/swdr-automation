# Toolshop Selenium SDET Portfolio — Phase 00

**Status:** Planning and exploratory testing (no Selenium code yet)  
**Application:** https://practicesoftwaretesting.com/  
**Alternative training environment:** https://with-bugs.practicesoftwaretesting.com/  
**Prepared:** 2026-10-14

## Your assignment

You are the SDET assigned to a public e-commerce practice application. Before automating, learn the business workflows, identify risks, formulate test cases, run a small manual smoke check, report evidence, and decide what deserves automation first.

> The test cases in this pack are **draft hypotheses** to validate against the live application, not previously executed tests or a verified product specification. Preserve discoveries, including differences from expected behavior. Do not automatically classify a difference as a defect before checking requirements.

## Recommended order (4 short sessions)

| Session | Focus | Files | Exit condition |
|---|---|---|---|
| 1 — Explore | Understand navigation, catalog, search, login, cart, checkout and identify unknowns | `docs/00-project-brief.md`, `docs/03-exploratory-charters.md`, `docs/08-test-data-and-environments.md` | Complete 2 exploratory charters and record observations |
| 2 — Design | Evaluate risks and convert observations to test cases | `docs/01-test-cases.md`, `docs/06-risk-and-traceability.md` | Prioritize at least 12 relevant cases and verify their test steps |
| 3 — Execute | Manually execute 6–8 high-priority cases and record results | `docs/04-manual-execution-log.md`, `evidence/README.md` | Evidence-linked Pass/Fail/Blocked results, not assumed Passes |
| 4 — Review | Decide what should be automated and summarize quality | `docs/02-test-strategy.md`, `docs/05-defect-report-template.md`, `docs/09-phase00-exit-criteria.md` | Phase 00 exit checklist completed and decisions justified |

## Documents

- `START_HERE.md` — guided first 45–60 minutes (begin here).
- `docs/00-project-brief.md` — mission, scope, assumptions, glossary of the customer journey.
- `docs/01-test-cases.md` — detailed, executable **manual** test cases and expectations.
- `docs/02-test-strategy.md` — approach, risk, priority, coverage, environments, entry/exit criteria, automation selection.
- `docs/03-exploratory-charters.md` — timeboxed exploratory scenarios with observation prompts.
- `docs/04-manual-execution-log.md` — run-level results tracker and sample entry.
- `docs/05-defect-report-template.md` — repeatable bug-report format with a fictitious worked example.
- `docs/06-risk-and-traceability.md` — initial risk register and coverage mapping.
- `docs/07-sprint-backlog.md` — tasks/user stories and acceptance criteria, ready to move into GitHub Issues or Jira.
- `docs/08-test-data-and-environments.md` — URLs, published demo accounts, privacy and cleanup rules.
- `docs/09-phase00-exit-criteria.md` — definition of done and reflective questions.
- `docs/10-qa-glossary.md` — concise definitions for Phase 00 concepts.
- `.github/ISSUE_TEMPLATE/bug_report.md` — optional GitHub issue template for your own repository.
- `evidence/README.md` — screenshot and evidence naming conventions.

## Immediate quick start

1. Read `START_HERE.md` and open the normal application: https://practicesoftwaretesting.com/
2. Read `docs/00-project-brief.md` and `docs/08-test-data-and-environments.md`.
3. Open `docs/03-exploratory-charters.md`; complete Charter E-01 (catalog) before reading deep test cases.
4. Fill in the **Observed behavior / open questions** fields from your own exploration.
5. Adapt and execute the cases in `docs/01-test-cases.md`; update the execution log.
6. Write a risk-based justification for your top five future Selenium tests.
7. Review `docs/09-phase00-exit-criteria.md`, then move to Phase 01.

## How to use with Git

Extract these files into your new repository `toolshop-selenium-java` and then run:

```bash
git init
git add README.md START_HERE.md docs/ evidence/ .github/ .gitignore
git commit -m "docs: prepare phase 00 test planning"
```

Set up a remote GitHub repository when you are ready. If you've already initialized the repository, just copy the files into it and commit normally.

## Reference sources

- Official project: https://github.com/testsmith-io/practice-software-testing
- Official project docs: https://github.com/testsmith-io/practice-software-testing/blob/main/docs/README.md
- Current web application: https://practicesoftwaretesting.com/
- API reference for future phases: https://api.practicesoftwaretesting.com/api/documentation

These files are original learning/project documents, not a copy of the application source code. Toolshop is a shared practice environment; do not load-test, scrape at scale, spam registration, or upload real payment/identity data.
