# 00 — Project Brief and QA Mission

**Project:** Toolshop Selenium Automation Framework (future)  
**Current phase:** 00 — manual exploration, risk analysis, and test design  
**System under test:** https://practicesoftwaretesting.com/  
**Test role:** SDET / QA engineer

## The business problem

Customers use a demo tool store to find products and, where supported, authenticate, manage carts and advance through checkout. The engineering team needs quick, credible feedback when a change breaks a critical user journey. You will eventually build a Java + Selenium automated regression suite, but you must first understand what the workflows are, what could fail, and how to recognize a failure.

## Your responsibilities in Phase 00

1. Discover customer journeys through **manual exploratory testing**.
2. Identify **testable requirements** and separate documented facts from assumptions.
3. Design positive, negative, and boundary scenarios.
4. Prioritize scenarios using business impact and failure likelihood.
5. Execute a small, representative manual suite and collect observations.
6. Document risks, issues, coverage gaps, and questions for product stakeholders.
7. Select a high-value **Phase 01 automation backlog** (only selection, no code yet).

## Personas / journeys to explore

| Persona | Goal | Critical user journey | Risks |
|---|---|---|---|
| Guest shopper | Discover products | Home → catalog → search/filter → details | Wrong results, unavailable data, confusing navigation |
| Returning customer | Authenticate | Sign in → access authorized area → sign out | Account access, ambiguous errors, stale session |
| Shopper with cart | Organize purchases | Select product → add to cart → change/remove item | Wrong item, wrong quantity, incorrect totals |
| Checkout customer | Complete shopping flow | Cart → checkout steps → confirmation (if supported) | Data loss, incorrect totals, premature success |

## What is known versus not yet verified

**Supported by official project documentation:** The current hosted project is the Sprint 5 application; a separate variant with seeded bugs exists; test accounts are documented; the project is an e-commerce testing playground. Source: https://github.com/testsmith-io/practice-software-testing/blob/main/docs/README.md.

**Needs verification in your own browser:** Exact button labels and element availability; current catalog items; validation messages; filter options; whether guest checkout is allowed; required form fields; behavior of payment simulation; precise navigation flow; responsive behavior; any account-specific state.

The site is client-rendered and can change. Avoid making exact-text assertions before observing the current behavior. A proposed test case is not a fact about the product.

## Scope boundaries

**In scope now:** Browser-based exploratory testing, test case design, risk analysis, manual execution, evidence collection, defect report drafting, automation candidates.

**Out of scope now:** Selenium code, REST Assured, Page Object Model, CI/CD pipelines, Docker, AWS infrastructure, performance testing, security scanning, and production payment processing.

## Questions to investigate

- Can a guest add items to a cart, or must they sign in first?
- Does search match names, descriptions, or both? What happens with empty input?
- Can sorting and category filters be combined?
- What happens if a customer refreshes the cart or navigates Back?
- Which checkout fields are mandatory? Is order completion simulated?
- What UI affordances are present for keyboard-only navigation?
- What behavior is actually required, versus what is only currently observed?

## Phase 00 deliverables

- Updated `01-test-cases.md` (at least 12 validated scenarios)
- Completed `03-exploratory-charters.md` observation notes for at least two charters
- At least 6 executed cases in `04-manual-execution-log.md`
- Reviewed `02-test-strategy.md` and prioritized risks in `06-risk-and-traceability.md`
- At least one high-quality defect report **if a credible reproducible issue is found** (do not invent a defect)
- Ranked shortlist of 5–8 future automated test cases

## Success statement (write your own at the end)

> Based on the observed behavior of Toolshop on [date/browser], the most important journeys are [...]. The highest risks are [...]. I recommend automating [...] first because [...]. The current manual smoke results are [...], with outstanding questions [...].
