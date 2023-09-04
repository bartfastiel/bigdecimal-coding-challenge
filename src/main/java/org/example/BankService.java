package org.example;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class BankService {

    private static int lastAccountNumber = 1000;

    private final Set<Account> accounts = new HashSet<>();
    private final Set<Client> clients = new HashSet<>();

    public String open(Client owner) {
        return open(Set.of(owner));
    }

    public String open(Set<Client> owners) {
        clients.addAll(owners);
        String accountNumber = "" + lastAccountNumber++;
        accounts.add(new Account(
                accountNumber,
                owners
        ));
        return accountNumber;
    }

    public void transfer(
            String sourceAccountNumber,
            BigDecimal amount,
            String targetAccountNumber) {
        Account source = findAccountByNumber(sourceAccountNumber);
        Account target = findAccountByNumber(targetAccountNumber);
        source.withdraw(amount);
        target.deposit(amount);
    }

    private Account findAccountByNumber(String sourceAccountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(sourceAccountNumber)) {
                return account;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "BankService{" +
                "accounts=" + accounts +
                ", clients=" + clients +
                '}';
    }
}
