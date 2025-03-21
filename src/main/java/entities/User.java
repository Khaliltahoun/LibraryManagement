package entities;


import jakarta.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String mail;

    @ManyToMany
    @JoinTable(
            name = "user_document",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "document_id")
    )
    private List<Document> borrowedDocuments;

    // Constructeurs
    public User() {}

    public User(String name, String mail) {
        this.name = name;
        this.mail = mail;
    }

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getMail() { return mail; }
    public void setMail(String mail) { this.mail = mail; }

    public List<Document> getBorrowedDocuments() { return borrowedDocuments; }
    public void setBorrowedDocuments(List<Document> borrowedDocuments) { this.borrowedDocuments = borrowedDocuments; }
}
