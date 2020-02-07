package teste.example.login.models;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    
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