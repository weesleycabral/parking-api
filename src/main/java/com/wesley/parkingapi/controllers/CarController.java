package com.wesley.parkingapi.controllers;


import com.wesley.parkingapi.models.Car;
import com.wesley.parkingapi.services.ParkingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private ParkingService parkingService;


    @GetMapping
    public List<Car> getAllCars() {
        return parkingService.getAllCars();
    }

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable Long id) {
        return parkingService.getCarById(id);
    }

    @PostMapping("/register")
    public Car registerCar(@RequestBody @Valid Car car) {
        return parkingService.registerCar(car);
    }

    @PutMapping("/checkout/{id}")
    public Car checkoutCar(@PathVariable Long id) {
        return parkingService.checkoutCar(id);
    }

    @DeleteMapping("/delete/{id}")
    public Car deleteCar(@PathVariable Long id) {
        return parkingService.deleteCar(id);
    }

    @DeleteMapping("/delete")
    public void deleteAllCars() {
        parkingService.deleteAllCars();
    }
}
