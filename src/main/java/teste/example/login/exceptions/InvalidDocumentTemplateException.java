package teste.example.login.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidDocumentTemplateException 
    extends RuntimeException 
{

    private static final long serialVersionUID = 1L;

    public InvalidDocumentTemplateException() {
        super();
    }
    public InvalidDocumentTemplateException(String message, Throwable cause) {
        super(message, cause);
    }
    public InvalidDocumentTemplateException(String message) {
        super(message);
    }
    public InvalidDocumentTemplateException(Throwable cause) {
        super(cause);
    }
    
}