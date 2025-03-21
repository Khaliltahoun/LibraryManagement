package com.example.entities;


import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "document_id")
    private Document document;

    private Date dateBorrow;
    private Date returnDate;

    // Constructeurs
    public Borrow() {}

    public Borrow(User user, Document document, Date dateBorrow) {
        this.user = user;
        this.document = document;
        this.dateBorrow = dateBorrow;
    }

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Document getDocument() { return document; }
    public void setDocument(Document document) { this.document = document; }

    public Date getDateBorrow() { return dateBorrow; }
    public void setDateBorrow(Date dateBorrow) { this.dateBorrow = dateBorrow; }

    public Date getReturnDate() { return returnDate; }
    public void setReturnDate(Date returnDate) { this.returnDate = returnDate; }
}
