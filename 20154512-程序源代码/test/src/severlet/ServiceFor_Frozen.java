package severlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BasicInformationDao;
import dao.CampusCardDao;
import dao.FinancialServiceDao;
import model.BasicInformation;
import model.CampusCard;
import model.FinancialService;

/**
 * Servlet implementation class ServiceFor_Frozen
 */
@WebServlet("/ServiceFor_Frozen")
public class ServiceFor_Frozen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceFor_Frozen() {
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
		String question_id = (String) session.getAttribute("question_id");
        String password = request.getParameter("password");
        String answer =new String(request.getParameter("answer").getBytes("ISO8859-1"),"UTF-8");
        String frozen =request.getParameter("frozen");
		CampusCard user = new CampusCard();
        FinancialService user_FS=new FinancialService();
        BasicInformation user_BI=new BasicInformation();
        BasicInformationDao user_BIDao=new BasicInformationDao();
        FinancialServiceDao user_FSDao = new FinancialServiceDao();
        user_FS=(FinancialService) session.getAttribute("user_FS");
        user=(CampusCard)session.getAttribute("user");
        int flag_ServiceFor_Frozen =1;
        if(password.equals(user.getPassword()))
        {
        	try {
				user_BI=(BasicInformation)user_BIDao.basicInformation(user.getId());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
			}
        	if(question_id.equals("0"))
        	{
        		if(answer.equals(user_BI.getGender()))
        		{
        			if(frozen.equals("1"))
        				user_FS.setCondition(true);
        			else 
        				user_FS.setCondition(false);
        			try {
						user_FSDao.update(user_FS);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
					}
        			session.setAttribute("user_FS", user_FS);
        		}else
        		{
        			flag_ServiceFor_Frozen =3;
        		}
        	}
        	else if(question_id.equals("1"))
        	{
        		if(answer.equals(user_BI.getBirth()))
        		{
        			if(frozen.equals("1"))
        				user_FS.setCondition(true);
        			else 
        				user_FS.setCondition(false);
        			try {
						user_FSDao.update(user_FS);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
					}
        			session.setAttribute("user_FS", user_FS);
        		}else
        		{
        			flag_ServiceFor_Frozen =3;
        		}
        	}
        	else if(question_id.equals("2"))
        	{
        		if(answer.equals(user_BI.getAddress()))
        		{
        			if(frozen.equals("1"))
        				user_FS.setCondition(true);
        			else 
        				user_FS.setCondition(false);
        			try {
						user_FSDao.update(user_FS);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
					}
        			session.setAttribute("user_FS", user_FS);
        		}else
        		{
        			flag_ServiceFor_Frozen =3;
        		}
        	}
        	else if(question_id.equals("3"))
        	{
        		if(answer.equals(user_BI.getName()))
        		{
        			if(frozen.equals("1"))
        				user_FS.setCondition(true);
        			else 
        				user_FS.setCondition(false);
        			try {
						user_FSDao.update(user_FS);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
					}
        			session.setAttribute("user_FS", user_FS);
        		}else
        		{
        			flag_ServiceFor_Frozen =3;
        		}
        	}
        	else
        	{
        		flag_ServiceFor_Frozen =4;
        	}
        }
        else 
        	flag_ServiceFor_Frozen =2;
        session.setAttribute("flag_ServiceFor_Frozen", flag_ServiceFor_Frozen);
        session.setAttribute("Service_pos", "Service_3");
        response.sendRedirect("Service.jsp");
        /*PrintWriter out = response.getWriter();
        String docType = "<!DOCTYPE html> \n";
        out.println(docType +
                "<html>\n" +
                "<head><title>"  + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" 
                );
        try {
			user_BI=(BasicInformation)user_BIDao.basicInformation("20154512");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			out.println("<ul>"+"aaaaa"+"</ul>");
	        
		}
        out.println(
                "<ul>123*" +question_id+" "+answer+" * "+user_BI.getAddress());
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
