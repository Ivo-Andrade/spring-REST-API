package teste.example.login.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class DocumentTemplateDaoException 
    extends RuntimeException 
{

    private static final long serialVersionUID = 1L;

    public DocumentTemplateDaoException() {
        super();
    }
    public DocumentTemplateDaoException(String message, Throwable cause) {
        super(message, cause);
    }
    public DocumentTemplateDaoException(String message) {
        super(message);
    }
    public DocumentTemplateDaoException(Throwable cause) {
        super(cause);
    }
    
}