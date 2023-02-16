package br.com.example.services.impl;

import br.com.example.models.Review;
import br.com.example.repositories.ReviewRepository;
import br.com.example.services.IService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService implements IService<Review> {

    private final ReviewRepository gameRepository;

    @Override
    public Review findById(Long id) {
        return gameRepository.findById(id)
                .orElseThrow();
    }

    public Review findByUserId(Long id) {
        return gameRepository.findbyUserId(id);
    }

    @Override
    public List<Review> findAll() {
        return gameRepository.findAll();
    }

    @Override
    public Review save(Review review) {
        return gameRepository.save(review);
    }

    @Override
    public void update(Review review) {
        Review reviewSaved = findById(review.getId());
        if (reviewSaved != null) {
            review.setDateEdit(Instant.now());
            gameRepository.save(review);
        }
    }

    @Override
    public void delete(Long id) {
        gameRepository.deleteById(id);
    }

}
