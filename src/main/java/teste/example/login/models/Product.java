package teste.example.login.models;

import java.util.UUID;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.annotations.Type;

import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {

    @Id
    @Type(type="org.hibernate.type.UUIDCharType")
	@GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    
    @NotBlank
    @Size(min = 4, max = 256)
    private String name;
    
    @NotBlank 
    @Size(min = 4, max = 256)
    private String make;
    
    @NonNull 
    private Double price;

    public String toString() {
        return String.format(
            "Product=[ID %d: \"%s\" by %s, $ %.2f]", 
            id, name, make, price);
    }

}