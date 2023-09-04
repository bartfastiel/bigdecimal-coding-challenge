package org.example;

import java.math.BigDecimal;
import java.time.Instant;

public record Transaction(
         BigDecimal amount,
         BigDecimal saldo,
         String description,
         Instant instant
) {
}
