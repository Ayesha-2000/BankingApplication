package test;

import java.io.IOException;

import DAO.TransferDAO;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/transfer")
public class TransferServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	        String targetAccno = request.getParameter("targetAccno");
	        String amountStr = request.getParameter("amount");
	        ServletContext ct=this.getServletContext();
	        String accno = (String) ct.getAttribute("accno");
	        double amt=Double.parseDouble(amountStr);
	        TransferDAO transferDAO = new TransferDAO();
	        boolean isSuccess = transferDAO.transfer(accno, targetAccno, amt);
	        if (isSuccess) {
	            response.sendRedirect("transfersuccess.jsp");
	        } else {
	            response.sendRedirect("fail.jsp");
	        }
}
}