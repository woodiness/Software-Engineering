package severlet;

import java.io.IOException;
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
 * Servlet implementation class CheckUser
 */
@WebServlet("/CheckUser")
public class CheckUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
        String password = request.getParameter("password");
		CampusCard user = new CampusCard();
        CampusCardDao userDao= new CampusCardDao();
        FinancialService user_FS=new FinancialService();
        FinancialServiceDao user_FSDao = new FinancialServiceDao();
        String Payment_pos="Payment_1";
        int flag_Login=1;
        try {
			user=userDao.campusCard(username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
        if(user==null)
        {
        	flag_Login=2;
        	session.setAttribute("flag_Login", flag_Login);
        	response.sendRedirect("login.jsp");
		}
        else if(user.getPassword().equals(password))
        {
        	flag_Login=1;
        	session.setAttribute("flag_Login", flag_Login);
        	session.setAttribute("user", user);
        	session.setAttribute("Payment_pos", Payment_pos);
        	try {
				user_FS=user_FSDao.financialService(username);
			} catch (Exception e) {
				// TODO Auto-generated catch block
			}
        	session.setAttribute("user_FS", user_FS);
            response.sendRedirect("Payment.jsp");
        }
        else 
        {
        	flag_Login=0;
        	session.setAttribute("flag_Login", flag_Login);
        	response.sendRedirect("login.jsp");
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
