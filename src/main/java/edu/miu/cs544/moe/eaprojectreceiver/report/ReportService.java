package edu.miu.cs544.moe.eaprojectreceiver.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class ReportService {
    private final ReportRepository reportRepository;

    @Autowired
    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public Page<Report> getAll(
            String doctorUuid,
            String doctorName,
            String doctorSpeciality,
            String patientUuid,
            String patientName,
            String patientAge,
            String visitUuid,
            String visitComplaint,
            String visitDiagnosis,
            Pageable pageable) {
        Specification<Report> spec = Specification.where(null);
        if (doctorUuid != null) {
            spec = spec.and(ReportSpecification.hasDoctorUuid(doctorUuid));
        }
        if (doctorName != null) {
            spec = spec.and(ReportSpecification.hasDoctorName(doctorName));
        }
        if (doctorSpeciality != null) {
            spec = spec.and(ReportSpecification.hasDoctorSpeciality(doctorSpeciality));
        }
        if (patientUuid != null) {
            spec = spec.and(ReportSpecification.hasPatientUuid(patientUuid));
        }
        if (patientName != null) {
            spec = spec.and(ReportSpecification.hasPatientName(patientName));
        }
        if (patientAge != null) {
            spec = spec.and(ReportSpecification.hasPatientAge(patientAge));
        }
        if (visitUuid != null) {
            spec = spec.and(ReportSpecification.hasVisitUuid(visitUuid));
        }
        if (visitComplaint != null) {
            spec = spec.and(ReportSpecification.hasVisitComplaint(visitComplaint));
        }
        if (visitDiagnosis != null) {
            spec = spec.and(ReportSpecification.hasVisitProvisionalDiagnosis(visitDiagnosis).or(ReportSpecification.hasVisitFinalDiagnosis(visitDiagnosis)));
        }
        return reportRepository.findAll(spec, pageable);
    }
}
