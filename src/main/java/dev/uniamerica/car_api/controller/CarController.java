package dev.uniamerica.car_api.controller;

import dev.uniamerica.car_api.model.dtos.Carro;
import dev.uniamerica.car_api.service.CarService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
@CrossOrigin("*")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Carro> findById(@PathVariable Long id) {
        Carro car = this.carService.findById(id);
        return ResponseEntity.ok(car);
    }

    @GetMapping()
    public ResponseEntity<List<Carro>> findAll() {
        return ResponseEntity.ok(this.carService.findAll());
    }

    @PostMapping
    public ResponseEntity<Carro> save(@Valid @RequestBody Carro newCar) {
        Carro savedCar = this.carService.save(newCar);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedCar);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        this.carService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Carro> update(@PathVariable Long id,@Valid @RequestBody Carro updatedCar) {
        Carro savedCar = this.carService.update(id, updatedCar);
        return ResponseEntity.ok(savedCar);
    }
}
