package com.sasken.LicenseGuard.services;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;
@Service
public class CsvService {

    @Autowired
    private ReportService reportService;

    public void exportLicensesToCSV(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        LocalDate   now = LocalDate.now();
        response.setHeader("Content-Disposition", "attachment; filename=\"license_report"+now+".csv\"");

        List<String[]> licenses = reportService.generateCsvReport();
        PrintWriter writer = response.getWriter();

        // Header
        writer.println("Type,Vendor,MaxUser,Assignee_Summary,Assignee_Email,PurchaseDate,ActivationDate,Cost,Compliance,Invoice");

        // Rows
        for (String[] license : licenses) {
            String row = String.join(",", license);
            writer.println(row);
        }

        writer.flush();
        writer.close();
    }
}

