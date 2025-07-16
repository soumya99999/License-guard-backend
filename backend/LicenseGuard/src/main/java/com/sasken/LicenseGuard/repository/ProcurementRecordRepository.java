package com.sasken.LicenseGuard.repository;

import com.sasken.LicenseGuard.models.ProcurementRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProcurementRecordRepository extends JpaRepository<ProcurementRecord, Long> {
    Optional<ProcurementRecord> findByInvoiceNumber(String invoiceNumber);
}
