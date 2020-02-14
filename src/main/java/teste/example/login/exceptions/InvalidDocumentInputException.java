package teste.example.login.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidDocumentInputException 
    extends RuntimeException 
{

    private static final long serialVersionUID = 1L;

    public InvalidDocumentInputException() {
        super();
    }
    public InvalidDocumentInputException(String message, Throwable cause) {
        super(message, cause);
    }
    public InvalidDocumentInputException(String message) {
        super(message);
    }
    public InvalidDocumentInputException(Throwable cause) {
        super(cause);
    }
    
}