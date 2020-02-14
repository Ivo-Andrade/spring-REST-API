package teste.example.login.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import teste.example.login.aspects.annotations.TokenValidationAdvice;
import teste.example.login.models.*;
import teste.example.login.services.DocumentCreationService;
import teste.example.login.services.DocumentTemplateService;
import teste.example.login.services.TokenService;
import teste.example.login.services.UserService;

@RestController
@RequestMapping("/api/templates")
public class DocumentController {

    @Autowired TokenService tokenService;
    @Autowired DocumentTemplateService documentTemplateService;
    @Autowired UserService userService;
    @Autowired DocumentCreationService documentCreationService;

    @GetMapping("")
    @TokenValidationAdvice
    public List<DocumentTemplate> listTemplates(@RequestBody @Valid Token token) {
        return documentTemplateService.listTemplatesByUser(userService.findById(tokenService.getUserId(token)));
    }

    @PostMapping("/save")
    @TokenValidationAdvice
    public DocumentTemplate saveTemplate(@RequestBody @Valid DocumentTemplateRequest documentTemplateRequest) {

        DocumentTemplate documentTemplate = new DocumentTemplate(
            userService.findById(
                tokenService.getUserId(
                    documentTemplateRequest.getToken()
                )
            ),
            documentTemplateRequest.getDocumentName(),
            documentTemplateRequest.getTreeNode().toString()
        );

        documentTemplateService.saveDocumentTemplate(documentTemplate);

        return documentTemplate;

    }

    @PostMapping("/create")
    @TokenValidationAdvice
    public String createDocument(@RequestBody @Valid DocumentInterviewRequest documentInterviewRequest) {
        return documentCreationService.createDocument(documentInterviewRequest);
    }

}