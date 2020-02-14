package teste.example.login.models;

import java.util.UUID;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.Type;

import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    @Id
    @Type(type="org.hibernate.type.UUIDCharType")
	@GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    
    @NotBlank 
    @Column(unique = true) 
    private String username;
    
    @JsonIgnore
    @NotBlank
    private String password;
    
    private String description;

    public String toString() {
        return String.format(
            "User=[ID %d: User \"%s\", pass \"%s\", \"%s\"]", 
            id, username, password, description);
    }

}