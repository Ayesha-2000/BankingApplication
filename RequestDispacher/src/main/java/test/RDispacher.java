package test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RDispacher extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num =Integer.parseInt(req.getParameter("num1"));
		String operation = req.getParameter("operation");
		int result=0;
		String message = "";
		switch(operation)
		{
		case "prime":
			if(isPrime(num))
				System.out.println(num + " is a prime number." );
			else
				System.out.println(num + " is not a prime number.");
            break;
		case "factor":
			message = getFactors(num);
           break;
		case "factorial":
			result = factorial(num);
            message = "The factorial is: " + result;
           break;
		case "square":
           result=num*num;
           break;
		default:
			System.out.println("invalid number");
		}
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		pw.println("The "+operation+" is : "+result);
		req.getRequestDispatcher("calculator.html").include(req, resp);
}

public static boolean isPrime(int num) {
    if (num <= 1) {
        return false;
    }
    for (int i = 2; i <= Math.sqrt(num); i++) {
        if (num % i == 0) {
            return false;
        }
    }
    return true;
}

public static String getFactors(int num) {
    
	String str="";
    for (int i = 1; i <= num; i++) {
        if (num % i == 0) 
        {
        	str+=i+" ";
        }
            
    }
	return "result: "+str;
}

public static int factorial(int num) {
    int result = 1;
    for (int i = 1; i <= num; i++) {
        result *= i;
    }
    return result;
}
}
