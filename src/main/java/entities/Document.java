package entities;


import jakarta.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Date dateCreate;

    // Constructeurs
    public Document() {}

    public Document(String title, Date dateCreate) {
        this.title = title;
        this.dateCreate = dateCreate;
    }

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Date getDateCreate() { return dateCreate; }
    public void setDateCreate(Date dateCreate) { this.dateCreate = dateCreate; }
}
