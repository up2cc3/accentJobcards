package com.accent;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by ccc on 23/04/2017.
 */
public class ComponerImagen {
    String shark = "C:\\Users\\ccc\\Documents\\accentJobcards\\imagenes\\shark.png";

    public ComponerImagen() {
    }


    public void save(String fs) throws IOException {

        PDDocument documentoFinal = new PDDocument();
        AbrePdf jobcard = new AbrePdf();
        File file = new File("C:\\Users\\ccc\\Documents\\accentJobcards\\PDF Departments\\original2.pdf");
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

                    for (String l : dpt.items) {

                        String text = l;
                        //Adding text in the form of string
                        System.out.println(l);


                        PDImageXObject pdImage = PDImageXObject.createFromFile(shark, documentoFinal);
                        contentStream.drawImage(pdImage, 0, 0);


                        contentStream.close();
                    }

                }
            }
            documentoFinal.save("C:\\Users\\ccc\\Documents\\accentJobcards\\PDF Departments\\imagenes.pdf");
            documentoFinal.close();

        }

    }


}