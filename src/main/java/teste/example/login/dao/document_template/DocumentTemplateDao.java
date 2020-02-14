package teste.example.login.dao.document_template;

import java.util.List;
import java.util.UUID;

import teste.example.login.dao.GenericDao;
import teste.example.login.models.DocumentTemplate;
import teste.example.login.models.User;

public interface DocumentTemplateDao 
    extends GenericDao<DocumentTemplate, UUID>
{
    List<DocumentTemplate> findAllByUser(User user);
}