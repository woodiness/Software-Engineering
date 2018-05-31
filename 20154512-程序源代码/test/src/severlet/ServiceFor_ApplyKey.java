package severlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DormKeyDao;
import model.DormKey;

/**
 * Servlet implementation class ServiceFor_ApplyKey
 */
@WebServlet("/ServiceFor_ApplyKey")
public class ServiceFor_ApplyKey extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceFor_ApplyKey() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#destroy()
	 */
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		DormKey user_DK=new DormKey();
		DormKeyDao user_DKDao=new DormKeyDao();
        String region = request.getParameter("region");
        int flag_ServiceFor_ApplyKey=1;
        try {
			user_DK=(DormKey)user_DKDao.dormKey(region);
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
        if(user_DK==null||user_DK.getDorm()==null)
        {
        	flag_ServiceFor_ApplyKey=2;
        }
        else
        {
        	flag_ServiceFor_ApplyKey=3;
        	session.setAttribute("user_DK", user_DK);
        }
        session.setAttribute("flag_ServiceFor_ApplyKey", flag_ServiceFor_ApplyKey);
        session.setAttribute("Service_pos", "Service_4");
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
