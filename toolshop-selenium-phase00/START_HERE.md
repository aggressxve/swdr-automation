# START HERE — Your First Phase 00 Session (45–60 minutes)

**No Java, Selenium, Maven or external accounts required yet.** Your only tools today: browser, DevTools, Markdown editor, optional screenshot tool.

## 0–5 minutes — Prepare

1. Open https://practicesoftwaretesting.com/ in your browser.
2. Open `docs/00-project-brief.md` and `docs/03-exploratory-charters.md` in your editor.
3. Record date/time, browser version, screen size, normal environment URL and whether you're logged in.
4. Create a temporary note headed `E-01 — Catalog and product discovery`.

## 5–15 minutes — Understand the catalog

1. What information is displayed on each product card? (e.g., name/price/photo). Write only what you see.
2. Can you open a product? Does its detail match the one you selected?
3. How do you return to the catalog? What happens to your previous state?
4. Take one useful screenshot if you find a surprising behavior.

**Write:** 3 actual observations, one testable expectation, and one unknown.

Example of *how to write*, not a claim about the site:

- Observation: “The selected product's name appears on the details page.”
- Potential test oracle: “After selecting item X, the details page identifies X.”
- Open question: “Are prices guaranteed to remain unchanged during a session?”

## 15–30 minutes — Explore search and filtering

1. Choose a product name you actually see, then search for a distinctive word from it.
2. Observe results; write whether the query matches titles, descriptions or something else **based only on what you can infer**.
3. Search for an unlikely term: `zz-no-match-98431`.
4. Inspect filter and sorting controls, if present. Try one and reset it.
5. Record what happens after clearing Search; do results restore?

**Write:** 2 proposed expected results and any contradictory observations.

## 30–40 minutes — Convert observations into tests

Open `docs/01-test-cases.md`. Find:

- `TC-HOME-001`
- `TC-PROD-001`
- `TC-SEARCH-001`
- `TC-SEARCH-002`

Adapt test data and proposed expected results to match the actual controls you saw. Don't change the outcome to Pass unless you explicitly run that test as written.

For each test, ask yourself: “Could another tester reproduce this without asking me what I meant?”

## 40–50 minutes — Execute and record two cases

1. Run `TC-HOME-001` from a known state.
2. Run `TC-SEARCH-002` from a known state.
3. Update only those rows in `docs/04-manual-execution-log.md` with actual outcomes, concise observations and evidence if useful.
4. If blocked, record why. If unclear, mark Needs Clarification rather than inventing a Pass/Fail.

## 50–60 minutes — Debrief

Fill the E-01 debrief in `docs/03-exploratory-charters.md`:

- What did I learn?
- What was surprising?
- Which one business risk matters most?
- Which two candidate tests would I automate eventually, and why?

Then commit the updated docs if you have initialized your own Git repository:

```bash
git add README.md START_HERE.md docs/ evidence/ .github/
git commit -m "test: explore Toolshop product discovery and design manual tests"
```

## What to do next

- Session 2: E-02 or E-03, followed by authentication/cart test-case review.
- Session 3: Execute 6+ cases and record evidence.
- Session 4: Risk analysis, automation candidates, defects (only real), exit checklist.

**Remember:** Phase 00 succeeds through quality of reasoning and documentation, not test-code quantity.
