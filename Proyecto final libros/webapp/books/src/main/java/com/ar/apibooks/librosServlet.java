package com.ar.apibooks;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;

@WebServlet("/libros")
public class librosServlet extends HttpServlet {

    private booksDAO booksDAO = new booksDAO();
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setHeader("Access-Control-Allow-Origin", "URL del sv");
        resp.setHeader("Access-Control-Allow-Methods", "x");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type");

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        books libro = objectMapper.readValue(req.getInputStream(), books.class);

        Long id = booksDAO.insertlibro(libro);

        String jsonResponse = objectMapper.writeValueAsString(id);

        resp.setContentType("application/json");
        resp.getWriter().write(jsonResponse);
        resp.setStatus(HttpServletResponse.SC_CREATED);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "URL del sv");
    resp.setHeader("Access-Control-Allow-Methods", "GET");
    resp.setHeader("Access-Control-Allow-Headers", "Content-Type");

    req.setCharacterEncoding("UTF-8");
    resp.setCharacterEncoding("UTF-8");

    List<books> libros = booksDAO.get_All_Libros();

    String jsonResponse = objectMapper.writeValueAsString(libros);

    resp.setContentType("application/json");
    resp.getWriter().write(jsonResponse);
    resp.setStatus(HttpServletResponse.SC_OK);
        super.doGet(req, resp);
    }

    
}

