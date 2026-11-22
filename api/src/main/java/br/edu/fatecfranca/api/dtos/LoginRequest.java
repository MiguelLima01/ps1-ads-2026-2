package br.edu.fatecfranca.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginRequest(
        @NotBlank String usernameOrEmail,
        @NotBlank @Size(max = 128) String password) {
}
