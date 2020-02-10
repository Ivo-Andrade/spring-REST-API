package teste.example.login.models;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.*;

// import com.fasterxml.jackson.annotation.JsonSubTypes;
// import com.fasterxml.jackson.annotation.JsonTypeInfo;
// import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;
import teste.example.login.deserializer.ComponentDeserializer;
// import teste.example.login.models.leaves.*;

@Data
@JsonDeserialize(using = ComponentDeserializer.class)
// @JsonTypeInfo(
//     use = JsonTypeInfo.Id.NONE
// )
// @JsonSubTypes({
//     @Type(value = Composite.class, name="composite")
//     , @Type(value = InputLeaf.class, name="input")
//     , @Type(value = TextLeaf.class, name ="text")
// })
public abstract class Component {

    @NotBlank
    private String tag = this.getClass().getSimpleName();

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
    
    public abstract void traverse(
        Component node
        // , JsonNode inputContext
    );

}