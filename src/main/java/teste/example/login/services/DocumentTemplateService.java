package teste.example.login.services;

import java.util.List;
import java.util.UUID;

import teste.example.login.models.DocumentTemplate;
import teste.example.login.models.User;

public interface DocumentTemplateService {

    public List<DocumentTemplate> listTemplatesByUser(User user);

    public void saveDocumentTemplate(DocumentTemplate documentTemplate);

    public DocumentTemplate findById(UUID templateId);

}