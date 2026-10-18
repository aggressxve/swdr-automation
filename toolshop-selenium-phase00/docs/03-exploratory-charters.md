# 03 — Exploratory Testing Charters

## What is a test charter?

A **charter** is a focused mission for a short exploratory session. Unlike a scripted test case, it gives you a goal and a few prompts, while allowing you to investigate new behaviors as you discover them. It combines learning, test design, and execution.

**Session rules:** 20–30 minutes per charter; start with a clean browser session when feasible; take concise notes; do not assume every anomaly is a defect; do not use real PII or payment information.

## Session header (copy per execution)

- Charter ID:
- Tester:
- Date and local time:
- Environment URL:
- Browser and version:
- Viewport / OS:
- Session duration:
- Initial state (guest, logged in, cart populated, etc.):

---

## E-01 — Catalog and product discovery

**Mission:** Learn how a shopper finds and evaluates products.

**Explore:**

1. Open the homepage. Find catalog cards and visible item information.
2. Open two different product details and return to the catalog.
3. Search for a product using its name; try a partial match and a term with no expected matches.
4. Explore categories and any sorting/filtering controls.
5. Experiment with clearing filters and browser back navigation.

**Questions to answer:** What exactly counts as a loaded catalog? What is searchable? Are results stable? What is the relationship among search, filters, sorting, and pagination?

**Write your findings:**

| Observation | Evidence | Follow-up or potential test |
|---|---|---|
| [Fill after exploration] | [Screenshot / description] | [New case or question] |
| [Fill] | [Fill] | [Fill] |
| [Fill] | [Fill] | [Fill] |

**Risks discovered:** [Fill]  
**Behavior requiring requirement clarification:** [Fill]  
**New test cases to add:** [Fill]

---

## E-02 — Authentication and session behavior

**Mission:** Learn how a customer logs in, receives feedback, and leaves the authenticated state.

**Explore:**

1. Locate Sign in and inspect form labels and required inputs.
2. Log in with a published demo user (`customer@practicesoftwaretesting.com` / `welcome01`).
3. Look for visible authenticated-state indicators and available account pages.
4. Log out; try normal Back/refresh navigation.
5. In a fresh session, attempt obviously invalid credentials and empty inputs (a small number of times only).

**Questions:** What indicates a successful login? Does empty form validation happen client-side? Does logout clear authenticated state? Are there temporary lockout/rate-limit rules?

| Observation | Evidence | Follow-up or potential test |
|---|---|---|
| [Fill] | [Fill] | [Fill] |
| [Fill] | [Fill] | [Fill] |

**Security boundary:** Do not brute-force passwords or attempt account takeover. Demo credentials are published; use only authorized practice scenarios.

---

## E-03 — Cart and safe checkout navigation

**Mission:** Identify cart invariants and checkout prerequisites without making real financial transactions.

**Explore:**

1. Choose a product and note its name and displayed price.
2. Add it to the cart; check navigation and cart indicator.
3. Remove it; note the empty-cart behavior.
4. If supported, add two products or change quantity and inspect totals.
5. Proceed into checkout only if the application offers a safe simulation; inspect required fields and navigation, without entering real card data.

**Questions:** Are item identity, quantity, and totals consistent? Does refresh change the cart? Can a guest proceed? What counts as final order confirmation in this demo?

| Observation | Evidence | Follow-up or potential test |
|---|---|---|
| [Fill] | [Fill] | [Fill] |
| [Fill] | [Fill] | [Fill] |

**Safety boundary:** Never enter real financial details. Stop if a flow appears to create an actual external charge or otherwise unsafe persistent effects.

---

## E-04 — Responsive and basic accessibility smoke

**Mission:** Determine whether primary shopping workflows remain usable on smaller screens and with keyboard-only navigation.

**Explore:**

1. Resize using DevTools (e.g. around 390 × 844) and inspect navigation/product cards.
2. Test search, a product detail, and cart access on the smaller view.
3. Reload at desktop size; navigate using Tab/Shift+Tab and Enter.
4. Observe focus visibility, input labels, and possible inaccessible controls.

| Observation | Evidence | Follow-up or potential test |
|---|---|---|
| [Fill] | [Fill] | [Fill] |
| [Fill] | [Fill] | [Fill] |

**Scope reminder:** This is not a complete accessibility conformance assessment.

---

## End-of-session debrief

Complete these after each charter:

1. **What did I learn about actual behavior?**
2. **What surprised me?**
3. **Which risk became more important or less important?**
4. **Which expectation needs a product decision or documentation check?**
5. **What new test case would catch a real regression?**
6. **What one workflow would I automate first, and why?**

**Session summary:** [Write 3–5 sentences]
