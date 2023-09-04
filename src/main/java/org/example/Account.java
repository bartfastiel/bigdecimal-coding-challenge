package org.example;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Account {

    private String accountNumber;
    private final List<Transaction> transactions = new ArrayList<>(List.of(
            new Transaction(BigDecimal.ZERO, BigDecimal.ZERO, "Kontoeröffnung", Instant.now())
    ));
    private Set<Client> owners;

    public Account(String accountNumber, Set<Client> owners) {
        this.accountNumber = accountNumber;
        this.owners = owners;
    }

    public void deposit(BigDecimal amount, String description) {
        transactions.add(new Transaction(
                amount,
                getSaldo().add(amount),
                description,
                Instant.now()
        ));
    }

    public void withdraw(BigDecimal amount, String description) {
        deposit(amount.negate(), description);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getSaldo() {
        return transactions.get(transactions.size() - 1).saldo();
    }

    public Set<Client> getOwners() {
        return owners;
    }

    @Override
    public String toString() {
        StringBuilder transactionsText = new StringBuilder();
        for (Transaction transaction : transactions) {
            transactionsText.append("  ").append(transaction).append("\n");
        }
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", transactions=\n" + transactionsText +
                ", owners=" + owners +
                '}';
    }
}
