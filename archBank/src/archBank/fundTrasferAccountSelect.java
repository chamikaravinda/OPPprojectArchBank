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
import com.my.service.fundTransferAccountSelectSevices;

@WebServlet("/fundTrasferAccountSelect")
public class fundTrasferAccountSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		customer c = new customer();
		fundTransferAccountSelectSevices sc = new fundTransferAccountSelectSevices();
		c.setAccountNo(request.getParameter("accNo"));

		String Str1 = new String(c.getAccountNo());

		if (Str1.length() != 8) {
			System.out.println("invalid number");
			String atu = "yes123";
			HttpSession session = request.getSession();
			session.setAttribute("authority", atu);

			request.setAttribute("InvalidAccountNo", "Invalid Account Number ");
			RequestDispatcher rd5 = request.getRequestDispatcher("ErrorTrans.jsp");
			rd5.forward(request, response);
			response.sendRedirect("ErrorTrans.jsp");
			return;
		}
		try {
			if (sc.checkAccountValid(c.getAccountNo())) {
				String atu = "yes123";
				HttpSession session = request.getSession();
				session.setAttribute("authority", atu);

				request.setAttribute("Invalid Account No", "Invalid Account Number ");
				RequestDispatcher rd5 = request.getRequestDispatcher("ErrorTrans.jsp");
				rd5.forward(request, response);
				response.sendRedirect("ErrorTrans.jsp");
				return;
			}
			System.out.println("Accounnt Availabe");
			customer out;
			out = sc.selectAccount(c.getAccountNo());

			String atu = "yes123";
			HttpSession session = request.getSession();
			session.setAttribute("authority", atu);

			session.setAttribute("trafname",out.getFname());
			session.setAttribute("tralname",out.getLname());
			session.setAttribute("traaccNo",out.getAccountNo());

			RequestDispatcher rd5 = request.getRequestDispatcher("fundtransfer.jsp");
			rd5.forward(request, response);
			response.sendRedirect("fundtransfers.jsp");
			return;

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
