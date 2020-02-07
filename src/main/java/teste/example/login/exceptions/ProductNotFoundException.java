package teste.example.login.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProductNotFoundException 
    extends RuntimeException 
{

    private static final long serialVersionUID = 1L;

    public ProductNotFoundException() {
        super();
    }
    public ProductNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public ProductNotFoundException(String message) {
        super(message);
    }
    public ProductNotFoundException(Throwable cause) {
        super(cause);
    }
    
}