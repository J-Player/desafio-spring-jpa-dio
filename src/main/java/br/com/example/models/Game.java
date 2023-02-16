package br.com.example.models;

import lombok.Builder;
import lombok.Data;
import lombok.With;

import javax.persistence.*;
import java.util.List;

@Data
@With
@Builder
@Entity
public class Game {

    @Id
    private Long id;
    @Column(unique = true)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Review> reviews;


}
