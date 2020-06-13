<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>LJ·D管理页面</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
<meta http-equiv="description" content="This is my page" />
<link href="${ctx}/css/css.css" type="text/css" rel="stylesheet" />
<!-- 导入jquery插件 -->
<script type="text/javascript" src="${ctx }/js/jquery-1.11.0.js"></script>
<script type="text/javascript" src="${ctx }/js/jquery-migrate-1.2.1.js"></script>
<script type="text/javascript" src="${ctx }/js/fkjava_timer.js"></script>
<script type="text/javascript">
	/** 文档加载完成后立即执行的方法 */
	// var weeks = new Array();
	$(function() {
		$("#nowTime").runTimer();

		$("#exit").click(function() {
			/** parent从主界面进行退出,避免局部刷新*/
			parent.location = "${ctx}/logout.action";
		})
	})
</script>

<link rel="stylesheet" href="style.css" type="text/css" />
<link rel="stylesheet" type="text/css" id="css" href="style/main.css" />
<link rel="stylesheet" type="text/css" id="css" href="style/style1.css" />
<link rel="stylesheet" type="text/css" id="css" href="style/style.css" />

<script src="js/base.js" type="text/javascript"></script>
<script src="js/common.js" type="text/javascript"></script>
<script src="js/main.js" type="text/javascript"></script>



</head>
<body style="background: #F3F3F3 url(images/background8.png) repeat-x;">

	<table width="100%" border="0" cellpadding="0" cellspacing="0" style="margin-top:-8px;margin-left:-40px">
		<div id="header" style="margin-top: 20px">
			<h1>
				<img src="images/title.png" alt="Your Site Name" height="71"
					style="width: 400px; height: 37px;margin-top:-15px;margin-left:0px" />
			</h1>
		</div>
		<tr>

			<td class="topnavlh" align="right"><img
				src="${ctx}/images/StatBar_admin.gif">&nbsp;&nbsp;当前用户：【${sessionScope.user_session.username}】&nbsp;&nbsp;欢迎您的使用！</td>
			<td class="topnavlh" align="center">&nbsp;&nbsp;&nbsp;</td>
			<td class="topnavlh" align="center"><img
				src="${ctx}/images/StatBar_time.gif">&nbsp;&nbsp;当前登陆时间：<span
				id="nowTime"></span></td>

		</tr>

		

		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			style="margin-top: -25px;margin-left:25px">
			<tr>
				<td height="50" width="200" class="toplink" align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td align="center"><img
					src="${ctx}/images/button_end_gradient.png" style="height:33px;margin-top:1px">
				<td height="50" width="70" class="toplink" align="left">&nbsp;&nbsp;<a
					href="javascript:void(0);"><font color="#DCE0E4">首页</font></a></td>
				<td align="center"><img
					src="${ctx}/images/button_end_gradient.png" style="height:33px;margin-top:1px">
				<td height="50" width="90" class="toplink" align="center">&nbsp;&nbsp;<a
					href="javascript:void(0);"><font color="#DCE0E4">小区介绍</font></a></td>
				<td align="center"><img
					src="${ctx}/images/button_end_gradient.png" style="height:33px;margin-top:1px">
				<td height="50" width="90" class="toplink" align="center">&nbsp;&nbsp;<a
					href="javascript:void(0);"><font color="#DCE0E4">小区图片</font></a></td>
				<td align="center"><img
					src="${ctx}/images/button_end_gradient.png" style="height:33px;margin-top:1px">
				<td height="50" width="90" class="toplink" align="center">&nbsp;&nbsp;<a
					href="javascript:void(0);"><font color="#DCE0E4">小区新闻</font></a></td>
				<td align="center"><img
					src="${ctx}/images/button_end_gradient.png" style="height:33px;margin-top:1px">
				<td height="50" width="90" class="toplink" align="center">&nbsp;&nbsp;<a
					href="javascript:void(0);"><font color="#DCE0E4">小区报价</font></a></td>
				<td align="center"><img
					src="${ctx}/images/button_end_gradient.png" style="height:33px;margin-top:1px">
				<td height="50" class="toplink" align="center">&nbsp;&nbsp;<a
					href="javascript:void(0);" id="exit"><font color="#DCE0E4">注销退出</font></a></td>
				</tr>
		</table> 
		<%-- <tr>   
	<td class="topbg">
	  <table width="100%" border="0" cellpadding="0" cellspacing="0">
	    <tr>
		  <td height="50" class="toplink" align="right"><img src="${ctx}/images/top_home.gif">&nbsp;&nbsp;<a href="javascript:void(0);">网站首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="${ctx}/images/top_exit.gif">&nbsp;&nbsp;<a href="javascript:void(0);" id="exit">注销退出</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		</tr>
		<tr>
		  
		</tr>
	  </table>
	</td>
  </tr> --%>
	</table>
</body>
</html>