<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.CampusCard" %>
<%@ page import="dao.CampusCardDao" %>
<%@ page import="model.CampusCard" %>
<%@ page import="model.DormElectric"%>
<%@ page import="model.NetworkFlow" %>
<%@ page import="model.FinancialService" %>
<%@ page import="dao.FinancialServiceDao" %>
<%@page import="pay.MD5" %>
<%@page import="java.util.*" %>
<%@ page import="model.DormKey" %>
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
    
    <!-- <script src="js/datepicker.js"></script>
    <script src="js/plugins.js"></script>
    <script src="js/main.js"></script> -->
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
<%String Service_pos="Service_1"; 
Service_pos=(String)session.getAttribute("Service_pos");
%>
<script>
jQuery(function($) {
    $(<%=Service_pos%>)[0].click();
});
</script>
<%
	CampusCard user = (CampusCard)session.getAttribute("user"); 
	CampusCardDao userDao = new CampusCardDao();
	int flag_ServiceFor_ChangePassword =1;
	try {
		flag_ServiceFor_ChangePassword = (int)session.getAttribute("flag_ServiceFor_ChangePassword");
	}catch (Exception e) {
		// TODO Auto-generated catch block
	}
	NetworkFlow user_NF =(NetworkFlow)session.getAttribute("user_NF");
	int flag_PayFor_WaterFee =1;
	try {
		flag_PayFor_WaterFee = (int)session.getAttribute("flag_PayFor_WaterFee");
	}catch (Exception e) {
		// TODO Auto-generated catch block
	}
	try {
		user_NF = (NetworkFlow)session.getAttribute("user_NF");
	}catch (Exception e) {
		// TODO Auto-generated catch block
	}
	FinancialService user_FS = (FinancialService)session.getAttribute("user_FS");
	int question_id=(int)(Math.random()*4);
	String str_question_id=question_id+"";
	session.setAttribute("question_id", str_question_id);
	int flag_ServiceFor_Frozen =1;
	try {
		flag_ServiceFor_Frozen = (int)session.getAttribute("flag_ServiceFor_Frozen");
	}catch (Exception e) {
		// TODO Auto-generated catch block
	}
	DormKey user_DK=new DormKey();
	int flag_ServiceFor_ApplyKey =1;
	try {
		flag_ServiceFor_ApplyKey = (int)session.getAttribute("flag_ServiceFor_ApplyKey");
	}catch (Exception e) {
		// TODO Auto-generated catch block
	}
	try {
		user_DK = (DormKey)session.getAttribute("user_DK");
	}catch (Exception e) {
		// TODO Auto-generated catch block
	}
%>
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
                <li><a href="RecordFor_Datatime">消费查询</a></li>
                <li><a href="ServiceFor_Data" class="selected">生活服务</a>  </li>
            </ul>
            <br style="clear: left" />
        </div> <!-- end of templatemo_menu -->
       <div class="cleaner"></div>
    </div> 
   </div>
	

       <nav>
          <ul>
            <li><a id="Service_1" href="#1"><i class="fa fa-pencil"></i> <em>修改消费密码</em></a></li>
			<li><a id="Service_2" href="#2"><i class="fa fa-wrench"></i> <em>修改网费套餐</em></a></li>
			<li><a id="Service_3" href="#3"><i class="fa fa-lock"></i> <em>校卡冻结/解冻</em></a></li>
            <li><a id="Service_4" href="#4"><i class="fa fa-bell"></i> <em>申请门禁密钥</em></a></li>
          </ul>
        </nav>
        
        <div class="slides">
          <div class="slide" id="1">
           <div class="content">
		   <div class="first-content">
		   <form action="ServiceFor_ChangePassword" method="post">
		   			<br>
					<br>
				    <span class="normal-font">旧消费密码:</span> <input type="text"  name="old_password"><br><br>
				     <span class="normal-font">新消费密码:</span> <input type="text"  name="new_password1"><br><br>
		     	     <span class="normal-font">重复新密码:</span> <input type="text"  name="new_password2"><br><br><br>
			<div style="text-align:right;"><input style="font-size:15px;padding:10px 30px 10px 30px;" type="submit" value="确认修改"></div><br><br>
				    </form>
					</div>
              		<%if(flag_ServiceFor_ChangePassword==2){ %>
						旧消费密码错误！<br>
					<%}else if(flag_ServiceFor_ChangePassword==3){ %>
						两次新消费密码不同！<br>
					<%}else if(flag_ServiceFor_ChangePassword==4){ %>
						修改成功！<br>
					<%}else{ %>
						<br>
					<%}%>
            </div> 
          </div>
		  
          <div class="slide" id="2">
            <div class="content">
			<div class="third-content">
                <p><span class="big-font">账户：<%=user_NF.getId() %></span></p>
				<span class="normal-font">网络套餐月租：<%=user_NF.getMonthlyRent() %>￥（月租费用于月初扣除）</span><br><br>
				<span class="normal-font">本月已用流量：<%=user_NF.getCurrentFlow() %> </span><br><br>
				<span class="normal-font">当前账户余额：<%=user_NF.getRestMoney() %>￥&nbsp;&nbsp;&nbsp;（余额小于等于0￥，上网账户冻结）</span><br><br>
				<span class="normal-font">请选择套餐：</span><br><br>
				<form action="ServiceFor_ChangeNet" method="post">
					<span class="normal-font"><input type="radio" name="net" value="15">15元30G</span><br>
					<span class="normal-font"><input type="radio" name="net" value="20">20元60G</span><br>
		<div style="text-align:right;"><input style="font-size:15px;padding:10px 30px 10px 30px;" type="submit" value="确认修改"></div><br><br>
				</form>
				</div>
            </div>
          </div>
          
          <div class="slide" id="3">
            <div class="content">
			<div class="third-content">
               <p><span class="big-font">账户：<%=user_FS.getId() %></span>
					<%if(user_FS.isCondition()==true){ %> 
						<span class="big-font">（未冻结）</span> 
					<%}else{ %> 
						<span class="big-font" style="color:#FF3333;">（冻结）</span>
					<%} %>   
				</p>
				<form action="ServiceFor_Frozen" method="post">
					<span class="normal-font">状态：</span>
					<input type="radio" name="frozen" value="0"><span class="normal-font">冻结</span>
					<input type="radio" name="frozen" value="1"><span class="normal-font">解冻</span><br><br>
					<p>消费密码: <input type="text"  name="password">
					<br><br>
					请&nbsp;回&nbsp;答:
					<%if(question_id==0) {%> 
					您的性别？(格式：男/女)
					<%}else if(question_id==1){%>
					您的出生日期？（格式：1996-11-07）
					<%}else if(question_id==2){%>
					您的籍贯？（格式：河北省邯郸市）
					<%}else if(question_id==3){%>
					您的姓名？
					<%} %> 
					</p>
					<p>答&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;案：<input type="text" name="answer"></p>
				<div style="text-align:right;"><input style="font-size:15px;padding:10px 30px 10px 30px;" type="submit" value="确认修改"></div><br><br>
				</form>
					<%if(flag_ServiceFor_Frozen==3){ %>
						答案错误！<br>
					<%}else if(flag_ServiceFor_Frozen==2){ %>
						消费密码错误！<br>
					<%}else{ %>
						<br>
					<%} %>
					<%if(flag_ServiceFor_Frozen==4){ %>
						问题错误！<br>
					<%}else{ %>
						<br>
					<%} %>
				</div>
            </div>
          </div>
		  
         
          <div class="slide" id="4">
            <div class="content">
			<div class="third-content">
			<br><br>
               宿舍区域编码共三位：<br>
				第一位：校区（例：浑南校区为“3”）<br>
				第二位：宿舍（例：一舍为“1”）<br>
				第三位： 区号，其中，A-H取用1-8代替，东南西用1-3代替，0代表没有<br><br>
			<form action="ServiceFor_ApplyKey" method="post"><br>
				<span class="normal-font">宿舍区域编码:</span> <input type="text"  name="region"><br><br><br>
				<div style="text-align:right;"><input style="font-size:15px;padding:10px 30px 10px 30px;" type="submit" value="申请门禁密钥"></div><br><br>
			</form>
				<%if(flag_ServiceFor_ApplyKey==3){ %>
					<span class="big-font">申请成功！门禁密钥为：</span><span class="big-font" style="color:#FF3333;"><%=user_DK.getKey() %></span><span class="big-font">有效时间为：</span><span class="big-font" style="color:#FF3333;">5s</span><br>
					
				<% response.setHeader("refresh", "5;URL=ServiceFor_UpdateKey");%>
				<%}else if(flag_ServiceFor_ApplyKey==2){ %>
					宿舍区域编码错误！<br>
				<%}else{ %>
					<br>
				<%}%>
			</div>
            </div>
          </div>

        </div> 
		


	
    


      
	
    

</body>
</html>




























