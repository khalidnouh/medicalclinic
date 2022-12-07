package com.stc.caa.controller;

import com.stc.caa.model.Appointment;
import com.stc.caa.model.enums.Filter;
import com.stc.caa.service.AppointmentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;
    @ApiOperation(value = "Responsible for getting all appointments . ")
    @RequestMapping(method = RequestMethod.GET, value = "/appointment", produces = MediaType.APPLICATION_JSON_VALUE)
    Mono<List<Appointment>> getAll() {
        return appointmentService.findAll();
    }

    @ApiOperation(value = "Responsible for getting  appointments by patient name. ")
    @RequestMapping(method = RequestMethod.GET, value = "/appointment/{patientName}", produces = MediaType.APPLICATION_JSON_VALUE)
    Mono<List<Appointment>> getAllByPatient(@PathVariable("patientName") String patientName) {
        return appointmentService.findAllByPatientName(patientName);
    }


    @ApiOperation(value = "Responsible for getting  patient appointments history by patient name (all appointments with status done or canceled ). ")
    @RequestMapping(method = RequestMethod.GET, value = "/appointmentsHistory /{patientName}", produces = MediaType.APPLICATION_JSON_VALUE)
    Mono<List<Appointment>> getAppointmentHistoryByPatient(@PathVariable("patientName") String patientName) {
        return appointmentService.getAppointmentHistoryByPatient(patientName);
    }

    @ApiOperation(value = "Responsible for adding an appointment . ")
    @RequestMapping(method = RequestMethod.POST, value = "/appointment", produces = MediaType.APPLICATION_JSON_VALUE)
    Mono<Appointment> addAppointment(@RequestBody Appointment appointment) {
        return appointmentService.addAppointment(appointment);
    }


    @ApiOperation(value = "Responsible for canceling an appointment . ")
    @RequestMapping(method = RequestMethod.PUT, value = "/cancel", produces = MediaType.APPLICATION_JSON_VALUE)
    Mono<Appointment> updateAppointment(@RequestParam("appointmentNumber")Long appointmentNumber,
                                        @RequestParam("reason")String reason) {
        return appointmentService.cancelAppointment(appointmentNumber,reason);
    }

    @ApiOperation(value = "Responsible for filtering appointments by date and type to indicate future or history " +
            "(history means appointment status done, future otherwise). ")
    @RequestMapping(method = RequestMethod.GET, value = "/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    Mono<List<Appointment>> filter(@RequestParam("date") Instant date, @RequestParam("type") Filter type) {
        return appointmentService.filterByDate(date,type);
    }
}
