package teste.example.login.models;

import java.util.UUID;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.hibernate.annotations.Type;

import lombok.*;
import teste.example.login.exceptions.InvalidDocumentTemplateException;
import teste.example.login.hash.DocumentTemplateHash;

@Data
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "id", "user_id" }))
@NoArgsConstructor
public class DocumentTemplate extends DocumentTemplateHash {

    @Id
    @Type(type = "org.hibernate.type.UUIDCharType")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NotBlank
    private String name;

    @Lob
    @NotBlank
    @JsonIgnore
    @Column(name = "tree_json")
    private String treeJson;

    @Column(unique = true)
    private Integer hash = this.hashCode();

    public DocumentTemplate(User user, String name, String treeJson) {
        try {
            this.user = user;
            this.name = name;
            this.treeJson = treeJson;
            this.id = UUID.randomUUID();
        } finally {
            this.hash = this.hashCode();
        }
    }

    public JsonNode getTree() {
        try {
            return new ObjectMapper().readValue(treeJson, JsonNode.class);
        } catch (Exception e) {
            throw new InvalidDocumentTemplateException();
        }
    }

    public void setTree() {}

    public Integer getHash() {
        return this.hashCode();
    }

    public void setHash(Integer hash) {
        return;
    }

    public int hashCode() {
        return this.hashCode(this);
    }

    public boolean equals(Object o) {
        return this.equals(this, o);
    }

}