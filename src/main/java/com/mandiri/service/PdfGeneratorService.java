package com.mandiri.service;

import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.*;
import javafx.scene.control.Cell;
import javafx.scene.text.Text;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.UnitValue;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.layout.element.Table;
import javafx.scene.text.Font;
@Service
public class PdfGeneratorService {

    public void createPdf(){
        try {
            //Create Document instance.
            Document document = new Document();

            //Create OutputStream instance.
            OutputStream outputStream = new FileOutputStream(new File("D:\\Document\\Academy\\MANDIRI-ODP-2\\pdf-file\\TestFile.pdf"));

            //Create PDFWriter instance.
            PdfWriter pw = PdfWriter.getInstance(document, outputStream);

            //Open the document.
            document.open();

            //set page size
            document.setPageSize(PageSize.A4);
            document.setMargins(4, 3, 3, 3);
            //Add content to the document.
//            document.add(new Paragraph("Name: "));
//            document.add(new Paragraph("NIK: "));
//            document.add(new Paragraph("Address : "));
//            document.add(new Paragraph("Phone Number: "));
//            document.add(new Paragraph("Nama: "));
//
            PdfPTable table = new PdfPTable(2);
            table.setWidths(new int[]{2, 6});
            table.addCell("Name: ");
            table.addCell("");
            table.addCell("NIK:");
            table.addCell("");
            table.addCell("Address:");
            table.addCell("");
            table.addCell("Email:");
            table.addCell("");
            table.addCell("Phone Number:");
            table.addCell("");
            document.add(table);

            //Close document and outputStream.
            document.close();
            outputStream.close();

            System.out.println("Pdf created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void writePdf(){
        try {
            //Create PdfReader instance.
            PdfReader pdfReader =
                    new PdfReader("D:\\Document\\Academy\\MANDIRI-ODP-2\\pdf-file\\TestFile.pdf");

            //Create PdfStamper instance.
            PdfStamper pdfStamper = new PdfStamper(pdfReader,
                    new FileOutputStream("D:\\Document\\Academy\\MANDIRI-ODP-2\\pdf-file\\ModifiedTestFile.pdf"));

            //Create BaseFont instance.
            BaseFont baseFont = BaseFont.createFont(
                    BaseFont.TIMES_ROMAN,
                    BaseFont.CP1252, BaseFont.NOT_EMBEDDED);

            //Get the number of pages in pdf.
            int pages = pdfReader.getNumberOfPages();

            //Iterate the pdf through pages.
            for(int i=1; i<=pages; i++) {
                //Contain the pdf data.
                PdfContentByte pageContentByte =
                        pdfStamper.getOverContent(i);

                pageContentByte.beginText();
                //Set text font and size.
                pageContentByte.setFontAndSize(baseFont, 14);

                pageContentByte.setTextMatrix(10, 798);

                //Write text
                pageContentByte.showText("w3spoint.com");
                pageContentByte.endText();
            }

            //Close the pdfStamper.
            pdfStamper.close();

            System.out.println("PDF modified successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
