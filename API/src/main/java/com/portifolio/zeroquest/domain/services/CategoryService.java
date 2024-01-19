package com.portifolio.zeroquest.domain.services;

import com.portifolio.zeroquest.domain.dtos.CategoryDTO;
import com.portifolio.zeroquest.domain.entities.Category;
import com.portifolio.zeroquest.domain.exceptions.EntityResourceNotFoundException;
import com.portifolio.zeroquest.domain.repositories.CategoryRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    private CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<CategoryDTO> findAll(){
        var categories = repository.findAll();

        return categories.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
    }

    public CategoryDTO findById(Long id) {
        Optional<Category> category = Optional.ofNullable(repository.findById(id).orElseThrow(
                () -> new EntityResourceNotFoundException("Entidade não encontrada")
        ));

        return new CategoryDTO(category.get());

    }

    /*public CategoryDTO findById(Long id) {
        Optional<Category> obj = repository.findById(id);

        Category entity = obj.orElseThrow( () -> new EntityResourceNotFoundException("Entidade não encontrada"));
        return new CategoryDTO(entity);

    }*/

    @Transactional()
    public CategoryDTO insert(CategoryDTO dto) {
        Category entity = new Category();

        entity.setId(dto.id());
        entity.setNome(dto.nome());
        entity = repository.save(entity);

        return new CategoryDTO(entity);
    }
}
