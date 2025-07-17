package com.sasken.LicenseGuard.repository;

import com.sasken.LicenseGuard.models.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    // Sum of userCount for a license
    @Query("SELECT COALESCE(SUM(a.userCount), 0) FROM Assignment a WHERE a.license.licenseId = :licenseId")
    int totalAssignedUsers(Long licenseId);
}