package teste.example.login.deserializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import teste.example.login.models.Component;
import teste.example.login.models.Composite;
import teste.example.login.models.leaves.InputLeaf;
import teste.example.login.models.leaves.TextLeaf;
import teste.example.login.strategies.outputs.CompositionStrategyConfig;
import teste.example.login.strategies.traversals.TraversalStrategyConfig;

public class ComponentDeserializer 
    extends StdDeserializer<Component>
{

    protected ComponentDeserializer() {
        this(null);
    }

    protected ComponentDeserializer(Class<?> vc) {
        super(vc);
    }

    private static final long serialVersionUID = 1L;

    @Override
    public Component deserialize(JsonParser jp, DeserializationContext context)
            throws IOException, JsonProcessingException
    {
        JsonNode node = jp.getCodec().readTree(jp);

        if(node.has("children")) {
            List<Component> children = new ArrayList<Component>();

            if (node.has("children")) for ( JsonNode childNode : node.get("children") ) {
                children.add(jp.getCodec().treeToValue(childNode, Component.class));
            }

            return new Composite(
                (node.has("tag")) ? node.get("tag").asText() : Composite.class.getSimpleName()
                , CompositionStrategyConfig.defaultComposition
                , children
                , (node.has("reference")) ? node.get("reference").asText() : ""
                , (node.has("traversal")) ? TraversalStrategyConfig.valueOf(node.get("traversal").asText()) : TraversalStrategyConfig.defaultTraversal
            );
        }
        else if(node.has("input"))
            return new InputLeaf(
                (node.has("tag")) ? node.get("tag").asText() : InputLeaf.class.getSimpleName()
                , CompositionStrategyConfig.defaultComposition
                , node.get("input").asText()
            );
        else if(node.has("text"))
            return new TextLeaf(
                (node.has("tag")) ? node.get("tag").asText() : TextLeaf.class.getSimpleName()
                , CompositionStrategyConfig.defaultComposition
                , node.get("text").asText()
            );
        throw new IOException("Error parsing component type "+node.toString());
    }
    
}