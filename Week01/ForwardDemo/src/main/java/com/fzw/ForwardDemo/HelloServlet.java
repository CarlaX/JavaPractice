package com.fzw.ForwardDemo;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(name = "helloServlet", urlPatterns = {"/hello-servlet"})
public class HelloServlet extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(HelloServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("helloServlet: {},{}", req.getContextPath(), req.getServletPath());
        req.getRequestDispatcher("hi-servlet").forward(req, resp);
    }
}