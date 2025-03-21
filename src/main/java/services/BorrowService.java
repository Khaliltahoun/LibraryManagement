package services;

import dao.BorrowDAO;
import dao.DocumentDAO;
import dao.UserDAO;
import entities.Borrow;
import entities.Document;
import entities.User;

import java.util.List;

public class BorrowService {
    private final BorrowDAO borrowDAO = new BorrowDAO();
    private final UserDAO userDAO = new UserDAO();
    private final DocumentDAO documentDAO = new DocumentDAO();

    public List<Borrow> getCurrentBorrows() {
        return borrowDAO.getCurrentBorrows();
    }

    public void borrowDocument(Long userId, Long documentId) {
        User user = userDAO.getUserById(userId);
        Document document = documentDAO.getDocumentById(documentId);

        if (user != null && document != null) {
            borrowDAO.borrowDocument(user, document);
        } else {
            throw new RuntimeException("User or Document not found");
        }
    }

    public void returnDocument(Long borrowId) {
        borrowDAO.returnDocument(borrowId);
    }
}
