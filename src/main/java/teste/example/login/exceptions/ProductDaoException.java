package teste.example.login.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ProductDaoException 
    extends RuntimeException 
{

    private static final long serialVersionUID = 1L;

    public ProductDaoException() {
        super();
    }
    public ProductDaoException(String message, Throwable cause) {
        super(message, cause);
    }
    public ProductDaoException(String message) {
        super(message);
    }
    public ProductDaoException(Throwable cause) {
        super(cause);
    }
    
}