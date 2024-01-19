package com.portifolio.zeroquest.domain.repositories;

import com.portifolio.zeroquest.domain.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository  extends JpaRepository<Category, Long> {
}
