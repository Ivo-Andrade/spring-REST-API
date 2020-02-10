package teste.example.login.models;

import javax.validation.Valid;
import javax.validation.constraints.*;

import lombok.Data;

@Data
public class Document {

    @NotBlank
    private String name;
    
    @NotNull
    @Min(1)
    @Max(5000)
    private Integer id;

    @NotNull
    @Valid
    Component tree;

}