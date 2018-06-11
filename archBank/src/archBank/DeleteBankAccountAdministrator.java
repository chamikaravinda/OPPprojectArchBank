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
import com.my.service.AdminDeleteAccountServices;

@WebServlet("/DeleteBankAccountAdministrator")
public class DeleteBankAccountAdministrator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			TraditionalAccount acc = new TraditionalAccount();
			AdminDeleteAccountServices ac = new AdminDeleteAccountServices();

			acc.setAccountNo(Long.parseLong(request.getParameter("accNo")));

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

			if (ac.Delete(acc.getAccountNo())) {

				String atu = "yes123";
				HttpSession session = request.getSession();
				session.setAttribute("authority", atu);

				request.setAttribute("Account Deleted", "Account Deleted");
				RequestDispatcher rd5 = request.getRequestDispatcher("AdminSuccesMessagePage.jsp");
				rd5.forward(request, response);
				response.sendRedirect("AdminSuccesMessagePage.jsp");
				return;

			}

			else {

				String atu = "yes123";
				HttpSession session = request.getSession();
				session.setAttribute("authority", atu);

				request.setAttribute("Error", "Account Not Availabe or Wrong Account No");
				RequestDispatcher rd5 = request.getRequestDispatcher("AdminSuccesMessagePage.jsp");
				rd5.forward(request, response);
				response.sendRedirect("AdminSuccesMessagePage.jsp");
				return;

			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;

	}

}
