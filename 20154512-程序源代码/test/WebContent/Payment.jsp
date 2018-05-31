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
<%String Payment_pos="Payment_1"; 
Payment_pos=(String)session.getAttribute("Payment_pos");
%>
<script>
jQuery(function($) {
   // $("#Payment_2")[0].click();
    $(<%=Payment_pos%>)[0].click();
});
</script>
<%
	CampusCard user = (CampusCard)session.getAttribute("user"); 
	CampusCardDao userDao = new CampusCardDao();
	int flag_PayFor_WaterFee =1;
	DormElectric user_DE = new DormElectric();
	int flag_PayFor_Electric =1;
	NetworkFlow user_NF=new NetworkFlow();
	int flag_PayFor_NetworkFlow =1;
	try {
		flag_PayFor_WaterFee = (int)session.getAttribute("flag_PayFor_WaterFee");
	}catch (Exception e) {
		// TODO Auto-generated catch block
	} 
	try {
		flag_PayFor_Electric = (int)session.getAttribute("flag_PayFor_Electric");
	}catch (Exception e) {
		// TODO Auto-generated catch block
	}
	try {
		user_DE = (DormElectric)session.getAttribute("user_DE");
	}catch (Exception e) {
		// TODO Auto-generated catch block
	}
	try {
		flag_PayFor_NetworkFlow = (int)session.getAttribute("flag_PayFor_NetworkFlow");
	}catch (Exception e) {
		// TODO Auto-generated catch block
	}
	try {
		user_NF = (NetworkFlow)session.getAttribute("user_NF");
	}catch (Exception e) {
		// TODO Auto-generated catch block
	}
%>
<%
FinancialService user_FS = (FinancialService)session.getAttribute("user_FS");
FinancialServiceDao user_FSDao = new FinancialServiceDao();
int flag_PayFor_CampusCard =1;
try {
	flag_PayFor_CampusCard = (int)session.getAttribute("flag_PayFor_CampusCard");
}catch (Exception e) {
	// TODO Auto-generated catch block
}
String key=null;
try {
	key=(String)session.getAttribute("key");
}catch (Exception e) {
	// TODO Auto-generated catch block
}
String record_id=null;
try {
	record_id=(String)session.getAttribute("record_id");
}catch (Exception e) {
	// TODO Auto-generated catch block
}
String price=null;
try {
	price=(String)session.getAttribute("price");
}catch (Exception e) {
	// TODO Auto-generated catch block
}
String istype=null;
try {
	istype=(String)session.getAttribute("istype");
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
                <li><a href="Payment.jsp" class="selected">生活缴费</a></li>
                <li><a href="RecordFor_Datatime">消费查询</a></li>
                <li><a href="ServiceFor_Data">生活服务</a>  </li>
            </ul>
            <br style="clear: left" />
        </div> <!-- end of templatemo_menu -->
       <div class="cleaner"></div>
    </div> 
   </div>
	

       <nav>
          <ul>
            <li><a id="Payment_1" href="#1"><i class="fa fa-usd"></i> <em>余额充值</em></a></li>
            <li><a id="Payment_2" href="#2"><i class="fa fa-tint"></i> <em>缴纳水费</em></a></li>
            <li><a id="Payment_3" href="#3"><i class="fa fa-flash"></i> <em>缴纳电费</em></a></li>
            <li><a id="Payment_4" href="#4"><i class="fa fa-globe"></i> <em>缴纳网费</em></a></li>
          </ul>
        </nav>
        
        <div class="slides">
          <div class="slide" id="1">
           <div class="content">
		   <div class="first-content">
             <p><span class="big-font">余额：<%=user_FS.getRest() %></span>
             </p>
				<%session.setAttribute("Payment_pos", "Payment_1"); %> 
                <form action="Pay_test"method="post"> 
		        <p><input type='radio' name='istype' value='2'>
                微信支付<br>
                <input type='radio' name='istype' value='1' checked >
                支付宝支付</p>
				<p> 充值金额：		
				<input type="text" name="price"></p>
				<p><div style="text-align:right;"><input style="font-size:15px;padding:10px 30px 10px 30px;" id="btn" type="submit"value="确认充值"></div></p>
				</form>
				<form style='display:none;' id='formpay' name='formpay' method='post' action='https://pay.paysapi.com'>
		        <input name='goodsname' id='goodsname' type='text' value='' >
		        <input name='istype' id='istype' type='text' value=<%=istype %> >
		        <input name='key' id='key' type='text' value=<%=key %>>
		        <input name='notify_url' id='notify_url' type='text' value='http://118.89.248.160:8080/test_end/Pay_yes'>
		        <input name='orderid' id='orderid' type='text' value=<%=record_id %>>
		        <input name='orderuid' id='orderuid' type='text' value=''>
		        <input name='price' id='price' type='text' value=<%=price %>>
		        <input name='return_url' id='return_url' type='text' value='http://118.89.248.160:8080/test_end/Pay_yes'>
		        <input name='uid' id='uid' type='text' value='4fb6cd91deaa54e56ee72a75'>
		        <input type='submit' id='submitdemo1'>
		   		</form>
		   		<%if(key!=null&&price!=null){ %>
			   		 <script>
			   		//$('#price').val(price);
			   		$('#submitdemo1').click();
			   		</script>

		   		<%} %>
			 </div>
            </div> 
          </div>
		  
          <div class="slide" id="2">
            <div class="content ">
			<div class="first-content">
              
				<p><span class="big-font">水费余额:<%=user.getWaterFee() %></span>
				 <p>（缴纳水费：余额上限10.00￥）</p>
				<form action="PayFor_WaterFee" method="post">
				   <span class="normal-font"> 充值金额:</span> 
			      <input type="number" step="0.01" name="price_WaterFee" max="10"><br><br>
				     <span class="normal-font"> 消费密码:</span> <input type="password" name="password"><br><br>
				   			<div style="text-align:right;"><input style="font-size:15px;padding:10px 30px 10px 30px;" type="submit" value="确认充值"></div><br><br>
			    </form>
			    <%if(flag_PayFor_WaterFee==2){ %>
						校卡余额不足！<br>
					<%}else if(flag_PayFor_WaterFee==3){ %>
						充值金额+之前余额>10.00,充值失败，重新输入充值金额！<br>
					<%}else if(flag_PayFor_WaterFee==4){ %>
						消费密码错误！<br>
					<%} %> 
			  </div>
            </div>
          </div>
          
          <div class="slide" id="3">
            <div class="content ">
			<div class="second-content">
             <form action="PayFor_DormElectric" method="post">
					<p><span class="big-font">缴纳电费：2度/元</span></p>
					
	          		自助购电宿舍编码共七位：<br>
					第一位：校区（例：浑南校区为“3”）<br>
					第二位：宿舍（例：一舍为“1”）<br>
					第三位：区号，其中，A-H取用1-8代替，东南西用1-3代替，0代表没有<br>
					第四位-第七位：寝室号，其中不足4位，在寝室号前加“0”（例：634寝室为“0634”）<br><br><br>
					
					<span class="normal-font">宿舍编码:</span> <input type="text"  name="DormId"><br><br>
					<span class="normal-font">充值金额:</span> <input type="number" step="0.01" name="price_DormElectric"><br><br>
				    <span class="normal-font">消费密码:</span> <input type="password" name="password"> <br><br>
				    	    <div style="text-align:right;"><input style="font-size:15px;padding:10px 30px 10px 30px;" type="submit" value="确认充值"></div><br><br>
				    </form>
				    <%if(flag_PayFor_Electric==2){ %>
						宿舍编码错误！<br>
					<%}else if(flag_PayFor_Electric==3){ %>
						校卡余额不足！<br>
					<%}else if(flag_PayFor_Electric==4){ %>
						消费密码错误！<br>
					<%}else if(flag_PayFor_Electric==5){ %>
						充值成功！编号：<%=user_DE.getDorm_Id() %>的宿舍最新电量余额为:<%=user_DE.getRest_Elec() %>度。<br>
					<%}else{ %>
						<br>
					<%} %> 
					</div>
            </div>
          </div>
		  
         
          <div class="slide" id="4">
            <div class="content ">
			<div class="first-content">
              <form action="PayFor_NetworkFlow" method="post">
			<span class="normal-font">输入学号:</span> <input type="text" maxlength="8" name="Id"><br><br>
			<span class="normal-font">充值金额:</span> <input type="number" step="0.01" name="price_NetworkFlow"><br><br>
			<span class="normal-font">消费密码:</span> <input type="password" name="password"><br><br>   
			    	    <div style="text-align:right;"><input style="font-size:15px;padding:10px 30px 10px 30px;" type="submit" value="确认充值"></div><br><br>
			    </form>
				<%if(flag_PayFor_NetworkFlow==2){ %>
					学号错误！<br>
				<%}else if(flag_PayFor_NetworkFlow==3){ %>
					校卡余额不足！<br>
				<%}else if(flag_PayFor_NetworkFlow==4){ %>
					消费密码错误！<br>
				<%}else if(flag_PayFor_NetworkFlow==5){ %>
					充值成功！学号：<%=user_NF.getId() %>的账户网费余额为:<%=user_NF.getRestMoney() %>￥（余额小于等于0￥，上网账户冻结）。<br>
				<%}else{ %>
					<br>
				<%} %>
				</div>
            </div>
          </div>
          
        </div>  
		


	
    


      
	
    

</body>
</html>




























