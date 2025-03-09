package com.servlet.userform;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class UserRegistrationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get form parameters
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Validate input
        String message = null;

        // Check if any field is empty
        if (username == null || username.isEmpty() || email == null || email.isEmpty() || password == null || password.isEmpty()) {
            message = "All fields are required.";
        } else {
            // Simulate basic email format validation (You can enhance it further)
            String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
            if (!email.matches(emailRegex)) {
                message = "Invalid email format.";
            } else {
                message = "Registration successful!";
            }
        }

        // Set message as a request attribute
        request.setAttribute("message", message);

        // Forward the request to the JSP page to display the result
        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }
}
