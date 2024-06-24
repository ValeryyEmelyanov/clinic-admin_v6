package com.springlesson.clinicadmin.controller;

import com.springlesson.clinicadmin.dto.SpecializationDto;
import com.springlesson.clinicadmin.entity.Specialization;
import com.springlesson.clinicadmin.repository.DoctorRepository;
import com.springlesson.clinicadmin.service.SpecializationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
// @RequestMapping("/specialization")
public class SpecializationController {
    private final SpecializationService specializationService;
    private DoctorRepository doctorRepository;

    public SpecializationController(SpecializationService specializationService) {
        this.specializationService = specializationService;
    }

    @PostMapping("/specialization")
    public ResponseEntity<?> addSpecialization(@RequestBody /*@Valid*/ Specialization specialization){
        return ResponseEntity
                .created(URI.create("http://localhost:8080/specialization/" +
                        specializationService.addSpecialization(specialization)))
                .build();
    }

    @GetMapping("/inactive")
    public List<SpecializationDto> getInactiveSpecializations() {
        return specializationService.getAllInactiveSpecializations();
    }
    }