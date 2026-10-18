# 04 — Manual Test Execution Log

**Important:** No tests have been executed by the author of this project pack. Every case starts as `Not Run`. Update only after you personally perform the steps.

## Execution run metadata

- Run ID: `MANUAL-2026-__-__-01` (replace date)
- Tester: [Your name / handle]
- Execution date/time: [YYYY-MM-DD / time zone]
- Environment: https://practicesoftwaretesting.com/
- Browser and version: [e.g., Chrome 1xx]
- Operating system: [e.g., Ubuntu]
- Account / starting state: [Guest or public demo customer]
- Known environment notes: [Outages, catalog updates, shared-state considerations]

## Outcome definitions

- **Pass:** Actual behavior satisfies a confirmed, measurable expectation.
- **Fail:** Confirmed expectation not met; include evidence and issue reference.
- **Blocked:** Cannot execute due to missing data, inaccessible environment, or prerequisite.
- **Not Run:** No attempt yet.
- **Needs Clarification:** Executed but expected result remains ambiguous; not a defect until confirmed.

## Run results

| Test ID | Priority | Outcome | Actual observation (1 sentence) | Evidence / bug ID |
|---|---|---|---|---|
| TC-HOME-001 | High | Not Run | — | — |
| TC-PROD-001 | High | Not Run | — | — |
| TC-PROD-002 | Medium | Not Run | — | — |
| TC-SEARCH-001 | High | Not Run | — | — |
| TC-SEARCH-002 | Medium | Not Run | — | — |
| TC-SEARCH-003 | Medium | Not Run | — | — |
| TC-FILTER-001 | Medium | Not Run | — | — |
| TC-FILTER-002 | Medium | Not Run | — | — |
| TC-SORT-001 | Medium | Not Run | — | — |
| TC-AUTH-001 | High | Not Run | — | — |
| TC-AUTH-002 | High | Not Run | — | — |
| TC-AUTH-003 | Medium | Not Run | — | — |
| TC-AUTH-004 | Medium | Not Run | — | — |
| TC-CART-001 | High | Not Run | — | — |
| TC-CART-002 | Medium | Not Run | — | — |
| TC-CART-003 | High | Not Run | — | — |
| TC-CHECK-001 | High | Not Run | — | — |
| TC-CHECK-002 | Medium | Not Run | — | — |
| TC-RESP-001 | Medium | Not Run | — | — |
| TC-A11Y-001 | Medium | Not Run | — | — |

## Per-case detailed log template

Copy for each executed case:

```markdown
### [TC-ID] — [Short title]
- Date/time:
- Browser/version:
- Preconditions actually observed:
- Steps performed (include deviations):
- Actual behavior:
- Expected source (documented requirement / confirmed behavior / assumption):
- Outcome (Pass / Fail / Blocked / Needs Clarification):
- Evidence paths:
- Bug ID if valid:
- Comments and follow-up:
```

## Example entry (ILLUSTRATIVE ONLY — NOT AN ACTUAL RUN)

```text
Test ID: TC-HOME-001
Outcome: Not Run
Actual: Not observed yet
Evidence: None
Note: First run scheduled; do not pre-mark Pass.
```

## End-of-run report

- Planned cases: [ ]
- Executed cases: [ ]
- Passed: [ ]
- Failed: [ ]
- Blocked: [ ]
- Needs Clarification: [ ]
- Not Run: [ ]
- New defects logged: [Bug IDs or None]
- Largest risk exposed: [ ]
- Top 3 follow-ups: [ ]

**Pass rate:** Passed / (Passed + Failed) × 100; state the denominator and exclude Blocked / Not Run. Never use a pass rate to hide risk or claim production readiness on a 6-test sample.

## Re-run / regression notes

If you repeat a run, **copy** this file or create a new run section with a new Run ID. Preserve the original results so readers can distinguish baseline observations from later runs.
