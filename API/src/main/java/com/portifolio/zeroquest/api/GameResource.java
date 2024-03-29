package com.portifolio.zeroquest.api;

import com.portifolio.zeroquest.domain.dtos.CategoryDTO;
import com.portifolio.zeroquest.domain.dtos.GameDTO;
import com.portifolio.zeroquest.domain.services.CategoryService;
import com.portifolio.zeroquest.domain.services.GameService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/games")
public class GameResource {
    private GameService gameService;

    public GameResource(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public ResponseEntity<Page<GameDTO>> findAll(Pageable pageable){
        Page<GameDTO> bodyRequest = gameService.findAll(pageable);
        return  ResponseEntity.ok().body(bodyRequest);
    }

   @GetMapping(value = "/{id}")
    public ResponseEntity<GameDTO> findById(@PathVariable Long id){
        GameDTO bodyRequest = gameService.findById(id);
        return  ResponseEntity.ok().body(bodyRequest);
    }

    /*
    @PostMapping
    public ResponseEntity<CategoryDTO> insert (@RequestBody CategoryDTO body){
        CategoryDTO bodyRequest = categoryService.insert(body);

      return ResponseEntity.status(HttpStatus.CREATED).body(bodyRequest);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CategoryDTO> update (@PathVariable Long id,
                                               @RequestBody CategoryDTO body){

        body = categoryService.update(id, body);

        return ResponseEntity.ok().body(body);

    }*/
}
