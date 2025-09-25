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
Fields:
  - `id` (Long, PK, auto-generated)
  - `number` (int, positive, required)
  - `agency` (String, not blank, required)
  - `nameHolder` (String, not blank, required)
  - `cpfHolder` (String, not blank, 11-14 characters, required)
  - `openingDate` (LocalDate, past or present, required)
  - `balance` (BigDecimal, positive or zero, required)
  - `active` (boolean, true by default) — used to enforce only one active account per CPF
  - `type` (AccountType enum: CHECKING, SAVINGS, SALARY, required) 

### Transaction
Fields:
  - `id` (Long, PK, auto-generated)
  - `sourceAccount` (Account, nullable for deposits)
  - `targetAccount` (Account, nullable for withdrawals)
  - `amount` (BigDecimal, positive, required)
  - `transactionDate` (LocalDateTime, past or present, required)
  - `type` (TransactionType enum: DEPOSIT, WITHDRAWAL, PIX, required)

## Business Rules
- Only one active account per CPF (inactive accounts can share the same CPF)
- All monetary amounts must be positive
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
