package dev.uniamerica.car_api.service;

import dev.uniamerica.car_api.exception.NotFoundException;
import dev.uniamerica.car_api.model.dtos.Carro;
import dev.uniamerica.car_api.repository.CarRepository;
import dev.uniamerica.car_api.model.entities.CarEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Carro findById(Long id) {
        return this.carRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("id=" + id +  " nao encontrado"))
                .toDto();
    }

    public List<Carro> findAll() {
        return this.carRepository.findAll()
                .stream()
                .map(CarEntity::toDto)
                .toList();
    }

    public Carro save(Carro newCar) {
        CarEntity carEntity = newCar.toEntity();
        CarEntity savedCar = this.carRepository.save(carEntity);
        return savedCar.toDto();
    }

    public void deleteById(Long id) {
        this.carRepository.deleteById(id);
    }

    public Carro update(Long id, Carro updatedCar) {
        CarEntity carEntity = this.carRepository.findById(id).
                orElseThrow(() -> new NotFoundException("id=" + id +  " nao encontrado"));

        carEntity.setName(updatedCar.nome());
        carEntity.setBrand(updatedCar.marca());

        CarEntity savedCar = this.carRepository.save(carEntity);
        return savedCar.toDto();
    }
}
