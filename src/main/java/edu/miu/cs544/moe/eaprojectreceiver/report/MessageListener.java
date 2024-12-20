package edu.miu.cs544.moe.eaprojectreceiver.report;

import edu.miu.cs544.moe.eaprojectreceiver.report.embeddable.Doctor;
import edu.miu.cs544.moe.eaprojectreceiver.report.embeddable.Patient;
import edu.miu.cs544.moe.eaprojectreceiver.report.embeddable.Visit;
import jakarta.jms.JMSException;
import jakarta.jms.MapMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageListener.class);
    @Value("${app.messaging.queue}")
    private String destination;

    private final ReportRepository reportRepository;

    @Autowired
    public MessageListener(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @JmsListener(destination = "${app.messaging.queue}")
    public void receiveMessage(MapMessage message) throws JMSException {
        LOGGER.info("Received message: {}", message);
        Doctor doctor = new Doctor();
        doctor.setUuid(message.getString("doctor.uuid"));
        doctor.setName(message.getString("doctor.name"));
        doctor.setSpeciality(message.getString("doctor.speciality"));

        Patient patient = new Patient();
        patient.setUuid(message.getString("patient.uuid"));
        patient.setName(message.getString("patient.name"));
        patient.setAge(message.getString("patient.age"));

        Visit visit = new Visit();
        visit.setUuid(message.getString("visit.uuid"));
        visit.setDate(message.getString("visit.date"));
        visit.setComplaint(message.getString("visit.complaint"));
        visit.setProvisionalDiagnosis(message.getString("visit.provisionalDiagnosis"));
        visit.setFinalDiagnosis(message.getString("visit.finalDiagnosis"));

        Report report = new Report();
        report.setDoctor(doctor);
        report.setPatient(patient);
        report.setVisit(visit);

        this.reportRepository.save(report);
    }
}
