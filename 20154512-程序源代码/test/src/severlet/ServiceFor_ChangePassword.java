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
import model.CampusCard;

/**
 * Servlet implementation class ServiceFor_ChangePassword
 */
@WebServlet("/ServiceFor_ChangePassword")
public class ServiceFor_ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceFor_ChangePassword() {
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
        user=(CampusCard)session.getAttribute("user");
        String new_password1 = request.getParameter("new_password1");
        String new_password2 = request.getParameter("new_password2");
        String old_password = request.getParameter("old_password");
        int flag_ServiceFor_ChangePassword=1;
        if(old_password.equals(user.getPassword()))
        {
        	if(new_password1.compareTo(new_password2)!=0)
        		flag_ServiceFor_ChangePassword=3;
        	else
        	{
        		flag_ServiceFor_ChangePassword=4;
        		user.setPassword(new_password1);
        		try {
					userDao.update(user);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
				}
        		session.setAttribute("user", user);
        	}
        }
        else
        	flag_ServiceFor_ChangePassword=2;    
        session.setAttribute("flag_ServiceFor_ChangePassword", flag_ServiceFor_ChangePassword);
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
