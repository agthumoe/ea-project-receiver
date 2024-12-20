package edu.miu.cs544.moe.eaprojectreceiver.report;

import org.springframework.data.jpa.domain.Specification;

public final class ReportSpecification {
    private ReportSpecification() {
    }

    public static Specification<Report> hasDoctorUuid(String doctorUuid) {
        return (root, query, cb) -> cb.like(cb.lower(root.get("doctor").get("uuid")), "%" + doctorUuid.toLowerCase() + "%");
    }

    public static Specification<Report> hasDoctorName(String doctorName) {
        return (root, query, cb) -> cb.like(cb.lower(root.get("doctor").get("name")), "%" + doctorName.toLowerCase() + "%");
    }

    public static Specification<Report> hasDoctorSpeciality(String doctorSpeciality) {
        return (root, query, cb) -> cb.like(cb.lower(root.get("doctor").get("speciality")), "%" + doctorSpeciality.toLowerCase() + "%");
    }

    public static Specification<Report> hasPatientUuid(String patientUuid) {
        return (root, query, cb) -> cb.like(cb.lower(root.get("patient").get("uuid")), "%" + patientUuid.toLowerCase() + "%");
    }

    public static Specification<Report> hasPatientName(String patientName) {
        return (root, query, cb) -> cb.like(cb.lower(root.get("patient").get("name")), "%" + patientName.toLowerCase() + "%");
    }

    public static Specification<Report> hasPatientAge(String patientAge) {
        return (root, query, cb) -> cb.like(cb.lower(root.get("patient").get("age")), "%" + patientAge.toLowerCase() + "%");
    }

    public static Specification<Report> hasVisitUuid(String visitUuid) {
        return (root, query, cb) -> cb.like(cb.lower(root.get("visit").get("uuid")), "%" + visitUuid.toLowerCase() + "%");
    }

    public static Specification<Report> hasVisitComplaint(String visitComplaint) {
        return (root, query, cb) -> cb.like(cb.lower(root.get("visit").get("complaint")), "%" + visitComplaint.toLowerCase() + "%");
    }

    public static Specification<Report> hasVisitProvisionalDiagnosis(String visitProvisionalDiagnosis) {
        return (root, query, cb) -> cb.like(cb.lower(root.get("visit").get("provisionalDiagnosis")), "%" + visitProvisionalDiagnosis.toLowerCase() + "%");
    }

    public static Specification<Report> hasVisitFinalDiagnosis(String visitFinalDiagnosis) {
        return (root, query, cb) -> cb.like(cb.lower(root.get("visit").get("finalDiagnosis")), "%" + visitFinalDiagnosis.toLowerCase() + "%");
    }
}
