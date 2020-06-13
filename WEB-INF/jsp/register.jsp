<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<title>注册</title>
<meta content="text/html; charset=utf-8" http-equiv="content-type" />
<meta name="description" content="Register page." />
<meta name="keywords" content="put,your,key words,phrases,here" />
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<link rel="stylesheet" href="${ctx}/css/style.css" type="text/css" />
<link rel="stylesheet" type="text/css" id="css"
	href="${ctx}/css/main.css" />
<link rel="stylesheet" type="text/css" id="css"
	href="${ctx}/css/style1.css" />
<link rel="stylesheet" type="text/css" id="css"
	href="${ctx}/css/style-1.css" />
<link rel="stylesheet" type="text/css"
	href="${ctx}/js/ligerUI/skins/Aqua/css/ligerui-dialog.css" />
<link href="${ctx}/js/ligerUI/skins/ligerui-icons.css" rel="stylesheet"
	type="text/css" />
<%-- <script src="${ctx }/js/base.js" type="text/javascript"></script>
<script src="${ctx }/js/common.js" type="text/javascript"></script>
<script src="${ctx }/js/main.js" type="text/javascript"></script> --%>

<style type="text/css">
table {
	border-spacing: 1px;
	border: 1px solid #A2C0DA;
}

td, th {
	padding: 2px 5px;
	border-collapse: collapse;
	text-align: left;
	font-weight: normal;
	text-align: left
}

thead tr th {
	height: 30px;
	background: #FFFFFF;
	border: 1px solid white;
}

thead tr th.line1 {
	background: #FFFFFF;
}

thead tr th.line4 {
	background: #C6C6C6;
}

tbody tr td {
	height: 35px;
	background: #CBE2FB;
	border: 1px solid white;
	vertical-align: middle;
}

tbody tr td.line4 {
	background: #D5D6D8;
}

tbody tr th {
	height: 35px;
	background: #DFEDFF;
	border: 1px solid white;
	vertical-align: middle;
}

tfoot tr td {
	height: 35px;
	background: #FFFFFF;
	border: 1px solid white;
	vertical-align: middle;
	text-align: center
}

#menu {
	width: 100%;
	height: 42px;
	clear: both;
	/*background: url(images/button_end_gradient.png) center left no-repeat;*/
	position: relative;
}

#menu ul {
	list-style-type: none;
	margin-top: -53px;
	padding: 0;
	position: absolute;
	left: 1px;
	background: #6A7A86 url(images/menu_background.png) repeat-x;
	color: #DCE0E4;
	width: 782px;
	top: 33px;
}

#menu ul li {
	display: inline;
}

#menu ul li a {
	text-decoration: none;
	height: 42px;
	padding: 0 17px;
	margin: 0;
	line-height: 42px;
	display: block;
	float: left !important;
	background: url(images/button_end_gradient.png) center right no-repeat;
	color: #D8DCE0;
	font-size: 16px;
	font-weight: bold;
}

#menu ul li a:hover {
	background: url(images/button_end_gradient.png) center right no-repeat;
	color: #FFF;
}

#footer {
	width: 790px;
	height: 56px;
	margin: 0 auto;
	background: #F3F3F3 url(images/footer_background.png) repeat-x;
	color: #5B6973;
	clear: both;
	text-align: left;
	padding: 0;
	position: relative;
}

#footer-content {
	padding: 19px 15px;
}

#footer-right {
	position: absolute;
	right: 0;
	top: 0;
	width: 15px;
	height: 56px;
	background: #F3F3F3 url(images/footer_right.png) no-repeat;
	color: #5B6973;
}

#footer-left {
	position: absolute;
	left: 0;
	top: 0;
	width: 15px;
	height: 56px;
	background: #F3F3F3 url(images/footer_left.png) no-repeat;
	color: #5B6973;
}

#footer p {
	margin: 0;
}

#footer a {
	background: transparent;
}

#footer-navigation {
	float: right;
	margin: 0;
}
</style>

<script type="text/javascript" src="${ctx }/js/jquery-1.11.0.js"></script>
<script type="text/javascript" src="${ctx }/js/jquery-migrate-1.2.1.js"></script>
<script src="${ctx}/js/ligerUI/js/core/base.js" type="text/javascript"></script>
<script src="${ctx}/js/ligerUI/js/plugins/ligerDrag.js"
	type="text/javascript"></script>
<script src="${ctx}/js/ligerUI/js/plugins/ligerDialog.js"
	type="text/javascript"></script>
<script src="${ctx}/js/ligerUI/js/plugins/ligerResizable.jss"
	type="text/javascript"></script>
<link href="${ctx}/css/pager.css" type="text/css" rel="stylesheet" />
<script language="javascript" type="text/javascript"
	src="${ctx }/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	$(function() {
		/** 员工表单提交 */
		$("#employeeForm").submit(function() {
			var name = $("#name");
			var passwd = $("#passwd");
			var repasswd = $("#repasswd");
			var birthday = $("#birthday");
			var phone = $("#phone");
			var email = $("#email");
			var qqNum = $("#qqNum");
			var passwdQuestion = $("#passwdQuestion");
			var passwdAnswer = $("#passwdAnswer");
			var provinceCity = $("#provinceCity");
			var address = $("#address");
			var xieyi = $("#xieyi");

			if ($.trim(name.val()) == "") {
				msg = "姓名不能为空！";
				name.focus();
			} else if ($.trim(passwd.val()) == "") {
				msg = "密码不能为空！";
				passwd.focus();
			} else if ($.trim(repasswd.val()) == "") {
				msg = "确认密码不能为空！";
				repasswd.focus();
			} else if ($.trim(passwd.val()) != $.trim(repasswd.val())) {
				msg = "2次密码输入不同！";
				passwd.focus();
				repasswd.focus();
			} else if ($.trim(birthday.val()) == "") {
				msg = "出生日期不能为空！";
				birthday.focus();
			} else if (!birthday.val()) {
				// 					!/^\d{4}-\d{2}-\d{2}$/.test($.trim(birthday.val()))
				msg = "出生日期格式不正确！";
				birthday.focus();
			} else if ($.trim(phone.val()) == "") {
				msg = "手机号码不能为空！";
				phone.focus();
			} else if (!/^1[3|5|8]\d{9}$/.test($.trim(phone.val()))) {
				msg = "手机号码格式不正确！";
				phone.focus();
			} else if ($.trim(email.val()) == "") {
				msg = "邮箱不能为空！";
				email.focus();
			} else if (!/^\w+@\w{2,3}\.\w{2,6}$/.test($.trim(email.val()))) {
				msg = "邮箱格式不正确！";
				email.focus();
			} else if ($.trim(qqNum.val()) == "") {
				msg = "QQ号码不能为空！";
				qqNum.focus();
			} else if (!/^\d{6,}$/.test($.trim(qqNum.val()))) {
				msg = "QQ号码格式不正确！";
				qqNum.focus();
			} else if ($.trim(xieyi.val()) == "1") {
				msg = "您需要阅读并同意注册协议！";
				passwdQuestion.focus();
			}
			if (msg != "") {
				$.ligerDialog.error(msg);
				return false;
			} else {
				return true;
			}
			$("#employeeForm").submit();
		});
	});
</script>
<script language="javascript">
	function agree() {
		if (document.getElementById('cb').checked)
			document.getElementById('tj').disabled = false;
		else
			document.getElementById('tj').disabled = 'disabled';
	}
</script>
</head>

<body style="background: #F3F3F3 url(images/background.png) repeat-x;">

	<div id="container">

		<div id="header">
			<h1>
				<img src="images/title.png" alt="Your Site Name" height="71"
					style="width: 581px; height: 71px;" />
			</h1>

			<div id="headform">
				<marquee direction="left" behavior="scroll">
					<p style="font-size: 15px">欢迎您的注册，希望能够为您提供更好的服务，有任何意见请及时反馈给我们！有关信息请注册后登陆查看！</p>
				</marquee>
			</div>
		</div>
		<!--End header-->



		<div id="menu">

			<img src="images/button_end_gradient.png"
				style="margin-top: -20px; margin-left: -2px" />

			<ul>

				<li><a title="Return to Home Page" href="#">首页</a></li>
				<li><a title="Learn More About Us" href="#">小区介绍</a></li>
				<li><a title="Company News" href="#">小区新闻</a></li>
				<li><a title="Services We Offer" href="#">小区报价</a></li>
				<li><a title="Contact Information" href="#">个人空间</a></li>
				<li><a title="Our Affiliates" href="#">注销退出</a></li>

			</ul>

		</div>
		<!--End main navigation menu-->

		<div class="clear-fix" id="wrapper">

			<!--The following division is your main content division-->
			<!--[if !IE]>End left-column<![endif]-->

			<!--Place secondary content in the following division.-->
			<!--End right-column-->

		</div>
		<!--End wrapper-->

		<div id="sub-outer">

			<div id="ltd">
				<h2>新会员注册</h2>

				<ul>
					<li class="current"></li>

					<div align="center">
						<table cellspacing=0 cellpadding=0 border=0>
							<tr>
								<td width="100%">
									<form action="${ctx}/employee/addEmployee" id="employeeForm"
										method="post">
										<input type="hidden" name="flag" value="2">
										<table width="100%">
											<thead>
												<tr>
													<th colspan=3><font
														face="Arial, Helvetica, sans-serif"><b>
																请填写个人资料：（注意带有<font color=#ff0000>*</font>的项目必须填写）
														</b></font></th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<th width="25%">
														<div align="right">
															<font color=#ff0000>*</font>姓名：
														</div>
													</th>
													<td width="30%"><input type="text" size="20"
														name="name" id="name" maxlength=14 style="width: 200px" /></td>

													<th width="45%"><font color=#ff0000>可使用长度为0-20的任何字符</font></th>
												</tr>



												<tr>
													<th>
														<div align="right">
															<font color=#ff0000>*</font> 密码：
														</div>
													</th>
													<td><input type=password maxlength=14
														style="width: 200px" name="passwd" id="passwd" /></td>
													<th><font color=#ff0000>密码可使用长度为6-14的任何字符，并区分英文字母大小写</font></th>
												</tr>

												<tr>
													<th>
														<div align="right">
															<font color=#ff0000>*</font> 确认密码：
														</div>
													</th>
													<td><input type=password maxlength=14
														style="width: 200px" name="repasswd" id="repasswd" /></td>
													<th><font color=#ff0000>请再次输入密码</font></th>
												</tr>

												<tr>
													<th>
														<div align="right">
															<font color=#ff0000>*</font> 出生日期：
														</div>
													</th>
													<td><input cssClass="Wdate"
														onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'});"
														name="birthday" id="birthday" style="width: 200px"
														maxlength=14 /></td>
													<th><font color=#ff0000>请填写以便存档</font></th>
												</tr>

												<tr>
													<th>
														<div align="right">
															<font color=#ff0000>*</font> 性别：
														</div>
													</th>
													<td><select name="sex" style="width: 143px;">
															<option value="0">--请选择性别--</option>
															<option value="1">男</option>
															<option value="2">女</option>
													</select></td>
													<th><font color=#ff0000>请填写以便存档</font></th>
												</tr>

												<tr>
													<th>
														<div align=right>
															<font color="#ff0000">*</font>联系电话：
														</div>
													</th>
													<td><input name="phone" style="width: 200px"
														id="phone" size="20" /></td>
													<th><font color=#ff0000>请输入真实的电话，以便我们与您联系</font></th>
												</tr>

												<tr>
													<th>
														<div align=right>
															<font color=#ff0000>*</font>电子邮箱：
														</div>
													</th>
													<td><input style="width: 200px" name="email"
														id="email" size="20" /></td>
													<th><font color=#ff0000>请输入您常用的电子邮箱</font></th>
												</tr>

												<tr>
													<th>
														<div align=right>
															<font color=#ff0000>*</font>QQ号码：
														</div>
													</th>
													<td><input name="qqNum" id="qqNum" size="20"
														style="width: 200px" /></td>
													<th><font color=#ff0000>请输入您的QQ号码以便联系</font></th>
												</tr>

												<tr>
													<th>
														<div align=right>密码提示问题：</div>
													</th>
													<td><input style="width: 200px" name="passwdQuestion"
														id="passwdQuestion" /></td>
													<th><font color=#ff0000>例如：我的父亲姓名？</font></th>
												</tr>
												<tr>
													<th>
														<div align=right>密码提示答案：</div>
													</th>
													<td><input style="width: 200px" name="passwdAnswer"
														id="passwdAnswer" /></td>
													<th><font color=#ff0000>密码提示问题答案帮助您重置密码</font></th>
												</tr>


												<tr>
													<th>
														<div align=right>户口所在省份/城市：</div>
													</th>
													<td><select name="provinceCity" id="provinceCity">
															<option value=0 selected>请选择</option>
															<option value=1>北京</option>
															<option value=2>上海</option>
															<option value=3>天津</option>
															<option value=4>重庆</option>
															<option value=5>辽宁</option>
															<option value=6>广东</option>
															<option value=7>浙江</option>
															<option value=8>江苏</option>
															<option value=9>山东</option>
															<option value=10>四川</option>
															<option value=11>黑龙江</option>
															<option value=12>湖南</option>
															<option value=13>湖北</option>
															<option value=14>福建</option>
															<option value=15>陕西</option>
															<option value=16>河南</option>
															<option value=17>安徽</option>
															<option value=18>河北</option>
															<option value=19>吉林</option>
															<option value=20>江西</option>
															<option value=21>广西</option>
															<option value=22>山西</option>
															<option value=23>内蒙古</option>
															<option value=24>甘肃</option>
															<option value=25>贵州</option>
															<option value=26>新疆</option>
															<option value=27>云南</option>
															<option value=28>宁夏</option>
															<option value=29>海南</option>
															<option value=30>青海</option>
															<option value=31>西藏</option>
															<option value=32>港澳台</option>
															<option value=33>海外</option>
															<option value=34>其它</option>
													</select></td>
													<th>&nbsp;</th>
												</tr>

												<tr>
													<th>
														<div align=right>房屋门牌编号：</div>
													</th>
													<td><input name="address" style="width: 200px"
														id="address" size="40" /></td>
													<th>&nbsp;</th>
												</tr>


												<tr>
													<th>
														<div align=right>
															<font color=#ff0000>*</font> 注册协议：
														</div>
													</th>

													<td><input name="confirm" type="checkbox"
														onclick="agree();" id="cb" /> 同意
													<th><font color=#ff0000>请阅读<a href=""><strong>《LJ·D高档海景小区注册协议》</strong></a></font></th>
												</tr>

											</tbody>
											<tfoot>
												<tr>
													<td colspan=3><div align=center>
															<input style="CURSOR: hand" type=submit name="submit1"
																value="提交" disabled="disabled" id="tj" /> &nbsp;&nbsp;
															<input style="CURSOR: hand" type=reset value=重置 />
														</div></td>
												</tr>
											</tfoot>
										</table>
									</form>
								</td>
							</tr>
						</table>
					</div>
					<li></li>
					<li></li>

				</ul>

			</div>

		</div>


		<div id="footer">

			<!--Begin nothing goes here-->
			<div id="footer-left"></div>
			<div id="footer-right"></div>
			<div id="footer-right"></div>
			<!--End nothing goes here-->

			<div id="footer-content">

				<div id="footer-navigation">

					<a href="#" title="View Our Terms of Use">Terms </a>&middot; <a
						href="#" title="Our Privacy Policy">Privacy Policy </a>&middot; <a
						href="#" title="View a Map of Our Site">Site Map </a>&middot;
					Design by <a href="#">1425董靓杰</a>

				</div>
				<!--End footer-navigation-->

				<p>Copyright &copy; 2018 Your Site. All rights reserved.</p>

			</div>
			<!--End footer-content-->

		</div>
		<!--End footer-->


		<div
			style="font-size: 0.8em; text-align: center; margin-top: 1.0em; margin-bottom: 1.0em;">
			<p>
				Designed by <a href="#">董靓杰（2014006241）</a> -
				太原理工大学-软件学院-软件工程-1425班/毕业设计
			</p>
		</div>
</body>
</html>