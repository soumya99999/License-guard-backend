package com.sasken.LicenseGuard.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "procurement_records")
public class ProcurementRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate purchaseDate;

    private String vendor;

    private Integer maxUser;

    private String invoiceNumber;

    private Double cost;

    private String email;

    // Constructors
    public ProcurementRecord() {}

    public ProcurementRecord(Long id, LocalDate purchaseDate, String vendor, Integer maxUser,
                             String invoiceNumber, Double cost, String email) {
        this.id = id;
        this.purchaseDate = purchaseDate;
        this.vendor = vendor;
        this.maxUser = maxUser;
        this.invoiceNumber = invoiceNumber;
        this.cost = cost;
        this.email = email;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getPurchaseDate() { return purchaseDate; }
    public void setPurchaseDate(LocalDate purchaseDate) { this.purchaseDate = purchaseDate; }

    public String getVendor() { return vendor; }
    public void setVendor(String vendor) { this.vendor = vendor; }

    public Integer getMaxUser() { return maxUser; }
    public void setMaxUser(Integer maxUser) { this.maxUser = maxUser; }

    public String getInvoiceNumber() { return invoiceNumber; }
    public void setInvoiceNumber(String invoiceNumber) { this.invoiceNumber = invoiceNumber; }

    public Double getCost() { return cost; }
    public void setCost(Double cost) { this.cost = cost; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
