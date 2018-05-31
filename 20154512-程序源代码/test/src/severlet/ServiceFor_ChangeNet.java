package severlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.NetworkFlowDao;
import model.CampusCard;
import model.NetworkFlow;

/**
 * Servlet implementation class ServiceFor_ChangeNet
 */
@WebServlet("/ServiceFor_ChangeNet")
public class ServiceFor_ChangeNet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceFor_ChangeNet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		NetworkFlow user_NF = new NetworkFlow();
		NetworkFlowDao user_NFDao = new NetworkFlowDao();
		CampusCard user = new CampusCard();
        user=(CampusCard)session.getAttribute("user");
        String MonthlyRent=request.getParameter("net");
        try {
			user_NF=(NetworkFlow)user_NFDao.networkFlow(user.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
        user_NF.setMonthlyRent(Integer.valueOf(MonthlyRent).intValue());
        try {
			user_NFDao.update(user_NF);
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
        session.setAttribute("user_NF", user_NF);
        session.setAttribute("Service_pos", "Service_2");
        response.sendRedirect("Service.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
