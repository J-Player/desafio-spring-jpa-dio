package br.com.example.models;

import lombok.Builder;
import lombok.Data;
import lombok.With;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.Instant;

@Data
@With
@Builder
@Entity
public class Review {

    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(nullable = false, updatable = false)
    private Game game;
    @ManyToOne
    @JoinColumn(nullable = false, updatable = false)
    private User user;
    private String comment;
    private boolean recommend;
    private final Instant date = Instant.now();
    private Instant dateEdit;

}
