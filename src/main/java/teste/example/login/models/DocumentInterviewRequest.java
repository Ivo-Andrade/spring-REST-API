package teste.example.login.models;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

import lombok.Data;
import teste.example.login.strategies.traversals.TraversalStrategyConfig;
import teste.example.login.strategies.outputs.CompositionStrategyConfig;

@Data
public class DocumentInterviewRequest {

    @NotNull
    @Valid
    private Token token;

    @NotBlank
    @JsonProperty("template")
    private String templateId;

    private String filename = "output_file_" + new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(new Date());

    @NotNull
    @JsonProperty("input")
    JsonNode inputContext;

    private CompositionStrategyConfig output = CompositionStrategyConfig.text;

    private TraversalStrategyConfig traversal = TraversalStrategyConfig.compose;

    public void setFilename(String filename) {
        this.templateId = (filename == null) ? "output_file_" + new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(new Date()) : filename;
    }

    public void setOutput(CompositionStrategyConfig output) {
        this.output = (output == null) ? CompositionStrategyConfig.text : output;
    }

    public void setTraversal(TraversalStrategyConfig traversal) {
        this.traversal = (traversal == null) ? TraversalStrategyConfig.compose : traversal;
    }

}