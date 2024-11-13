package test;

import java.io.IOException;

import DAO.LoginDAO;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/log")
public class LoginServlet extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	        String accno = request.getParameter("accno");
	        String holderName = request.getParameter("holderName");
	        LoginDAO loginDAO = new LoginDAO();
	        ServletContext ct=this.getServletContext();
	        ct.setAttribute("accno",accno);
	        boolean isValid = loginDAO.validate(accno, holderName);
	        if (isValid) {
	            response.sendRedirect("loginsuccess.jsp");
	        } else {
	            response.sendRedirect("fail.jsp");
	        }
}
}