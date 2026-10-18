# 02 — Test Strategy: Toolshop

**Version:** 0.1 (draft to validate)  
**Owner:** [Your name or GitHub handle]  
**Date reviewed:** [YYYY-MM-DD]  
**Environment:** https://practicesoftwaretesting.com/

## 1. Objective

Reduce the risk of critical customer-facing regressions in product discovery, authentication, cart, and checkout by combining exploratory manual testing (Phase 00) with maintainable automated checks in subsequent phases.

This is a portfolio practice strategy, not an official statement of Toolshop product requirements or a claim of release readiness.

## 2. Context and stakeholders

| Stakeholder | Needs from testing |
|---|---|
| Customer | Core journeys work and feedback is understandable |
| Developer | Reproducible failures with expected vs. actual behavior |
| Product owner | Business risks, covered and uncovered requirements |
| QA/SDET | Reliable tests, safe data, useful evidence, maintainable automation |

## 3. Scope

### Included workflows

- Catalog availability, product details, search, sorting, filtering
- Authentication: valid / invalid credentials, logout, session behavior
- Cart: add/remove, quantity/total consistency where UI supports it
- Checkout: navigation, required fields, safe simulated completion if available
- Basic responsive and accessibility smoke observation

### Excluded from Phase 00

- Automated Selenium, JUnit, REST Assured, Page Objects, build pipeline
- High-volume performance/load/stress or vulnerability scanning
- Destructive database actions; payment capture; real personal/financial data
- Admin workflows unless expressly needed and permitted for the later project

## 4. Test approach

### Manual exploratory testing

Use timeboxed charters, document steps and observed results, investigate unexpected outcomes, and convert findings into focused test cases or questions. Start with core business journeys before rare edge cases.

### Scripted manual testing

Run prioritized test cases with explicit preconditions, actions, and expected outcomes. Mark every result Pass, Fail, Blocked, or Not Run; include execution date, browser, build/environment, and evidence.

### Future automation strategy (decision only in Phase 00)

Automate **frequent, deterministic, business-critical** regression checks first. Favor a smaller, reliable set of UI tests alongside more extensive API-level testing later. Do not automate flows with unstable prerequisites, uncontrolled shared-state behavior, or uncertain requirements until those limitations are addressed.

| Candidate level | Suitable validation | Example |
|---|---|---|
| UI / Selenium | User-visible journeys and browser integrations | Find a product, open detail, add to cart |
| API / REST Assured | Fast, deterministic business rules and response contracts | Retrieve product; invalid authentication response |
| Unit (application-owned code) | Fine-grained rules in code you maintain | A price calculator, if it were your codebase |
| Manual / exploratory | Ambiguity, visual feel, newly released features | Responsive layout or unfamiliar checkout states |

## 5. Prioritization rules

Rate each scenario based on **impact** (1–3), **likelihood** (1–3), and **exposure/frequency** (1–3). Risk score = Impact × Likelihood × Exposure (1–27). Use this as a conversation aid, not a substitute for judgment.

- **High:** Revenue / sign-in / cart critical path, or risk score >= 18.
- **Medium:** Product discovery accuracy, common validations, or score 8–17.
- **Low:** Low-frequency cosmetic or optional behavior, or score <= 7.

An **automation candidate** also needs deterministic setup, observable assertions, repeatability, low test pollution, and reasonable maintenance cost. High-risk does not automatically mean UI automation is appropriate.

## 6. Test types and examples

| Type | Purpose | Example |
|---|---|---|
| Smoke | Quick check that key journeys are functional | Homepage, search, login, cart add |
| Functional | Validate expected feature behavior | Sort by price ascending |
| Negative | Check handling of invalid input | Invalid credentials |
| Boundary | Test inputs near allowed limits | Required checkout field missing |
| Regression | Guard against previously working features breaking | Search, cart, authentication suite |
| End-to-end | Validate a full customer workflow | Catalog → cart → checkout (safe simulated flow) |
| Accessibility smoke | Detect basic usability barriers | Keyboard focus reaches main controls |
| Exploratory | Learn and discover unknown risks | Refresh cart and inspect state |

## 7. Environment and data

- Primary: https://practicesoftwaretesting.com/ (official hosted Sprint 5).
- Defect-hunting later: https://with-bugs.practicesoftwaretesting.com/ (separate seeded-bug environment).
- Browser for Phase 00: [Chrome version], optionally [Firefox version].
- Shared demo account: `customer@practicesoftwaretesting.com`; public demo password `welcome01` (documented by project). This is not a private credential.
- Never use personal data or real payment details. Reset the shopping state when possible; avoid polluting shared accounts.
- Record any environment outage as **Blocked** (not Fail).

## 8. Entry criteria

- The environment loads in a supported browser.
- The workflow under test is accessible without unknown prerequisites.
- Test data and expected behavior have been identified or marked as an assumption to validate.
- Tester knows whether actions have persistent side effects.

## 9. Exit criteria for Phase 00

- >=2 exploratory charters executed and documented.
- >=12 test cases reviewed against actual browser behavior.
- >=6 scripted cases executed manually with outcomes.
- >=1 prioritized risk register; test coverage mapping reviewed.
- 5–8 automation candidates selected, with reasons and exclusions.
- Any credible defects are reproducible and recorded; unknowns are labeled as questions.

These are **learning-phase exit criteria**, not a claim that the system is safe for production deployment.

## 10. Defect triage

- **Severity** = how badly the behavior affects the system.
- **Priority** = how urgently the team should fix it.
- Critical: essential flow completely broken or unsafe.
- High: important journey blocked with no reasonable workaround.
- Medium: partial functionality broken or workaround exists.
- Low: minor usability or presentation issue.

Always record reproducibility, environment, evidence, expected versus actual behavior, and requirement provenance (documented, inferred, or needs confirmation). A failed assumption is not automatically a defect.

## 11. Risks and mitigations

| Risk | Mitigation |
|---|---|
| Hosted site changes without notice | Record date; avoid hardcoded catalog values; update cases |
| Shared public data changes | Use documented demo accounts carefully, reset state, keep tests independent |
| Angular dynamic rendering / delays | Later use explicit condition-based waits rather than sleeps |
| Unclear requirements | Mark candidate expected outcomes as hypotheses, confirm through app/docs |
| Browser differences | Record browser/version, plan a Chrome + Firefox matrix later |
| Test flakiness | Prefer stable selectors, isolated setup, reproducible assertions |
| Unsafe interactions | No actual purchases, payment information, stress testing, or spamming |

## 12. Reporting

At the end of a manual session, provide: total cases run, Pass/Fail/Blocked counts, new bugs, risks, unanswered questions, and recommended next actions. Use `04-manual-execution-log.md` and `05-defect-report-template.md`.

## 13. Decisions to make after exploration

- Which 5–8 tests enter the first Selenium smoke suite? Why?
- Which checks should move to REST Assured later instead of UI tests?
- Which expected behaviors remain ambiguous?
- Which cases are data-dependent or risky on a shared environment?
- What would block your next phase?

## External references

- https://github.com/testsmith-io/practice-software-testing/blob/main/docs/README.md
- https://practicesoftwaretesting.com/
