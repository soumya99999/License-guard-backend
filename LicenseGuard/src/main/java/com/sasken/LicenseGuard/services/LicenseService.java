package com.sasken.LicenseGuard.services;


import com.sasken.LicenseGuard.models.License;
import com.sasken.LicenseGuard.models.ProcurementRecord;
import com.sasken.LicenseGuard.repository.LicenseRepository;
import com.sasken.LicenseGuard.repository.ProcurementRecordRepository;
import org.springframework.stereotype.Service;

import java.time.Period;
import java.util.List;

@Service
public class LicenseService {

    private final LicenseRepository licenseRepo;
    private final ProcurementRecordRepository procurementRecordRepo;

    public LicenseService(LicenseRepository licenseRepo, ProcurementRecordRepository procurementRecordRepo) {
        this.licenseRepo = licenseRepo;
        this.procurementRecordRepo = procurementRecordRepo;
    }

    public License createLicense(License license) {
        // Validation: validityStart < validityEnd
        if (license.getValidityStart() == null || license.getValidityEnd() == null) {
            throw new IllegalArgumentException("Validity start and end dates must not be null");
        }
        if (!license.getValidityStart().isBefore(license.getValidityEnd())) {
            throw new IllegalArgumentException("Validity start date must be before validity end date");
        }

        // Validation: duration minimum 1 year
        Period duration = Period.between(license.getValidityStart(), license.getValidityEnd());
        if (duration.getYears() < 1) {
            throw new IllegalArgumentException("License duration must be at least 1 year");
        }

        // Validation: invoice number must exist in procurement records
        String invoiceNumber = license.getInvoiceNumber();
        if (invoiceNumber == null || invoiceNumber.isEmpty()) {
            throw new IllegalArgumentException("Invoice number must not be null or empty");
        }
        ProcurementRecord procurementRecord = procurementRecordRepo.findByInvoiceNumber(invoiceNumber)
                .orElseThrow(() -> new IllegalArgumentException("Invoice number not found in procurement records"));

        // Validation: maxUsers <= maxUser in procurement record
        Integer licenseMaxUsers = license.getMaxUsers();
        Integer procurementMaxUsers = procurementRecord.getMaxUser();
        if (licenseMaxUsers == null) {
            throw new IllegalArgumentException("Max users must not be null");
        }
        if (procurementMaxUsers == null) {
            throw new IllegalArgumentException("Procurement record max user is null");
        }
        if (licenseMaxUsers > procurementMaxUsers) {
            throw new IllegalArgumentException("License max users must be less than or equal to procurement record max users");
        }

        return licenseRepo.save(license);
    }

    public List<License> getAllLicenses() {
        return licenseRepo.findAll();
    }

    public License getLicenseById(Long id) {
        return licenseRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("License not found"));
    }
}
