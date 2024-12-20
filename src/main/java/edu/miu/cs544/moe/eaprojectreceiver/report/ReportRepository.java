package edu.miu.cs544.moe.eaprojectreceiver.report;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long>, JpaSpecificationExecutor<Report> {
    Optional<Report> findByVisitUuidAndDoctorUuidAndPatientUuid(String visitUuid, String doctorUuid, String patientUuid);
}
