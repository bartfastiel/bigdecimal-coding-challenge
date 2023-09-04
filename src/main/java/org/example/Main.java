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

        bankOfExamplehausen.transfer(donaldAccountNumber, BigDecimal.valueOf(100), "Fronleistung", dagobertAccountNumber);


        String jointAccount = bankOfExamplehausen.open(Set.of(dagobert, donald));
        bankOfExamplehausen.transfer(dagobertAccountNumber, new BigDecimal("9.43"), "Jahresgehalt", jointAccount);
        bankOfExamplehausen.split(jointAccount);
        System.out.println(bankOfExamplehausen);


        BankService bankOfZinshausen = new BankService();
        String interestCheckNumber1 = bankOfZinshausen.open(new Client(
                "id-1",
                "Zins",
                "Test"
        ));
        String interestCheckNumber2 = bankOfZinshausen.open(new Client(
                "id-2",
                "Zins",
                "Test"
        ));

        bankOfZinshausen.transfer(interestCheckNumber1, BigDecimal.valueOf(100), "Geschenk", interestCheckNumber2);

        bankOfZinshausen.payInterests(new BigDecimal("1.005"));

        System.out.println(bankOfZinshausen);


    }
}