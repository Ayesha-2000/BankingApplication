package test;

import java.io.IOException;

import DAO.DepositDAO;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deposit")
public class DepositServlet extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	        String amountStr = request.getParameter("amount");
	   
	        ServletContext ct=this.getServletContext();
	        String accno = (String) ct.getAttribute("accno");
	        DepositDAO depositDAO = new DepositDAO();
	        boolean isSuccess = depositDAO.deposit(Long.parseLong(amountStr), Long.parseLong(accno));
	        System.out.println("isSuccess"+isSuccess);
	        if (isSuccess) {
	            request.getRequestDispatcher("transfersuccess.jsp").forward(request, response);
	        } else {
	            response.sendRedirect("fail.jsp");
	        }
}
}
