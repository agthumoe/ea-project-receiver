package edu.miu.cs544.moe.eaprojectreceiver.report;

import edu.miu.cs544.moe.eaprojectreceiver.report.embeddable.Doctor;
import edu.miu.cs544.moe.eaprojectreceiver.report.embeddable.Patient;
import edu.miu.cs544.moe.eaprojectreceiver.report.embeddable.Visit;
import jakarta.persistence.*;

@Entity
public class Report {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Visit visit;
    @Embedded
    private Doctor doctor;
    @Embedded
    private Patient patient;

    public Long getId() {
        return id;
    }

    public Visit getVisit() {
        return visit;
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
