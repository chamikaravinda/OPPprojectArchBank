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

import com.my.modle.CustomerPassword;
import com.my.service.PasswordUpdateService;

@WebServlet("/updatePassword")
public class updatePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NullPointerException {

		CustomerPassword c1=new CustomerPassword();
		PasswordUpdateService c2=new PasswordUpdateService();
		
		c1.setCurrentPassword(request.getParameter("CurrentPass"));
		c1.setNewPassword(request.getParameter("newPass"));
		c1.setConfirmPassword(request.getParameter("confirmpass"));

		HttpSession session = request.getSession();
		c1.setUser((String) session.getAttribute("username"));
		
		try {

			

			if (c1.getCurrentPassword().equals(c2.getCurrentPassword(c1.getUser()))==false) {
				request.setAttribute("errorPass", "Current Password is invalid ");
				RequestDispatcher rd4 = request.getRequestDispatcher("updatePassword.jsp");
				rd4.forward(request, response);
				response.sendRedirect("updatePassword.jsp");
				
			}

			if (c1.getNewPassword().equals(c1.getConfirmPassword()) == false) {
				request.setAttribute("errorPass2", "Passwords Don't match");
				RequestDispatcher rd4 = request.getRequestDispatcher("updatePassword.jsp");
				rd4.forward(request, response);
				response.sendRedirect("updatePassword.jsp");

			}

			else {
			  
				
				

				if (c2.updatePassowrd(c1) > 0) {

					System.out.print("done");
					String atu = "yes123";

					session.setAttribute("authority", atu);
					response.sendRedirect("passwordUpdateCompleat.jsp");

				}

				else {

					request.setAttribute("errorUpdate", "Error In Update");
					RequestDispatcher rd1 = request.getRequestDispatcher("updatePassword.jsp");
					rd1.forward(request, response);
					response.sendRedirect("updatePassword.jsp");
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
