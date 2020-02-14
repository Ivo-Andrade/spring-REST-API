package teste.example.login.strategies.traversals.strategies;

import com.fasterxml.jackson.databind.JsonNode;

import teste.example.login.exceptions.InvalidDocumentInputException;
import teste.example.login.models.Component;
import teste.example.login.strategies.traversals.TraversalStrategy;

public class ConditionalComposeTraversalStrategy
    extends TraversalStrategy
{
    
    public void traverse(
        Component node
        , JsonNode inputContext
    ) {

        String condition;

        if( inputContext.has(node.getTag()) ) {

            condition = inputContext.get(node.getTag()).asText();

            for( Component child : node.getChildren() ){
                if(child.getTag().equals(condition) && inputContext.has(node.getReference())) {
                    child.traverse(
                        child
                        , inputContext.get(node.getReference())
                    );
                    return;
                }
            }

            throw new InvalidDocumentInputException("Houve um erro na leitura da condição de um Or!");

        }
        else
            throw new InvalidDocumentInputException("Erro de entrada na condição de Or! ");

    }
    
}