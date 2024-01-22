package com.portifolio.zeroquest.domain.services;

import com.portifolio.zeroquest.domain.dtos.CategoryDTO;
import com.portifolio.zeroquest.domain.dtos.RoleDTO;
import com.portifolio.zeroquest.domain.dtos.UserDTO;
import com.portifolio.zeroquest.domain.dtos.UserInsertDTO;
import com.portifolio.zeroquest.domain.entities.Category;
import com.portifolio.zeroquest.domain.entities.Role;
import com.portifolio.zeroquest.domain.entities.User;
import com.portifolio.zeroquest.domain.exceptions.EntityResourceNotFoundException;
import com.portifolio.zeroquest.domain.repositories.RoleRepository;
import com.portifolio.zeroquest.domain.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private UserRepository repository;

    private RoleRepository roleRepository;

    private BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository repository, RoleRepository roleRepository) {
        this.repository = repository;
        this.roleRepository = roleRepository;
    }

    public List<UserDTO> findAll(){
        var uses = repository.findAll();

        return uses.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
    }

    public UserDTO findById(Long id) {
        Optional<User> user = Optional.ofNullable(repository.findById(id).orElseThrow(
                () -> new EntityResourceNotFoundException("Entidade não encontrada")
        ));

        return new UserDTO(user.get());

    }

    @Transactional
    public UserDTO insert(UserInsertDTO dto) {
        User entity = new User();

        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setLastName(dto.getEmail());
        //vai encriptar a senha que o usuario passar quando for inserir um novo User
        entity.setPassword(passwordEncoder.encode(dto.getPassword()) );
        for (RoleDTO roleDTO : dto.getRoles()){
            Role role = roleRepository.getReferenceById(roleDTO.getId());
            entity.getRoles().add(role);
        }
        entity = repository.save(entity);

        return new UserDTO(entity);
    }

    @Transactional
    public UserDTO update(Long id, UserDTO body) {

        try {
            User entity = repository.getReferenceById(id);
            entity.setEmail(body.getEmail());
            entity.setFirstName(body.getFirstName());
            entity.setLastName(body.getLastName());

            for (RoleDTO roleDTO : body.getRoles()){
                Role role = roleRepository.getReferenceById(roleDTO.getId());
                entity.getRoles().add(role);
            }

            entity = repository.save(entity);

            return new UserDTO(entity);

        }
        catch (EntityNotFoundException e){
            throw new EntityResourceNotFoundException(e.getMessage());
        }
    }
}
