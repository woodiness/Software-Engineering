package severlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DormKeyDao;
import model.DormKey;

/**
 * Servlet implementation class ServiceFor_UpdateKey
 */
@WebServlet("/ServiceFor_UpdateKey")
public class ServiceFor_UpdateKey extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceFor_UpdateKey() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		DormKey user_DK=new DormKey();
		DormKeyDao user_DKDao=new DormKeyDao();
		int flag_ServiceFor_ApplyKey=1;
        user_DK=(DormKey)session.getAttribute("user_DK");
        int temp_key=(int)(Math.random()*8000);
        user_DK.setKey(temp_key);
        try {
			user_DKDao.update(user_DK);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
        session.setAttribute("user_DK", user_DK);
        session.setAttribute("flag_ServiceFor_ApplyKey", flag_ServiceFor_ApplyKey);
        session.setAttribute("Service_pos", "Service_4");
    	response.sendRedirect("Service.jsp");
       /* PrintWriter out = response.getWriter();
        String docType = "<!DOCTYPE html> \n";
        out.println(docType +
                "<html>\n" +
                "<head><title>"  + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" 
                );
        out.println(
                "<ul>"+" * "+user_DK.getKey()+" * * "+temp_key);
        out.println("</ul>\n" +
                "</body></html>");*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
