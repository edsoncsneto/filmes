package com.example.filmes.model.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record FilmeRequestDTO(
        @NotBlank String titulo,
        String autor,
        String genero,
        @Min(1) int minutos
) {}
