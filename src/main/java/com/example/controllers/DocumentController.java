package com.example.controllers;

import com.google.gson.Gson;
import com.example.services.DocumentService;
import com.example.entities.Document;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/documents/*")
public class DocumentController extends HttpServlet {
    private final DocumentService documentService = new DocumentService();
    private final Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Document> documents = documentService.getAllDocuments();
        String json = gson.toJson(documents);

        resp.setContentType("application/json");
        resp.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();

        BufferedReader reader = req.getReader();
        Document document = gson.fromJson(reader, Document.class);

        if (path != null && path.equals("/book")) {
            documentService.addBook(document.getTitle(), document.getTitle(), "123456", new java.util.Date());
            resp.getWriter().write("{\"message\": \"Livre ajouté avec succès\"}");
        } else if (path != null && path.equals("/magazine")) {
            documentService.addMagazine(document.getTitle(), "Publisher", "Issue 1", new java.util.Date());
            resp.getWriter().write("{\"message\": \"Magazine ajouté avec succès\"}");
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Type de document invalide");
        }

        resp.setContentType("application/json");
    }
}
