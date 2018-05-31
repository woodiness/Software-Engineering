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
	<%for(int i=0;i<len_list;i++){%>
		{"C_id":"<%=RecordFor_QueryList.get(i).getId()%>",
		"C_cardreader_id":"<%=RecordFor_QueryList.get(i).getCardreader_Id()%>",
		"C_money":"<%=RecordFor_QueryList.get(i).getMoney()%>",
		"C_time":"<%=RecordFor_QueryList.get(i).getTime()%>"}
	<%if(i+1<len_list){%>
		, 
	<%}%>
	<%}%>
	]
</script>
<div id="histroyBox"></div>

<script type="text/javascript">
				    //前台分页的样子
				    $('#histroyBox').CJJTable({
				       'title':["学号","消费窗口","消费金额","消费日期"],//thead中的标题 必填
				       'body':["C_id","C_cardreader_id","C_money","C_time"],//tbody td 取值的字段 必填
				       'display':[1,1,1,1],//隐藏域，1显示，2隐藏 必填
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




























