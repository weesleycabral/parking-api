package com.wesley.parkingapi.repository;

import com.wesley.parkingapi.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
  //  long countByCheck_outIsNull();
}
