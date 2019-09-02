package com.arzamed.patient.appointments.booking.entity;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum PatientGender {

    MALE("male"), FEMALE("female"), GENDER_NEUTRAL("gender-neutral");

    private String personSex;

    PatientGender(String type) {
        personSex = type;
    }

    public static PatientGender fromValue(String value) {
        for (PatientGender category : PatientGender.values()) {
            if (category.personSex.equalsIgnoreCase(value)) {
                return category;
            }
        }
        throw new IllegalArgumentException("Unknown enum type " + value + ", Allowed values are " + Arrays.toString(values()));
    }
}
