package com.demotest.wplab1.service;

import com.demotest.wplab1.model.Location;

import java.util.List;
import java.util.Optional;

public interface LocationService {
    public Optional<List<Location>> findAll();
}
