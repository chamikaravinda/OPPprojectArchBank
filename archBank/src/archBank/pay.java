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

import com.my.modle.FundTransfer;
import com.my.service.FundTransferServices;

@WebServlet("/pay")
public class pay extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			HttpSession session = request.getSession();
			FundTransfer fd = new FundTransfer();
			FundTransferServices fdd = new FundTransferServices();

			fd.setDebitAcc((String) session.getAttribute("AccNo"));
			fd.setCreditAcc((String) session.getAttribute("traaccNo"));
			fd.setTransferAmount(Double.parseDouble(request.getParameter("amount")));
			fd.setCreditAccBalanace(fdd.getCurrentBalance(fd.getCreditAcc()));
			fd.setDebitAccBalance(fdd.getCurrentBalance(fd.getDebitAcc()));
			fd.setDebitAccNewBalance(fdd.debitAccNewBalance(fd.getTransferAmount(), fd.getDebitAccBalance()));
			fd.setCreditAccNewBalance(fdd.creditAccNewBalance(fd.getTransferAmount(), fd.getCreditAccBalanace()));
			fd.setTransIDcr(fdd.createTranIDcr());
			fd.setTransIDDr(fdd.createTranIDDr());
			
			if(fd.getTransferAmount()>fd.getDebitAccBalance()) {
				String atu = "yes123";

				session.setAttribute("authority", atu);
				response.sendRedirect("ErrorTrans.jsp");
				return;
				
			}

			if (fdd.updateAccount(fd.getCreditAcc(), fd.getCreditAccNewBalance())) {
				if (fdd.updateAccount(fd.getDebitAcc(), fd.getDebitAccBalance())) {
					if (fdd.addTransaction(fd.getCreditAcc(), fd.getTransIDcr(), fd.getTransferAmount(), "CR")) {
						if (fdd.addTransaction(fd.getDebitAcc(), fd.getTransIDDr(), fd.getTransferAmount(), "DR")) {

							String atu = "yes123";

							session.setAttribute("authority", atu);
							response.sendRedirect("TransDone.jsp");
							return;

						}
					}
				}
			}
			
			else {
				
				String atu = "yes123";

				session.setAttribute("authority", atu);
				response.sendRedirect("ErrorTrans.jsp");
				return;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
