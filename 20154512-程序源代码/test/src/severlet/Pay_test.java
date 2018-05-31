package severlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pay.MD5;

/**
 * Servlet implementation class Pay_test
 */
@WebServlet("/Pay_test")
public class Pay_test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pay_test() {
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
		String price =new String(request.getParameter("price").getBytes("ISO8859-1"),"UTF-8");
		int record_id=(int)(Math.random()*10000);
		String uid="4fb6cd91deaa54e56ee72a75";
		String istype=new String(request.getParameter("istype").getBytes("ISO8859-1"),"UTF-8");
		String notify_url="http://118.89.248.160:8080/test_end/Pay_yes";
		String return_url="http://118.89.248.160:8080/test_end/Pay_yes";
		String orderid=String.valueOf(record_id);
		String orderuid="";
		String goodsname="";
		String token="bf1e63aa4a7cdc1f4b8886c1782909b7";
		String key="";
		key=goodsname + istype + notify_url + orderid + orderuid + price + return_url + token + uid;
		MD5 test=new MD5();
		key=MD5.encryption(key);
		session.setAttribute("istype", istype);
		session.setAttribute("price", price);
		session.setAttribute("record_id", orderid);
		session.setAttribute("key", key);
		response.sendRedirect("Payment.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
