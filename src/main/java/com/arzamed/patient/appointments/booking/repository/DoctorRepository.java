package com.arzamed.patient.appointments.booking.repository;

import com.arzamed.patient.appointments.booking.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {}
