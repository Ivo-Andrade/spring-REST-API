package teste.example.login.models;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.*;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class Composite 
    extends Component
{

    @NotNull
    @Valid
    private List<Component> children = new ArrayList<Component>();
    
    @NotBlank
    private String reference;

    public final void addChild ( 
        Component child
    ) {
        this.children.add(child);
    }

    public Component getChild( Integer index ) {
        return this.children.get(index);
    }

    public Boolean isLeaf() {
        return false;
    }

    public void traverse(
        Component node
        // , JsonNode inputContext
    ) {
        System.out.println("Traversing \""+this.getTag()+"\" with reference \""+this.getReference()+"\" and "+this.getChildren().size()+" children");
        for( Component child : node.getChildren() ) { child.traverse(child); }
        // traversal.traverse(this, inputContext);
    }

}