package com.arzamed.patient.appointments.booking.repository;

import com.arzamed.patient.appointments.booking.entity.Appointment;
import com.arzamed.patient.appointments.booking.entity.Doctor;
import com.arzamed.patient.appointments.booking.entity.Patient;
import com.arzamed.patient.appointments.booking.entity.PatientGender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AppointmentRepositoryTest {

    private final LocalDateTime APPOINTMENT_TIME = LocalDateTime.now() ;

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void whenFindByDate_thenReturnAppointment() {
        // given
        Patient patientJohn = Patient.builder()
                .name("John")
                .surname("Doe")
                .birthday(LocalDate.of(2015, Month.JULY, 29))
                .gender(PatientGender.MALE)
                .build();

        patientRepository.save(patientJohn);

        Doctor DrMary = Doctor.builder()
                .name("Mary")
                .surname("Ann")
                .build();
        doctorRepository.save(DrMary);

        Appointment appointmentForTheDay = Appointment.builder()
                .doctor(DrMary)
                .patient(patientJohn)
                .dateTime(APPOINTMENT_TIME)
                .build();
        appointmentRepository.save(appointmentForTheDay);

        // when
        Collection appointmentFound = appointmentRepository.findByDateTime(APPOINTMENT_TIME);
        //This is a diagnostic code : List<Appointment> all = appointmentRepository.findAll();

        // then
        assertEquals(1, appointmentFound.size());
    }
}
