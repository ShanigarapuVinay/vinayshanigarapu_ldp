package com.vinay.rest.restful_web_services.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "recipe")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NonNull
    private String name;

    @Column(name = "process")
    @NonNull
    private String process;

    @Column(name = "rating")
    @NonNull
    private double rating;
}
