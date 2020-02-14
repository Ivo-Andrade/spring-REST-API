package teste.example.login.models;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.JsonNode;

import lombok.*;
import teste.example.login.strategies.outputs.CompositionStrategyConfig;
import teste.example.login.strategies.traversals.TraversalStrategyConfig;

@Data
@EqualsAndHashCode(callSuper=true)
public class Composite 
    extends Component
{

    @NotNull
    @Valid
    private List<Component> children = new ArrayList<Component>();
    
    @NotNull
    private String reference = "";

    @NotNull
    private TraversalStrategyConfig traversal = TraversalStrategyConfig.defaultTraversal;

    public Composite(
        String tag
        , CompositionStrategyConfig output
        , List<Component> children
        , String reference
        , TraversalStrategyConfig traversal
    ) {
        super(tag, output);
        this.children = children;
        this.reference = reference;
        this.traversal = traversal;
    }

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
        , JsonNode inputContext
    ) {
        traversal.getStrategy().traverse(this, inputContext);
    }

}