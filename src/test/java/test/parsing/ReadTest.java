package test.parsing;

import com.accent.AbrePdf;
import com.accent.MegaParser;
import com.accent.Order;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.Test;
import com.accent.AbrePdf;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by ccc on 24/04/2017.
 */
public class ReadTest {


    @Test
    public void testOpenPdf() throws IOException {
        InputStream st = getClass().getResourceAsStream("/p2.pdf");
        PDDocument doc = PDDocument.load(st);
        AbrePdf t = new AbrePdf();
        List<String> lineas = t.extractLines(doc);
        assertEquals("Should be 10 job orders ", 10, lineas.size());


    }
}
