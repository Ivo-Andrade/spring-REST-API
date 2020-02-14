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
public class InputLeaf 
    extends Leaf
{

    @NotBlank
    @JsonProperty("input")
    private String inputField;

    public InputLeaf(
        String tag
        , CompositionStrategyConfig output
        , String inputField
    ) {
        super(tag, output);
        this.inputField = inputField;
    }
    
    public void traverse(
        Component node 
        , JsonNode inputContext
    ) {
        this.compose(node, inputContext.get(inputField).asText());
    }

    public void compose(Component node, String append) {
        this.getOutput().getStrategy().compose(node, append);
    }

}