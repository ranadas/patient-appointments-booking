package com.arzamed.patient.appointments.booking.entity;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Data
@Entity
@Table(name = "appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Doctor doctor;

    @ManyToOne
    private Patient patient;

    private LocalDateTime dateTime;

}

