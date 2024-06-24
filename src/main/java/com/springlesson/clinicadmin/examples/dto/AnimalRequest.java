package com.springlesson.clinicadmin.examples.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.springlesson.clinicadmin.examples.entity.Animal;


@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record AnimalRequest(Animal animal, int shelterId){
}
