package com.example.filmes.model.dto.response;

public record FilmeResponseDTO(
        int id,
        String titulo,
        String autor,
        String genero,
        int minutos
) {}
