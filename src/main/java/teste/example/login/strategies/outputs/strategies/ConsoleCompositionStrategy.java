package teste.example.login.strategies.outputs.strategies;

import java.io.File;

import teste.example.login.models.Component;
import teste.example.login.strategies.outputs.CompositionStrategy;
import teste.example.login.strategies.outputs.singletons.SingleComposition;

public class ConsoleCompositionStrategy 
    extends CompositionStrategy
{

    public void compose( Component node, String append ) {

        if(append == null || append == "")
            throw new IllegalArgumentException("Apêndice de texto vazio!");
        
        SingleComposition.getInstance().append(append);

    }

    public File print( String documentName ) {

        System.out.println( SingleComposition.getInstance().getComposition() );
        SingleComposition.getInstance().resetComposition();

        return null;

    }

}