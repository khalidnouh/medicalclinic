package com.stc.caa.repository;

import com.stc.caa.model.Appointment;
import com.stc.caa.model.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment,Long> {

    List<Appointment> findAllByPatientName(String patientName);

    List<Appointment> findAllByPatientNameAndStatusNot(String patientName,Status status);

    List<Appointment> findAllByAppointmentDateAndStatus(Instant date, Status status);

    List<Appointment> findAllByAppointmentDateAndStatusNot(Instant date, Status status);

    List<Appointment> findAllByAppointmentDate(Instant date);

}
