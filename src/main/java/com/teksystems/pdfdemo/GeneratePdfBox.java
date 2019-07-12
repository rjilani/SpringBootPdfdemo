package com.teksystems.pdfdemo;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class GeneratePdfBox {

    public static ByteArrayOutputStream getReport() throws IOException {

        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);
        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        PDFont font = PDType1Font.HELVETICA_BOLD;
        contentStream.beginText();
        contentStream.setFont( font, 12 );
        contentStream.newLineAtOffset(25, 500);
        String text = "This is the sample document and we are adding content to it.";
        contentStream.showText(text);
        contentStream.endText();
        contentStream.close();
//        document.save("Hello World.pdf");
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        document.save(bout);
        document.close();

        return bout;

    }
}
