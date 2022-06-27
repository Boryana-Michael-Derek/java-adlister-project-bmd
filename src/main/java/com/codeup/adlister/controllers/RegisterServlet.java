package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.System.out;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirm_password");

        // validate input
//        boolean inputHasErrors = username.isEmpty()
//            || email.isEmpty()
//            || password.isEmpty()
//            || (! password.equals(passwordConfirmation));
        boolean usernameNotExist = false;
        boolean emailNotExist = false;
        boolean userConflicts = false;

        User nameTest = DaoFactory.getUsersDao().findByUsername(username);
        User emailTest = DaoFactory.getUsersDao().findByEmail(email);

        if(nameTest == null){
            usernameNotExist = true;
        }
        if(emailTest == null){
            emailNotExist = true;
        }
        if(usernameNotExist && emailNotExist){
            userConflicts = true;
        }

        String usernameExistMessage = "<script>alert('The Username already exists, try again');</script>";
        String emailExistMessage = "<script>alert('The email already exist with another user, try again');</script>";
        String emaiNUsernameExistMessage = "<script>alert('The username and email already exist with another user, try again');</script>";

        if (userConflicts) {
            User user = new User(username, email, password);
            DaoFactory.getUsersDao().insert(user);
            response.sendRedirect("/login");
        } else if (!usernameNotExist && !emailNotExist) {
// <<<<<<< hannah-paterka
            request.setAttribute("passwordError", "The password is incorrect!");

            out.println("<script>");
            out.println("alert('This username and email is already in use, please try different ones.');");
            out.println("window.location.replace('" + "/register" + "');");
            out.println("</script>");
//             request.setAttribute("usernameExistMessage", usernameExistMessage);
//             request.setAttribute("emailExistMessage", emailExistMessage);
// =======
            request.setAttribute("emaiNUsernameExistMessage", emaiNUsernameExistMessage);
//             request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
// >>>>>>> master
        } else if (!emailNotExist) {
            out.println("<script>");
            out.println("alert('This email is already in use, please try another.');");
            out.println("window.location.replace('" + "/register" + "');");
            out.println("</script>");
            request.setAttribute("username", username);
            request.setAttribute("emailExistMessage", emailExistMessage);
        } else {
            out.println("<script>");
            out.println("alert('This username is already in use, please try another.');");
            out.println("window.location.replace('" + "/register" + "');");
            out.println("</script>");
            request.setAttribute("email", email);
            request.setAttribute("usernameExistMessage", usernameExistMessage);
        }

        if(username.isEmpty()){
            request.setAttribute("usernameError", "You need to enter a username!");
//            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
        else if(email.isEmpty() || email.contains("@")) {
            request.setAttribute("emailError", "You need to enter a valid email address!");
//           request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
        else if (!password.equals(passwordConfirmation) || password.isEmpty()) {
            request.setAttribute("passwordError", "The password is incorrect!");
//            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }

//       else if (password.isEmpty()){
//            request.setAttribute("passwordEmptyError", "You need to enter a password!");
////            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);


        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);


//        if (inputHasErrors) {
//            response.sendRedirect("/register");
//            return;
//        }
        User foundUser = DaoFactory.getUsersDao().findByUsername(username);
        if(foundUser != null) {
            response.sendRedirect("/register");
            return;
        }
        // create and save a new user
        User user = new User(username, email, password);
        DaoFactory.getUsersDao().insert(user);
        response.sendRedirect("/login");
    }
}
