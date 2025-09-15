package com.example.filmes.controller;

import com.example.filmes.model.FilmeModel;
import com.example.filmes.model.dto.request.FilmeRequestDTO;
import com.example.filmes.model.dto.response.FilmeResponseDTO;
import com.example.filmes.service.FilmeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
@RequiredArgsConstructor
public class FilmeController {

    private final FilmeService service;

    @GetMapping
    public List<FilmeResponseDTO> listarTodos() {
        return service.listarTodos();
    }

    @PostMapping
    public ResponseEntity<FilmeResponseDTO> criar(@Valid @RequestBody FilmeRequestDTO dto) {
        FilmeResponseDTO filmeCriado = service.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(filmeCriado);
    }
}
