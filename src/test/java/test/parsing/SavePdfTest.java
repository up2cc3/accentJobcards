package test.parsing;

import com.accent.AbrePdf;
import com.accent.ComponerImagen;
import com.accent.ComponerPdf;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by ccc on 24/04/2017.
 */
public class SavePdfTest {
    @Test
    public void SavePdf() throws IOException {
        ComponerPdf newPdf = new ComponerPdf();
        String fs= "C:\\Users\\ccc\\Documents\\accent-depts\\PDF Departments\\pdf.pdf";
        newPdf.save(fs);
        File f = new File(fs);
        assertEquals("Should be 1 document", true, f.exists());

    }
    @Test
    public void PagesPdf() throws IOException {
        ComponerPdf newPdf = new ComponerPdf();
        File f = new File("C:\\Users\\ccc\\Documents\\accent-depts\\PDF Departments\\pdf.pdf");
        PDDocument pdf = PDDocument.load(f);
        assertEquals("Should be 1 document", 4, pdf.getNumberOfPages());

    }

}
