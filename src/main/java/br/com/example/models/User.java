package br.com.example.models;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Builder
@Entity
public class User {

    @Id
    private Long id;
    private String name;

    @OneToMany(orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Game> games;

    @OneToMany(orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Review> reviews;

}
