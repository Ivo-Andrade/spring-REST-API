package teste.example.login.strategies.outputs.strategies;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import teste.example.login.models.Component;
import teste.example.login.strategies.outputs.CompositionStrategy;
import teste.example.login.strategies.outputs.singletons.SingleComposition;

public class TextCompositionStrategy 
    extends CompositionStrategy 
{

    public void compose( Component node, String append ) {

        if(append == null || append == "")
            throw new IllegalArgumentException("Apêndice de texto vazio!");
        
        SingleComposition.getInstance().append(append);

    }

    public File print( String documentName ) {

        try {

            Files.write(
                Paths.get( documentName + ".txt" ), 
                SingleComposition.getInstance().getComposition().getBytes()
            );

            return new File(documentName + ".txt");

        } catch (Exception e) {
            throw new RuntimeException("Um erro ocorreu na impressão do texto da árvore!\n"+e);
        } finally {
            SingleComposition.getInstance().resetComposition();
        }

    }

}