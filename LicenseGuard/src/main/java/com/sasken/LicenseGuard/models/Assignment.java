package com.sasken.LicenseGuard.models;


import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "assignments")
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long assignmentId;

    @ManyToOne
    @JoinColumn(name = "license_id")
    private License license;

    private String assignee;

    private Integer userCount;

    private LocalDate assignmentDate;

    private String status;

    private String email;

    // Constructors
    public Assignment() {}

    public Assignment(Long assignmentId, License license, String assignee, Integer userCount,
                      LocalDate assignmentDate, String status, String email) {
        this.assignmentId = assignmentId;
        this.license = license;
        this.assignee = assignee;
        this.userCount = userCount;
        this.assignmentDate = assignmentDate;
        this.status = status;
        this.email = email;
    }

    // Getters and Setters
    public Long getAssignmentId() { return assignmentId; }
    public void setAssignmentId(Long assignmentId) { this.assignmentId = assignmentId; }

    public License getLicense() { return license; }
    public void setLicense(License license) { this.license = license; }

    public String getAssignee() { return assignee; }
    public void setAssignee(String assignee) { this.assignee = assignee; }

    public Integer getUserCount() { return userCount; }
    public void setUserCount(Integer userCount) { this.userCount = userCount; }

    public LocalDate getAssignmentDate() { return assignmentDate; }
    public void setAssignmentDate(LocalDate assignmentDate) { this.assignmentDate = assignmentDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}

