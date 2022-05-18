package com.twentythree.controller;

import com.twentythree.entities.Location;
import com.twentythree.repos.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/location/")
public class LocationRESTController {

    @Autowired
    LocationRepository locationRepository;

    @GetMapping
    public List<Location> getLocation(){
        return locationRepository.findAll();
    }

    @PostMapping("saveLocation")
    public Location createLocation(@RequestBody Location location){
        return locationRepository.save(location);
    }

    @PutMapping("updateLocation")
    public Location updateLocation(@RequestBody Location location){
        return locationRepository.save(location);
    }

    @DeleteMapping("deletelocation/{id}")
    public void deleteLocation(@PathVariable("id") int id){
        Location location = locationRepository.getById(id);
        locationRepository.delete(location);
    }

    @GetMapping("getLocationById/{id}")
    public Location getLocationById(@PathVariable("id") int id){
        Location location = locationRepository.getById(id);
        return location;
    }

}
