package teste.example.login.models.leaves;

import teste.example.login.models.Component;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class InputLeaf 
    extends Component
{

    @NotBlank
    @JsonProperty("input")
    private String inputField;

    @NotBlank
    @JsonProperty("value")
    private String inputValue;
    
    public void traverse(
        Component node 
        // , JsonNode inputContext
    ) {
        System.out.println("Traversing \""+this.getTag()+"\" with input var \""+inputField+"\" and value \""+inputValue+"\"");
    }

}