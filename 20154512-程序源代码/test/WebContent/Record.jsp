<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.CampusCard" %>
<%@ page import="model.ConsumeRecord" %>
<%@page import="java.util.*" %>
<%@ page import="model.Analysis" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>悦·享生活</title>

        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="apple-touch-icon" href="apple-touch-icon.png">

        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="css/fontAwesome.css">
        <link rel="stylesheet" href="css/light-box.css">
        <link rel="stylesheet" href="css/templatemo-main.css">
		<link href="css/templatemo_style.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css" /> 
		<link rel="stylesheet" type="text/css" href="css/Untitled-1.css" media="screen" />


        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800" rel="stylesheet">

        <script src="js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
        <style type="text/css">
<!--
.STYLE1 {font-family: "华文行楷"}
.STYLE2 {color: #3399CC}
-->
        </style>


    <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.11.2.min.js"><\/script>')</script>
    <script src="js/vendor/bootstrap.min.js"></script>
    <script src="js/datepicker.js"></script>  
    <script src="js/main.js"></script>
    <script src="js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript">
    $(document).ready(function() {
        // navigation click actions 
        $('.scroll-link').on('click', function(event){
            event.preventDefault();
            var sectionID = $(this).attr("data-id");
            scrollToID('#' + sectionID, 750);
        });
        // scroll to top action
        $('.scroll-top').on('click', function(event) {
            event.preventDefault();
            $('html, body').animate({scrollTop:0}, 'slow');         
        });
        // mobile nav toggle
        $('#nav-toggle').on('click', function (event) {
            event.preventDefault();
            $('#main-nav').toggleClass("open");
        });
    });
    // scroll function
    function scrollToID(id, speed){
        var offSet = 0;
        var targetOffset = $(id).offset().top - offSet;
        var mainNav = $('#main-nav');
        $('html,body').animate({scrollTop:targetOffset}, speed);
        if (mainNav.hasClass("open")) {
            mainNav.css("height", "1px").removeClass("in").addClass("collapse");
            mainNav.removeClass("open");
        }
    }
    if (typeof console === "undefined") {
        console = {
            log: function() { }
        }; 
    }
    </script> 
</head>

<body>
<%String Record_pos="Record_1"; 
Record_pos=(String)session.getAttribute("Record_pos");
%>
<script>
jQuery(function($) {
    $(<%=Record_pos%>)[0].click();
});
</script>
<%
	CampusCard user = (CampusCard)session.getAttribute("user"); 
	String RecordFor_DatatimeBegin=(String)session.getAttribute("RecordFor_DatatimeBegin");
    String RecordFor_DatatimeEnd=(String)session.getAttribute("RecordFor_DatatimeEnd");
    List<ConsumeRecord> RecordFor_QueryList = new ArrayList<ConsumeRecord>();
    ConsumeRecord temp_CR=new ConsumeRecord();
	int flag_RecordFor_ConsumeRecord =1;
	int num_sug=4;
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
	<%if(len_list>0){%>
	
	<%}%>
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

 <div class="container_12">
        <div class="grid_12">
            <div id="branding">
                
               <div class="floatright">
                    <div class="floatleft">
                       <!-- <img src="img/img-profile.jpg" alt="Profile Pic" /> --> </div>
                    <div class="floatleft marginleft10">
                        <ul class="inline-ul floatleft">
                            <li>欢迎，<%=user.getId() %></li>
                            <li><a href="login.jsp" class="STYLE2">退出</a></li>
                        </ul>
                        <br />
                 </div>
              </div>   
            </div>
        </div>  
    </div>
    
   <div class="sequence">
  
      <div class="seq-preloader">
        <svg width="39" height="16" viewBox="0 0 39 16" xmlns="http://www.w3.org/2000/svg" class="seq-preload-indicator"><g fill="#F96D38"><path class="seq-preload-circle seq-preload-circle-1" d="M3.999 12.012c2.209 0 3.999-1.791 3.999-3.999s-1.79-3.999-3.999-3.999-3.999 1.791-3.999 3.999 1.79 3.999 3.999 3.999z"/><path class="seq-preload-circle seq-preload-circle-2" d="M15.996 13.468c3.018 0 5.465-2.447 5.465-5.466 0-3.018-2.447-5.465-5.465-5.465-3.019 0-5.466 2.447-5.466 5.465 0 3.019 2.447 5.466 5.466 5.466z"/><path class="seq-preload-circle seq-preload-circle-3" d="M31.322 15.334c4.049 0 7.332-3.282 7.332-7.332 0-4.049-3.282-7.332-7.332-7.332s-7.332 3.283-7.332 7.332c0 4.05 3.283 7.332 7.332 7.332z"/></g></svg>
      </div>  
    </div>
	
	
    
  <div id="templatemo_wrapper">

	<div id="templatemo_header">
	
	<div id="site_title"><h1 class="STYLE1">“享悦”生活系统</h1></div>
  
        <div id="templatemo_menu" class="ddsmoothmenu">
            <ul>
                <li><a href="Payment.jsp" >生活缴费</a></li>
                <li><a href="RecordFor_Datatime" class="selected">消费查询</a></li>
                <li><a href="ServiceFor_Data">生活服务</a>  </li>
            </ul>
            <br style="clear: left" />
        </div> <!-- end of templatemo_menu -->
       <div class="cleaner"></div>
    </div> 
   </div>
	

       <nav>
          <ul>
            <li><a id="Record_1" href="#1"><i class="fa fa-search"></i> <em>消费流水查询</em></a></li>
            <li><a id="Record_2" href="#3"><i class="fa fa-cutlery"></i> <em>饮食消费分析</em></a></li>
          </ul>
        </nav>
        
        <div class="slides">
          <div class="slide" id="1">
           <div class="content">
		   <div class="third-content">
               <p>消费流水查询：可以查询距今<span style="color:#FF3333;">一个月内</span>的消费流水</p>
				<span style="font-size:13px;color:#666666">时间输入格式为："yyyy-MM-dd HH:mm:ss"（例如：1996-11-07 13:00:32）,符号均为英文字符</span><br><br>
				<p>您的消费流水记录的时间区间为：<br><%=RecordFor_DatatimeBegin %>~<%=RecordFor_DatatimeEnd %> </p>
				<form action="RecordFor_Query" method="post">
				    <span class="normal-font">消费流水开始时间:</span><input type="text"  name="datatime_begin"><br><br>
				     <span class="normal-font">消费流水结束时间:</span><input type="text"  name="datatime_end"><br><br>
				    	    <div style="text-align:right;"><input style="font-size:15px;padding:10px 30px 10px 30px;" type="submit" value="查询"></div><br><br>
				</form> 
				<%if(flag_RecordFor_ConsumeRecord==2){ %>
						消费流水开始时间与结束时间可能颠倒，重新输入！<br>
				<%}%>  
				</div>
            </div> 
          </div>
		  
          <div class="slide" id="2">
            <div class="content second-content">
               
            </div>
          </div>
          
          <div class="slide" id="3">
            <div class="content">
			<div class="third-content">
               <p>饮食消费分析：可以分析距今<span style="color:#FF3333;">一个月内</span>的食堂饮食消费情况</p>
			<span style="font-size:13px;color:#666666">时间输入格式为："yyyy-MM-dd HH:mm:ss"（例如：1996-11-07 13:00:32）,符号均为英文字符</span><br><br>
				<p>您的消费流水记录的时间区间为：<br><%=RecordFor_DatatimeBegin %>~<%=RecordFor_DatatimeEnd %> </p>
				<form action="RecordFor_Analysis" method="post">
				     <span class="normal-font">消费流水开始时间:</span><input type="text"  name="datatime_begin"><br><br>
				     <span class="normal-font">消费流水结束时间:</span><input type="text"  name="datatime_end"><br><br>
			<div style="text-align:right;"><input style="font-size:15px;padding:10px 30px 10px 30px;" type="submit" value="分析"></div><br><br>
				</form>
				<%if(flag_RecordFor_Analysis==2){ %>
				消费流水开始时间与结束时间可能颠倒，重新输入！<br>
				<%}else if(flag_RecordFor_Analysis==3){ %>
				<%for(int i=0;i<4;i++){ %>
								<p><%=aList[i].cardreader_name() %>:<%=aList[i].percent_frequency() %>%</p>
						<%} %>
				<p><a href="Tables_Chart.jsp"><span style="color:#FF3333;">查看饼状图</span></a></p>
				
				<p>饮食建议<br>        
					<%for(int i=0;i<4;i++)
					{
						if(aList[i].getsuggestion().equals("nothing"))
						{num_sug--;continue;}
						else{%>
					
					 <%=aList[i].getsuggestion() %><br>
						<%} %>
					<%} %>
						
				<%}else if(num_sug==0){ %>
					饮食习惯良好，继续保持~<br>
				<%} %>
				 </p>
				</div>
            </div>
          </div>

        </div> 
</body>
</html>




























