package com.stc.caa.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stc.caa.model.enums.Status;
import lombok.Data;
import lombok.NonNull;
import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Entity(name = "appointment")
@Data
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="appointment_number")
    private Long appointmentNumber;
    @Column(name="appointment_date")
    private Instant appointmentDate;
    @Column(name="appointment_type")
    private String appointmentType;
    @Column(name="appointment_desc")
    private String appointmentDesc;
    @Column(name="status")
    private Status status;
    @Column(name="cancel_reason")
    private String cancelReason;
    @Column(name = "patient_name")
    private String patientName;
    @Column(name = "patient_mobile")
    private String patientMobile;
//    @Column(name = "is_history")
//    private Boolean isHistory;
    public Appointment() {

    }
}