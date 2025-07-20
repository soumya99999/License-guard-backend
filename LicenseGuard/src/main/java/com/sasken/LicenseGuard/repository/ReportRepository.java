package com.sasken.LicenseGuard.repository;

import com.sasken.LicenseGuard.models.License;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ReportRepository extends JpaRepository<License,Long> {}
