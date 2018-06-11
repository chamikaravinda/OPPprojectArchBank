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

import com.my.modle.customer;
import com.my.service.inputValidation;
import com.my.service.updateServices;

@WebServlet("/UpdateDetails")
public class UpdateDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		customer n1 = new customer();

		updateServices n2 = new updateServices();

		n1.setFname(request.getParameter("fname"));
		n1.setLname(request.getParameter("lname"));
		n1.setEmail(request.getParameter("email"));
		n1.setPassword(request.getParameter("CurrentPass"));
		n1.setAccountNo(request.getParameter("accNo"));

		try {
			
			inputValidation check = new inputValidation();

			// validate first name

			if (check.valideTextOnly(n1.getFname()) == false) {
				request.setAttribute("errorFname", "Invalid Characters in First Name");
				RequestDispatcher rd1 = request.getRequestDispatcher("updateAccount.jsp");
				rd1.forward(request, response);
				response.sendRedirect("updateAccount.jsp");
			}

			// validate last name
			if (check.valideTextOnly(n1.getLname()) == false) {
				request.setAttribute("errorLname", "Invalid Characters in last name");
				RequestDispatcher rd2 = request.getRequestDispatcher("updateAccount.jsp");
				rd2.forward(request, response);
				response.sendRedirect("updateAccount.jsp");
			}

			// validate email
			if (check.valideEmail(n1.getEmail()) == false) {
				request.setAttribute("errorEmail", "Invalid Email Address");
				RequestDispatcher rd3 = request.getRequestDispatcher("updateAccount.jsp");
				rd3.forward(request, response);
				response.sendRedirect("updateAccount.jsp");
			}

			// check new entered email not in use

			if (n2.checkEmailAlreadyInUse(n1.getEmail(), n1.getAccountNo())) {

				request.setAttribute("errorEmail2", "This Email is already use");
				RequestDispatcher rd4 = request.getRequestDispatcher("updateAccount.jsp");
				rd4.forward(request, response);
				response.sendRedirect("updateAccount.jsp");
			}

			// end of checking email

			if (n2.PasswordCorrect(n1.getPassword(), n1.getAccountNo()) == false) {
				request.setAttribute("errorPass", "Invalid Current Password");
				RequestDispatcher rd4 = request.getRequestDispatcher("updateAccount.jsp");
				rd4.forward(request, response);
				response.sendRedirect("updateAccount.jsp");
			}

			if (n2.Update(n1)) {
				System.out.print("done");
				String atu = "yes123";

				HttpSession session = request.getSession();

				session.removeAttribute("username");
				session.removeAttribute("userFname");
				session.removeAttribute("Accbalance");
				session.removeAttribute("userLname");
				session.removeAttribute("currentPass");
				session.removeAttribute("AccNo");

				session.setAttribute("authority", atu);
				
				response.sendRedirect("updateCompleate.jsp");

			}

			else {

				request.setAttribute("errorUpdate", "Error In Update");
				RequestDispatcher rd1 = request.getRequestDispatcher("updateAccount.jsp");
				rd1.forward(request, response);
				response.sendRedirect("updateAccount.jsp");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}