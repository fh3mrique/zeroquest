package com.portifolio.zeroquest.domain.repositories;

import com.portifolio.zeroquest.domain.entities.Category;
import com.portifolio.zeroquest.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
