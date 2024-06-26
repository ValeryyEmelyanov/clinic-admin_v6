package com.springlesson.clinicadmin.service;


import com.springlesson.clinicadmin.dto.SpecializationDto;
import com.springlesson.clinicadmin.entity.Doctor;
import com.springlesson.clinicadmin.entity.Specialization;
import com.springlesson.clinicadmin.repository.DoctorRepository;
import com.springlesson.clinicadmin.repository.SpecializationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    private DoctorRepository doctorRepository;
    private final SpecializationRepository specializationRepository;

    public DoctorService(DoctorRepository doctorRepository, SpecializationRepository specializationRepository) {
        this.doctorRepository = doctorRepository;
        this.specializationRepository = specializationRepository;
    }


    public List<Doctor> getDoctors(){
        Doctor doctor01 = new Doctor();
        doctor01.setId(1);
        doctor01.setActive(true);
        doctor01.setFirstName("Кирилл");
        doctor01.setLastName("Потапов");
        doctor01.setExperience(15);

        Doctor doctor02 = new Doctor();
        doctor02.setId(2);
        doctor02.setActive(true);
        doctor02.setFirstName("Ольга");
        doctor02.setLastName("Иванова");
        doctor02.setExperience(22);
        List<Doctor> doctors = doctorRepository.findAll();
        if (doctors.isEmpty()) {
            doctors.add(doctor01);
            doctors.add(doctor02);
        }
        return doctors;
    }
}