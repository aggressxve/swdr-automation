# 07 — Phase 00 Sprint Backlog (GitHub Issues / Jira Ready)

**Sprint objective:** Understand Toolshop workflows and produce evidence-based test design before starting Java/Selenium.

Use this like a lightweight Kanban board: **To Do → In Progress → Review → Done**. A task is Done only when its acceptance criteria are met. Suggested estimates are effort guides, not deadlines.

---

## SDET-001 — Learn the application and define QA scope

**As a QA engineer, I want** to identify major Toolshop user journeys **so that** I can target the highest-business-value tests.

**Tasks:** Read `00-project-brief.md`; visit the main app; list available workflows; mark unknowns.

**Acceptance criteria:**
- [ ] Scope and out-of-scope features documented.
- [ ] At least 4 user journeys identified.
- [ ] Unknown or ambiguous behaviors listed without inventing requirements.

**Deliverable:** Updated `00-project-brief.md`.  
**Suggested effort:** 30–45 min.

## SDET-002 — Explore product discovery

**As a tester, I want** to explore catalog, search, and filters **so that** high-risk discovery paths have meaningful test cases.

**Tasks:** Execute charter E-01; inspect two products; try positive/no-match search, sorting and categories.

**Acceptance criteria:**
- [ ] E-01 observations recorded.
- [ ] At least 3 meaningful product/search assertions proposed.
- [ ] Any uncertain UI behavior captured as a question.

**Deliverable:** Completed E-01 section, reviewed catalog tests.  
**Suggested effort:** 30–45 min.

## SDET-003 — Explore account and cart

**As a tester, I want** to learn authentication and shopping state **so that** later test setup is safe and repeatable.

**Tasks:** Execute E-02 and/or E-03; use only documented demo account; record session/cart effects.

**Acceptance criteria:**
- [ ] At least one second exploratory charter completed.
- [ ] Login state and cart initialization behavior recorded.
- [ ] Shared-environment cleanup and safety concerns documented.

**Deliverable:** Charter notes and `08-test-data-and-environments.md` updates.  
**Suggested effort:** 30–45 min.

## SDET-004 — Review and expand test cases

**As an SDET, I want** explicit repeatable scenarios **so that** manual and future automated runs measure the same intent.

**Tasks:** Review `01-test-cases.md` against actual UI; refine expected outcomes; add 3 newly discovered scenarios.

**Acceptance criteria:**
- [ ] At least 12 cases verified for feasibility and clarity.
- [ ] Preconditions, data, steps, and expected outcomes are actionable.
- [ ] At least 3 new cases drafted based on discoveries.

**Deliverable:** Updated `01-test-cases.md`.  
**Suggested effort:** 60–90 min.

## SDET-005 — Run manual smoke tests

**As an SDET, I want** execution evidence **so that** the baseline is credible and reproducible.

**Tasks:** Run at least 6 high-value cases. Log the real results, browser, time, observations and evidence.

**Acceptance criteria:**
- [ ] At least 6 cases actually executed (not assumed Pass).
- [ ] Every run has Pass/Fail/Blocked/Needs Clarification and evidence or notes.
- [ ] Run summary totals correctly match outcomes.

**Deliverable:** `04-manual-execution-log.md` and safe evidence files.  
**Suggested effort:** 60–90 min.

## SDET-006 — Create risk-based test strategy

**As a QA engineer, I want** to prioritize failure impact **so that** automation time is invested where it matters.

**Tasks:** Review `02-test-strategy.md` and `06-risk-and-traceability.md`; adjust risk scores; justify 5–8 UI automation candidates and identify 2 API candidates.

**Acceptance criteria:**
- [ ] Priority and risk criteria explained.
- [ ] Coverage / unknowns are traceable to test IDs.
- [ ] Automation decisions include observability and data setup considerations.

**Deliverable:** Updated strategy, risks, candidate shortlist.  
**Suggested effort:** 45–60 min.

## SDET-007 — Practice defect reporting

**As a QA engineer, I want** to communicate reproducible bugs **so that** developers can act on them efficiently.

**Tasks:** If a genuine issue is observed, validate the expectation and reproduction, then complete `05-defect-report-template.md`. If none, review the clearly fictitious example and explain what good evidence requires.

**Acceptance criteria:**
- [ ] Understand severity vs. priority and reproducibility.
- [ ] No fabricated defect is reported as real.
- [ ] Any real defect includes environment, actual/expected, steps, evidence.

**Deliverable:** Credible report (if found) or an annotated practice template.  
**Suggested effort:** 20–40 min.

## SDET-008 — Phase 00 review and repository checkpoint

**As an SDET, I want** a reviewable QA package **so that** the next phase begins with measurable requirements.

**Tasks:** Complete the exit checklist, summarize findings, commit documentation.

**Acceptance criteria:**
- [ ] `09-phase00-exit-criteria.md` reviewed and answered.
- [ ] No unsupported Pass / Fail claims.
- [ ] Documentation is easy for another QA engineer to follow.
- [ ] Git commit records Phase 00 checkpoint.

**Deliverable:** Phase 00 Git commit and next-phase test shortlist.  
**Suggested effort:** 20–30 min.

---

## Suggested issue labels

`phase:00`, `type:task`, `type:test-design`, `type:exploration`, `type:bug`, `priority:high`, `priority:medium`, `status:blocked`

## Suggested Kanban ordering

Start SDET-001 → SDET-002 → SDET-003 → SDET-004 → SDET-005 → SDET-006 → SDET-007 → SDET-008. Revisit earlier tasks as you learn more.
