package com.mandiri.controller;

import com.mandiri.dto.ValueDto;
import com.mandiri.service.PdfGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PdfController {
    @Autowired
    PdfGeneratorService pdfGeneratorService;

    @GetMapping("/simple-pdf")
    public void simplePdf(){
        pdfGeneratorService.simplePdf();
    }

    @GetMapping("/template-pdf")
    public void createPdf(){
        pdfGeneratorService.createPdf();
    }
    @PostMapping("/new-pdf")
    public void writePdf(@RequestBody ValueDto valueDto){
        pdfGeneratorService.writePdf(valueDto);
    }

    @GetMapping("/userbio-pdf")
    public void writePdfDb(@RequestParam Integer id){
        pdfGeneratorService.writePdfDb(id);
    }
}
