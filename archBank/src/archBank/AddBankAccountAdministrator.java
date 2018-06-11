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

import com.my.modle.TraditionalAccount;
import com.my.service.AdminAddAccontServices;

@WebServlet("/AddBankAccountAdministrator")
public class AddBankAccountAdministrator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("passed");
		TraditionalAccount acc = new TraditionalAccount();
		AdminAddAccontServices ac = new AdminAddAccontServices();

		acc.setAccountNo(Long.parseLong(request.getParameter("accNo")));
		acc.setCurrentBalance(Double.parseDouble(request.getParameter("Balance")));
		acc.setSecurityKey(ac.GenerateSecurityPin());

		try {
			
			
			if (String.valueOf(acc.getAccountNo()).length() != 8) {

				String atu = "yes123";
				HttpSession session = request.getSession();
				session.setAttribute("authority", atu);

				request.setAttribute("Invalid Account No", "Invalid Account Number ");
				RequestDispatcher rd5 = request.getRequestDispatcher("AdminSuccesMessagePage.jsp");
				rd5.forward(request, response);
				response.sendRedirect("AdminSuccesMessagePage.jsp");
				return;
			}

			if (ac.checkAccountNotInDB(acc.getAccountNo())) {

				String atu = "yes123";
				HttpSession session = request.getSession();
				session.setAttribute("authority", atu);

				request.setAttribute("NotAdded", "Bank Account Already In Data Base");
				RequestDispatcher rd5 = request.getRequestDispatcher("AdminSuccesMessagePage.jsp");
				rd5.forward(request, response);
				response.sendRedirect("AdminSuccesMessagePage.jsp");
				return;
			}
			if (ac.AddToDB(acc) > 0) {// adding to DB

				String atu = "yes123";
				HttpSession session = request.getSession();
				session.setAttribute("authority", atu);

				request.setAttribute("AccountAdded", "Bank Account Added");
				request.setAttribute("Security Key", "Security Key : " + acc.getSecurityKey());
				RequestDispatcher rd5 = request.getRequestDispatcher("AdminSuccesMessagePage.jsp");
				rd5.forward(request, response);
				response.sendRedirect("AdminSuccesMessagePage.jsp");
				return;
			} else {

				request.setAttribute("Error", "Error Occured in Adding Account");
				RequestDispatcher rd5 = request.getRequestDispatcher("AdministratorHome.jsp");
				rd5.forward(request, response);
				response.sendRedirect("AdministratorHome.jsp");
				return;
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
