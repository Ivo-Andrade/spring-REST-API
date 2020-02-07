package teste.example.login.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class IncorrectPasswordException 
    extends RuntimeException 
{

    private static final long serialVersionUID = 1L;

    public IncorrectPasswordException() {
        super();
    }
    public IncorrectPasswordException(String message, Throwable cause) {
        super(message, cause);
    }
    public IncorrectPasswordException(String message) {
        super(message);
    }
    public IncorrectPasswordException(Throwable cause) {
        super(cause);
    }
    
}