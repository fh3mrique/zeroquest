package com.portifolio.zeroquest.domain.dtos;

import com.portifolio.zeroquest.domain.enums.Status;
import com.portifolio.zeroquest.domain.entities.Category;
import com.portifolio.zeroquest.domain.entities.Game;

import java.util.List;

public record GameDTO(Long id, String name, String review, Double grade, Status status, List<Category> categories) {

    public GameDTO(Game entity){
        this(entity.getId(), entity.getName(), entity.getReview(), entity.getGrade(), entity.getStatus(), entity.getCategories());
    }
}
