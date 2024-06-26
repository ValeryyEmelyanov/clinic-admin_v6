package com.springlesson.clinicadmin.service;

import com.springlesson.clinicadmin.dto.DoctorDto;
import com.springlesson.clinicadmin.dto.SpecializationDto;
import com.springlesson.clinicadmin.entity.Doctor;
import com.springlesson.clinicadmin.entity.Specialization;
import com.springlesson.clinicadmin.repository.DoctorRepository;
import com.springlesson.clinicadmin.repository.SpecializationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpecializationService {
    private final SpecializationRepository specializationRepository;
    private final DoctorRepository doctorRepository;
    private final DoctorService doctorService;

    public SpecializationService(SpecializationRepository specializationRepository,
                                 DoctorRepository doctorRepository, DoctorService doctorService) {
        this.specializationRepository = specializationRepository;
        this.doctorRepository = doctorRepository;
        this.doctorService = doctorService;
    }

    public int addSpecialization(Specialization specialization){
        return specializationRepository.save(specialization).getId();
    }

    public List<SpecializationDto> getAllInactiveSpecializations() {
        List<Specialization> specializations = specializationRepository.findByIsActiveFalse();
        List<SpecializationDto> specializationDtos = new ArrayList<>();

        for (Specialization specialization : specializations) {
            List<Doctor> doctors = doctorRepository.findBySpecializations(specialization);
            List<DoctorDto> doctorDtos = new ArrayList<>();

            for (Doctor doctor : doctors) {
                doctorDtos.add(new DoctorDto(doctor));
            }

            SpecializationDto specializationDto = new SpecializationDto(specialization, doctorDtos);
            specializationDtos.add(specializationDto);
        }

        return specializationDtos;
    }

    public List<Specialization> getAllSpecializations() {
        List<Specialization> specializations = specializationRepository.findAll();
        return specializations;
    }
}