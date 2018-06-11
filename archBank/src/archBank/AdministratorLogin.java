package archBank;

import java.io.IOException; 
import java.sql.SQLException;
import java.text.DecimalFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.my.modle.Administrator;
import com.my.service.AdminLoginServices;

@WebServlet("/AdministratorLogin")
public class AdministratorLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				try {

					Administrator c1 = new Administrator();
					AdminLoginServices c2 = new AdminLoginServices();

					c1.setUsername(request.getParameter("username"));
					c1.setPassword(request.getParameter("password"));

					if ((c2.Login(c1.getUsername(), c1.getPassword()))) {

						c1.setFname(c2.setfname(c1.getUsername()));
						c1.setLname(c2.setLastname(c1.getUsername()));
						c1.setAdminID(c2.adminID(c1.getUsername()));
						
						


						HttpSession session = request.getSession();

						session.setAttribute("username",c1.getUsername());// email
						session.setAttribute("userFname", c1.getFname());
						session.setAttribute("userLname", c1.getLname());
						session.setAttribute("currentPass", c1.getPassword());
						session.setAttribute("AdminID", c1.getAdminID());
						
						String totalBalance=c2.totalBankBalance();
						double balance_check=Double.parseDouble(totalBalance);
						
						DecimalFormat df = new DecimalFormat("0.00"); 
						
						if(balance_check<1000000){
							balance_check=balance_check/1000;
							totalBalance=String.valueOf(balance_check)+"K";
						}
						
						else if(balance_check<100000000){
							balance_check=balance_check/1000000;
							totalBalance=String.valueOf(balance_check)+"M";
						}
						else{
							balance_check=balance_check/100000000;
							//totalBalance=String.valueOf(balance_check)+"B";
							totalBalance=df.format(balance_check)+" B";
						}
						

						
						     
						
						
						RequestDispatcher rd4 = request.getRequestDispatcher("AdministratorHome.jsp");
						
						session.setAttribute("totalbankAccounts",c2.totalbankAccounts());
						session.setAttribute("totalbankBalance",totalBalance);
						session.setAttribute("totalOnlincebankAccounts",c2.totalOnlinebankAccounts());
						session.setAttribute("totalTransactions",c2.totalTransaction());
					
						rd4.forward(request, response);
						response.sendRedirect("AdministratorHome.jsp");
						return;
						
						
					}

					else  {
						request.setAttribute("errorMessage", "Invalid user or password");
						RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
						rd.forward(request, response);
						response.sendRedirect("AdministratorLogin.jsp");
						return;
					}

				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}

}
}

