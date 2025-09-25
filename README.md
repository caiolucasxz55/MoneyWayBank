# MoneyWayBank

MoneyWayBank is a simple banking API built with Spring Boot, made for a College Project. It supports basic account management and monetary transactions with precise decimal handling via BigDecimal.

## Key Features
- Create and manage bank accounts
- Enforce “one active account per CPF” rule
- Deposit, Withdraw, and Pix (transfer between accounts)
- Validation with Bean Validation (Jakarta Validation)
- Persistence with Spring Data JPA
- Clear transaction history model (Transaction entity)

## Domain Model

### Account
- Fields (typical):
  - `id` (Long, PK, generated)
  - `number` (String)
  - `agency` (String)
  - `nameHolder` (String)
  - `cpfHolder` (String)
  - `active` (boolean, true by default) — used to enforce only one active account per CPF
  - `balance` (BigDecimal) — if present in your model

### Transaction
- Fields:
  - `id` (Long, PK, generated)
  - `sourceAccount` (Account) — used for withdrawals and Pix
  - `targetAccount` (Account) — used for deposits and Pix
  - `amount` (BigDecimal)
  - `transactionDate` (LocalDateTime)
  - `type` (TransactionType: DEPOSIT, WITHDRAWAL, PIX)

## Business Rules
- Only one active account per CPF (inactive accounts can share the same CPF)
- Amounts must be positive
- Withdraw requires sufficient balance
- Pix requires different source and target accounts
- Monetary math using BigDecimal 

### Endpoints

1) Deposit
- POST `/transactions/deposit`
- Request body:
```json
{
  "accountId": 1,
  "amount": 100.00
}
```

2) Withdraw
- POST `/transactions/withdraw`
- Request body:
```json
{
  "accountId": 1,
  "amount": 50.00
}
```

3) Pix (Transfer)
- POST `/transactions/pix`
- Request body:
```json
{
  "sourceAccountId": 1,
  "targetAccountId": 2,
  "amount": 25.00
}
```



## License
This project is for educational purposes, made by: joaoGFG and caiolucasxz55
