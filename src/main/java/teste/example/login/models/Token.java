package teste.example.login.models;

import javax.validation.constraints.NotBlank;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Token {

    @NotBlank
    private String token;

}