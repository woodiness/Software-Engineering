package severlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CampusCardDao;
import dao.FinancialServiceDao;
import model.CampusCard;
import model.FinancialService;

/**
 * Servlet implementation class PayFor_WaterFee
 */
@WebServlet("/PayFor_WaterFee")
public class PayFor_WaterFee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayFor_WaterFee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		CampusCard user = new CampusCard();
        CampusCardDao userDao= new CampusCardDao();
        FinancialService user_FS=new FinancialService();
        FinancialServiceDao user_FSDao = new FinancialServiceDao();
        user_FS=(FinancialService)session.getAttribute("user_FS");
        user=(CampusCard)session.getAttribute("user");
        float price_WaterFee = Float.valueOf(request.getParameter("price_WaterFee"));
        String password = request.getParameter("password");
        int flag_PayFor_WaterFee=1;
        if(password.equals(user.getPassword()))
        {
        	if(user_FS.getRest()<price_WaterFee)
        		flag_PayFor_WaterFee=2;
        	else if(price_WaterFee+user.getWaterFee()>10.00)
        		flag_PayFor_WaterFee=3;
        	else
        	{
        		user_FS.setRest(user_FS.getRest()-price_WaterFee);
        		try {
					user_FSDao.update(user_FS);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					flag_PayFor_WaterFee=5;
				}
        		user.setWaterFee(user.getWaterFee()+price_WaterFee);
        		try {
					userDao.update(user);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
				}
        		session.setAttribute("user", user);
        		session.setAttribute("user_FS", user_FS);
        	}
        }
        else
        	flag_PayFor_WaterFee=4;    
        session.setAttribute("flag_PayFor_WaterFee", flag_PayFor_WaterFee);
        session.setAttribute("Payment_pos", "Payment_2");
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
