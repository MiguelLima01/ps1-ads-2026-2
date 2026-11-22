package br.edu.fatecfranca.api.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public record CarRequest(
        @NotBlank String brand,
        @NotBlank String model,
        @NotBlank String color,
        @NotNull @Positive Long yearManufacture,
        @NotNull Boolean imported,
        @NotBlank @Pattern(regexp = "(?:[A-Z]{3}-\\d{4}|[A-Z]{3}\\d[A-Z]\\d{2})") String plates,
        @PastOrPresent LocalDate sellingDate,
        @Positive @Digits(integer = 10, fraction = 2) BigDecimal sellingPrice,
        @Positive Long customerId) {
}
