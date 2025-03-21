package services;

import dao.DocumentDAO;
import entities.Book;
import entities.Document;
import entities.Magazine;
import java.util.List;

public class DocumentService {
    private final DocumentDAO documentDAO = new DocumentDAO();

    public List<Document> getAllDocuments() {
        return documentDAO.getAllDocuments();
    }

    public Document getDocumentById(Long id) {
        return documentDAO.getDocumentById(id);
    }

    public void addBook(String title, String author, String isbn, java.util.Date datePublication) {
        Book book = new Book(title, new java.util.Date(), author, isbn, datePublication);
        documentDAO.addDocument(book);
    }

    public void addMagazine(String title, String publisher, String issueNumber, java.util.Date dateIssue) {
        Magazine magazine = new Magazine(title, new java.util.Date(), publisher, issueNumber, dateIssue);
        documentDAO.addDocument(magazine);
    }
}
