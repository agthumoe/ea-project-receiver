package edu.miu.cs544.moe.eaprojectreceiver.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportController {
    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/reports")
    public Page<Report> getAllReports(
            @RequestParam(required = false) String doctorUuid,
            @RequestParam(required = false) String doctorName,
            @RequestParam(required = false) String doctorSpeciality,
            @RequestParam(required = false) String patientUuid,
            @RequestParam(required = false) String patientName,
            @RequestParam(required = false) String patientAge,
            @RequestParam(required = false) String visitUuid,
            @RequestParam(required = false) String visitComplaint,
            @RequestParam(required = false) String visitDiagnosis,
            Pageable pageable)  {
        return reportService.getAll(doctorUuid, doctorName, doctorSpeciality, patientUuid, patientName, patientAge, visitUuid, visitComplaint, visitDiagnosis, pageable);
    }
}
