package com.springlesson.clinicadmin.repository;

import com.springlesson.clinicadmin.entity.Doctor;
import com.springlesson.clinicadmin.entity.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    List<Doctor> findBySpecializations (Specialization specialization);
    @Query(nativeQuery = true, value = "SELECT d.* FROM doctor d JOIN specialization s "
            + "on d.specialization_id = s.id" +
            "WHERE s.code = :code")
    List<Doctor> findAllBySpecializationsCode(String code);

}
