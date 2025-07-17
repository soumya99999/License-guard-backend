package com.sasken.LicenseGuard.services;

import com.sasken.LicenseGuard.models.Assignment;
import com.sasken.LicenseGuard.models.License;
import com.sasken.LicenseGuard.repository.AssignmentRepository;
import com.sasken.LicenseGuard.repository.LicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Autowired
    private LicenseRepository licenseRepository;

    public Assignment assignLicense(Long licenseId, String assignee, Integer userCount, String status) throws Exception {
        License license = licenseRepository.findById(licenseId)
                .orElseThrow(() -> new Exception("License not found"));

        int assignedUsers = assignmentRepository.totalAssignedUsers(licenseId);
        int maxUsers = license.getMaxUsers();

        if (assignedUsers + userCount > maxUsers) {
            throw new Exception("Cannot assign: exceeds max user limit for this license");
        }

        Assignment assignment = new Assignment();
        assignment.setLicense(license);
        assignment.setAssignee(assignee);
        assignment.setUserCount(userCount);
        assignment.setAssignmentDate(LocalDate.now());
        assignment.setStatus(status);


        return assignmentRepository.save(assignment);
    }
}