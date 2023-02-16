package br.com.example.services.impl;

import br.com.example.models.Game;
import br.com.example.repositories.GameRepository;
import br.com.example.services.IService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService implements IService<Game> {

    private final GameRepository gameRepository;

    @Override
    public Game findById(Long id) {
        return gameRepository.findById(id)
                .orElseThrow();
    }

    @Override
    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    @Override
    public Game save(Game game) {
        return gameRepository.save(game);
    }

    @Override
    public void update(Game game) {
        Game gameSaved = findById(game.getId());
        if (gameSaved != null) {
            gameRepository.save(game);
        }
    }

    @Override
    public void delete(Long id) {
        gameRepository.deleteById(id);
    }
}
