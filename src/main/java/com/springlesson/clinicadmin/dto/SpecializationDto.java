package com.springlesson.clinicadmin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.springlesson.clinicadmin.entity.Doctor;
import com.springlesson.clinicadmin.entity.Specialization;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data

public class SpecializationDto {

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("code")
    private String code;

    @JsonProperty("description")
    private String description;

    @JsonProperty("is_active")
    private boolean isActive;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    @JsonProperty("doctors")
    private List<DoctorDto> doctors;

    @JsonProperty("number_of_active_doctors")
    private int activeDoctorsCount;

    @JsonProperty("number_of_inactive_doctors")
    private int inactiveDoctorsCount;

    public SpecializationDto(Specialization specialization, List<DoctorDto> doctors) {
        this.id = specialization.getId();
        this.name = specialization.getName();
        this.code = specialization.getCode();
        this.description = specialization.getDescription();
        this.isActive = specialization.isActive();
        this.createdAt = specialization.getCreatedAt();
        this.doctors = doctors;
        this.activeDoctorsCount = (int) doctors.stream().filter(DoctorDto::isActive).count();
        this.inactiveDoctorsCount = (int) doctors.stream().filter(DoctorDto::isNotActive).count();
    }
}
