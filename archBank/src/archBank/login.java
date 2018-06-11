package archBank;

import java.io.IOException; 

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.my.modle.customerLogin;
import com.my.service.LoginService;

import java.sql.*;

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NullPointerException {

		try {

			customerLogin c1 = new customerLogin();
			LoginService c2 = new LoginService();

			c1.setEmail(request.getParameter("username"));
			c1.setPassword(request.getParameter("password"));

			if ((c2.Login(c1.getEmail(), c1.getPassword()))) {

				c1.setFname(c2.setfname(c1.getEmail()));
				c1.setLname(c2.setLastname(c1.getEmail()));
				c1.setAccountNo(c2.setAccNo(c1.getEmail()));
				c1.setAccountBalance(c2.setBalance(c1.getAccountNo()));

				HttpSession session = request.getSession();

				session.setAttribute("username", c1.getEmail());// email
				session.setAttribute("userFname", c1.getFname());
				session.setAttribute("Accbalance", c1.getAccountBalance());
				session.setAttribute("userLname", c1.getLname());
				session.setAttribute("currentPass", c1.getPassword());
				session.setAttribute("AccNo", c1.getAccountNo());
				

				response.sendRedirect("homepage.jsp");
			}

			else  {
				request.setAttribute("errorMessage", "Invalid user or password");
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
				response.sendRedirect("login.jsp");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
