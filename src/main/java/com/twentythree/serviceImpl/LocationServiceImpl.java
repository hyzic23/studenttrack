package com.twentythree.serviceImpl;

import com.twentythree.entities.Location;
import com.twentythree.repos.LocationRepository;
import com.twentythree.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service    //This allowas spring to create an instance of this at runtime and also does DI in other classes as required
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository repository;

    @Override
    public Location saveLocation(Location location) {
        return repository.save(location);
    }

    @Override
    public Location updateLocation(Location location) {
        return repository.save(location);
    }

    @Override
    public void deleteLocation(Location location) {
        repository.delete(location);
    }

    @Override
    public Location getLocationById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Location> getAllLocations() {
        return repository.findAll();
    }
}
