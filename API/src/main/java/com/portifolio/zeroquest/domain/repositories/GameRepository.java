package com.portifolio.zeroquest.domain.repositories;

import com.portifolio.zeroquest.domain.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository  extends JpaRepository<Game, Long> {
}
