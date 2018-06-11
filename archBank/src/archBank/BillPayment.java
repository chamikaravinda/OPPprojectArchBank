package archBank;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.my.modle.BillPay;
import com.my.service.BillPayService;

@WebServlet("/BillPayment")
public class BillPayment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			BillPay p = new BillPay();
			BillPayService pp = new BillPayService();

			p.setDebitAcc((String) session.getAttribute("AccNo"));
			p.setBillAcc(request.getParameter("account"));
			p.setTransferAmount(Double.parseDouble(request.getParameter("amount")));
				System.out.println(p.getBillAcc());
				System.out.println(p.getDebitAcc());

			p.setBillAccBalanace(pp.getCurrentBalanceBill(p.getBillAcc()));
			p.setDebitAccBalance(pp.getCurrentBalance(p.getDebitAcc()));
			p.setDebitAccNewBalance(pp.debitAccNewBalance(p.getTransferAmount(), p.getDebitAccBalance()));
			p.setBillAccNewBalance(pp.BillAccNewBalance(p.getTransferAmount(), p.getBillAccBalanace()));
			p.setTransIDDr(pp.createTranIDDR());
			p.setTransIDBill(pp.createTranIDbill());

			if (p.getTransferAmount() > p.getDebitAccBalance()) {
				String atu = "yes123";

				session.setAttribute("authority", atu);
				response.sendRedirect("ErrorTrans.jsp");
				return;

			}

			if (pp.updateAccountDR(p.getDebitAcc(), p.getDebitAccNewBalance())) {
				if (pp.updateAccountBill(p.getBillAcc(), p.getBillAccNewBalance())) {
					if (pp.addTransaction(p.getDebitAcc(), p.getTransIDDr(), p.getDebitAccNewBalance(), "Bill Pay")) {
						if (pp.addBillPay(p.getDebitAcc(), p.getBillAcc(), p.getTransIDBill(), p.getTransferAmount())) {
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

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
