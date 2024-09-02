package com.vinay.hibernate.demo.entity4;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "review")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "comment")
    @NonNull
    private String comment;

}
