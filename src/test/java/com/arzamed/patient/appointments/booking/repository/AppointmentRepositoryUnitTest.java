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

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AppointmentRepositoryUnitTest {

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
        Patient john = Patient.builder()
                .name("John")
                .surname("Doe")
                .birthday(LocalDate.of(2015, Month.JULY, 29))
                .gender(PatientGender.MALE)
                .build();

        patientRepository.save(john);

        Doctor mary = Doctor.builder()
                .name("Mary")
                .surname("Ann")
                .build();
        doctorRepository.save(mary);

        Appointment todays_appointment = Appointment.builder()
                .doctor(mary)
                .patient(john)
                .build();
        appointmentRepository.save(todays_appointment);

        // when
        Collection found = appointmentRepository.findByDate(APPOINTMENT_TIME);

        // then
        assertEquals(1, found.size());
    }
}
