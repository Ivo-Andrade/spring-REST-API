package teste.example.login.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    
    @NotBlank 
    @Column(unique = true) private String username;
    
    @NotBlank 
    private String password;
    
    private String description;

    public String toString() {
        return String.format(
            "User=[ID %d: User \"%s\", pass \"%s\", \"%s\"]", 
            id, username, password, description);
    }

}