package com.portifolio.zeroquest.domain.dtos;

import com.portifolio.zeroquest.domain.entities.Role;

import java.util.List;

public record RegisterDTO(String email, String password, String role) {

}
