# 08 — Environments, Accounts, and Safe Test Data

## Official environments

| Environment | URL | How it is used |
|---|---|---|
| Normal hosted Sprint 5 | https://practicesoftwaretesting.com/ | Phase 00 baseline exploration and manual test design |
| Version with seeded bugs | https://with-bugs.practicesoftwaretesting.com/ | Later investigation and bug-report practice; do not confuse results with baseline |
| Public API docs | https://api.practicesoftwaretesting.com/api/documentation | Future API and hybrid testing phase |
| Official repository/docs | https://github.com/testsmith-io/practice-software-testing/blob/main/docs/README.md | Source of hosted-version and demo-account information |

The normal and intentionally buggy environments are distinct. Always paste the environment URL into execution logs and bug reports.

## Published demo accounts

Source: official project docs (listed above). These are **public training accounts**, not secrets:

| Use | Email | Demo password | Notes |
|---|---|---|---|
| Customer baseline | `customer@practicesoftwaretesting.com` | `welcome01` | Preferred for basic login workflow exploration |
| Alternate customer | `customer2@practicesoftwaretesting.com` | `welcome01` | Only if needed; shared state may be affected by others |
| Additional customer | `customer3@practicesoftwaretesting.com` | `pass123` | Only if needed |

Admin account exists in official docs but is **not needed** for Phase 00. Avoid admin or potentially destructive operations.

## Safe input guidance

- **Search:** Derive positive queries from actual visible product names; use a clearly invalid string like `zz-no-match-98431` for negative search.
- **Email negative case:** `not-a-user@example.invalid` (reserved invalid top-level domain, not a real mailbox).
- **Password negative case:** An arbitrary invalid value such as `not-the-password-123`.
- **Address inputs, if checkout supports a test flow:** Use obviously synthetic test names and addresses only; never real personal details.
- **Payment:** Never enter real credit-card or bank information. Do not perform a real transaction. Confirm simulation behavior before proceeding.

## Shared-instance precautions

1. Keep runs small and respectful; this public site is a practice resource.
2. Don't mass-register users, brute-force logins, or repeatedly submit large orders.
3. Avoid saving credentials or session tokens in screenshots/logs.
4. Clear session/cart state where feasible; if not, explicitly record initial state.
5. If the hosted application changes or goes offline, mark the test Blocked and note the time instead of assuming a product bug.
6. Don't copy the official project's source into your repository unless you have reviewed and complied with its license; this project contains independently authored QA documentation only.

## Environment report template

```text
Environment:
App URL:
Timestamp and timezone:
Operating system:
Browser and version:
Viewport dimensions:
Authenticated? Which PUBLIC demo account?:
Initial cart/session state:
Known environment anomalies:
```

## Open test data questions

- Does the public account preserve a cart across sessions?
- Does checkout have guest and authenticated variants?
- Are data values reset periodically?
- Which product names are stable enough to use as future fixtures?

Record answers only after you observe them. Don't guess.
