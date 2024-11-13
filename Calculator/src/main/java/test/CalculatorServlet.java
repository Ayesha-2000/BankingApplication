package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num1 =Integer.parseInt(req.getParameter("num1"));
		int num2 =Integer.parseInt(req.getParameter("num2"));
		String operation = req.getParameter("operation");
		
		int result = 0;
		switch(operation)
		{
		case "add":
             result= num1 + num2;
            break;
		case "sub":
            result= num1 - num2;
           break;
		case "mul":
           result= num1 * num2;
           break;
		case "div":
           result= num1 / num2;
           break;
		default:
			System.out.println("invalid number");
		}
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		pw.print("The "+operation+" is : "+result);
		req.getRequestDispatcher("calculator.html").include(req, resp);
	}

}
