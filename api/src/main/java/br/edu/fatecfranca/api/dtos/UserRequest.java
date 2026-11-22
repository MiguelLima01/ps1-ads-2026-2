package br.edu.fatecfranca.api.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UserRequest(
        @NotBlank String fullname,
        @NotBlank @Pattern(regexp = "[A-Za-z0-9._-]+") String username,
        @NotBlank @Email String email,
        @NotBlank @Size(min = 8) String password,
        @NotNull Boolean isAdmin) {
}
