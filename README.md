# Swedbank

Unofficial Java API client for Swedbank with the following features:

- Overview of your bank accounts, loans, debit and credit cards
- List account transactions

Supported authentication methods:
- Mobile BankID

## Code Examples

Login using mobile bank id and get a list of all of your accounts on Swedbank.
```java
Swedbank swedbank = new Swedbank();
MobileBankID mobileBankID = new MobileBankID(new SwedbankApp(), "ENTER YOUR PERSONAL NUMBER HERE.");

// Login using mobile bank id.
swedbank.login(mobileBankID);

// Wait for the user to authenticate in the mobile bank id app.
while (!swedbank.isLoggedIn()) {
    System.out.println("Waiting for the user to confirm authentication in mobile bank id app.");
    Thread.sleep(5000);     // Wait 5 seconds until we check if the user has authenticated.
}

// Fetch all accounts: transaction accounts, transaction disposal accounts, loan accounts, saving accounts and card accounts.
AccountList accountList = swedbank.accountList();

// Show the name and balance of all accounts.
for (TransactionAccount account : accountList.getAllAccounts()) {
    System.out.println("Account Name: " + account.getName());
    System.out.println("Account Balance: " + account.getBalance());
}
```

Get all transactions for all of your accounts on Swedbank.
```java
int transactionsPerPage = 100;
AccountDetails accountDetails;

for (TransactionAccount account : accountList.getAllAccounts()) {
    System.out.println("Account name: " + account.getName());
    int page = 1;

    // Print all transactions for the given account.
    do {
        accountDetails = swedbank.accountDetails(account, transactionsPerPage, page);    // Fetch transactions for the given account.

        for (Transaction transaction : accountDetails.getTransactions()) {
            System.out.println("Transaction date: " + transaction.getDate().toString());
            System.out.println("Transaction description: " + transaction.getDescription());
            System.out.println("Transaction amount: " + transaction.getAmount());
        }

        page++;
    } while (accountDetails.isMoreTransactionsAvailable());
}
```

## Not Implemented
- Transfer money between accounts
- Activate, deactivate and view quick balance (aka. snabbsaldo)
- Security token with one time code
- No authentication (used for some functionality eg. quick balance)

For information on how to implement this check out https://github.com/walle89/SwedbankJson.

## Releases

Available in the [Maven Central repository](https://mvnrepository.com/artifact/com.github.soshibby/swedbank/1.2)

### Maven configuration:
```java
<dependency>
    <groupId>com.github.soshibby</groupId>
    <artifactId>swedbank</artifactId>
    <version>1.2</version>
</dependency>
```

### Gradle configuration:
```java
compile group: 'com.github.soshibby', name: 'swedbank', version: '1.2'
```

## Special Thanks
A special thank you to https://github.com/walle89 for providing the code on which this project is based on (https://github.com/walle89/SwedbankJson).
