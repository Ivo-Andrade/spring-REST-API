package teste.example.login.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import teste.example.login.models.Component;
import teste.example.login.strategies.outputs.Composition;
import teste.example.login.strategies.outputs.CompositionStrategyConfig;

@Data
@EqualsAndHashCode(callSuper = true)
public abstract class Leaf 
    extends Component 
    implements Composition 
{

    public Leaf(
        String tag
        , CompositionStrategyConfig output
    ) {
        super(tag, output);
    }

}