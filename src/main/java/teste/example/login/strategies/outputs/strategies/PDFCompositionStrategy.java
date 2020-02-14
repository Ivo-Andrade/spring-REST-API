package teste.example.login.strategies.outputs.strategies;

import java.io.File;
import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import teste.example.login.models.Component;
import teste.example.login.strategies.outputs.CompositionStrategy;
import teste.example.login.strategies.outputs.singletons.SingleComposition;

public class PDFCompositionStrategy 
    extends CompositionStrategy
{

    public void compose( Component node, String append ) {

        SingleComposition.getInstance().append(append);

    }

    public File print( String documentName ) {

        try {

            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream( documentName + ".pdf" ));
            
            document.open();
            Font font = FontFactory.getFont( FontFactory.COURIER, 16, BaseColor.BLACK );
            Paragraph paragraph = new Paragraph( SingleComposition.getInstance().getComposition(), font );
            
            document.add(paragraph);
            document.close();

            return new File(documentName + ".pdf");

        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException("Um erro ocorreu na impressão do PDF da árvore!\n"+e);
        } finally {
            SingleComposition.getInstance().resetComposition();
        }

    }

}