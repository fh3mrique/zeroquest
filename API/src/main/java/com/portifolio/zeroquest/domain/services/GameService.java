package com.portifolio.zeroquest.domain.services;

import com.portifolio.zeroquest.domain.dtos.CategoryDTO;
import com.portifolio.zeroquest.domain.dtos.GameDTO;
import com.portifolio.zeroquest.domain.entities.Category;
import com.portifolio.zeroquest.domain.entities.Game;
import com.portifolio.zeroquest.domain.exceptions.EntityResourceNotFoundException;
import com.portifolio.zeroquest.domain.repositories.GameRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GameService {
    private GameRepository repository;

    public GameService(GameRepository repository) {
        this.repository = repository;
    }

    public List<GameDTO> findAll(){
        var games = repository.findAll();

        return games.stream().map(x -> new GameDTO(x)).collect(Collectors.toList());
    }

   /* public GameDTO findById(Long id) {
        Optional<Game> game = Optional.ofNullable(repository.findById(id).orElseThrow(
                () -> new EntityResourceNotFoundException("Entidade não encontrada")
        ));

        return new CategoryDTO(game.get());

    }

    @Transactional
    public CategoryDTO insert(CategoryDTO dto) {
        Category entity = new Category();

        entity.setId(dto.id());
        entity.setNome(dto.nome());
        entity = repository.save(entity);

        return new CategoryDTO(entity);
    }

    @Transactional
    public CategoryDTO update(Long id, CategoryDTO body) {

        try {
            Category entity = repository.getReferenceById(id);
            entity.setNome(body.nome());

            entity = repository.save(entity);

            return new CategoryDTO(entity);

        }
        catch (EntityNotFoundException e){
            throw new EntityResourceNotFoundException(e.getMessage());
        }
    }*/
}
