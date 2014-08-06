<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户-邮箱注册</title>
<link href="<%=request.getContextPath() %>/front/static/css/common.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/front/static/css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/front/static/css/l_login.css"/>
</head>

<body>
<jsp:include page="../common/header.jsp"/>
<div class="container">
<div class="w1000">
	
	<div class="content_n">
		<div class="yhzc">
			<div class="yhzcL">
				<div class="yhzcLA">
					<div class="yhzcLA_a"><span><a href="#">邮箱注册</a></span></div>
					<div class="yhzcLA_b"><a href="<%=request.getContextPath()%>/user/goSignUpByPhone.htm">手机注册</a></div>
					<div class="yhzcLA_c">
						<a href="#">会员卡注册</a>&nbsp;成为诚途会员
					</div>
				</div>
				<div class="yhzcLB">
				<form id="emailRegForm" action="<%=request.getContextPath() %>/user/signUp.htm" method="post">
					<ul>
						<li>
							<div class="yhzcLB_a"><span>*</span>您的Email地址：</div><input id="sso_email_b" name="email" type="text" class="yhzcLB_b" />
						</li>
						<li>
							<div class="yhzcLB_a"><span>*</span>用户名：</div><input  id="sso_username" name="username" type="text" class="yhzcLB_b" />
						</li>
						<li>
							<div class="yhzcLB_a"><span>*</span>设置密码：</div><input id="sso_password" name="password" type="password" class="yhzcLB_b" />
						</li>
						<li>
							<div class="yhzcLB_a"><span>*</span>确认密码：</div><input id="sso_againPassword" name="againPassword" type="password" class="yhzcLB_b" />
						</li>
						<li>
							<div class="yhzcLB_a"><span>*</span>验证码：</div><input  id="sso_verifycode1" name="verifycode" type="text" class="yhzcLB_c" />
							<div class="yhzcLB_d">
								<img id="image" src="<%=request.getContextPath() %>/common/genVerifyCode.htm" /><a href="#" class="link_blue" onClick="refreshCheckCode('image');return false;">换一张</a>
							</div>
						</li>
						<li class="">
							<div class="yhzcLB_a">所在地：</div>
							<select id="captialId" class="province" name="province">
								<option value="">--请选择--</option>
							</select>
							<select id="cityId" name="city" class="city">
							<option>--请选择--</option>
							</select>
						</li>
						<li>
							<div class="yhzcLB_a">&nbsp;</div>	
							<%-- <div class="yhzcLB_e"><input id="submitBtn" type="image" src="<%=request.getContextPath() %>/front/static/img/yhzc_22.jpg"/><br />
							</div> --%>
							<a id="submitBtn" class="register_submit" href="javascript:void(0)"></a>
						</li>
						<li><label class="csmm_form_col w105"> </label><input type="checkbox" class="register_tk" checked id="terms"><a class="link_blue" href="javascript:void(0)" id="chengtu_tk">《诚途旅游网会员服务条款》</a>
						<pre class="xy">
						诚途旅游网会员服务条款</pre>
		<div id="terms_xx"></div>
							</li>
					</ul>
					</form>
				</div>
			</div>
			<div class="yhzcR">
				<div class="yhzcR_a">
					<img src="<%=request.getContextPath() %>/front/static/img/yhzc_09.jpg" /><span>现在注册即可获得<strong>100积分</strong></span>
				</div>
				<div class="yhzcR_b">
					<span>已经有诚途账号？</span><input name="" type="image" src="<%=request.getContextPath() %>/front/static/img/yhzc_15.jpg" />
				</div>
				<div class="yhzcR_c">
					<div class="yhzcR_ca">
						<div class="yhzcR_caa">使用合作网站账号登录</div><br />
						<div class="yhzcR_caa"><span><img src="<%=request.getContextPath() %>/front/static/img/login_19.jpg" /></span><a href="#">QQ</a></div>
						<div class="yhzcR_caa"><span><img src="<%=request.getContextPath() %>/front/static/img/login_21.jpg" /></span><a href="#">腾讯微博</a></div>
						<div class="yhzcR_caa"><span><img src="<%=request.getContextPath() %>/front/static/img/login_29.jpg" /></span><a href="#">新浪微博</a></div>
						<div class="yhzcR_caa"><span><img src="<%=request.getContextPath() %>/front/static/img/login_32.jpg" /></span><a href="#">支付宝</a></div>
						<div class="yhzcR_caa"><span><img src="<%=request.getContextPath() %>/front/static/img/login_34.jpg" /></span><a href="#">开心网</a></div>
						<div class="yhzcR_caa"><span><img src="<%=request.getContextPath() %>/front/static/img/login_36.jpg" /></span><a href="#">盛大</a></div>
					</div>
				</div>
				<div class="yhzcR_d"><img src="<%=request.getContextPath() %>/front/static/img/yhzc_19.jpg" /></div>
			</div>
		</div>
	</div>
	
</div>
</div>

<jsp:include page="../common/footer.jsp"/>

<script src="<%=request.getContextPath() %>/front/static/js/jquery-1.7.2.js"></script>
<script src="<%=request.getContextPath() %>/front/static/js/chengtuUI.js"></script>

<script>
function provinceLoaded(){
 	  for(var i = 0; i < document.getElementById("captialId").options.length;i++) {  
    if (document.getElementById("captialId").options[i].value == "310000"){                
      document.getElementById("captialId").options[i].selected ="true";
      break; 
    }
   }
   $("#captialId").change();
}		
		
function cityLoaded(){
    for(var i = 0; i < document.getElementById("cityId").options.length;i++) {  
	if (document.getElementById("cityId").options[i].value == '310000')
       {                
	    document.getElementById("cityId").options[i].selected ="true"; 
                        break;
       }
    }
  
}					

//验证邮箱是否被注册过
function sso_email_b_callback(call){
	$.ajax({
		type: "POST",
		url:  "<%=request.getContextPath()%>/user/checkEmailExisted.htm",
		data: {
			email: this.value
		},
		dataType: "json",
		success: function(response) {
			if (response.success == "true") {
				error_tip("#sso_email_b","该Email地址已被注册，请更换其它地址",undefined,"reg_mtop");
			} else {
				call();
			}
		}
	});
}

//验证用户名是否被注册
function sso_username_callback(call){
	$.ajax({
		type: "POST",
		url:  "<%=request.getContextPath()%>/user/checkUsernameExisted.htm",
		data: {
			username: this.value
		},
		dataType: "json",
		success: function(response) {
			if (response.success == "true") {
				error_tip("#sso_username","该用户名已被使用，请更换其他用户名");  
			} else {
				call();
			}
		}
	});				
}		

//判断验证码是否正确
function sso_verifycode1_callback(call){
	$.ajax({
		type: "POST",
		url:  "<%=request.getContextPath()%>/common/checkVerifyCode.htm",
		data: {
			authenticationCode: this.value
		},
		dataType: "json",
		success: function(response) {
			if (response.success == "false") {
				error_tip("#sso_verifycode1","验证码输入错误",":last");  
			} else {
				call();
			}
		}
	});				
}		
		
function validate_pass(){
 	/* if($("#terms:checked").length==0){
		error_tip("#terms","抱歉，您必须同意诚途旅游网的服务条款后，才能提交注册。","#terms_xx");
		return;
	}  */
	$("#emailRegForm").submit();
}
		//refreshCheckCode('image');
</script>

<script type="text/javascript" src="<%=request.getContextPath() %>/front/static/js/form.validate.js"></script>
</body>
</html>
