package teste.example.login.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class InvalidTokenException 
    extends RuntimeException 
{

    private static final long serialVersionUID = 1L;

    public InvalidTokenException() {
        super();
    }
    public InvalidTokenException(String message, Throwable cause) {
        super(message, cause);
    }
    public InvalidTokenException(String message) {
        super(message);
    }
    public InvalidTokenException(Throwable cause) {
        super(cause);
    }
    
}