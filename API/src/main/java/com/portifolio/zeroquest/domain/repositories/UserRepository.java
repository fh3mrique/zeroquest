package com.portifolio.zeroquest.domain.repositories;

import com.portifolio.zeroquest.domain.entities.Category;
import com.portifolio.zeroquest.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {
    UserDetails findByEmail (String email);
}
