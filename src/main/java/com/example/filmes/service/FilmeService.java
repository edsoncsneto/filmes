package com.example.filmes.service;

import com.example.filmes.model.FilmeModel;
import com.example.filmes.model.dto.request.FilmeRequestDTO;
import com.example.filmes.model.dto.response.FilmeResponseDTO;
import com.example.filmes.repository.FilmeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public FilmeResponseDTO criar(FilmeRequestDTO dto) {
        FilmeModel filme = new FilmeModel();
        filme.setTitulo(dto.titulo());
        filme.setAutor(dto.autor());
        filme.setGenero(dto.genero());
        filme.setMinutos(dto.minutos());

        FilmeModel filmeSalvo = repository.save(filme);

        return new FilmeResponseDTO(
                filmeSalvo.getId(),
                filmeSalvo.getTitulo(),
                filmeSalvo.getAutor(),
                filmeSalvo.getGenero(),
                filmeSalvo.getMinutos()
        );
    }
}
