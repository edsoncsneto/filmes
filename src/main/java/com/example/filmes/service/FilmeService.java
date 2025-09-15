package com.example.filmes.service;

import com.example.filmes.model.FilmeModel;
import com.example.filmes.model.dto.response.FilmeResponseDTO;
import com.example.filmes.repository.FilmeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FilmeService {

    private final FilmeRepository repository;

    @Transactional(readOnly = true)
    public List<FilmeResponseDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(filme -> new FilmeResponseDTO(
                        filme.getId(),
                        filme.getTitulo(),
                        filme.getAutor(),
                        filme.getGenero(),
                        filme.getMinutos()
                ))
                .toList();
    }
}
