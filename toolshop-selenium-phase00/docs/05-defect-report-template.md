# 05 — Defect Report Template

A professional defect report lets another engineer reproduce a problem without guessing the data, environment, or steps. A mismatch between an assumption and actual behavior is not automatically a defect.

## Blank template

**Bug ID:** BUG-###  
**Title:** [Feature] [Observed problem] when [trigger]  
**Status:** New / Triaged / In Progress / Fixed / Cannot Reproduce  
**Severity:** Critical / High / Medium / Low  
**Priority:** P0 / P1 / P2 / P3  
**Reproducibility:** Always / Intermittent (x/y attempts) / Once  
**Related test case(s):** TC-...  
**Environment:** URL, browser + version, OS, date/time  
**Requirement or expectation source:** Link, acceptance criterion, or confirmed owner decision

### Preconditions

- [ ] Initial login state
- [ ] Relevant cart/search/filter state
- [ ] Any necessary test data (do not paste secrets)

### Reproduction steps

1. [Concrete action]
2. [Concrete action]
3. [Concrete action]

### Expected result

[Explain the observable correct behavior and source of expectation.]

### Actual result

[State exactly what happened. Include exact messages or values when relevant.]

### Impact

[Explain what customer journey fails and how severe the consequence is.]

### Evidence

- Screenshot: `evidence/...`
- Screen recording or console snippet: [if useful]
- Log/HTTP info: [only if safely captured]

### Workaround and additional notes

[Known workaround, frequency, suspected scope, similar cases, remaining questions]

---

## Fully worked example (FICTITIOUS — training illustration, not a Toolshop claim)

**Bug ID:** BUG-EXAMPLE-001  
**Title:** [Cart] Adding a second item removes the first product  
**Severity:** High  
**Priority:** P1  
**Reproducibility:** 3/3 attempts  
**Environment:** Example demo build / Chrome (example only)  
**Requirement basis:** Business expectation that adding a second distinct cart item should preserve the first

**Precondition:** Empty cart.

**Steps:**

1. Open product A and select Add to cart.
2. Open product B and select Add to cart.
3. Open the cart.

**Expected:** Both product A and product B are listed.  
**Actual (hypothetical):** Only product B is shown.  
**Impact:** Customer loses selected items, which disrupts purchase flow.  
**Evidence:** `evidence/BUG-EXAMPLE-001-cart.png` (illustrative name; no real evidence exists).

**Do not copy this as a real bug.** Use the blank template only after you reproduce a genuine issue and validate the expectation.

## Triage checklist

- [ ] Steps reproducible in a fresh/known state
- [ ] Actual and expected behavior clearly separated
- [ ] Expected behavior grounded in a requirement, UX rule, or owner decision
- [ ] Severity and priority explained independently
- [ ] Screenshots use safe data and relevant context
- [ ] Tested browser / environment and date included
- [ ] Not a known limitation or unstable public demo artifact
