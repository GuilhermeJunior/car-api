package dev.uniamerica.car_api.model.dtos;

import dev.uniamerica.car_api.model.entities.CarEntity;
import jakarta.validation.constraints.NotBlank;

public record Carro(Long id, @NotBlank String nome, @NotBlank String marca) {

    public CarEntity toEntity() {
        CarEntity carEntity = new CarEntity();
        carEntity.setName(this.nome);
        carEntity.setBrand(this.marca);
        return carEntity;
    }
}
