<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>持名法州后台管理中心</title>
			
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
	<link rel="icon" href="${pageContext.request.contextPath}/img/favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" type="text/css"></link>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" type="text/css"></link>
	<script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/script/common.js"></script>

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/icon.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN.js"></script>


	<script type="text/javascript">
	
		$(function(){
            $("#loginFormPhone").validatebox({
                required:true,
                missingMessage:"请填写手机号码",
                validType:"islength[11]"
            });

            $("#loginFormPassword").validatebox({
                required:true,
                missingMessage:"请填密码",
                validType:"length[6,16]"
            });
            $("#loginFormCode").validatebox({
                required:true,
                missingMessage:"请填验证码",
                validType:"islength[4]"
            });

            $.extend($.fn.validatebox.defaults.rules, {
                islength: {
                    validator: function(value,param){
                        return value.length ==param[0];
                    },
                    message: "输入长度不符合，请输入长度为{0}的数"
                }
            });


            $("#loginFormSubmit").click(function () {

                $("#loginForm").form("submit",{
                    url:"${pageContext.request.contextPath}/admin/login",
                    onSubmit:function () {
                        return $("#loginForm").form("validate");
                    },
                    success:function (value) {
                        if(value!="ok"){
                            $.messager.show({
                                title:"系统提示",
                                msg:value
                            });
                        }else {
                            location.href="${pageContext.request.contextPath}/main/main.jsp"
                        }

                    }

                });

           	 });

			$("#ims").click(function () {

                    $.post(
                        "${pageContext.request.contextPath}/admin/image",
                        function(){
                            $("#ims").prop("src","${pageContext.request.contextPath}/admin/image");
                        }
                    );
                });


        });



	</script>
</head>
<body>
	
		<div class="login">
			<form id="loginForm"  method="post" >
				
				<table>
					<tbody>
						<tr>
							<td width="190" rowspan="2" align="center" valign="bottom">
								<img src="${pageContext.request.contextPath}/img/header_logo.gif" />
							</td>
							<th>
								用户名:
							</th>
							<td>
								<input id="loginFormPhone" type="text"  name="phone" class="text" maxlength="20"/>
							</td>
					  </tr>
					  <tr>
							<th>
								密&nbsp;&nbsp;&nbsp;码:
							</th>
							<td>
								<input id="loginFormPassword" type="password" name="password" class="text"  maxlength="20" autocomplete="off"/>
							</td>
					  </tr>
					
						<tr>
							<td>&nbsp;</td>
							<th>验证码:</th>
							<td>
								<img id="ims"  class="captchaImage" src="${pageContext.request.contextPath}/admin/image" title="点击更换验证码"/>
							<br>
								<input id="loginFormCode" type="text" name="code" class="text captcha" maxlength="4" autocomplete="off"/>
							</td>
						</tr>					
					<tr>
						<td>
							&nbsp;
						</td>
						<th>
							&nbsp;
						</th>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<th>&nbsp;</th>
						<td>
							<input type="button" class="homeButton" value="" onclick="location.href='/'"><input id="loginFormSubmit" readonly="readonly" class="loginButton" value="   登录">
						</td>
					</tr>
				</tbody></table>
				<div class="powered">COPYRIGHT © 2008-2017.</div>
				<div class="link">
					<a href="http://www.chimingfowang.com/">持名佛网首页</a> |
					<a href="http://www.chimingbbs.com/">交流论坛</a> |
					<a href="">关于我们</a> |
					<a href="">联系我们</a> |
					<a href="">授权查询</a>
				</div>
			</form>
		</div>
</body>
</html>