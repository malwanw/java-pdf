package com.mandiri.controller;

import com.mandiri.dto.ValueDto;
import com.mandiri.service.PdfGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PdfController {
    @Autowired
    PdfGeneratorService pdfGeneratorService;

    @GetMapping("/create-pdf")
    public void createPdf(){
        pdfGeneratorService.createPdf();
    }
    @PostMapping("/new-pdf")
    public void writePdf(@RequestBody ValueDto valueDto){
        pdfGeneratorService.writePdf(valueDto);
    }
}
