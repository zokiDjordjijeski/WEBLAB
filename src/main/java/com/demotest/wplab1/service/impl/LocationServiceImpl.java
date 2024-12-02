package com.demotest.wplab1.service.impl;

import com.demotest.wplab1.model.Location;
import com.demotest.wplab1.repository.jpa.LocationRepository;
import com.demotest.wplab1.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepositoryInMemory;

    public LocationServiceImpl(LocationRepository locationRepositoryInMemory) {
        this.locationRepositoryInMemory = locationRepositoryInMemory;
    }

    @Override
    public Optional<List<Location>> findAll() {
        return Optional.of(this.locationRepositoryInMemory.findAll());
    }
}
