package br.com.example.controllers.impl;

import br.com.example.controllers.IController;
import br.com.example.mappers.GameMapper;
import br.com.example.models.Game;
import br.com.example.models.dtos.GameDTO;
import br.com.example.services.impl.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class GameController implements IController<Game, GameDTO> {

    private final GameService gameService;

    @Override
    @GetMapping("/{id}")
    public Game findById(Long id) {
        return gameService.findById(id);
    }

    @Override
    @GetMapping
    public List<Game> findAll() {
        return gameService.findAll();
    }

    @Override
    @PostMapping
    public Game save(@RequestBody @Valid GameDTO gameDTO) {
        return gameService.save(GameMapper.INSTANCE.toGame(gameDTO));
    }

    @Override
    @PutMapping("/{id}")
    public void update(@RequestBody @Valid GameDTO gameDTO, @PathVariable Long id) {
        gameService.update(GameMapper.INSTANCE.toGame(gameDTO).withId(id));
    }

    @Override
    @DeleteMapping
    public void delete(Long id) {
        gameService.delete(id);
    }

}
