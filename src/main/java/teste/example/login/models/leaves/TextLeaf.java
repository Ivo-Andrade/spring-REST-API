package teste.example.login.models.leaves;

import teste.example.login.models.Component;
import teste.example.login.models.Leaf;
import teste.example.login.strategies.outputs.CompositionStrategyConfig;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper=true)
public class TextLeaf 
    extends Leaf
{

    @NotBlank
    @JsonProperty("text")
    private String textValue;
    
    public TextLeaf(
        String tag
        , CompositionStrategyConfig output
        , String textValue
    ) {
        super(tag, output);
        this.textValue = textValue;
    }

    public void traverse(
        Component node
        , JsonNode inputContext
    ) {
        this.compose(node, textValue);
    }

    public void compose(Component node, String append) {
        this.getOutput().getStrategy().compose(node, append);

    }

}