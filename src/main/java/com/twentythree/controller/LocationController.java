package com.twentythree.controller;


import com.twentythree.entities.Location;
import com.twentythree.repos.LocationRepository;
import com.twentythree.service.LocationService;
import com.twentythree.util.EmailUtil;
import com.twentythree.util.ReportUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import java.util.List;

@Controller
public class LocationController {

    @Autowired
    LocationService service;

    @Autowired
    EmailUtil emailUtil;

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    ReportUtil reportUtil;

    @Autowired
    ServletContext servletContext;

    @GetMapping("/")
    public String hello(){
        return "index";
    }

    @RequestMapping("/createLocation")
    public String createLocation(){
        return "createLocation";
    }

    @PostMapping("/saveLoc")
    public String saveLocation(@ModelAttribute("location") Location location,
                                ModelMap modelMap){
        Location locationSave = service.saveLocation(location);
        String msg = "Location saved with id: " + locationSave.getId();
        System.out.println("Successful" + msg);
        modelMap.addAttribute("msg", msg);

        emailUtil.sendEmail("hyzic23@gmail.com", "Location Saved",
                "Location saved successfully");

        return "createLocation";
    }

    @GetMapping("/displayLocations")
    public String displayLocations(ModelMap modelMap){
        List<Location> locations = service.getAllLocations();
        modelMap.addAttribute("locations", locations);
        System.out.println("Locations Count" + locations.size());
        return "displayLocations";
    }

    @RequestMapping("/deleteLocation")
    public String deleteLocation(@RequestParam("id") int id, ModelMap modelMap){
        System.out.println("Id to delete is " + id);
        Location location = service.getLocationById(id);
        service.deleteLocation(location);
        System.out.println("i am here");
        List<Location> locations = service.getAllLocations();
        System.out.println("i am here size " + locations.size());
        modelMap.addAttribute("locations", locations);
        return "displayLocations";
    }

    @GetMapping("/showUpdate")
    public String showUpdate(@RequestParam("id") int id, ModelMap modelMap){
        Location location = service.getLocationById(id);
        modelMap.addAttribute("location", location);
        return "updateLocation";
    }


    @RequestMapping("/updateLoc")
    public String updateLocation(@ModelAttribute("location") Location location,
                                 ModelMap modelMap){
        service.updateLocation(location);
        List<Location> locations = service.getAllLocations();
        modelMap.addAttribute("locations", locations);
        return "displayLocations";
    }

    @RequestMapping("/generateReport")
    public String generateReport(){
        String path = servletContext.getRealPath("/");
        System.out.println("Path is " + path);
        List<Object[]> data = locationRepository.findTypeAndTypeCount();
        reportUtil.generatePieChart(path, data);
        return "report";
    }




}
