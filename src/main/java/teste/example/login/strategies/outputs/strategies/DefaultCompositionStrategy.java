package teste.example.login.strategies.outputs.strategies;

import java.io.File;

import lombok.Data;
import lombok.EqualsAndHashCode;
import teste.example.login.models.Component;
import teste.example.login.strategies.outputs.CompositionStrategy;

@Data
@EqualsAndHashCode(callSuper=true)
public class DefaultCompositionStrategy 
    extends CompositionStrategy
{

    CompositionStrategy strategy;

    static DefaultCompositionStrategy instance = new DefaultCompositionStrategy();

    public static DefaultCompositionStrategy getInstance() {
        return instance;
    }

    public void compose( Component node, String append ) {
        strategy.compose(node, append);
    }

    public File print( String documentName ) {
        return strategy.print(documentName);
    }

}