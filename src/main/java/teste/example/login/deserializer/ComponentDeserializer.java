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

            for ( JsonNode childNode : node.get("children") ) {
                children.add(jp.getCodec().treeToValue(childNode, Component.class));
            }

            return new Composite(
                children
                , node.get("reference").asText()
            );
        }
        else if(node.has("input"))
            return new InputLeaf(
                node.get("input").asText()
                , node.get("value").asText()
            );
        else if(node.has("text"))
            return new TextLeaf(
                node.get("text").asText()
            );
        throw new IOException("Error parsing component type!");
    }
    
}