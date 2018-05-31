package severlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FinancialServiceDao;
import model.FinancialService;

/**
 * Servlet implementation class Pay_yes
 */
@WebServlet("/Pay_yes")
public class Pay_yes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pay_yes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		FinancialService user_FS=new FinancialService();
		FinancialServiceDao user_FSDao = new FinancialServiceDao();
		float price=Float.parseFloat((String)session.getAttribute("price"));
        user_FS=(FinancialService) session.getAttribute("user_FS");
        user_FS.setRest(user_FS.getRest()+price);
        try {
			user_FSDao.update(user_FS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
        session.setAttribute("user_FS", user_FS);
		session.setAttribute("Payment_pos", "Payment_1");
		session.setAttribute("key", null);
		session.setAttribute("price", "0");
		response.sendRedirect("Payment.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
