package com.sasken.LicenseGuard.services;

import com.sasken.LicenseGuard.models.Assignment;
import com.sasken.LicenseGuard.repository.AssignmentRepository;
import com.sasken.LicenseGuard.repository.ProcurementRecordRepository;
import com.sasken.LicenseGuard.repository.ReportRepository;
import com.sasken.LicenseGuard.models.License;
import com.sasken.LicenseGuard.models.ProcurementRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ReportService {
    private final ReportRepository reportRepository;
    private final ProcurementRecordRepository procurementRecordRepository;
    private final AssignmentRepository assignmentRepository;

    @Autowired
    public ReportService(ReportRepository reportRepository, ProcurementRecordRepository procurementRecordRepository, AssignmentRepository assignmentRepository) {
        this.reportRepository = reportRepository;
        this.procurementRecordRepository = procurementRecordRepository;
        this.assignmentRepository = assignmentRepository;
    }
    public List<String[]> generateCsvReport() {
        List<License> licenses = reportRepository.findAll();
        List<ProcurementRecord> procurementRecords = procurementRecordRepository.findAll();
        List<Assignment> assignments = assignmentRepository.findAll();
        List<String[]> reportData = new ArrayList<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        for (License lic : licenses) {
            //access procurement record by invoice number
            ProcurementRecord record = procurementRecordRepository
                    .findByInvoiceNumber(lic.getInvoiceNumber())
                    .orElse(null);
            List<Assignment> assignmentRecords = (record.getEmail()!= null) ? assignmentRepository.findByEmail(record.getEmail()) : new ArrayList<>();
            StringBuilder assigneeBuilder = new StringBuilder();

            for (Assignment assignment : assignmentRecords) {
                assigneeBuilder.append(assignment.getAssignee())
                        .append(" (").append(assignment.getUserCount()).append(" users), ");
            }

            String assigneeSummary = assignmentRecords.isEmpty() ? "No Assignee" :
                    assigneeBuilder.substring(0, assigneeBuilder.length() - 2);
            String cost = String.valueOf(record.getCost());
            String compliance = lic.getValidityEnd().isAfter(LocalDate.now()) ? "compliant" : "expired";
                        String[] row = {
                    lic.getType(),
                    lic.getVendor(),
                    lic.getMaxUsers() + " users",
                        assigneeSummary,
                                record.getEmail(),
                    lic.getPurchaseDate().format(formatter),
                    lic.getValidityStart().format(formatter),
                    cost,
                    compliance,
                    lic.getInvoiceNumber()
            };
            reportData.add(row);
        }
        return reportData;
    }
}

