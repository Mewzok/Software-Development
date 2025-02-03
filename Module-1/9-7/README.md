## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

UML

Account
-id: int
-balance: double
-annualInterestRate: double
-dateCreated: java.util.Date
---------------------------
+Account()
+Account(id: int, balance: double)
+getId(): int
+setId(newId: int): void
+getBalance(): double
+setBalance(newBalance: double): void
+getAnnualInterestRate(): double
+setAnnualInterestRate(newAnnualInterestRate: double): void
+getMonthlyInterestRate(): double
+getMonthlyInterest(): double
+withdraw(double: amount): void
+deposite(double: amount): void