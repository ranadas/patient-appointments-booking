package com.arzamed.patient.appointments.booking.repository;

import com.arzamed.patient.appointments.booking.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Collection;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    Collection<Appointment> findByDateTime(LocalDateTime appointmentDate);
}