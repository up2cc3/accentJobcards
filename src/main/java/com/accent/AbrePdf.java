package com.accent;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ccc on 24/04/2017.
 */
public class AbrePdf {

    public List<String> extractLines(PDDocument doc) throws IOException {
        PDFTextStripper s = new PDFTextStripper();
        String text = s.getText(doc);
        text = text.replaceAll("\\r", "");
        String[] lines = text.split("\\n");
        return Arrays.asList(lines);

    }

    public List<String> extractRegiones(PDDocument doc) throws IOException {

        PDFTextStripperByArea s = new PDFTextStripperByArea();
        for (int i = 0; i < doc.getNumberOfPages(); i++) {
            s.extractRegions(doc.getPage(i));
        }
        List<String> regiones = s.getRegions();
        List<String> lines= new ArrayList<>();
        for (String t : regiones) {
            String texto = s.getTextForRegion(t);
            lines.add(texto);
            System.out.println(texto);
        }
        return lines;
    }

}
