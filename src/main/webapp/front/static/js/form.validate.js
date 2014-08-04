$(function(){
	var isGoOn = false;
	var tmpdataobj = {
		sso_membership : {
			active : "请输入有效的会员卡号",
			empty : "请输入有效的会员卡号"
		},
		sso_mobile : {
			active : "请填写您真实的手机号码，作为诚途的登录账号",
			empty : "手机号码不能为空",
			phone : "请输入有效的手机号码"
		},
		sso_mobile2 : {
			active : "请填写您真实的手机号码",
			empty : "手机号码不能为空",
			phone : "请输入有效的手机号码"
		},
		sso_username : {
			active : "4-16个字符，中英文均可，一个中文为2个字符，推荐使用中文名",
			className : "reg_mtop",
			empty : "用户名不能为空",
			express : [{
				text : "用户名在4-16个字符内",
				func : function(){
					var text = $(this).val();
					var len = text.length + text.replace(/[^\u4e00-\u9fa5]+/g,"").length;
					return (len>=4 && len<=16);
				}
			},{
				text : "包含非法字符",
				func : function(){
					var text = $(this).val();
					var len = text.length + text.replace(/[^\u4e00-\u9fa5]+/g,"").length;
					return (/^[\_a-z0-9\u4e00-\u9fa5]+$/i.test(text) && (len>=4 && len<=16));
				}
			},{
				text : "不能全为数字",
				func : function(){
					var text = $(this).val();
					return !/^[\d]+$/.test(text);
				}
			}]
		},
		sso_oldPassword : {
			active : "请输入旧密码",
			empty : "旧密码不能为空",
			express : [{
				text : "密码在6-16个字符内",
				func : function(){
					var text = $(this).val();
					return (text.length>=6 && text.length<=16);
				}
			}]
		},
		sso_password : {
			active : "6-16个字符，推荐使用英文字母加数字的组合密码",
			empty : "密码不能为空",
			express : [{
				text : "密码在6-16个字符内",
				func : function(){
					var text = $(this).val();
					return (text.length>=6 && text.length<=16);
				}
			}]
		},
		sso_againPassword : {
			active : "请再次输入密码",
			empty : "两次密码输入不一致",
			express : [{
				text : "两次密码输入不一致",
				func : function(){
					var pwd1 = $(this).val();
					var pwd2 = $("#sso_password").val();
					return pwd2==pwd1;
				}
			}]
		},
		sso_email : {
			active : "请填写常用的Email地址",
			email : "请输入有效的Email地址"
		},
		sso_email_b : {
			active : "请填写常用的Email地址，作为诚途的登录账号",
			empty : "email地址不能为空",
			email: "请输入有效的Email地址",
			yahooEmail: "您输入的电子邮箱域名不能注册成功，请更换其它邮箱"
		},
		sso_email_c : {
			active : "请填写常用的Email地址",
			empty : "email地址不能为空",
			email : "请输入有效的Email地址"
		},
		sso_verifycode1 : {
			active : "请输入验证码",
			empty : "验证码不能为空",
			express : [{
				text : "验证码输入错误",
				func : function(){
					var len = this.value.length;
					var length = parseInt($(this).attr("length") || 4);
					return len==length;
				}
			}],
			position : ":last"
		},
		sso_verifycode2 : {
			active : "请输入短信校验码",
			empty : "短信校验码不能为空"
		},
		sso_verifycode3 : {
			active : "请输入短信校验码",
			empty : "短信校验码不能为空",
			express : [{
				text : "校验码输入错误",
				func : function(){
					var len = this.value.length;
					var length = parseInt($(this).attr("length") || 6);
					return len==length;
				}
			}],
			position : ":last"
		},
		sso_verifycode4 : {
			active : "请输入短信校验码",
			empty : "短信校验码不能为空",
			express : [{
				text : "校验码输入错误",
				func : function(){
					var len = this.value.length;
					var length = parseInt($(this).attr("length") || 6);
					return len==length;
				}
			}],
			position : ":last"
		}
	};
	$("#sso_password").change(function(){
		var apwd = document.getElementById("sso_againPassword");
		if(this.value!="" && this.value == apwd.value){
			$(apwd).change();
		}
	});
	var tmpArr = [];
	for(var n in tmpdataobj){
		var elt = $("#"+n);
		elt.length>0 && tmpArr.push(elt);
	}
	var input_s = $("input.zhfs_form_input");
	tmpArr.sort(function(a,b){
		return input_s.index(a) > input_s.index(b);
	});
	var dataobj = {};
	for(var i=0;i<tmpArr.length;i++){
		dataobj[tmpArr[i].attr("id")] = tmpdataobj[tmpArr[i].attr("id")];
	}
	for(var n in dataobj){
		$("#"+n).val("").ui("validate",dataobj[n]);
	}
	if($("#captialId").length>0 && $("#cityId").length>0){
		$("body").ui("selectArea",{
			province : "#captialId",
			city : "#cityId"
		});
	}
	
	$("#submitBtn").click(function(){
		if($(this).hasClass("btn-disabled")){
			return;
		}
		$.validate(dataobj,"",function(){
			window.validate_pass && window.validate_pass();
		});
	});
	var lihide = $("#emailRegForm li.hide");
	if(lihide.size()>0){
		$("#sso_email_b").one("click",function(){
			lihide.show();
		});
	}
	//诚途服务条款
	$("#chengtu_tk").click(function(){
		$(this).next().toggleClass("showBlock");
	});
});
!function(window){
	var ua = window.navigator.userAgent.toLowerCase(), 
	reg = /msie|applewebkit.+safari/;
	if(reg.test(ua)){
		var _sort = Array.prototype.sort;
		Array.prototype.sort = function(fn){
			if(!!fn && typeof fn === 'function'){
				if(this.length < 2) return this;
				var i = 0, j = i + 1, l = this.length, tmp, r = false, t = 0;
				for(;i < l;i++){
					for(j = i + 1;j < l;j++){
						t = fn.call(this, this[i], this[j]);
						r = (typeof t === 'number' ? t : 
						!!t ? 1 : 0) > 0 
						? true : false;
						if(r){
							tmp = this[i];
							this[i] = this[j];
							this[j] = tmp;
						}
					}
				}
				return this;
			}
			else{
				return _sort.call(this);
			}
		};
	}
}(window);
function refreshCheckCode(s){
    var elt = document.getElementById(s);
    elt.src = elt.src + "?_="+new Date().getTime();
}
var form_validate = true;