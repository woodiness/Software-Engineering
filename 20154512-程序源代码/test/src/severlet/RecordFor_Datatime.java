package severlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ConsumeRecordDao;
import model.CampusCard;
import model.ConsumeRecord;

/**
 * Servlet implementation class RecordFor_Datatime
 */
@WebServlet("/RecordFor_Datatime")
public class RecordFor_Datatime extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecordFor_Datatime() {
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
        ConsumeRecordDao user_CRDao = new ConsumeRecordDao();
        user=(CampusCard)session.getAttribute("user");
        List<ConsumeRecord> gs = new ArrayList<ConsumeRecord>();
        try {
			gs=(List<ConsumeRecord>)user_CRDao.consumeRecord(user.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
        String RecordFor_DatatimeBegin=null;
        String RecordFor_DatatimeEnd=null;
        if(gs.size()!=0)
        {
        	RecordFor_DatatimeBegin=gs.get(0).getTime();
        	RecordFor_DatatimeEnd=gs.get(gs.size()-1).getTime();
        	session.setAttribute("RecordFor_DatatimeBegin", RecordFor_DatatimeBegin);
        	session.setAttribute("RecordFor_DatatimeEnd", RecordFor_DatatimeEnd);
        }
        response.sendRedirect("Record.jsp");
        /*PrintWriter out = response.getWriter();
        String docType = "<!DOCTYPE html> \n";
        out.println(docType +
                "<html>\n" +
                "<head><title>"  + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<ul>\n" +RecordFor_DatatimeBegin+"  "+RecordFor_DatatimeEnd
                );
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
