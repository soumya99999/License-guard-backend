package com.sasken.LicenseGuard.models;


import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "licenses")
public class License {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long licenseId;

    private String type;

    private String vendor;

    private LocalDate validityStart;

    private LocalDate validityEnd;

    private LocalDate purchaseDate;

    private Integer maxUsers;

    private String invoiceNumber;

    // Constructors
    public License() {}

    public License(Long licenseId, String type, String vendor, LocalDate validityStart, LocalDate validityEnd,
                   LocalDate purchaseDate, Integer maxUsers, String invoiceNumber) {
        this.licenseId = licenseId;
        this.type = type;
        this.vendor = vendor;
        this.validityStart = validityStart;
        this.validityEnd = validityEnd;
        this.purchaseDate = purchaseDate;
        this.maxUsers = maxUsers;
        this.invoiceNumber = invoiceNumber;
    }

    // Getters and Setters
    public Long getLicenseId() { return licenseId; }
    public void setLicenseId(Long licenseId) { this.licenseId = licenseId; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getVendor() { return vendor; }
    public void setVendor(String vendor) { this.vendor = vendor; }

    public LocalDate getValidityStart() { return validityStart; }
    public void setValidityStart(LocalDate validityStart) { this.validityStart = validityStart; }

    public LocalDate getValidityEnd() { return validityEnd; }
    public void setValidityEnd(LocalDate validityEnd) { this.validityEnd = validityEnd; }

    public LocalDate getPurchaseDate() { return purchaseDate; }
    public void setPurchaseDate(LocalDate purchaseDate) { this.purchaseDate = purchaseDate; }

    public Integer getMaxUsers() { return maxUsers; }
    public void setMaxUsers(Integer maxUsers) { this.maxUsers = maxUsers; }

    public String getInvoiceNumber() { return invoiceNumber; }
    public void setInvoiceNumber(String invoiceNumber) { this.invoiceNumber = invoiceNumber; }
}