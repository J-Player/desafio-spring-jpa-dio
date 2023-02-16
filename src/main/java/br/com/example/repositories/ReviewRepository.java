package br.com.example.repositories;

import br.com.example.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    Review findbyUserId(Long name);

}
