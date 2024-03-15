package com.wesley.parkingapi.services;

import com.wesley.parkingapi.exceptions.CarNotFoundException;
import com.wesley.parkingapi.exceptions.ParkingFullException;
import com.wesley.parkingapi.models.Car;
import com.wesley.parkingapi.models.CarStatus;
import com.wesley.parkingapi.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class ParkingService {
    private final CarRepository carRepository;

    public ParkingService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars() {
        return carRepository.findByStatus(CarStatus.CHECKED_IN);
    }

    public Car getCarById(Long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new CarNotFoundException(id));
    }

    public Boolean isParkingFull() {
        return carRepository.count() >= 10;
    }

    public Car registerCar(Car car) {
        long count = carRepository.count();
        if (isParkingFull()) {
            throw new ParkingFullException();
        }
        car.setStatus(CarStatus.CHECKED_IN);
        car.setCheck_in(LocalDateTime.now());
        return carRepository.save(car);
    }

    public Car checkoutCar(Long id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new CarNotFoundException(id));
        car.setCheck_out(LocalDateTime.now());
        car.setStatus(CarStatus.CHECKED_OUT);
        return carRepository.save(car);
    }

    public Car deleteCar(Long id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new CarNotFoundException(id));
        carRepository.delete(car);
        return car;
    }

    public void deleteAllCars() {
        carRepository.deleteAll();
    }
}
