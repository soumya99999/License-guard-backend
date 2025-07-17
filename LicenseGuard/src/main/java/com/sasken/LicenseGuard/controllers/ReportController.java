package com.sasken.LicenseGuard.controllers;

import com.sasken.LicenseGuard.services.CsvService;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("/api/reports")
public class ReportController {
    @Autowired
    private CsvService csvService;

    @GetMapping("/download/csv")
    public void exportToCSV(HttpServletResponse response) throws IOException {
        csvService.exportLicensesToCSV(response);
    }

}
