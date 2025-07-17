package com.sasken.LicenseGuard.services;

import com.sasken.LicenseGuard.models.ProcurementRecord;
import com.sasken.LicenseGuard.repository.ProcurementRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcurementRecordService {

    private final ProcurementRecordRepository procurementRecordRepository;

    public ProcurementRecordService(ProcurementRecordRepository procurementRecordRepository) {
        this.procurementRecordRepository = procurementRecordRepository;
    }

    public ProcurementRecord createProcurementRecord(ProcurementRecord procurementRecord) {
        return procurementRecordRepository.save(procurementRecord);
    }

    public List<ProcurementRecord> getAllProcurementRecords() {
        return procurementRecordRepository.findAll();
    }

    public ProcurementRecord getProcurementRecordById(Long id) {
        return procurementRecordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Procurement record not found"));
    }
}
