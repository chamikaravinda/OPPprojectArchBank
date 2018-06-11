package archBank;

import java.io.IOException; 
import java.sql.SQLException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import com.my.modle.customerReg;
import com.my.service.RegisterServices;
import com.my.service.inputValidation;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		customerReg n1 = new customerReg();

		RegisterServices n2 = new RegisterServices();

		inputValidation check = new inputValidation();

		n1.setFname(request.getParameter("fname"));
		n1.setLname(request.getParameter("lname"));
		n1.setEmail(request.getParameter("email"));
		n1.setAccountNo(request.getParameter("accNo"));
		n1.setSecurityKey(request.getParameter("securityKey"));
		n1.setCreatePassword(request.getParameter("creatPass"));
		n1.setConfirmPassword(request.getParameter("ConfirmPass"));
		
		try {
			n1.setCustomerID(n2.GenerateCustomerID());
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		System.out.print("CustomerID befor adding to Db"+n1.getCustomerID());

		

		// checking whether theres only text in first name
		if (check.valideTextOnly(n1.getFname()) == false) {
			request.setAttribute("errorFname", "Invalid Characters");
			RequestDispatcher rd1 = request.getRequestDispatcher("register.jsp");
			rd1.forward(request, response);
			response.sendRedirect("register.jsp");
			return;
		}

		// checking whether theres only text in last name

		if (check.valideTextOnly(n1.getLname()) == false) {
			request.setAttribute("errorLname", "Invalid Characters in last name");
			RequestDispatcher rd2 = request.getRequestDispatcher("register.jsp");
			rd2.forward(request, response);
			response.sendRedirect("register.jsp");
			return;
		}

		// checking whether the email is valid

		if (check.valideEmail(n1.getEmail()) == false) {
			request.setAttribute("errorEmail", "Invalid Email");
			RequestDispatcher rd3 = request.getRequestDispatcher("register.jsp");
			rd3.forward(request, response);
			response.sendRedirect("register.jsp");
			return;
		}
		

		// check whether the email already in use

		try {
			if (n2.CheckEmailAlreadyInUse(n1.getEmail()) == true) {

				request.setAttribute("errorEmail2", "Email already in use");
				RequestDispatcher rd4 = request.getRequestDispatcher("register.jsp");
				rd4.forward(request, response);
				response.sendRedirect("register.jsp");
				return;

			}
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("2");
		// check whether the account number is valid
		if ((check.valideNumberOnly(n1.getAccountNo()) == false) || (n1.getAccountNo().length() != 8)) {
			request.setAttribute("errorACCNO", "Invalid Account number");
			RequestDispatcher rd5 = request.getRequestDispatcher("register.jsp");
			rd5.forward(request, response);
			response.sendRedirect("register.jsp");
			
			return;
		}
		// check whether the AccountID is a valid bank account
		try {

			if (n2.CheckCustomerIsvalid(n1.getAccountNo()) == false) {

				String atu = "yes123";
				HttpSession session = request.getSession();
				session.setAttribute("authority", atu);
				response.sendRedirect("NotAcustomer.jsp");
				return;

			}

			// check whether the user has a account for the bank account
			if (n2.checkAccountNumberInUse(n1.getAccountNo()) == true) {

				String atu = "yes123";
				HttpSession session = request.getSession();
				session.setAttribute("authority", atu);
				response.sendRedirect("AccountNumberInUse.jsp");
				return;
			}
			// check the security key is correct

			if (n2.checkSecurityKey(n1.getAccountNo()) == false) {
				request.setAttribute("errorSecurityKey", "Invalid security Key");
				RequestDispatcher rd5 = request.getRequestDispatcher("register.jsp");
				rd5.forward(request, response);
				response.sendRedirect("register.jsp");
				return;
			}

			// check whether the passwords are equal
			String creatPass = n1.getCreatePassword();
			String confirmPass = n1.getConfirmPassword();

			if (creatPass.equals(confirmPass) == false) {
				request.setAttribute("errorPass", "Password dont match");
				RequestDispatcher rd5 = request.getRequestDispatcher("register.jsp");
				rd5.forward(request, response);
				response.sendRedirect("register.jsp");
				return;
			}

			else {

				n2.Registercustomer(n1);

				String atu = "yes123";
				HttpSession session = request.getSession();
				session.setAttribute("authority", atu);
				response.sendRedirect("RegistComplet.jsp");
				return;
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
