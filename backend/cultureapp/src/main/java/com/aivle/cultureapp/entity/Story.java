package com.aivle.cultureapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Story {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 3000)
    private String desc;

    private String category;

    private Double lat;

    private Double lng;

    private String color;

    private String imageUrl;

    @OneToMany(mappedBy = "story",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Timeline> timelines;
}