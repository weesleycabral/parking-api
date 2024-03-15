package com.wesley.parkingapi.exceptions;

public class CarNotFoundException extends RuntimeException {

        public CarNotFoundException(Long id) {
            super("Carro com id: " + id  + " não encontrado!");
        }

        public CarNotFoundException(String message, Long id) {
            super(message + id);
        }
}
