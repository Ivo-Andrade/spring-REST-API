package teste.example.login.dao.document_template;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import teste.example.login.models.DocumentTemplate;
import teste.example.login.models.User;

public interface DocumentTemplateRepository
    extends JpaRepository<DocumentTemplate, UUID>
{
    List<DocumentTemplate> findByUser(User user);
}