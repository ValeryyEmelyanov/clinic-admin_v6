package com.springlesson.clinicadmin.service;


import com.springlesson.clinicadmin.repository.DoctorRepository;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    private DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }
}