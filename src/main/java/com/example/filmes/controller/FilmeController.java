package com.example.filmes.controller;

import com.example.filmes.model.FilmeModel;
import com.example.filmes.model.dto.response.FilmeResponseDTO;
import com.example.filmes.service.FilmeService;
import lombok.RequiredArgsConstructor;
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
}
