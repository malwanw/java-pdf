package com.mandiri.service;

import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.*;
import com.mandiri.dto.ValueDto;
import com.mandiri.entity.Parameter;
import javafx.scene.control.Cell;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.UnitValue;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.layout.element.Table;
import javafx.scene.text.Font;
@Service
public class PdfGeneratorService {
    @Autowired
    ParameterService parameterService;

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

            List<Parameter> parameterList = parameterService.getAll();
            BaseFont baseFont = BaseFont.createFont(
                    BaseFont.TIMES_ROMAN,
                    BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
            PdfContentByte cb = pw.getDirectContent();
            cb.beginText();
            //Set text font and size.
            for(Parameter parameter:parameterList){
                cb.setFontAndSize(baseFont, parameter.getSize());
                cb.setTextMatrix(parameter.getX(), parameter.getY());
                //Write text
                cb.showText(parameter.getParam()+":");
            }
            cb.endText();
//            PdfPTable table = new PdfPTable(2);
//            table.setWidths(new int[]{2, 6});
//            for(Parameter param:parameterList){
//                table.addCell(param.getParam());
//                table.addCell("");
//            }
//            document.add(table);

            //Close document and outputStream.
            document.close();
            outputStream.close();

            System.out.println("Pdf created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void writePdf(ValueDto valueDto){
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
                pageContentByte.setTextMatrix(200, 795);
                //Write text
                pageContentByte.showText(valueDto.getName());

                //Set text font and size.
                pageContentByte.setFontAndSize(baseFont, 14);
                pageContentByte.setTextMatrix(200, 779);
                //Write text
                pageContentByte.showText(valueDto.getNik());

                //Set text font and size.
                pageContentByte.setFontAndSize(baseFont, 14);
                pageContentByte.setTextMatrix(200, 763);
                //Write text
                pageContentByte.showText(valueDto.getAddress());

                //Set text font and size.
                pageContentByte.setFontAndSize(baseFont, 14);
                pageContentByte.setTextMatrix(200, 747);
                //Write text
                pageContentByte.showText(valueDto.getEmail());
                

                //Set text font and size.
                pageContentByte.setFontAndSize(baseFont, 14);
                pageContentByte.setTextMatrix(200, 731);
                //Write text
                pageContentByte.showText(valueDto.getPhone());
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
