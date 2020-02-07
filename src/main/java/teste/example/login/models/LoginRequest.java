package teste.example.login.models;

import javax.validation.Valid;
import javax.validation.constraints.*;

import lombok.*;

@Data
public class LoginRequest {

    @NotBlank
    @Size(min = 4, max = 64)
    private String username;
    
    @NotBlank
    @Size(min = 4, max = 64)
    private String password;

    @NotNull
    @Valid
    private Coordinates coordinates;

}