package com.sasken.LicenseGuard.controllers;

import com.sasken.LicenseGuard.models.License;
import com.sasken.LicenseGuard.repository.LicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/licenses")
public class LicenseController {

    @Autowired
    private LicenseRepository licenseRepository;

    @PostMapping
    public License createLicense(@RequestBody License license) {
        return licenseRepository.save(license);
    }

    @GetMapping
    public List<License> getAllLicenses() {
        return licenseRepository.findAll();
    }

    @GetMapping("/{id}")
    public License getLicenseById(@PathVariable Long id) {
        return licenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("License not found"));
    }
}

