package com.demotest.wplab1.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Event {
    String name;
    String description;
    double popularityScore;
}
