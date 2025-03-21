package com.example.controllers;

import com.google.gson.Gson;
import com.example.services.BorrowService;
import com.example.entities.Borrow;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/borrows/*")
public class BorrowController extends HttpServlet {
    private final BorrowService borrowService = new BorrowService();
    private final Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Borrow> borrows = borrowService.getCurrentBorrows();
        String json = gson.toJson(borrows);

        resp.setContentType("application/json");
        resp.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        Borrow borrow = gson.fromJson(reader, Borrow.class);

        borrowService.borrowDocument(borrow.getUser().getId(), borrow.getDocument().getId());

        resp.setContentType("application/json");
        resp.getWriter().write("{\"message\": \"Document emprunté avec succès\"}");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        if (path != null && path.equals("/return")) {
            BufferedReader reader = req.getReader();
            Borrow borrow = gson.fromJson(reader, Borrow.class);

            borrowService.returnDocument(borrow.getId());

            resp.setContentType("application/json");
            resp.getWriter().write("{\"message\": \"Document retourné avec succès\"}");
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "URL invalide");
        }
    }
}
