package com.portifolio.zeroquest.domain.repositories;

import com.portifolio.zeroquest.domain.entities.Role;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
