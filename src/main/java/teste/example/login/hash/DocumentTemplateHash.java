package teste.example.login.hash;

import teste.example.login.models.DocumentTemplate;

public abstract class DocumentTemplateHash 
    implements Hash
{

    public int hashCode(DocumentTemplate documentTemplate) {
        Integer hash = 37;
        hash = (documentTemplate.getUser() == null) ? 0 : 23 * hash + documentTemplate.getUser().getId().toString().hashCode();
        hash = (documentTemplate.getTreeJson() == null) ? 0 : 23 * hash + documentTemplate.getTreeJson().hashCode();
        return hash;
    }

    public boolean equals(DocumentTemplate documentTemplate, Object o) {
        if (documentTemplate == o) return true;
        if (o == null) return false;
        if (documentTemplate.getClass() != o.getClass()) return false;
        
        DocumentTemplate documentTemplateObj = (DocumentTemplate) o;
        
        return documentTemplate.getId() == documentTemplateObj.getId()
            && documentTemplate.getUser().equals(documentTemplateObj.getUser())
            && documentTemplate.getName().equals(documentTemplateObj.getName())
            && documentTemplate.getTreeJson().equals(documentTemplateObj.getTreeJson());
    }

}