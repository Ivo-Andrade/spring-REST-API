package teste.example.login.models;

import java.util.UUID;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.hibernate.annotations.Type;

import lombok.*;
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
    @Column(name = "document_name")
    private String documentName;

    @Lob
    @NotBlank
    @JsonIgnore
    @Column(name = "tree_json")
    private String treeJson;

    @Transient
    @JsonProperty("tree")
    private JsonNode treeNode;

    @Column(unique = true)
    private Integer hash = this.hashCode();

    public DocumentTemplate(User user, String documentName, String treeJson) {
        try {
            this.user = user;
            this.documentName = documentName;
            this.treeJson = treeJson;
            this.id = UUID.randomUUID();
        } finally {
            this.hash = this.hashCode();
        }
    }

    public JsonNode getTreeNode() {
        try {
            return new ObjectMapper().readTree(this.treeJson);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public void setTreeNode(JsonNode node) {}

    public Integer getHash() {
        return this.hashCode();
    }

    public void setHash(Integer hash) { }

    public int hashCode() {
        return this.hashCode(this);
    }

    public boolean equals(Object o) {
        return this.equals(this, o);
    }

}