package com.example.services;

import com.example.dao.BorrowDAO;
import com.example.dao.DocumentDAO;
import com.example.dao.UserDAO;
import com.example.entities.Borrow;
import com.example.entities.Document;
import com.example.entities.User;

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
