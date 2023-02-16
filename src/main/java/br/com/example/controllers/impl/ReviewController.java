package br.com.example.controllers.impl;

import br.com.example.controllers.IController;
import br.com.example.mappers.ReviewMapper;
import br.com.example.models.Game;
import br.com.example.models.Review;
import br.com.example.models.User;
import br.com.example.models.dtos.ReviewDTO;
import br.com.example.services.impl.GameService;
import br.com.example.services.impl.ReviewService;
import br.com.example.services.impl.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class ReviewController implements IController<Review, ReviewDTO> {

    private final ReviewService reviewService;
    private final GameService gameService;
    private final UserService userService;

    @Override
    @GetMapping("/{id}")
    public Review findById(@PathVariable Long id) {
        return reviewService.findById(id);
    }

    @Override
    @GetMapping
    public List<Review> findAll() {
        return reviewService.findAll();
    }

    @Override
    @PostMapping
    public Review save(@RequestBody @Valid ReviewDTO reviewDTO) {
        Review review = ReviewMapper.INSTANCE.toReview(reviewDTO);
        Game game = gameService.findById(reviewDTO.getGameId());
        User user = userService.findById(reviewDTO.getUserId());
        review.setGame(game);
        review.setUser(user);
        return reviewService.save(review);
    }

    @Override
    @PutMapping("/{id}")
    public void update(@RequestBody @Valid ReviewDTO reviewDTO, @PathVariable Long id) {
        Review review = ReviewMapper.INSTANCE.toReview(reviewDTO).withId(id);
        Game game = gameService.findById(reviewDTO.getGameId());
        User user = userService.findById(reviewDTO.getUserId());
        review.setGame(game);
        review.setUser(user);
        reviewService.update(review);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        reviewService.delete(id);
    }
}
