package com.techshard.graphql.service;

import com.techshard.graphql.dao.entity.Vehicle;
import com.techshard.graphql.dao.entity.Status;
import com.techshard.graphql.dao.repository.VehicleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository ;

    public VehicleService(final VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository ;
    }

    @Transactional
    public Vehicle createVehicle(final String type,final String modelCode, final String brandName, final String launchDate, final Status status) {
        final Vehicle vehicle = new Vehicle();
        vehicle.setType(type);
        vehicle.setModelCode(modelCode);
        vehicle.setBrandName(brandName);
        vehicle.setLaunchDate(LocalDate.parse(launchDate));
        vehicle.setStatus(status);
        return this.vehicleRepository.save(vehicle); 
    }

    @Transactional(readOnly = true)
    public List<Vehicle> getAllVehicles(final int count) {
    	System.out.println("Get All vehicles");

        return this.vehicleRepository.findAll().stream().limit(count).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<Vehicle> getVehicle(final int id) {
    	System.out.println("get Vehicle by Id");

        return this.vehicleRepository.findById(id);
    }
    
    @Transactional(readOnly = true)
    public List<Vehicle> getVehicleByname(final String brandName) {
    	System.out.println("in brnad Name query");
        return this.vehicleRepository.findByBrandName(brandName);
    }
    
    @Transactional(readOnly = true)
    public List<Vehicle> getVehicleByStatus(final Status status) {
    	System.out.println("in brnad Name query");
        return this.vehicleRepository.findByStatus(status);
    }
}
