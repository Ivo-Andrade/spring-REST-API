package teste.example.login.models;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;

@Data
public class DocumentTemplateRequest {

    @NotBlank
    @JsonProperty("name")
    private String documentName;

    @Valid
    Token token;

    @NotNull
    @JsonProperty("tree")
    JsonNode treeNode;

    @NotNull
    @Valid
    Component treeComp;

    public void setTreeNode(JsonNode treeNode) {
        this.treeNode = treeNode;
        try {
            setTreeComp(new ObjectMapper().treeToValue(treeNode, Component.class));
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

}