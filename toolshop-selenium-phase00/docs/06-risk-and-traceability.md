# 06 — Risk Register and Coverage Traceability

This is an initial **risk hypothesis**, not a factual claim about current defects. Re-score after doing exploratory testing.

## Scoring model

- **Impact (I):** 1 = minor inconvenience; 2 = meaningful workflow impairment; 3 = blocks critical user value.
- **Likelihood (L):** 1 = unlikely; 2 = plausible; 3 = frequent/fragile based on evidence.
- **Exposure (E):** 1 = rare path; 2 = sometimes; 3 = common path.
- **Risk score:** I × L × E; High >= 18, Medium 8–17, Low <= 7.

Scores below are an **illustrative starting point to challenge**. They reflect judgment about the importance of a workflow, not observed incidents.

## Initial risk register

| Risk ID | Potential failure | I | L | E | Score | Mitigation / proposed test |
|---|---|---:|---:|---:|---:|---|
| R-01 | Site/catalog not usable | 3 | 2 | 3 | 18 | TC-HOME-001 smoke check |
| R-02 | Product detail doesn't match clicked product | 2 | 2 | 3 | 12 | TC-PROD-001, TC-PROD-002 |
| R-03 | Search results misleading or unavailable | 2 | 2 | 3 | 12 | TC-SEARCH-001/002 |
| R-04 | Sorting/filtering gives inconsistent products | 2 | 2 | 2 | 8 | TC-FILTER-001/002, TC-SORT-001 |
| R-05 | Customer cannot authenticate | 3 | 2 | 3 | 18 | TC-AUTH-001/002 |
| R-06 | Session remains accessible after logout | 3 | 2 | 2 | 12 | TC-AUTH-004 |
| R-07 | Added cart item disappears or changes | 3 | 2 | 3 | 18 | TC-CART-001/002 |
| R-08 | Cart totals inconsistent | 3 | 2 | 2 | 12 | TC-CART-003 |
| R-09 | Checkout fails or loses data | 3 | 2 | 2 | 12 | TC-CHECK-001/002 |
| R-10 | Core flows unusable on small screen | 2 | 2 | 2 | 8 | TC-RESP-001 |
| R-11 | Critical controls unreachable by keyboard | 2 | 2 | 2 | 8 | TC-A11Y-001 |
| R-12 | Public shared environment changes unexpectedly | 2 | 3 | 3 | 18 | Isolated test state, evidence, limited run scope |

### Risk reflection

- Highest-risk scenario after you explore: [ ]
- What new evidence changes the risk score? [ ]
- Which risks could be tested below the UI layer? [ ]
- Which risks should **not** be automated first? [ ]

## Coverage / requirements traceability (candidate)

| Business capability / requirement hypothesis | Test cases | Coverage type | Future layer | Status |
|---|---|---|---|---|
| Customer can discover products | TC-HOME-001, TC-PROD-001, TC-PROD-002 | Positive / smoke | UI | Unverified |
| Search finds relevant products / handles no-match | TC-SEARCH-001/002/003 | Positive / negative / boundary | UI + API | Unverified |
| Filters and sorting refine results correctly | TC-FILTER-001/002, TC-SORT-001 | Functional / integration | UI + API | Unverified |
| Customer can sign in and receive errors | TC-AUTH-001/002/003 | Positive / negative | UI + API | Unverified |
| Customer can log out | TC-AUTH-004 | Functional | UI | Unverified |
| Cart keeps item identity and totals | TC-CART-001/002/003 | Smoke / functional | UI + API | Unverified |
| Checkout enforces safe flow and validations | TC-CHECK-001/002 | E2E / negative | UI + API | Unverified |
| Primary mobile actions are usable | TC-RESP-001 | Exploratory | Manual | Unverified |
| Basic keyboard interactions work | TC-A11Y-001 | Exploratory | Manual + specialist tools later | Unverified |

## Automation decision worksheet

Pick 5–8 candidates from the above. Complete the decision fields **after** manual exploration. Example format:

| Candidate ID | Business value | Stable prerequisite? | UI assertion is observable? | Data cleanup? | Automation decision / rationale |
|---|---|---|---|---|---|
| TC-HOME-001 | High | To verify | To verify | None expected | Tentative yes: cheap smoke signal |
| TC-AUTH-001 | High | Shared account caveats | To verify | Logout | Tentative yes after state control |
| TC-SEARCH-001 | High | Catalog may vary | To verify | Reset search | Tentative yes with discovered product |
| [Your choice] | [ ] | [ ] | [ ] | [ ] | [ ] |
| [Your choice] | [ ] | [ ] | [ ] | [ ] | [ ] |

## Coverage gaps to think about

- Is product pagination present? If so, do current cases cover it?
- Are there discount, payment, or stock rules that deserve higher priority?
- What happens when requests fail or network connection is lost? Is that within your accessible test environment?
- Is there a user authorization rule that cannot be meaningfully verified from just the UI?

Create new cases when you discover a genuine capability or documented requirement. Avoid writing cases for features that aren't present.
