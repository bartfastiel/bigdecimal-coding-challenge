package org.example;

import java.math.BigDecimal;

public class Account {

    private String accountNumber;
    private BigDecimal saldo = BigDecimal.ZERO;
    private Client owner;

    public Account(String accountNumber, Client owner) {
        this.accountNumber = accountNumber;
        this.owner = owner;
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

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", saldo='" + saldo + '\'' +
                ", owner=" + owner +
                '}';
    }
}
