package com.demotest.wplab1.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double popularityScore;

    @ManyToOne()
    private Location location;

    @ManyToOne
    private Category category;

    public Event(String name, String description, double popularityScore, Location location, Category category) {
        this.name = name;
        this.description = description;
        this.popularityScore = popularityScore;
        this.location = location;
        this.category = category;
    }
}
