package teste.example.login.models.leaves;

import teste.example.login.models.Component;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class TextLeaf 
    extends Component
{

    @NotBlank
    @JsonProperty("text")
    private String textValue;
    
    public void traverse(
        Component node
        // , JsonNode inputContext
    ) {
        System.out.println("Traversing \""+this.getTag()+"\" with value \""+textValue+"\"");
    }

}