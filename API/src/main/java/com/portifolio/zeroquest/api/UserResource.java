package com.portifolio.zeroquest.api;

import com.portifolio.zeroquest.domain.dtos.CategoryDTO;
import com.portifolio.zeroquest.domain.dtos.UserDTO;
import com.portifolio.zeroquest.domain.dtos.UserInsertDTO;
import com.portifolio.zeroquest.domain.entities.User;
import com.portifolio.zeroquest.domain.services.CategoryService;
import com.portifolio.zeroquest.domain.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserResource {
    private UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<UserDTO> bodyRequest = userService.findAll();
        return  ResponseEntity.ok().body(bodyRequest);
    }

   @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findAll(@PathVariable Long id){
       UserDTO bodyRequest = userService.findById(id);
        return  ResponseEntity.ok().body(bodyRequest);
    }

    @PostMapping
    public ResponseEntity<UserDTO> insert (@RequestBody UserInsertDTO body){
        UserDTO bodyRequest = userService.insert(body);

      return ResponseEntity.status(HttpStatus.CREATED).body(bodyRequest);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDTO> update (@PathVariable Long id,
                                               @RequestBody UserDTO body){

        body = userService.update(id, body);

        return ResponseEntity.ok().body(body);

    }
}
