package com.sasken.LicenseGuard.dtos;

import java.time.LocalDate;

public class AssignmentDTO {
    private Long licenseId;
    private String assignee;
    private Integer userCount;
    private LocalDate assignmentDate;
    private String status;
    private String email;

    // Getters and Setters
    public Long getLicenseId() {
        return licenseId;
    }
    public void setLicenseId(Long licenseId) {
        this.licenseId = licenseId;
    }

    public String getAssignee() {
        return assignee;
    }
    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public Integer getUserCount() {
        return userCount;
    }
    public void setUserCount(Integer userCount) {
        this.userCount = userCount;
    }

    public LocalDate getAssignmentDate() {
        return assignmentDate;
    }
    public void setAssignmentDate(LocalDate assignmentDate) {
        this.assignmentDate = assignmentDate;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
