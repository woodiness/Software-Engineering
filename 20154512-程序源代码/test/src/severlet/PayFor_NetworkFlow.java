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
import dao.NetworkFlowDao;
import model.CampusCard;
import model.FinancialService;
import model.NetworkFlow;

/**
 * Servlet implementation class PayFor_NetworkFlow
 */
@WebServlet("/PayFor_NetworkFlow")
public class PayFor_NetworkFlow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayFor_NetworkFlow() {
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
        NetworkFlow user_NF = new NetworkFlow();
        NetworkFlowDao user_NFDao = new NetworkFlowDao();
        user_FS=(FinancialService)session.getAttribute("user_FS");
        user=(CampusCard)session.getAttribute("user");
        String Id = request.getParameter("Id");
        float price_NetworkFlow = Float.valueOf(request.getParameter("price_NetworkFlow"));
        String password = request.getParameter("password");
        int flag_PayFor_NetworkFlow=1;
        if(password.equals(user.getPassword()))
        {
    		try {
				user_NF=user_NFDao.networkFlow(Id);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
			}
    		if(user_NF==null||user_NF.getId()==null)
    			flag_PayFor_NetworkFlow=2;
    		else if(user_FS.getRest()<price_NetworkFlow)
    			flag_PayFor_NetworkFlow=3;
        	else
        	{
        		user_FS.setRest(user_FS.getRest()-price_NetworkFlow);
        		try {
					user_FSDao.update(user_FS);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
				}
        		user_NF.setRestMoney(user_NF.getRestMoney()+price_NetworkFlow);
        		try {
					user_NFDao.update(user_NF);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
				}
        		session.setAttribute("user_NF", user_NF);
        		session.setAttribute("user_FS", user_FS);
        		flag_PayFor_NetworkFlow=5;
        	}
        }
        else
        	flag_PayFor_NetworkFlow=4;  
        session.setAttribute("flag_PayFor_NetworkFlow", flag_PayFor_NetworkFlow);
        session.setAttribute("Payment_pos", "Payment_4");
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
