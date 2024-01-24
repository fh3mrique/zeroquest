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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
    private UserRepository repository;

    private RoleRepository roleRepository;

    private BCryptPasswordEncoder passwordEncoder;

    private Logger log = LoggerFactory.getLogger(UserService.class);

    public UserService(UserRepository repository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
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
        entity.setEmail(dto.getEmail());
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByEmail(username);

        if (user == null){
            log.error("user não encotrado " + username);
            throw new UsernameNotFoundException("Email não encontrado");
        }

        log.info("user encontrado " + username);
        return user;
    }
}
