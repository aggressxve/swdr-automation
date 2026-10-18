# 01 — Toolshop Manual Test Cases

**Status:** Draft test design; outcomes are **not executed**.  
**Test environment:** https://practicesoftwaretesting.com/  
**Reference:** https://github.com/testsmith-io/practice-software-testing/blob/main/docs/README.md

## How to use this document

1. Manually explore the relevant feature before executing its proposed test case.
2. Confirm the feature/field exists and refine the expected result into a measurable oracle.
3. Execute one case at a time, ideally with controlled preconditions.
4. Record Pass / Fail / Blocked / Not Run and evidence in `04-manual-execution-log.md`.
5. A UI mismatch against an **unconfirmed assumption** is an open question, not automatically a defect.

**Priority:** High = business-critical; Medium = important secondary workflow; Low = optional.  
**Automation candidate:** Suggested only; do not automate until the behavior and setup are stable.

## Index

| ID | Area | Scenario | Priority | Future automation |
|---|---|---|---|---|
| TC-HOME-001 | Catalog | Landing page shows the catalog | High | Yes, UI |
| TC-PROD-001 | Catalog | Open product detail from catalog | High | Yes, UI |
| TC-PROD-002 | Catalog | Open different product details independently | Medium | Candidate, UI |
| TC-SEARCH-001 | Search | Search for a matching product | High | Yes, UI |
| TC-SEARCH-002 | Search | Search for a nonsensical string | Medium | Yes, UI |
| TC-SEARCH-003 | Search | Search with leading/trailing spaces | Medium | Later, after requirement confirmed |
| TC-FILTER-001 | Filtering | Filter products by category | Medium | Yes, UI if stable |
| TC-FILTER-002 | Filtering | Combine search with a filter | Medium | Candidate, UI |
| TC-SORT-001 | Sorting | Sort prices low to high | Medium | Yes, UI |
| TC-AUTH-001 | Authentication | Valid customer login | High | Yes, UI |
| TC-AUTH-002 | Authentication | Invalid credentials are rejected | High | Yes, UI |
| TC-AUTH-003 | Authentication | Required login inputs | Medium | Yes, UI |
| TC-AUTH-004 | Authentication | Logout invalidates visible session | Medium | Yes, UI |
| TC-CART-001 | Cart | Add one product to cart | High | Yes, UI |
| TC-CART-002 | Cart | Remove product from cart | Medium | Yes, UI |
| TC-CART-003 | Cart | Cart quantity and totals consistency | High | Yes, if quantity control exists |
| TC-CHECK-001 | Checkout | Checkout progression retains cart | High | Conditional, UI |
| TC-CHECK-002 | Checkout | Required checkout field validation | Medium | Conditional, UI |
| TC-RESP-001 | Responsive | Basic small-viewport usability | Medium | Manual first |
| TC-A11Y-001 | Accessibility | Keyboard navigation smoke | Medium | Manual first |

---

## Detailed cases

### TC-HOME-001 — Landing page shows the catalog

| Attribute | Value |
|---|---|
| Area | Catalog |
| Priority | High |
| Type | Smoke / positive |
| Suggested future automation | Yes, UI |
| Preconditions | Start with a fresh browser session on the normal hosted application. |
| Test data | No account needed. |

**Steps**

1. Open the Toolshop home page.
2. Wait for the page to finish visibly rendering.
3. Identify the primary product listing and its first card.
4. Navigate away and return home.

**Proposed expected result:** The page is usable and shows recognizable product entries without an blocking error; the catalog is visible after returning home.

**Observation / specification question:** Record what counts as “loaded”: a visible product card, a label or another stable signal.

**Actual result / evidence:** _Complete during manual execution; log outcome in `04-manual-execution-log.md`._

---

### TC-PROD-001 — Open product detail from catalog

| Attribute | Value |
|---|---|
| Area | Catalog |
| Priority | High |
| Type | Functional / positive |
| Suggested future automation | Yes, UI |
| Preconditions | Catalog contains at least one product. |
| Test data | Choose an existing product at run time; note its name. |

**Steps**

1. Record the name of one visible product.
2. Open its detail page using the product card.
3. Read the detail page name, price, and available description.
4. Return to the listing.

**Proposed expected result:** Product detail corresponds to the selected item and renders its available information; navigation back remains usable.

**Observation / specification question:** Do not hardcode the identity of the first product as a permanent product requirement.

**Actual result / evidence:** _Complete during manual execution; log outcome in `04-manual-execution-log.md`._

---

### TC-PROD-002 — Open different product details independently

| Attribute | Value |
|---|---|
| Area | Catalog |
| Priority | Medium |
| Type | Functional / positive |
| Suggested future automation | Candidate, UI |
| Preconditions | Catalog contains at least two products. |
| Test data | Choose two products with different names. |

**Steps**

1. Open the first item and record its title.
2. Return to catalog.
3. Open a different item.
4. Compare detail content and page identity.

**Proposed expected result:** Each detail page represents the selected item; there is no unexpected stale content.

**Observation / specification question:** If fewer than two products are visible, mark Blocked and explain why.

**Actual result / evidence:** _Complete during manual execution; log outcome in `04-manual-execution-log.md`._

---

### TC-SEARCH-001 — Search for a matching product

| Attribute | Value |
|---|---|
| Area | Search |
| Priority | High |
| Type | Smoke / positive |
| Suggested future automation | Yes, UI |
| Preconditions | A catalog search feature is visible. |
| Test data | Use an observed substring from an actual product name (e.g., choose one manually). |

**Steps**

1. Record an actual product name.
2. Enter a distinctive part of that name in Search.
3. Submit or trigger search as the UI requires.
4. Review displayed result cards.

**Proposed expected result:** Matching products are returned; result labels are consistent with the application’s actual search rules.

**Observation / specification question:** Verify whether matching is by name, description, or other fields before writing an exact expected count.

**Actual result / evidence:** _Complete during manual execution; log outcome in `04-manual-execution-log.md`._

---

### TC-SEARCH-002 — Search for a nonsensical string

| Attribute | Value |
|---|---|
| Area | Search |
| Priority | Medium |
| Type | Negative |
| Suggested future automation | Yes, UI |
| Preconditions | Search control is available. |
| Test data | Use a clearly unlikely string such as zz-no-match-98431. |

**Steps**

1. Enter the nonsensical string.
2. Trigger search.
3. Observe the result count or empty-results state.
4. Clear the search.

**Proposed expected result:** The application handles the lack of matches gracefully, without broken pages or unrelated product results.

**Observation / specification question:** Capture exact empty-state behavior in observations; do not invent an expected message.

**Actual result / evidence:** _Complete during manual execution; log outcome in `04-manual-execution-log.md`._

---

### TC-SEARCH-003 — Search with leading/trailing spaces

| Attribute | Value |
|---|---|
| Area | Search |
| Priority | Medium |
| Type | Boundary / exploratory |
| Suggested future automation | Later, after requirement confirmed |
| Preconditions | Search control is available. |
| Test data | A known matching term with added spaces. |

**Steps**

1. Search the matching term without extra spaces; record results.
2. Repeat with spaces before and after the term.
3. Compare results and UI feedback.

**Proposed expected result:** Behavior is consistent with the documented trimming/search rule; if unknown, record the difference as a product question.

**Observation / specification question:** Do not label a difference a bug before knowing whether the search spec trims whitespace.

**Actual result / evidence:** _Complete during manual execution; log outcome in `04-manual-execution-log.md`._

---

### TC-FILTER-001 — Filter products by category

| Attribute | Value |
|---|---|
| Area | Filtering |
| Priority | Medium |
| Type | Functional / positive |
| Suggested future automation | Yes, UI if stable |
| Preconditions | A category filter is available. |
| Test data | Choose a visible category that has at least one result. |

**Steps**

1. Observe the initial product list.
2. Choose the category.
3. Review products and any active filter indicator.
4. Reset the filter.

**Proposed expected result:** Results are consistent with the chosen category and clearing the filter restores the expected unfiltered view.

**Observation / specification question:** Check the current category names in your browser; category values may change.

**Actual result / evidence:** _Complete during manual execution; log outcome in `04-manual-execution-log.md`._

---

### TC-FILTER-002 — Combine search with a filter

| Attribute | Value |
|---|---|
| Area | Filtering |
| Priority | Medium |
| Type | Functional / integration |
| Suggested future automation | Candidate, UI |
| Preconditions | Search and category filtering are both present. |
| Test data | Choose a known item whose category is visible. |

**Steps**

1. Filter to the item’s category.
2. Search for that item by name.
3. Observe the intersection of results.
4. Remove one constraint and observe the update.

**Proposed expected result:** Result content and active filters are consistent with the combination and subsequent removal.

**Observation / specification question:** If the UI only supports one control at a time, log a requirement question or mark Not Applicable.

**Actual result / evidence:** _Complete during manual execution; log outcome in `04-manual-execution-log.md`._

---

### TC-SORT-001 — Sort prices low to high

| Attribute | Value |
|---|---|
| Area | Sorting |
| Priority | Medium |
| Type | Functional / boundary |
| Suggested future automation | Yes, UI |
| Preconditions | Sorting control and visible numeric product prices are available. |
| Test data | Use currently loaded prices. |

**Steps**

1. Record several prices in the default view.
2. Select ascending price sorting if available.
3. Read visible product prices in the rendered order.
4. Check each adjacent pair of prices.

**Proposed expected result:** Prices are non-decreasing from top to bottom; identical prices may appear in either order.

**Observation / specification question:** Treat pagination/loading and currency normalization carefully. Skip if sorting unavailable.

**Actual result / evidence:** _Complete during manual execution; log outcome in `04-manual-execution-log.md`._

---

### TC-AUTH-001 — Valid customer login

| Attribute | Value |
|---|---|
| Area | Authentication |
| Priority | High |
| Type | Smoke / positive |
| Suggested future automation | Yes, UI |
| Preconditions | Logged out. Public demo account is usable. |
| Test data | customer@practicesoftwaretesting.com / welcome01. |

**Steps**

1. Navigate to Sign in.
2. Enter the documented demo email and password.
3. Submit login.
4. Observe signed-in indicators and an authorized destination.

**Proposed expected result:** Authentication succeeds and the interface unmistakably shows an authenticated session.

**Observation / specification question:** Identify a stable post-login oracle after you inspect the current application.

**Actual result / evidence:** _Complete during manual execution; log outcome in `04-manual-execution-log.md`._

---

### TC-AUTH-002 — Invalid credentials are rejected

| Attribute | Value |
|---|---|
| Area | Authentication |
| Priority | High |
| Type | Negative |
| Suggested future automation | Yes, UI |
| Preconditions | Logged out. |
| Test data | Use an invalid email/password combination. Never guess another real user’s password. |

**Steps**

1. Open Sign in.
2. Provide an invalid credential pair.
3. Submit.
4. Read validation/feedback.
5. Check that protected account content is not accessible.

**Proposed expected result:** Sign-in does not succeed; user gets appropriate feedback; protected account data is not exposed.

**Observation / specification question:** Capture the exact wording, but do not assert a text that has not yet been observed.

**Actual result / evidence:** _Complete during manual execution; log outcome in `04-manual-execution-log.md`._

---

### TC-AUTH-003 — Required login inputs

| Attribute | Value |
|---|---|
| Area | Authentication |
| Priority | Medium |
| Type | Negative / boundary |
| Suggested future automation | Yes, UI |
| Preconditions | Logged out; sign-in form available. |
| Test data | Empty email and/or password. |

**Steps**

1. Submit with both inputs empty.
2. Record validation on each input.
3. Enter only email and submit.
4. Enter only password and submit.

**Proposed expected result:** Required-field validation prevents an unauthenticated empty-form login; messages or field states are observable.

**Observation / specification question:** Consider whether validation comes from HTML, frontend code, or backend.

**Actual result / evidence:** _Complete during manual execution; log outcome in `04-manual-execution-log.md`._

---

### TC-AUTH-004 — Logout invalidates visible session

| Attribute | Value |
|---|---|
| Area | Authentication |
| Priority | Medium |
| Type | Functional / security smoke |
| Suggested future automation | Yes, UI |
| Preconditions | Signed in using the demo account. |
| Test data | Public demo customer user. |

**Steps**

1. Sign in.
2. Locate and invoke Logout.
3. Return to sign-in or another public page.
4. Try navigating Back or refreshing the former account page.

**Proposed expected result:** User appears logged out and private account information is not available without renewed authentication.

**Observation / specification question:** Do not use aggressive security probing; observe normal UI navigation.

**Actual result / evidence:** _Complete during manual execution; log outcome in `04-manual-execution-log.md`._

---

### TC-CART-001 — Add one product to cart

| Attribute | Value |
|---|---|
| Area | Cart |
| Priority | High |
| Type | Smoke / positive |
| Suggested future automation | Yes, UI |
| Preconditions | Cart initially empty or its contents recorded; product add action available. |
| Test data | Choose an in-stock or addable product. |

**Steps**

1. Record chosen product name and listed price.
2. Add the item to cart.
3. Open cart.
4. Identify the line item and cart indicator.

**Proposed expected result:** Cart contains the selected product and its displayed identity/price correspond to the chosen item.

**Observation / specification question:** Shared session may have existing cart data; clear first if the UI allows.

**Actual result / evidence:** _Complete during manual execution; log outcome in `04-manual-execution-log.md`._

---

### TC-CART-002 — Remove product from cart

| Attribute | Value |
|---|---|
| Area | Cart |
| Priority | Medium |
| Type | Functional / positive |
| Suggested future automation | Yes, UI |
| Preconditions | Cart contains a known test product. |
| Test data | A product added during current test. |

**Steps**

1. Open cart.
2. Identify the known product.
3. Remove it using the UI.
4. Review cart contents and count.

**Proposed expected result:** Removed item is no longer present; cart state updates consistently.

**Observation / specification question:** If the application uses quantity decrement instead of a remove action, record actual flow.

**Actual result / evidence:** _Complete during manual execution; log outcome in `04-manual-execution-log.md`._

---

### TC-CART-003 — Cart quantity and totals consistency

| Attribute | Value |
|---|---|
| Area | Cart |
| Priority | High |
| Type | Functional / boundary |
| Suggested future automation | Yes, if quantity control exists |
| Preconditions | Cart contains one or more identified products. |
| Test data | Record product unit price and initial quantity. |

**Steps**

1. Observe cart line price and cart total.
2. Increase/decrease quantity if supported.
3. Recalculate expected line total manually.
4. Check displayed total after each change.

**Proposed expected result:** Quantities and totals remain internally consistent with displayed prices and documented shipping/tax rules.

**Observation / specification question:** If no quantity control or additional charges visible, narrow scope to what the UI actually supports.

**Actual result / evidence:** _Complete during manual execution; log outcome in `04-manual-execution-log.md`._

---

### TC-CHECK-001 — Checkout progression retains cart

| Attribute | Value |
|---|---|
| Area | Checkout |
| Priority | High |
| Type | End-to-end / functional |
| Suggested future automation | Conditional, UI |
| Preconditions | Cart has an item; only proceed through safe demonstration checkout actions. |
| Test data | Demo user and synthetic address only where accepted by the site. |

**Steps**

1. Proceed from cart to checkout.
2. Observe login/address/payment steps if present.
3. Navigate between steps without finalizing any real payment.
4. Check selected items and values remain consistent.

**Proposed expected result:** Checkout steps can be traversed without losing relevant cart items or user-provided values.

**Observation / specification question:** Do not complete a real transaction or submit real card information; confirm whether payment is simulated.

**Actual result / evidence:** _Complete during manual execution; log outcome in `04-manual-execution-log.md`._

---

### TC-CHECK-002 — Required checkout field validation

| Attribute | Value |
|---|---|
| Area | Checkout |
| Priority | Medium |
| Type | Negative / boundary |
| Suggested future automation | Conditional, UI |
| Preconditions | Checkout is available and includes a required input step. |
| Test data | Use empty inputs only; avoid real personal data. |

**Steps**

1. Open checkout.
2. Leave a required field empty.
3. Attempt to continue.
4. Read the field-level or form-level feedback.
5. Correct the field with synthetic data if safe.

**Proposed expected result:** Invalid required input is recognized, and the user is not silently advanced with incomplete data.

**Observation / specification question:** If required fields are not known, observe the UI and write exact cases after exploration.

**Actual result / evidence:** _Complete during manual execution; log outcome in `04-manual-execution-log.md`._

---

### TC-RESP-001 — Basic small-viewport usability

| Attribute | Value |
|---|---|
| Area | Responsive |
| Priority | Medium |
| Type | Exploratory / usability |
| Suggested future automation | Manual first |
| Preconditions | Home page accessible. |
| Test data | Chrome DevTools responsive viewport around 390 × 844 px. |

**Steps**

1. Open responsive view.
2. Navigate catalog, search, and product detail.
3. Inspect clipping, overlapping controls, and horizontal scrolling.
4. Try keyboard tab navigation where possible.

**Proposed expected result:** Core interactions remain usable and actionable; no critical controls are hidden or overlapped.

**Observation / specification question:** This is a smoke observation, not a full accessibility conformance audit.

**Actual result / evidence:** _Complete during manual execution; log outcome in `04-manual-execution-log.md`._

---

### TC-A11Y-001 — Keyboard navigation smoke

| Attribute | Value |
|---|---|
| Area | Accessibility |
| Priority | Medium |
| Type | Exploratory / accessibility |
| Suggested future automation | Manual first |
| Preconditions | Browser open, no mouse interaction for this case. |
| Test data | Keyboard Tab, Shift+Tab, Enter and Space. |

**Steps**

1. Reload home page.
2. Navigate primary controls using Tab.
3. Check visible focus indication.
4. Activate a navigational link with Enter.
5. Attempt basic search using keyboard only.

**Proposed expected result:** Primary workflow controls are reachable and usable with the keyboard, with perceptible focus.

**Observation / specification question:** Record findings without claiming WCAG certification or an exhaustive accessibility audit.

**Actual result / evidence:** _Complete during manual execution; log outcome in `04-manual-execution-log.md`._

---

## New-case template

```markdown
### TC-AREA-### — Descriptive behavior
- Priority: High / Medium / Low
- Type: Smoke / functional / negative / boundary / other
- Preconditions:
- Test data:
- Steps:
  1.
  2.
  3.
- Expected result (supported by requirement or confirmed observation):
- Actual result:
- Status: Not Run / Pass / Fail / Blocked
- Evidence:
- Follow-up question:
```

## Additional test design homework

- Create 3 new test cases from genuine discoveries during exploration.
- For 2 test cases, identify one equivalence partition and one boundary condition.
- Select 5–8 cases for the future UI smoke suite and justify why each belongs at UI level.
- Identify at least 2 cases better suited to an API check in a later phase.
