# 09 — Phase 00: Definition of Done and Self-Review

Use this as a **real checkpoint** before implementing Selenium tests. Mark completion only after doing the work.

## Required artifacts

- [ ] `00-project-brief.md` updated with your understanding of the user journeys.
- [ ] `03-exploratory-charters.md` has completed observations for at least E-01 and one more charter.
- [ ] `01-test-cases.md` includes at least 12 reviewed/feasible cases and 3 additional cases from your discoveries.
- [ ] `04-manual-execution-log.md` records >=6 genuinely executed cases with actual results.
- [ ] `02-test-strategy.md` explains scope, priorities, levels, and safe data handling.
- [ ] `06-risk-and-traceability.md` has a revised risk order and evidence-aware coverage mapping.
- [ ] `05-defect-report-template.md` understood; any *real* defect is reproducible, not invented.
- [ ] 5–8 top Selenium candidates are selected and justified; 2 API-level candidates identified.
- [ ] Documentation has been committed to your own Git repository.

## Test design self-assessment

Explain each concept in your own words (2–3 sentences each):

1. What is the difference between a **test plan** and a **test case**?
2. How does exploratory testing differ from scripted manual testing?
3. What makes an expected result testable, rather than vague?
4. What is a positive vs. negative test? Give an example from Toolshop.
5. What does an equivalence partition mean? Give a search or login example.
6. What is boundary-value analysis? Which Toolshop input has a meaningful boundary?
7. What differentiates severity from priority?
8. What is a smoke test, and why should it be short?
9. Why is a successful Selenium click not sufficient to prove a feature works?
10. Why should UI tests not be your only type of automated test?
11. Why is it dangerous to write tests against a shared public demo without controlling initial state?
12. What evidence would help a developer reproduce a cart defect?

## Sprint retrospective (fill at completion)

**Top three discoveries:**

1. [ ]
2. [ ]
3. [ ]

**Most important unanswered requirement:** [ ]

**A case I changed after learning the real UI:** [Case ID and reason]

**One behavior that would be expensive or brittle to automate:** [ ]

**My recommended first Selenium smoke suite (5–8 test IDs):** [ ]

**Why these tests, and why UI rather than API only:** [ ]

**What I will learn in Phase 01:** Understand WebDriver, browser lifecycle, locating and interacting with elements, then implement tests selected here.

## Recommended Phase 00 status label

- **Not Started:** Haven't explored yet.
- **In Progress:** At least one charter underway.
- **Ready for Review:** Deliverables complete, expecting peer/senior QA review.
- **Done:** All required items above complete; clear plan for automation.

Don't claim "Done" based on prefilled templates alone.
