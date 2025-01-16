package com.vinay.hibernate.demo.entity3;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "instructor_detail")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString(exclude = "instructor")
public class InstructorDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "youtube_channel")
    @NonNull
    private String youtubeChannel;

    @Column(name = "hobby")
    @NonNull
    private String hobby;

    @OneToOne(mappedBy = "instructorDetail",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Instructor instructor;
}
