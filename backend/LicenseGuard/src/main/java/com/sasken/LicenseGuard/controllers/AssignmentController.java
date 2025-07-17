package com.sasken.LicenseGuard.controllers;

import com.sasken.LicenseGuard.models.Assignment;
import com.sasken.LicenseGuard.services.AssignmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    @PostMapping("/assign")
    public ResponseEntity<?> assignLicense(
            @RequestParam Long licenseId,
            @RequestParam String assignee,
            @RequestParam Integer userCount,
            @RequestParam String status) {
        try {
            Assignment assignment = assignmentService.assignLicense(licenseId, assignee, userCount, status);
            return ResponseEntity.ok(assignment);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}