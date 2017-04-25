package test.parsing;

import com.accent.ComponerImagen;
import com.accent.ComponerPdf;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by ccc on 24/04/2017.
 */
public class ImagenPdfTest {
    @Test
    public void SavePdf() throws IOException {
        ComponerImagen newPdf = new ComponerImagen();
        String fs= "C:\\Users\\ccc\\Documents\\accent-depts\\PDF Departments\\pdf.pdf";
        newPdf.save(fs);
        File f = new File(fs);
        assertEquals("Should be 1 document", true, f.exists());

    }

}
