package com.techshard.graphql.dao.repository;

import com.techshard.graphql.dao.entity.Vehicle;
import com.techshard.graphql.dao.entity.Status;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
	
	List<Vehicle> findByBrandName (String brandName);
	

	List<Vehicle> findByStatus(Status status);
	

}
