package com.accent;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ccc on 24/04/2017.
 */
public class AbrePdf {

    public List<String> extractLines(PDDocument doc) throws IOException {
        PDFTextStripper s = new PDFTextStripper();

        String text = s.getText(doc);
        text = text.replaceAll("\\r","");
        String[] lines = text.split("\\n");
        return Arrays.asList(lines);

    }
}
