package teste.example.login.strategies.traversals.strategies;

import com.fasterxml.jackson.databind.JsonNode;

import lombok.Data;
import lombok.EqualsAndHashCode;
import teste.example.login.models.Component;
import teste.example.login.strategies.traversals.TraversalStrategy;

@Data
@EqualsAndHashCode(callSuper=true)
public class DefaultTraversalStrategy 
    extends TraversalStrategy 
{

    TraversalStrategy strategy;

    static DefaultTraversalStrategy instance = new DefaultTraversalStrategy();

    public static DefaultTraversalStrategy getInstance() {
        return instance;
    }

    public void traverse(
        Component node
        , JsonNode inputContext
    ) {
        
        this.strategy.traverse(node,inputContext);

    }

    

}