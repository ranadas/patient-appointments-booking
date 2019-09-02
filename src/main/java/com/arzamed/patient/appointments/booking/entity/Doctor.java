package com.arzamed.patient.appointments.booking.entity;

import lombok.*;
import javax.persistence.*;
import java.util.Set;

@Builder
@Data
@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String surname;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctor")
    private Set<Appointment> appointments;
}
