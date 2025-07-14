package com.sasken.LicenseGuard.controllers;

import com.sasken.LicenseGuard.models.ProcurementRecord;
import com.sasken.LicenseGuard.services.ProcurementRecordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/procurement-records")
public class ProcurementRecordController {

    private final ProcurementRecordService procurementRecordService;

    public ProcurementRecordController(ProcurementRecordService procurementRecordService) {
        this.procurementRecordService = procurementRecordService;
    }

    @PostMapping
    public ResponseEntity<ProcurementRecord> createProcurementRecord(@RequestBody ProcurementRecord procurementRecord) {
        ProcurementRecord createdRecord = procurementRecordService.createProcurementRecord(procurementRecord);
        return new ResponseEntity<>(createdRecord, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProcurementRecord>> getAllProcurementRecords() {
        List<ProcurementRecord> records = procurementRecordService.getAllProcurementRecords();
        return new ResponseEntity<>(records, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProcurementRecord> getProcurementRecordById(@PathVariable Long id) {
        ProcurementRecord record = procurementRecordService.getProcurementRecordById(id);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }
}
