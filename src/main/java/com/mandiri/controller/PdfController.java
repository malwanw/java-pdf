package com.mandiri.controller;

import com.mandiri.service.PdfGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PdfController {
    @Autowired
    PdfGeneratorService pdfGeneratorService;

    @GetMapping("/create-pdf")
    public void createPdf(){
        pdfGeneratorService.createPdf();
    }
    @PostMapping("/write-pdf")
    public void writePdf(){
        pdfGeneratorService.writePdf();
    }
}
