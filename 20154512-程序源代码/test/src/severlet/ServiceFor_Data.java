package severlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ConsumeRecordDao;
import dao.FinancialServiceDao;
import dao.NetworkFlowDao;
import model.CampusCard;
import model.FinancialService;
import model.NetworkFlow;

/**
 * Servlet implementation class ServiceFor_Data
 */
@WebServlet("/ServiceFor_Data")
public class ServiceFor_Data extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceFor_Data() {
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
        try {
			user_NF=(NetworkFlow)user_NFDao.networkFlow(user.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
        session.setAttribute("user_NF", user_NF);
        session.setAttribute("Service_pos", "Service_1");
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
