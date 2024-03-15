package com.wesley.parkingapi.exceptions;

public class ParkingFullException extends RuntimeException {

    public ParkingFullException() {
        super("Estacionamento está lotado!");
    }

    public ParkingFullException(String message) {
        super(message);
    }
}
