package org.example;

import java.math.BigDecimal;
import java.util.Set;

public class Account {

    private String accountNumber;
    private BigDecimal saldo = BigDecimal.ZERO;
    private Set<Client> owners;

    public Account(String accountNumber, Set<Client> owners) {
        this.accountNumber = accountNumber;
        this.owners = owners;
    }

    public void deposit(BigDecimal amount) {
        saldo = saldo.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        saldo = saldo.subtract(amount);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Set<Client> getOwners() {
        return owners;
    }

    public void setOwners(Set<Client> owners) {
        this.owners = owners;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", saldo=" + saldo +
                ", owners=" + owners +
                '}';
    }
}
