package teste.example.login.dao.document_template;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import teste.example.login.exceptions.DocumentTemplateDaoException;
import teste.example.login.exceptions.DocumentTemplateNotFoundException;
import teste.example.login.models.DocumentTemplate;
import teste.example.login.models.User;

public class DocumentTemplateRepositoryImpl
    implements DocumentTemplateDao 
{

    @Autowired
    DocumentTemplateRepository documentRepo;

    public void create(DocumentTemplate newInstance) {
        try {
            documentRepo.save(newInstance);
        } catch (Exception e) {
            throw new DocumentTemplateDaoException(e);
        }
    }

    public List<DocumentTemplate> findAll() {
        try {
            return documentRepo.findAll();
        } catch (Exception e) {
            throw new DocumentTemplateDaoException(e);
        }
    }

    public DocumentTemplate update(DocumentTemplate transientObject) {
        try {
            documentRepo.deleteById(transientObject.getId());
            return documentRepo.save(transientObject);
        } catch (Exception e) {
            throw new DocumentTemplateDaoException(e);
        }
    }

    public void delete(DocumentTemplate persistentObject) {
        try {
            documentRepo.delete(persistentObject);
        } catch (Exception e) {
            throw new DocumentTemplateDaoException(e);
        }
    }

    public DocumentTemplate findById(UUID id) {
        try {
            return documentRepo.findById(id).orElseThrow(() -> new DocumentTemplateNotFoundException("Document template not found!"));
        } catch (Exception e) {
            throw new DocumentTemplateDaoException(e);
        }
    }

    public List<DocumentTemplate> findAllByUser(User user) {
        try {
            return documentRepo.findByUser(user);
        } catch (Exception e) {
            throw new DocumentTemplateDaoException(e);
        }
    }

}