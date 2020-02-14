package teste.example.login.models;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

import lombok.Data;

@Data
public class DocumentTemplateRequest {

    @NotBlank
    private String name;

    @Valid
    Token token;

    @NotNull
    @JsonProperty("tree")
    JsonNode treeNode;    

    public void setTreeNode(JsonNode treeNode) {
        this.treeNode = treeNode;
    }

}