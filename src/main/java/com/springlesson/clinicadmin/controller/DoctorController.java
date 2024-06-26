package com.springlesson.clinicadmin.controller;

import com.springlesson.clinicadmin.entity.Doctor;
import com.springlesson.clinicadmin.entity.Specialization;
import com.springlesson.clinicadmin.service.DoctorService;
import com.springlesson.clinicadmin.service.SpecializationService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class DoctorController {

    private final SpecializationService specializationService;
    private final DoctorService doctorService;

    public DoctorController(SpecializationService specializationService, DoctorService doctorService) {
        this.specializationService = specializationService;
        this.doctorService = doctorService;
    }

    @GetMapping
    public String getDoctor(Model model){
        List<Doctor> doctors = doctorService.getDoctors();
        List<Specialization> specializations = specializationService.getAllSpecializations();
        model.addAttribute("doctor_list, doctors");
        model.addAttribute("specialization_list, specialization");
        return "doctor";
    }


    @GetMapping("/{id}")
    public String getDoctorById(@PathVariable int id){
        return "doctor";
    }

    @GetMapping("/doctor/specialization/{code}")
    public String getDoctorBySpecialization(@PathVariable String code){
        return "doctorSpecialization";
    }


}
