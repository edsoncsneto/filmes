package com.example.filmes.repository;

import com.example.filmes.model.FilmeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<FilmeModel, Integer> {
}
