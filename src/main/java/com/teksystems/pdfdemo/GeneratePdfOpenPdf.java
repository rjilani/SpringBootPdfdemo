package com.teksystems.pdfdemo;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.Document;

public class GeneratePdfOpenPdf {

    public static ByteArrayInputStream getOpenPdfReport() {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Document document = new Document();
        PdfWriter.getInstance(document, out);
        document.open();
        document.add(new Paragraph("Hello World"));
        document.close();
        return new ByteArrayInputStream(out.toByteArray());

    }
}
