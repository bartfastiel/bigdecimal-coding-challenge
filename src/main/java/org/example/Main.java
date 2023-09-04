package org.example;

import java.math.BigDecimal;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Client dagobert = new Client(
                "dag-123",
                "Dagobert",
                "Rich"
        );
        Client donald = new Client(
                "don-234",
                "Donald",
                "Poor"
        );
        BankService bankOfExamplehausen = new BankService();

        String dagobertAccountNumber = bankOfExamplehausen.open(dagobert);
        String donaldAccountNumber = bankOfExamplehausen.open(donald);

        bankOfExamplehausen.transfer(donaldAccountNumber, BigDecimal.valueOf(100), dagobertAccountNumber);


        String jointAccount = bankOfExamplehausen.open(Set.of(dagobert, donald));
        System.out.println(bankOfExamplehausen);


    }
}