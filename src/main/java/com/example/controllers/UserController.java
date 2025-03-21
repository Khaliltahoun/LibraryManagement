package com.example.controllers;

import com.google.gson.Gson;
import com.example.services.UserService;
import com.example.entities.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/users")
public class UserController extends HttpServlet {
    private final UserService userService = new UserService();
    private final Gson gson = new Gson();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        User user = gson.fromJson(reader, User.class);

        userService.addUser(user.getName(), user.getMail());

        resp.setContentType("application/json");
        resp.getWriter().write("{\"message\": \"Utilisateur enregistré avec succès\"}");
    }
}
