# Test Evidence Guidelines

Keep only useful evidence with an execution ID and test/bug ID. Do not record or publish passwords, authorization tokens, payment information, personal addresses, session cookies or another tester's account data.

## Suggested filenames

```text
MANUAL-2026-10-14-01_TC-SEARCH-002_empty-state.png
MANUAL-2026-10-14-01_TC-CART-001_cart-item.png
BUG-001_step-03_cart.png
```

Screenshots should include enough context to identify the application and affected element, but crop/blur sensitive details before committing anything publicly.

## Evidence checklist

- [ ] Screenshot/log belongs to a real test run.
- [ ] Test case ID and timestamp are traceable in the execution log.
- [ ] Sensitive personal data, passwords, and tokens are excluded.
- [ ] Screenshot genuinely illustrates the observation.
- [ ] The expected behavior is explained separately in the test/bug report.

**No images are included in this starter pack.** You will capture them during manual execution.
