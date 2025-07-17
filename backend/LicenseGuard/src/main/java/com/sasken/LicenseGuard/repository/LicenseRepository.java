package com.sasken.LicenseGuard.repository;
import com.sasken.LicenseGuard.models.License;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicenseRepository extends JpaRepository<License, Long> {
    // Custom queries if needed, e.g., find by vendor, type, etc.
}
