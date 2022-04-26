package com.mandiri.service;

import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.*;
import javafx.scene.control.Cell;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.layout.borders.Border;

@Service
public class PdfGeneratorService {
    public void createPdf(){
        try {
            //Create Document instance.
            Document document = new Document();

            //Create OutputStream instance.
            OutputStream outputStream = new FileOutputStream(new File("D:\\Document\\Academy\\MANDIRI-ODP-2\\pdf-file\\TestFile.pdf"));

            //Create PDFWriter instance.
            PdfWriter.getInstance(document, outputStream);

            //Open the document.
            document.open();

            //set page size
            document.setPageSize(PageSize.A4);
            document.setMargins(4, 3, 3, 3);

            //Add content to the document.
//            document.add(new Paragraph("Nama " +
//                    "this is a test pdf file."));

            PdfPTable table = new PdfPTable(3);
            table.setWidths(new int[]{ 1, 3, 3});
            table.addCell(new Cell().setBorder(Border.NO_BORDER).setFont(bold).add(new Paragraph("Name:")));
            table.addCell(new Cell().setBorder(Border.NO_BORDER).setFont(regular).add(new Paragraph(user1.getName())));
            PdfPCell cell;
            cell = new PdfPCell(new Phrase("S/N"));
            cell.setRowspan(2);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase("Name"));
            cell.setColspan(3);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase("Age"));
            cell.setRowspan(2);
            table.addCell(cell);
            table.addCell("SURNAME");
            table.addCell("FIRST NAME");
            table.addCell("MIDDLE NAME");
            table.addCell("1");
            table.addCell("James");
            table.addCell("Fish");
            table.addCell("Stone");
            table.addCell("17");
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

                pageContentByte.setTextMatrix(50, 740);

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
