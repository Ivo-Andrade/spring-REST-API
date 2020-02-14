package teste.example.login.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teste.example.login.dao.document_template.DocumentTemplateDao;
import teste.example.login.models.DocumentTemplate;
import teste.example.login.models.User;
import teste.example.login.services.DocumentTemplateService;

@Service
public class DocumentTemplateServiceImpl 
    implements DocumentTemplateService 
{

    @Autowired DocumentTemplateDao documentTemplateRepo;

    public List<DocumentTemplate> listTemplatesByUser(User user) {
        return documentTemplateRepo.findAllByUser(user);
    }

    public void saveDocumentTemplate(DocumentTemplate documentTemplate) {
        documentTemplateRepo.create(documentTemplate);
    }

    public DocumentTemplate findById(UUID templateId) {
        return documentTemplateRepo.findById(templateId);
    }
    
}