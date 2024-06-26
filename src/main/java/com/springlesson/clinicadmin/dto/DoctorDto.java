package com.springlesson.clinicadmin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.springlesson.clinicadmin.entity.Doctor;
import com.springlesson.clinicadmin.entity.Specialization;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DoctorDto {

    @JsonProperty("id")
    private int id;

    @JsonProperty("doctor_first_name")
    private String firstName;

    @JsonProperty("doctor_last_name")
    private String lastName;

    @JsonProperty("experience")
    private int experience;

    @JsonProperty("is_active")
    private boolean isActive;

    public DoctorDto(Doctor doctor) {
        this.id = doctor.getId();
        this.firstName = doctor.getFirstName();
        this.lastName = doctor.getLastName();
        this.experience = doctor.getExperience();
        this.isActive = doctor.isActive();
    }

    public boolean isNotActive() {
        return !this.isActive;
    }


}
