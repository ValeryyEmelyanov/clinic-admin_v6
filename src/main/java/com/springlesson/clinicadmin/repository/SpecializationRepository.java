package com.springlesson.clinicadmin.repository;


import com.springlesson.clinicadmin.entity.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpecializationRepository extends JpaRepository<Specialization, Integer> {

    List<Specialization> findByIsActiveTrue ();
    List<Specialization> findByIsActiveFalse();


}