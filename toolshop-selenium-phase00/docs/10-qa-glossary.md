# 10 — QA / SDET Glossary for Phase 00

| Term | Meaning | Toolshop example |
|---|---|---|
| SUT | System Under Test: the application you're checking | The hosted Toolshop website |
| Requirement | Expected product behavior agreed by a product owner/spec | "Adding an item keeps it in the cart" if formally confirmed |
| Test case | Reproducible inputs/actions/expected result | Search for observed product name |
| Test scenario | Broad behavior to validate | Customer discovers and buys products |
| Test oracle | Evidence/rule to tell correct from incorrect | Result name matches selected product |
| Preconditions | State required to run a case | User is logged out; cart is empty |
| Test data | Values used during testing | A documented demo login |
| Positive test | Valid input should succeed | Search for a known item |
| Negative test | Invalid input should be handled | Wrong password rejected |
| Boundary test | Values at/near the edge of accepted ranges | Empty required field, then valid value |
| Equivalence partition | Group of inputs treated similarly by a rule | Valid search terms vs no-match terms |
| Smoke testing | Small suite checking critical functionality | Homepage + login + cart add |
| Regression testing | Check previous behavior after changes | Repeat core shopping tests after a release |
| Exploratory testing | Concurrently learn, design, and execute tests | Investigate cart behavior after refresh |
| Risk-based testing | Allocate effort according to likely impact | Prioritize checkout and authentication |
| Severity | How much a defect harms functionality | Checkout totally blocked = potentially high |
| Priority | Urgency for fixing an issue | Promotional typo may be urgent but not severe |
| Blocked | Can't perform a test due to external/prerequisite cause | Hosted site unavailable |
| Flaky test | Automated test intermittently fails without product change | UI test dependent on unhandled loading state |
| Test pyramid | Concept of more lower-level checks and fewer expensive UI E2E tests | Many API checks, a focused UI smoke suite |
| Traceability | Link between requirement/risk and a test | R-07 ↔ TC-CART-001 |
| Acceptance criteria | Observable conditions required to accept work | After adding item, cart shows that product |
| Definition of Done | Agreed quality/finish requirements for task | Test case reviewed and evidence logged |
| POM | Page Object Model: later Selenium design pattern | `LoginPage` encapsulates login actions |

## Learn by applying

Take any 3 cases from `01-test-cases.md` and write: (a) the test oracle, (b) preconditions, (c) risk mitigated, and (d) whether API or UI automation is most appropriate later.
