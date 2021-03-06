package teste.example.login.strategies.traversals.strategies;

import com.fasterxml.jackson.databind.JsonNode;

import teste.example.login.models.Component;
import teste.example.login.strategies.traversals.TraversalStrategy;

public class ComposeTraversalStrategy
    extends TraversalStrategy
{
    
    public void traverse(
        Component node
        , JsonNode inputContext    
    ) {

        for( Component child : node.getChildren() ){
            child.traverse(child,inputContext);
        }

    }
    
}