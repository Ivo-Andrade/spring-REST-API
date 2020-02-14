package teste.example.login.models;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import teste.example.login.deserializer.ComponentDeserializer;
import teste.example.login.strategies.traversals.Traversal;
import teste.example.login.strategies.outputs.*;

@Data
@AllArgsConstructor
@JsonDeserialize(using = ComponentDeserializer.class)
public abstract class Component 
    implements Traversal
{

    @NotBlank
    private String tag;
    
    @NotNull
    private CompositionStrategyConfig output;

    public Boolean isLeaf() {
        return true;
    }

    public void addChild( Component branch ) { }

    public List<Component> getChildren() { 
        return new ArrayList<Component>();
    }

    public String getReference() {
        return null;
    }

}