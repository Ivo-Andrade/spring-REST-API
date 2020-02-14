package teste.example.login.services;

import com.fasterxml.jackson.databind.JsonNode;

import teste.example.login.models.Component;
import teste.example.login.models.DocumentInterviewRequest;
import teste.example.login.models.DocumentTemplate;

public interface DocumentCreationService {

    public String createDocument(DocumentInterviewRequest documentInterviewRequest);

    public void setupStrategies(DocumentInterviewRequest documentInterviewRequest);

    public Component setupDocumentComponent(DocumentTemplate template);

    public void composeDocument(Component documentComponent, JsonNode inputContext);

    public String printDocument(Component documentComponent, String filename);

}