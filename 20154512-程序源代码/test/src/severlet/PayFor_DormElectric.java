package severlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DormElectricDao;
import dao.FinancialServiceDao;
import model.CampusCard;
import model.DormElectric;
import model.FinancialService;

/**
 * Servlet implementation class PayFor_DormElectric
 */
@WebServlet("/PayFor_DormElectric")
public class PayFor_DormElectric extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayFor_DormElectric() {
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
        FinancialService user_FS=new FinancialService();
        FinancialServiceDao user_FSDao = new FinancialServiceDao();
        DormElectric user_DE = new DormElectric();
        DormElectricDao user_DEDao = new DormElectricDao();
        user_FS=(FinancialService)session.getAttribute("user_FS");
        user=(CampusCard)session.getAttribute("user");
        String DormId = request.getParameter("DormId");
        float price_DormElectric = Float.valueOf(request.getParameter("price_DormElectric"));
        String password = request.getParameter("password");
        int flag_PayFor_Electric=1;
        if(password.equals(user.getPassword()))
        {
    		try {
				user_DE=user_DEDao.dormElectric(DormId);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				/*flag_PayFor_Electric=2;
				session.setAttribute("flag_PayFor_Electric", flag_PayFor_Electric);
		        response.sendRedirect("Payment_DormElectric.jsp");*/
			}
    		if(user_DE==null||user_DE.getDorm_Id()==null)
    			flag_PayFor_Electric=2;
    		else if(user_FS.getRest()<price_DormElectric)
        		flag_PayFor_Electric=3;
        	else
        	{
        		user_FS.setRest(user_FS.getRest()-price_DormElectric);
        		try {
					user_FSDao.update(user_FS);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
				}
        		price_DormElectric=price_DormElectric*2;
        		user_DE.setRest_Elec(user_DE.getRest_Elec()+price_DormElectric);
        		try {
					user_DEDao.update(user_DE);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
				}
        		session.setAttribute("user_DE", user_DE);
        		session.setAttribute("user_FS", user_FS);
        		flag_PayFor_Electric=5;
        	}
        }
        else
        	flag_PayFor_Electric=4;  
        session.setAttribute("flag_PayFor_Electric", flag_PayFor_Electric);
        session.setAttribute("Payment_pos", "Payment_3");
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
