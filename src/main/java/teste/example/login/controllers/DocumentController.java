package teste.example.login.controllers;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import teste.example.login.aspects.annotations.ComponentValidationAdvice;
import teste.example.login.aspects.annotations.TokenValidationAdvice;
import teste.example.login.dao.document_template.DocumentTemplateDao;
import teste.example.login.dao.user.UserDao;
import teste.example.login.models.*;
import teste.example.login.services.TokenService;
import teste.example.login.strategies.outputs.strategies.DefaultCompositionStrategy;
import teste.example.login.strategies.traversals.strategies.DefaultTraversalStrategy;

@RestController
@RequestMapping("/api/templates")
public class DocumentController {

    @Autowired
    TokenService tokenService;

    @Autowired
    DocumentTemplateDao documentTemplateRepo;

    @Autowired
    @Qualifier("repository")
    UserDao userRepo;

    @GetMapping("")
    @TokenValidationAdvice
    public List<DocumentTemplate> listTemplates(@RequestBody @Valid Token token) {
        // TODO: Request Handler / Service
        return documentTemplateRepo.findAllByUser(userRepo.findById(tokenService.getUserId(token)));
    }

    @PostMapping("/save")
    @TokenValidationAdvice
    @ComponentValidationAdvice
    public DocumentTemplate saveTemplate(@RequestBody @Valid DocumentTemplateRequest documentTemplateRequest) {

        // TODO: Request Handler / Service
        DocumentTemplate documentTemplate = new DocumentTemplate(
                userRepo.findById(tokenService.getUserId(documentTemplateRequest.getToken())),
                documentTemplateRequest.getName(), documentTemplateRequest.getTreeNode().toString());

        documentTemplateRepo.create(documentTemplate);

        return documentTemplate;

    }

    @PostMapping("/create")
    @TokenValidationAdvice
    @ComponentValidationAdvice
    public String createDocument(@RequestBody @Valid DocumentInterviewRequest documentInterviewRequest) {

        // TODO: Request Handler / Service
        DefaultTraversalStrategy.getInstance().setStrategy(documentInterviewRequest.getTraversal().getStrategy());
        DefaultCompositionStrategy.getInstance().setStrategy(documentInterviewRequest.getOutput().getStrategy());

        UUID templateId = UUID.fromString(documentInterviewRequest.getTemplateId());

        DocumentTemplate template = documentTemplateRepo.findById(templateId);

        Component templateComponent;

        try {
            templateComponent = new ObjectMapper().readValue(template.getTreeJson(), Component.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

        templateComponent.traverse(templateComponent, documentInterviewRequest.getInputContext());

        DefaultCompositionStrategy.getInstance().print(documentInterviewRequest.getFilename());

        return documentInterviewRequest.getFilename();
    }

}