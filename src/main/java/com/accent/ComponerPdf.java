package com.accent;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

import static java.awt.SystemColor.text;

/**
 * Created by ccc on 23/04/2017.
 */
public class ComponerPdf {

    public ComponerPdf() {
    }


    public void save(String fs) throws IOException {

        PDDocument documentoFinal = new PDDocument();
        AbrePdf jobcard = new AbrePdf();
        File file = new File("C:\\Users\\ccc\\Documents\\accentJobcards\\PDF Departments\\original.pdf");
        PDDocument pdforiginal = PDDocument.load(file);
        Iterable<String> s = jobcard.extractLines(pdforiginal);
        MegaParser p = new MegaParser();
        List<Order> result = p.parse(s);


        for (Order order : result) {

            for (int i = 0; i < 5; i++) {
                Dept dpt = order.getDepts().get(i);
                if (dpt.items.size() > 0) {
                    PDPage pag = new PDPage();
                    documentoFinal.addPage(pag);
                    PDPageContentStream contentStream = new PDPageContentStream(documentoFinal, pag);

                    //Setting the font to the Content stream
                    contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
                    contentStream.beginText();
                    contentStream.newLineAtOffset(25, 700);

                    for (String l : dpt.items) {

                        String text = l;
                        //Adding text in the form of string
                        System.out.println(l);

                        contentStream.newLineAtOffset(0, -15);
                        contentStream.showText(text);

                    }
                    contentStream.endText();
                    contentStream.close();
                }
            }
            documentoFinal.save("C:\\Users\\ccc\\Documents\\accentJobcards\\PDF Departments\\pdf.pdf");
            documentoFinal.close();

        }

    }


}