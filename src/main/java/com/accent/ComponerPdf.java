package com.accent;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

import static java.awt.SystemColor.text;

/**
 * Created by ccc on 23/04/2017.
 */
public class ComponerPdf {
    String shark = "C:\\Users\\ccc\\Documents\\accentJobcards\\imagenes\\shark.png";
String original="C:\\Users\\ccc\\Documents\\accentJobcards\\PDF Departments\\SalesOrd_38156_from_Accent_Group_NZ_Ltd.pdf";
    public ComponerPdf() {
    }


    public void save(String fs) throws IOException {

        PDDocument documentoFinal = new PDDocument();
        AbrePdf jobcard = new AbrePdf();
        File file = new File(original);
        PDDocument pdforiginal = PDDocument.load(file);
        Iterable<String> s = jobcard.extractLines(pdforiginal);
        MegaParser p = new MegaParser();
        List<Order> result = p.parse(s);



        for (Order order : result) {

            for (int i = 0; i < 5; i++) {
                int y=700;
                Dept dpt = order.getDepts().get(i);
                if (dpt.items.size() > 0) {
                    PDPage pag = new PDPage();
                    documentoFinal.addPage(pag);
                    PDPageContentStream contentStream = new PDPageContentStream(documentoFinal, pag);

                    //Setting the font to the Content stream
                    contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
                    contentStream.beginText();
                    contentStream.newLineAtOffset(25, y);

                    for (String l : dpt.items) {

                        String text = l;
                        //Adding text in the form of string
                        System.out.println(l);
                        contentStream.newLineAtOffset(0, -15);
                        y=y-15;
                        contentStream.showText(text);
                        if (l.contains("sharknose")) {
                            PDImageXObject pdImage = PDImageXObject.createFromFile(shark, documentoFinal);
                            PDPageContentStream imagenStream = new PDPageContentStream(documentoFinal, pag, PDPageContentStream.AppendMode.APPEND, true, true);
                            imagenStream.drawImage(pdImage, 530, y-31);
                            imagenStream.close();
                        }

                    }
                    contentStream.endText();
                    contentStream.close();

                }
            }
            documentoFinal.save("C:\\Users\\ccc\\Documents\\accentJobcards\\PDF Departments\\final.pdf");
            documentoFinal.close();

        }

    }

}