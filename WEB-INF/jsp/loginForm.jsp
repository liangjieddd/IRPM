<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>LJ·D小区物业管理系统</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta content="" name="description" />
<meta content="" name="author" />
<link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
<link rel="stylesheet" href="assets/css/reset.css">
<link rel="stylesheet" href="assets/css/supersized.css">
<link rel="stylesheet" href="assets/css/style.css">

<script type="text/javascript" src="${ctx }/js/jquery-1.11.0.js"></script>
<script type="text/javascript" src="${ctx }/js/jquery-migrate-1.2.1.js"></script>
<script type="text/javascript">
   
   $(function(){
	    /** 按了回车键 */
	   $(document).keydown(function(event){
		   if(event.keyCode == 13){
			   $("#login-submit-btn").trigger("click");
		   }
	   })

	   /** 给登录按钮绑定点击事件  */
	   $("#login-submit-btn").on("click",function(){
		   /** 校验登录参数 ctrl+K */
		   var loginname = $("#loginname").val();
		   var password = $("#password").val();
		   
		   var msg = "";
		   
		   if(!/^\w{4,20}$/.test(loginname)){
			     msg = "登录名长度必须是6~20之间";
		   }else if(!/^\w{4,20}$/.test(password)){
			     msg = "密码长度必须是6~20之间";
		   }
		   if(msg !=""){
			   $.ligerDialog.error(msg);
			   return;
		   }
		   /** 提交表单 */
		   $("#loginForm").submit();
		   
	   })   
   })
</script>
</head>

<body>
	<div class="page-container">
		<h1 style="margin-top:20px"><font size="8px">LJ·D高档海景小区物业管理系统</font></h1><br>
		<h1><font size="6px">Login</font></h1>
		<form action="login" method="post" id="loginForm">
		<div class="page-lock-info">
					<c:choose>
						<c:when test="${requestScope.message == null }">
							<span style="padding-top: 5px"><font size="2px">允许以中文名称登录</font></span>
						</c:when>
						<c:otherwise>
							<span style="padding-top: 5px"><font color="red">${requestScope.message}</font></span>
						</c:otherwise>
					</c:choose>	
					<span style="padding-top: 5px"><font size="2px">无账号点此<a href="#">注册</a>|<a href="#">忘记密码</a></font></span>	
				</div>

		 <input type="text" name="loginname" id="loginname" class="username" placeholder="Username" value="${loginname}">
         <input type="password" id="password" name="password" class="password" placeholder="Password" value="${password}">     
         <button type="submit" id="login-submit-btn">Log in</button>
               
         <div class="error"><span>+</span></div>
		</form>
	</div>

	<!-- Javascript -->
        <script src="assets/js/jquery-1.8.2.min.js"></script>
        <script src="assets/js/supersized.3.2.7.min.js"></script>
        <script src="assets/js/supersized-init.js"></script>
        <script src="assets/js/scripts.js"></script>
	
	<!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
	<script
		src="${ctx}/js/metronic/plugins/jquery-ui/jquery-ui-1.10.1.custom.min.js"
		type="text/javascript"></script>
	<script src="${ctx}/js/metronic/plugins/bootstrap/js/bootstrap.min.js"
		type="text/javascript"></script>
	
	<script src="${ctx}/js/metronic/plugins/breakpoints/breakpoints.js"
		type="text/javascript"></script>
	<!-- IMPORTANT! jquery.slimscroll.min.js depends on jquery-ui-1.10.1.custom.min.js -->
	<script src="${ctx}/js/metronic/plugins/uniform/jquery.uniform.min.js"
		type="text/javascript"></script>
	<!-- END CORE PLUGINS -->
	<!-- BEGIN PAGE LEVEL PLUGINS -->
	<script
		src="${ctx}/js/metronic/plugins/backstretch/jquery.backstretch.min.js"
		type="text/javascript"></script>
	<!-- END PAGE LEVEL PLUGINS -->
	<script src="${ctx}/js/metronic/scripts/app.js"></script>
	<script src="${ctx}/js/metronic/scripts/lock.js"></script>
	<script>
		$(function() {
			App.init();
			Lock.init();
		});
	</script>
	<!-- END JAVASCRIPTS -->
	<script type="text/javascript">
		var _gaq = _gaq || [];
		_gaq.push([ '_setAccount', 'UA-37564768-1' ]);
		_gaq.push([ '_setDomainName', 'keenthemes.com' ]);
		_gaq.push([ '_setAllowLinker', true ]);
		_gaq.push([ '_trackPageview' ]);
		(function() {
			var ga = document.createElement('script');
			ga.type = 'text/javascript';
			ga.async = true;
			ga.src = ('https:' == document.location.protocol ? 'https://'
					: 'http://')
					+ 'stats.g.doubleclick.net/dc.js';
			var s = document.getElementsByTagName('script')[0];
			s.parentNode.insertBefore(ga, s);
		})();
	</script>
</body>
</html>