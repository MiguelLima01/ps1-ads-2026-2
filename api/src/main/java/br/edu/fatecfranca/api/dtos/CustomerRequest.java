package br.edu.fatecfranca.api.dtos;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;

public record CustomerRequest(
        @NotBlank String name,
        @NotBlank String identDocument,
        @PastOrPresent LocalDate birthDate,
        @NotBlank String streetName,
        @NotBlank String houseNumber,
        String complements,
        @NotBlank String district,
        @NotBlank String municipality,
        @NotBlank @Pattern(regexp = "[A-Z]{2}") String state,
        @NotBlank String phone,
        @NotBlank @Email String email) {
}
