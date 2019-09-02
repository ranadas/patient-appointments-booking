package com.arzamed.patient.appointments.booking.entity;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Builder
@Data
@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String surname;

    private LocalDate birthday;

    private PatientGender gender;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patient")
    private Set<Appointment> appointments;
}
