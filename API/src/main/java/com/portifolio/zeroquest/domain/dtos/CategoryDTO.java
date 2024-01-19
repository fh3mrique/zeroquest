package com.portifolio.zeroquest.domain.dtos;

import com.portifolio.zeroquest.domain.entities.Category;

import java.util.List;
import java.util.Optional;

public record CategoryDTO(Long id, String nome) {

    public CategoryDTO(Category entity) {
        this(entity.getId(), entity.getNome());
    }


}
