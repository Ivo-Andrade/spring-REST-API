package teste.example.login.services.impl;

import java.util.UUID;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teste.example.login.dao.document_template.DocumentTemplateDao;
import teste.example.login.models.Component;
import teste.example.login.models.DocumentInterviewRequest;
import teste.example.login.models.DocumentTemplate;
import teste.example.login.services.DocumentCreationService;
import teste.example.login.services.DocumentTemplateService;
import teste.example.login.strategies.outputs.strategies.DefaultCompositionStrategy;
import teste.example.login.strategies.traversals.strategies.DefaultTraversalStrategy;

@Service
public class DocumentCreationServiceImpl 
    implements DocumentCreationService 
{

    @Autowired DocumentTemplateDao documentTemplateRepo;
    @Autowired DocumentTemplateService documentTemplateService;

    public String createDocument(DocumentInterviewRequest documentInterviewRequest) {
        
        setupStrategies(documentInterviewRequest);

        Component templateComponent = setupDocumentComponent(
            documentTemplateService.findById(
                UUID.fromString(
                    documentInterviewRequest.getTemplateId()
                )
            )
        );

        composeDocument(  
            templateComponent
            , documentInterviewRequest.getInputContext()
        );

        return printDocument(
            templateComponent
            , documentInterviewRequest.getFilename()
        );

    }

    public void setupStrategies(DocumentInterviewRequest documentInterviewRequest) {
        DefaultTraversalStrategy.getInstance().setStrategy(documentInterviewRequest.getTraversal().getStrategy());
        DefaultCompositionStrategy.getInstance().setStrategy(documentInterviewRequest.getOutput().getStrategy());
    }

    public Component setupDocumentComponent(DocumentTemplate template) {
        try {
            return new ObjectMapper().readValue(template.getTreeJson(), Component.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void composeDocument(Component templateComponent, JsonNode inputContext) {
        templateComponent.traverse(templateComponent, inputContext);
    }

    public String printDocument(Component templateComponent, String filename) {
        DefaultCompositionStrategy.getInstance().print(filename);
        return filename;
    }
    
}