package com.wesley.parkingapi.repository;

import com.wesley.parkingapi.models.Car;
import com.wesley.parkingapi.models.CarStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByStatus(CarStatus status);
}
