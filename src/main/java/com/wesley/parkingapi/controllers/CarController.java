package com.wesley.parkingapi.controllers;


import com.wesley.parkingapi.models.Car;
import com.wesley.parkingapi.repository.CarRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping
public class CarController {
    private final CarRepository carRepository;

    public CarController(CarRepository carRepository){
        this.carRepository = carRepository;
    }

    @GetMapping("/cars")
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @GetMapping("/cars/{id}")
    public Car getCarById(@RequestParam Long id) {
        return carRepository.findById(id).orElse(null);
    }

    @PostMapping("/cars/register")
    public Car registerCar(@RequestBody @Valid Car car) {
        long count = carRepository.count();
        if (count >= 10) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Estacionamento cheio");
        }
        car.setCheck_in(LocalDateTime.now());
        return carRepository.save(car);
    }

    @PutMapping("/cars/checkout/{id}")
    public Car checkoutCar(@PathVariable Long id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Carro não encontrado com id " + id));
        car.setCheck_out(LocalDateTime.now());
        return carRepository.save(car);
    }

    @DeleteMapping("/cars/delete/{id}")
    public Car deleteCar(@PathVariable Long id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Carro não encontrado com id " + id));
        carRepository.delete(car);
        return car;
    }
}
