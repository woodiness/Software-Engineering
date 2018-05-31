package severlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CardReaderDao;
import dao.ConsumeRecordDao;
import model.Analysis;
import model.CampusCard;
import model.CardReader;
import model.ConsumeRecord;
import model.Suggestion;

/**
 * Servlet implementation class RecordFor_Analysis
 */
@WebServlet("/RecordFor_Analysis")
public class RecordFor_Analysis extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecordFor_Analysis() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		response.setContentType("text/html;charset=UTF-8");
		CampusCard user = new CampusCard();
        ConsumeRecord user_CR=new ConsumeRecord();
        ConsumeRecordDao user_CRDao = new ConsumeRecordDao();
        CardReader user_CardR = new CardReader();
        CardReaderDao user_CardRDao=new CardReaderDao();
        user=(CampusCard)session.getAttribute("user");
        String datatime_begin = request.getParameter("datatime_begin");
        String datatime_end = request.getParameter("datatime_end");
        String RecordFor_DatatimeBegin=(String)session.getAttribute("RecordFor_DatatimeBegin");
        String RecordFor_DatatimeEnd=(String)session.getAttribute("RecordFor_DatatimeEnd");
        int flag_RecordFor_Analysis=1;
        List<ConsumeRecord> list_ConsumeRecord = new ArrayList<ConsumeRecord>();
        List<CardReader> list_CardReader = new ArrayList<CardReader>();
        Map<String, Integer> map_id_to_pos = new HashMap<String, Integer>();
        Map<String, Integer> map_category_to_pos = new HashMap<String, Integer>();
        float cnt_money=0;
        float cnt_number=0;
        Analysis[] aList = new Analysis[50];
        Suggestion[] Sugg = new Suggestion[50];
        Sugg[0]=new Suggestion();
        Sugg[0].set_category("肉类");
        Sugg[0].set_Suggestion_1("多吃点肉，吃肉可以提高免疫力");
        Sugg[0].set_Suggestion_2("适当少吃些肉，鱼肉、鸡蛋和豆类也能补充蛋白质呢");
        Sugg[0].set_Suggestion_3("少吃肉，虽然我们年轻，但也要预防“三高”哦");
        Sugg[0].set_percent_1((float)5);
        Sugg[0].set_percent_2((float)20);
        Sugg[0].set_percent_3((float)50);
        Sugg[1]=new Suggestion();
        Sugg[1].set_category("蔬菜类");
        Sugg[1].set_Suggestion_1("要多吃蔬菜，记得补充维生素");
        Sugg[1].set_Suggestion_2("可以适量少吃些蔬菜，要吃肉，吃肉才可以变得强壮");
        Sugg[1].set_Suggestion_3("要变成兔子啦，该多吃主食和肉了");
        Sugg[1].set_percent_1((float)40);
        Sugg[1].set_percent_2((float)60);
        Sugg[1].set_percent_3((float)80);
        Sugg[2]=new Suggestion();
        Sugg[2].set_category("豆类");
        Sugg[2].set_Suggestion_1("要多吃豆类，豆类可是含有很高的营养哦");
        Sugg[2].set_Suggestion_2("少吃豆类，豆类含有很高的胆固醇呢，记得鸡蛋和豆浆不能一起吃哦");
        Sugg[2].set_Suggestion_3("少吃豆类，豆类含有很高的胆固醇呢，记得鸡蛋和豆浆不能一起吃哦");
        Sugg[2].set_percent_1((float)5);
        Sugg[2].set_percent_2((float)30);
        Sugg[2].set_percent_3((float)30);
        Sugg[3]=new Suggestion();
        Sugg[3].set_category("主食");
        Sugg[3].set_Suggestion_1("多吃主食，糖类是生长发育必不可少的营养");
        Sugg[3].set_Suggestion_2("适当减少主食摄入，身体还需要其他的营养元素哟");
        Sugg[3].set_Suggestion_3("要少吃主食，不能只吃饭不吃菜");
        Sugg[3].set_percent_1((float)30);
        Sugg[3].set_percent_2((float)50);
        Sugg[3].set_percent_3((float)80);
        map_id_to_pos.put("肉类",0);
        map_id_to_pos.put("蔬菜类",1);
        map_id_to_pos.put("豆类",2);
        map_id_to_pos.put("主食",3);
        try {
        	list_ConsumeRecord=(List<ConsumeRecord>)user_CRDao.consumeRecord(user.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
        try {
        	list_CardReader=(List<CardReader>) user_CardRDao.cardReaders();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
        if(datatime_begin.compareTo(datatime_end)>0)
        {
        	flag_RecordFor_Analysis=2;
        	session.setAttribute("flag_RecordFor_Analysis", flag_RecordFor_Analysis);
            response.sendRedirect("Record.jsp");
        }
        else
        {
        	for(int i=0;i<list_CardReader.size();i++)
        	{
        		aList[i]=new Analysis();
        		aList[i].set_cardreader_Id(list_CardReader.get(i).getId());
        		aList[i].set_cardreader_name(list_CardReader.get(i).getCategory());
        		aList[i].set_percent_frequency(0);
        		aList[i].set_percent_money(0);
        		aList[i].set_number(0);
        		aList[i].set_money(0);
        		aList[i].set_suggestion("nothing");
        		map_id_to_pos.put(list_CardReader.get(i).getId(),i);
        	}
        	for(int i=0;i<list_ConsumeRecord.size();i++)
        	{
        		if(list_ConsumeRecord.get(i).getId().equals("5"))
        		{
        			continue;
        		}
        		else if(list_ConsumeRecord.get(i).getTime().compareTo(datatime_begin)>=0&&list_ConsumeRecord.get(i).getTime().compareTo(datatime_end)<=0)
        		{
        			aList[map_id_to_pos.get(list_ConsumeRecord.get(i).getCardreader_Id())].OnePlus(list_ConsumeRecord.get(i).getMoney());
        			cnt_money+=list_ConsumeRecord.get(i).getMoney();
        			cnt_number++;
        		}
        	}
        	for(int i=0;i<list_CardReader.size();i++)
        	{
        		aList[i].set_percent_frequency((float)100*aList[i].number()/cnt_number);
        		aList[i].set_percent_money((float)100*aList[i].money()/cnt_money);
        		if(aList[i].getcardreader_Id().equals("5"))
        			continue;
        		else
        		{
        			int j=map_id_to_pos.get(aList[i].cardreader_name());
            		if(aList[i].percent_frequency()>Sugg[j].get_percent_3())
            		{
            			aList[i].set_suggestion(Sugg[j].get_Suggestion_3());
            		}
            		else if(aList[i].percent_frequency()>Sugg[j].get_percent_2())
            		{
            			aList[i].set_suggestion(Sugg[j].get_Suggestion_2());
            		}
            		else if(aList[i].percent_frequency()<Sugg[j].get_percent_1())
            		{
            			aList[i].set_suggestion(Sugg[j].get_Suggestion_1());
            		}
        		}

        	}
        	session.setAttribute("RecordFor_AnalysisList", aList);
        	session.setAttribute("Record_pos", "Record_2");
        	flag_RecordFor_Analysis=3;
        	session.setAttribute("flag_RecordFor_Analysis", flag_RecordFor_Analysis);
            response.sendRedirect("Record.jsp");
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
