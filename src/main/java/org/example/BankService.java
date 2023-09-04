package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

    public List<String> split(String sourceAccountNumber) {
        Account source = findAccountByNumber(sourceAccountNumber);
        int numberOfOwners = source.getOwners().size();
        if (numberOfOwners < 2) {
            return List.of(sourceAccountNumber);
        }
        List<String> resultingAccounts = new ArrayList<>();
        List<Client> ownerSorted = new ArrayList<>(source.getOwners());
        BigDecimal roundedDownMoney = source.getSaldo().divide(BigDecimal.valueOf(numberOfOwners), RoundingMode.DOWN);
        for (int i = 0; i < ownerSorted.size(); i++) {
            String singleAccountNumber = open(ownerSorted.get(i));
            resultingAccounts.add(singleAccountNumber);
            BigDecimal moneyForOnePerson;
            if (i < ownerSorted.size() - 1) {
                moneyForOnePerson = roundedDownMoney;
            } else {
                moneyForOnePerson = source.getSaldo();
            }
            transfer(sourceAccountNumber,
                    moneyForOnePerson,
                    singleAccountNumber
            );
        }
        return resultingAccounts;
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder("BankService{");
        for (Account account : accounts) {
            text.append("\n").append(account);
        }
        return text.toString() + "\n}";
    }
}
