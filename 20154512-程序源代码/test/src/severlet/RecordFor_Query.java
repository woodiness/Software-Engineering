package severlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CampusCardDao;
import dao.ConsumeRecordDao;
import dao.FinancialServiceDao;
import model.CampusCard;
import model.ConsumeRecord;
import model.FinancialService;

/**
 * Servlet implementation class RecordFor_Query
 */
@WebServlet("/RecordFor_Query")
public class RecordFor_Query extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecordFor_Query() {
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
        ConsumeRecord user_CR=new ConsumeRecord();
        ConsumeRecordDao user_CRDao = new ConsumeRecordDao();
        user=(CampusCard)session.getAttribute("user");
        String datatime_begin = request.getParameter("datatime_begin");
        String datatime_end = request.getParameter("datatime_end");
        String RecordFor_DatatimeBegin=(String)session.getAttribute("RecordFor_DatatimeBegin");
        String RecordFor_DatatimeEnd=(String)session.getAttribute("RecordFor_DatatimeEnd");
        int flag_RecordFor_ConsumeRecord=1;
        List<ConsumeRecord> gs = new ArrayList<ConsumeRecord>();
        List<ConsumeRecord> temp_gs = new ArrayList<ConsumeRecord>();
        try {
			gs=(List<ConsumeRecord>)user_CRDao.consumeRecord(user.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
       /* PrintWriter out = response.getWriter();
        String docType = "<!DOCTYPE html> \n";
        out.println(docType +
                "<html>\n" +
                "<head><title>"  + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<ul>\n" 
                );
        for(int i=0;i<gs.size();i++)
        {
        	out.println("  <li><b>"
                    +  gs.get(i).getTime()+"  "+gs.get(i).getMoney()+" "+gs.get(i).getCardreader_Id()+"<\b>");
        }
        out.println("</ul>\n" +
                "</body></html>");*/
        if(datatime_begin.compareTo(datatime_end)>0)
        {
        	flag_RecordFor_ConsumeRecord=2;
        	session.setAttribute("flag_RecordFor_ConsumeRecord", flag_RecordFor_ConsumeRecord);
            response.sendRedirect("Record.jsp");
        }
        else
        {
        	for(int i=0;i<gs.size();i++)
        	{
        		if(gs.get(i).getTime().compareTo(datatime_begin)>=0&&gs.get(i).getTime().compareTo(datatime_end)<=0)
        			temp_gs.add(gs.get(i));
        	}
        	session.setAttribute("RecordFor_QueryList", temp_gs);
        	
        	flag_RecordFor_ConsumeRecord=3;
        	session.setAttribute("flag_RecordFor_ConsumeRecord", flag_RecordFor_ConsumeRecord);
        	session.setAttribute("Record_pos", "Record_1");
            //response.sendRedirect("Record.jsp");
        	response.sendRedirect("Tables_Record.jsp");
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
