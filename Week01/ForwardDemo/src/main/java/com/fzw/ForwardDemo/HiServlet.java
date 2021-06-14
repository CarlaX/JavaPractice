package com.fzw.ForwardDemo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author fzw
 * @description
 * @date 2021-06-13
 **/
@WebServlet(name = "hiServlet", urlPatterns = {"/hi-servlet"})
public class HiServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(HiServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("hi");
    }
}
