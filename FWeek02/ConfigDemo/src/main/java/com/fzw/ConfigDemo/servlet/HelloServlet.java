package com.fzw.ConfigDemo.servlet;

import com.fzw.ConfigDemo.config.ServletRequestConfigSource;

import java.io.*;
import java.util.Arrays;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ServletRequestConfigSource configSource = new ServletRequestConfigSource(request);
        Set<String> propertyNames = configSource.getPropertyNames();

        System.out.println(propertyNames);

        String name = configSource.getString("name");
        int age = configSource.getInt("age");
        String[] friends = configSource.getArray("friend");

        System.out.println(name);
        System.out.println(age);
        System.out.println(Arrays.toString(friends));

        response.setContentType("text/html");
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}