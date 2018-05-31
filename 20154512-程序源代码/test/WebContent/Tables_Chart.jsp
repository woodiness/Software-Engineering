<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.CampusCard" %>
<%@ page import="model.ConsumeRecord" %>
<%@page import="java.util.*" %>
<%@ page import="model.Analysis" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>悦·享生活</title>
	
	<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
	<!-- <script type="text/javascript" src="js/back-endPage.js"></script> --> <!-- 后台分页 -->
    <script type="text/javascript" src="js/front-endPage.js"></script><!-- 前台分页 -->
	
	<link rel="stylesheet" type="text/css" href="css/table.css">
	<style type="text/css">
	*{margin:0;padding:0;list-style-type:none;}
	a,img{border:0;}
	body{font:12px/180% Arial, Helvetica, sans-serif, "新宋体";}
	/* holder */
	#holder{margin:-350px 0 0 -350px;width:700px;height:700px;position:absolute;left:50%;top:50%;}
	</style>
	<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="js/raphael-min.js"></script>
	<script type="text/javascript" src="js/script_chart.js"></script>
</head>


<body>
<%
	CampusCard user = (CampusCard)session.getAttribute("user"); 
	String RecordFor_DatatimeBegin=(String)session.getAttribute("RecordFor_DatatimeBegin");
    String RecordFor_DatatimeEnd=(String)session.getAttribute("RecordFor_DatatimeEnd");
    List<ConsumeRecord> RecordFor_QueryList = new ArrayList<ConsumeRecord>();
    ConsumeRecord temp_CR=new ConsumeRecord();
	int flag_RecordFor_ConsumeRecord =1;
	try {
		flag_RecordFor_ConsumeRecord = (int)session.getAttribute("flag_RecordFor_ConsumeRecord");
	}catch (Exception e) {
		// TODO Auto-generated catch block
	}
	try {
		RecordFor_QueryList= (List<ConsumeRecord>) session.getAttribute("RecordFor_QueryList");
	}catch (Exception e) {
		// TODO Auto-generated catch block
	}
	int len_list=0;
	try {
		len_list=RecordFor_QueryList.size();
	}catch (Exception e) {
		// TODO Auto-generated catch block
	}
	int flag_RecordFor_Analysis =1;
	try {
		flag_RecordFor_Analysis = (int)session.getAttribute("flag_RecordFor_Analysis");
	}catch (Exception e) {
		// TODO Auto-generated catch block
	}
    Analysis[] aList = new Analysis[15];
	try {
		aList= (Analysis[]) session.getAttribute("RecordFor_AnalysisList");
	}catch (Exception e) {
		// TODO Auto-generated catch block
	}
%>
<script>
var data = [ 
	<%for(int i=0;i<4;i++){%>
		{
		"cardreader_name"<%=aList[i].cardreader_name()%>",
		"number":"<%=aList[i].number()%>",
		"percent_frequency":"<%=aList[i].percent_frequency() %>%",
		"money":"<%=aList[i].money() %>",
		"percent_money":"<%=aList[i].percent_money() %>%"}
	<%if(i+1<len_list){%>
		, 
	<%}%>
	<%}%>
	]
</script>
<div id="histroyBox"></div>
				<table>
					<tbody>
						<%for(int i=0;i<4;i++){ %>
							<tr>
								<th scope="row"><%=aList[i].cardreader_name() %>:<%=aList[i].percent_frequency() %>%</th>
								<td><%=aList[i].percent_frequency() %>%</td>
							</tr>
						<%} %>
					</tbody>
				</table>
				<div id="holder"></div>
<script type="text/javascript">
				    //前台分页的样子
				    $('#histroyBox').CJJTable({
				       'title':["窗口类型","消费次数","消费次数比例","消费金额","消费金额比例"],//thead中的标题 必填
				       'body':["cardreader_name","number","percent_frequency","money","percent_money"],//tbody td 取值的字段 必填
				       'display':[1,1,1,1,1],//隐藏域，1显示，2隐藏 必填
				       'pageNUmber':10,//每页显示的条数 选填
				       'pageLength':data.length,//选填
				       'url':data,//数据源 必填
				       dbTrclick:function(e){//双击tr事件
				        alert(e.find('.C_time').html())
				       }
				    });
				</script>
				
<p><a href="Record.jsp">返回 悦·享生活</a></p>

</body>
</html>




























