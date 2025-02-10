UML

Account
-id: int
-balance: double
-annualInterestRate: double
-dateCreated: java.util.Date
----------------------------
+Account()
+Account(id: int, balance: double)
+Account(id: int, balance: double, annualInterestRate: date, dateCreated: java.util.Date)
+getId(): int
+setId(id: int): void
+getBalance(): double
+setBalance(balance: double): void
+getAnnualInterestRate(): double
+setAnnualInterestRate(annualInterestRate: double): void
+getMonthlyInterestRate(): double
+getMonthlyInterest(): double
+widthdraw(amount: double): void
+deposit(amount: double): void
+getDate(): java.util.Date
+toString(): String


CheckingAccount
-overdraftLimit: double
------------------------
+CheckingAccount()
+CheckingAccount(id: int, balance: double, annualInterestRate: double, overdraftLimit: double)
+getOverdraftLimit(): double
+setOverdraftLimit(overdraftLimit: double): void
+toString(): String


SavingsAccount
+SavingsAccount()
+SavingsAccount(id: int, balance: double, annualInterestRate: double)
+withdraw(amount: double): void
+toString(): String