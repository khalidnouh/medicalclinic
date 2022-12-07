package com.stc.caa.service;

import com.stc.caa.model.Appointment;
import com.stc.caa.model.enums.Filter;
import com.stc.caa.model.enums.Status;
import com.stc.caa.repository.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    AppointmentRepo appointmentRepo;

    public Mono<Appointment> addAppointment(Appointment appointment) {
        appointment.setStatus(Status.NEW);
        return Mono.just(appointmentRepo.save(appointment));
    }

    public Mono<Appointment> cancelAppointment(Long appointmentNo, String reason) {
        Appointment temp = appointmentRepo.findById(appointmentNo).get();
        temp.setStatus(Status.CANCELED);
        temp.setCancelReason(reason);
        return Mono.just(appointmentRepo.save(temp));

    }

    public Mono<List<Appointment>> findAll() {
        return Mono.just(appointmentRepo.findAll());
    }


    public Mono<List<Appointment>> getAppointmentHistoryByPatient(String name) {
        return Mono.just(appointmentRepo.findAllByPatientNameAndStatusNot(name,Status.NEW));
    }

    public Mono<List<Appointment>> findAllByPatientName(String name) {
        return Mono.just(appointmentRepo.findAllByPatientName(name));
    }


    public Mono<List<Appointment>> filterByDate(Instant date, Filter type) {
//        return Mono.just(appointmentRepo.findAllByAppointmentDate(date));
        if (type.equals(Filter.FUTURE))
            return Mono.just(appointmentRepo.findAllByAppointmentDateAndStatus(date, Status.NEW));
        else if (type.equals(Filter.HISTORY))
            return Mono.just(appointmentRepo.findAllByAppointmentDateAndStatusNot(date, Status.NEW));
        return Mono.empty();
    }

}
