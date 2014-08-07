<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>我的个人资料-诚途旅游网</title>
<link href="<%=request.getContextPath() %>/front/static/css/common.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/front/static/css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<jsp:include page="../common/header.jsp"/>

<div class="container">
<div class="w1000">
	<div class="nav">
		<a href="<%=request.getContextPath() %>/user/goUserInfoCenter.htm">我的诚途</a> > <a href="#">我的信息</a>
	</div>
	
	<div class="content">
	
		<jsp:include page="../common/sidebar.jsp"/>
		
		<div class="right">
			<div class="grzl">
				<div class="grzlA">
					<h2>个人资料</h2>
					<div class="grzlA_a">个人资料</div>
				</div>
				<form method="post" action="<%=request.getContextPath() %>/user/updateUserInfo.htm">
				<div class="grzlB">
					<div class="grzlB_n">
						<div class="grzlB_a">*用户名：</div>
						<div class="grzlB_b">
							<input name="" type="text" value="${user.username}" class="grzlB_ba"/>
							<span>(用户名不能修改)</span>
						</div>
					</div>
					<div class="grzlB_n">
						<div class="grzlB_a">*EMAIL：</div>
						<div class="grzlB_b">
							<input id="email" name="email" type="text" class="grzlB_ba" value="${user.email }"/>
							<a href="javascript:;" onclick="modifyEmail()">修改</a>
							<c:if test="${user.validateEmail == null or  user.validateEmail == 0}">
							<span><a href="javascript:;" onclick="sendVerifyEmail()">未验证</a></span></c:if>
							<c:if test="${user.validateEmail != null and  user.validateEmail == 1}">
								<a href="javascript:;" onclick="removeEmailBind()">解绑</a>
								<span>已验证</span>
							</c:if>
						</div>
					</div>
					<div class="grzlB_n">
						<div class="grzlB_a">*手机号码：</div>
						<div class="grzlB_b">
							<span>未绑定</span>
							<a href="#">立即绑定</a>
							<div class="grzlB_bb">
								<div class="grzlB_bba"><img src="<%=request.getContextPath() %>/front/static/img/grzl_06.jpg" /></div>
								<div class="grzlB_bbb"><img src="<%=request.getContextPath() %>/front/static/img/grzl_03.jpg" /></div>
								<div class="grzlB_bbc">绑定手机后，可以用手机号码登录。绑定手机成功可获得300积分。</div>
							</div>
						</div>
					</div>
					<div class="grzlB_n">
						<div class="grzlB_a">*真实姓名：</div>
						<div class="grzlB_b">
							<input name="realname" type="text" class="grzlB_ba" value="${user.realname }"/>
						</div>
					</div>
					<div class="grzlB_n">
						<div class="grzlB_a">性别：</div>
						<div class="grzlB_b">
							<label>
							<input name="sex" type="radio" value="1" <c:if test='${user.sex == null or user.sex == 1}'>checked='checked'</c:if> />男
							</label>
							<label>
							<input name="sex" type="radio" value="0" <c:if test='${user.sex == 0}'>checked='checked'</c:if> />女
							</label>
						</div>
					</div>
					<div class="grzlB_n">
						<div class="grzlB_a">生日：</div>
						<div class="grzlB_b">
							<select name="yearOfBirthday" style="width:80px;">
								<option>年</option>
								<c:forEach var="y" begin="1900" end="2030" step="1">
									<option <c:if test="${user.yearOfBirthday == y }">selected</c:if> value="${y }">${y }</option>
								</c:forEach>
							</select>
							<select name="monthOfBirthday" style="width:50px;">
								<option>月</option>
								<c:forEach var="m" begin="1" end="12" step="1">
									<option <c:if test="${user.monthOfBirthday == m }">selected</c:if> value="${m }">${m }</option>
								</c:forEach>
							</select>
							<select name="dayOfBirthday" style="width:50px;">
								<option>日</option>
								<c:forEach var="d" begin="1" end="31" step="1">
									<option <c:if test="${user.dayOfBirthday == d }">selected</c:if> value="${d }">${d }</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="grzlB_n">
						<div class="grzlB_a">所在地：</div>
						<div class="grzlB_b">
							<select id="captialId" class="province" name="province" style="width:80px;">
								<option value="">--请选择--</option>
							</select>
							<select id="cityId" name="city" class="city" style="width:80px;">
							<option>--请选择--</option>
							</select>
						</div>
					</div>
					<div class="grzlB_n">
						<div class="grzlB_a">&nbsp;</div>
						<div class="grzlB_b">
							<input name="" type="image" src="<%=request.getContextPath() %>/front/static/img/grzl_11.jpg" />
						</div>
					</div>
				</div>
				</form>
			</div>		
		</div>
	</div>
	
	<div class="about">
		<div class="about_n">
			<div class="about_a"><span><img src="<%=request.getContextPath() %>/front/static/img/grzx_63.jpg" /></span><strong>订购指南</strong></div>
			<div class="about_b">
				<ul>
					<li><a href="#">门票订购流程是怎样的？</a></li>
					<li><a href="#">门票订购流程是怎样的？</a></li>
					<li><a href="#">门票订购流程是怎样的？</a></li>
					<li><a href="#">门票订购流程是怎样的？</a></li>
				</ul>
			</div>
		</div>
		<div class="about_n">
			<div class="about_a"><span><img src="<%=request.getContextPath() %>/front/static/img/grzx_66.jpg" /></span><strong>注册与登录</strong></div>
			<div class="about_b">
				<ul>
					<li><a href="#">门票订购流程是怎样的？</a></li>
					<li><a href="#">门票订购流程是怎样的？</a></li>
					<li><a href="#">门票订购流程是怎样的？</a></li>
					<li><a href="#">门票订购流程是怎样的？</a></li>
				</ul>
			</div>
		</div>
		<div class="about_n">
			<div class="about_a"><span><img src="<%=request.getContextPath() %>/front/static/img/grzx_69.jpg" /></span><strong>支付与取票</strong></div>
			<div class="about_b">
				<ul>
					<li><a href="#">门票订购流程是怎样的？</a></li>
					<li><a href="#">门票订购流程是怎样的？</a></li>
					<li><a href="#">门票订购流程是怎样的？</a></li>
					<li><a href="#">门票订购流程是怎样的？</a></li>
				</ul>
			</div>
		</div>
		<div class="about_n">
			<div class="about_a"><span><img src="<%=request.getContextPath() %>/front/static/img/grzx_72.jpg" /></span><strong>沟通与订阅</strong></div>
			<div class="about_b">
				<ul>
					<li><a href="#">门票订购流程是怎样的？</a></li>
					<li><a href="#">门票订购流程是怎样的？</a></li>
					<li><a href="#">门票订购流程是怎样的？</a></li>
					<li><a href="#">门票订购流程是怎样的？</a></li>
				</ul>
			</div>
		</div>
	</div>
	
</div>
</div>
<input type="hidden" id="myProvince" value="${user.province }"/>
<input type="hidden" id="myCity" value="${user.city }"/>

<jsp:include page="../common/footer.jsp"/>
<script src="<%=request.getContextPath() %>/front/static/js/jquery-1.7.2.js"></script>
<script src="<%=request.getContextPath() %>/front/static/js/chengtuUI.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/front/static/js/form.validate.js"></script>

<script>
 function provinceLoaded(){
 	  for(var i = 0; i < document.getElementById("captialId").options.length;i++) {  
    if (document.getElementById("captialId").options[i].value == $("#myProvince").val()){                
      document.getElementById("captialId").options[i].selected ="true";
      break; 
    }
   }
   $("#captialId").change();
}		
		
function cityLoaded(){
    for(var i = 0; i < document.getElementById("cityId").options.length;i++) {  
	if (document.getElementById("cityId").options[i].value == $("#myCity").val())
       {                
	    document.getElementById("cityId").options[i].selected ="true"; 
                        break;
       }
    }
  
}	

function modifyEmail(){
	var email = $("#email").val();
	var url = "<%=request.getContextPath() %>/user/updateUserEmail.htm";
	$.post(url,{email:email},function(result){
		alert(result.msg);
	});
}

function removeEmailBind(){
	var url = "<%=request.getContextPath() %>/user/removeEmailBind.htm";
	$.post(url,{},function(result){
		alert(result.msg);
	});
}

function sendVerifyEmail(){
	var url = "<%=request.getContextPath() %>/user/sendVerifyEmail.htm";
	$.post(url,{},function(result){
		alert(result.msg)
	});
}		
</script>

</body>
</html>
