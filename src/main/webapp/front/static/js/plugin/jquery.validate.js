(function(){
	window.common_validate = function(opt,notSendHttp){
		if($(this).is(":hidden")){
			notSendHttp();
			return true;
		}
		var phone = /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|170|18[0|1|2|3|5|6|7|8|9])\d{8}$/;
		var email = (/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/);
		var yahooEmail = /(@yahoo.com.cn)|(@yahoo.cn)/;
		var strHtml = '';
		$(opt.position+" .zhfs_state").hide();
		$(this).nextAll().filter(".zhfs_state").hide();
		$(this).siblings("img.validate_loading").remove();
		if(opt.empty && $.trim(this.value)==''){ //非空
			strHtml = '<span class="zhfs_state zhfs_v_error" validate="empty" ><i></i><label class="label_tip">'+opt.empty+'</label></span>';
			error_ouput(this,"empty",opt,strHtml);
			$(this).addClass("input_border_red");
			var tobj = this;
			setTimeout(function(){
				tobj.focus();
				tobj.select();
			},100);
			return false;
		}
		if(opt.express){
			var arr = opt.express;
			for(var i=0;i<arr.length;i++){
				if(!arr[i].func.call(this)){
					strHtml = '<span class="zhfs_state zhfs_v_error" validate="express'+i+'" ><i></i><label class="label_tip">'+arr[i].text+'</label></span>';
					error_ouput(this,"express"+i,opt,strHtml);
					$(this).addClass("input_border_red");
					var tobj = this;
					setTimeout(function(){
						tobj.focus();
						tobj.select();
					},100);
					return false;
				}
			}
		}
		if(opt.phone && (!phone.test(this.value.replace(/\s/g,"")) && this.value!="")){ //手机号
			strHtml = '<span class="zhfs_state zhfs_v_error" validate="phone" ><i></i><label class="label_tip">'+opt.phone+'</label></span>';
			error_ouput(this,"phone",opt,strHtml);
			$(this).addClass("input_border_red");
			var tobj = this;
			setTimeout(function(){
				tobj.focus();
				tobj.select();
			},100);
		}else if(opt.email && (!email.test(this.value) && this.value!="")){ //邮箱验证
			strHtml = '<span class="zhfs_state zhfs_v_error" validate="email" ><i></i><label class="label_tip">'+opt.email+'</label></span>';
			error_ouput(this,"email",opt,strHtml);
			$(this).addClass("input_border_red");
			var tobj = this;
			setTimeout(function(){
				tobj.focus();
				tobj.select();
			},100);
		}else if (opt.email && (yahooEmail.test(this.value) && this.value != "")) {
		    strHtml = '<span class="zhfs_state zhfs_v_error" validate="email" ><i></i><label class="label_tip">' + opt.yahooEmail + '</label></span>';
	        error_ouput(this,"email",opt,strHtml);
	        $(this).addClass("input_border_red");
	        var tobj = this;
	        setTimeout(function(){
	            tobj.focus();
	            tobj.select();
	        },100);
		}else { //成功
			if(opt.noSuccess){
				return true;
			}
			var loop = function(_this,opt){
				notSendHttp && notSendHttp();
				if(_this.value==""){
					$(_this).removeClass("input_border_red");
					return true;
				}
				var strHtml = '<span class="zhfs_state zhfs_v_success" validate="pass"><i></i><label class="label_tip">'+(opt.pass||"")+'</label></span>';
				opt.position = ":last";
				error_ouput(_this,"pass",opt,strHtml);
				$(_this).removeClass("input_border_red");
				return true;
			}
			var callback = window[this.id+"_callback"];
			if(callback){
				var _this = this;
				$(_this).parent().find(":last").after("<img class='validate_loading' src='http://pic.lvmama.com/img/new_v/ob_login/validate_loading.gif'/>");
				callback.call(_this,function(){
					$(_this).siblings("img.validate_loading").remove();
					loop(_this,opt);
				});
				return 1;
			}else{
				return loop(this,opt);
			}
		}
	}
	function error_ouput(tobj,v1,opt,strHtml){
		var obj = $(tobj).nextAll().filter("[validate='"+v1+"']");
		if(opt.position && /^[^\:]+/.test(opt.position)){
			obj = $(opt.position+" [validate='"+v1+"']");
		}
		if(obj.length==0){
			if(opt.position){
				if(/^\:/.test(opt.position)){
					$(tobj).parent().children().filter(opt.position).after(strHtml);
				}else{
					$(opt.position).html(strHtml);
				}
			}else{
				$(tobj).after(strHtml);
			}
		}else{
			if(opt.position && /^[^\:]+/.test(opt.position)){
				$(opt.position).html(strHtml);
			}else{
				obj.replaceWith(strHtml);
			}
		}
	}
	//邮箱补全提示
	window.email_auto = function(selector){
		var elt = $(selector);
		var strHtml = '<div class="login_autoComplete" id="login_autoComplete">'+
					'		<ul class="login_auto_ul">'+
					'			<li class="login_auto_title">请选择邮箱后缀</li>'+
					'			<li class="hover" hz="@qq.com"></li>'+
					'			<li hz="@163.com"></li>'+
					'			<li hz="@126.com"></li>'+
					'			<li hz="@sina.com"></li>'+
					'			<li hz="@21cn.com"></li>'+
					'		</ul>'+
					'	</div>';
		var lc = "#login_autoComplete";
		var autoComplete,autoLi;
		if($(lc).length==0){
			$("body").append(strHtml);
			$(lc).data("elt",elt);
			autoComplete = $("#login_autoComplete");
			autoLi = autoComplete.find("li:not(.login_auto_title)");
			autoLi.mouseover(function(){
				$(this).siblings().filter(".hover").removeClass("hover");
				$(this).addClass("hover");
			}).mouseout(function(){
				$(this).removeClass("hover");
			}).mousedown(function(){
				$(lc).data("elt").val($(this).text()).change();
				$(this).parent().parent().hide();
			});
		}else{
			$(lc).data("elt",elt);
			autoComplete = $("#login_autoComplete");
			autoLi = autoComplete.find("li:not(.login_auto_title)");
		}
		$(lc).css("width",elt.outerWidth()-1);
		//用户名补全+翻动
		elt.keyup(function(e){
			if(/13|38|40|116/.test(e.keyCode) || this.value==''){
				return false;
			}
			var username = this.value;
			if(username.indexOf("@")==-1){
				autoComplete.hide();
				return false;
			}
			autoLi.each(function(){
				this.innerHTML = username.replace(/\@+.*/,"")+$(this).attr("hz");
				if(this.innerHTML.indexOf(username)>=0){
					$(this).show();
				}else{
					$(this).hide();	
				}
			}).filter(".hover").removeClass("hover");
			autoComplete.show().css({
				left : $(this).offset().left,
				top : $(this).offset().top + $(this).outerHeight(true) - 1
			});
			if(autoLi.filter(":visible").length==0){
				autoComplete.hide();
			}else{
				autoLi.filter(":visible").eq(0).addClass("hover");			
			}
		}).change(function(){
			$("#login_autoComplete").hide();
		}).keydown(function(e){
			if(e.keyCode==38){ //上
				autoLi.filter(".hover").prev().not(".login_auto_title").addClass("hover").next().removeClass("hover");
			}else if(e.keyCode==40){ //下
				autoLi.filter(".hover").next().addClass("hover").prev().removeClass("hover");
			}else if(e.keyCode==13){ //Enter
				autoLi.filter(".hover").mousedown();
			}
		}).focus(function(){
			$("#login_autoComplete").data("elt",$(this));
		});
	}
	//错误提示
	function error_tip(elt,msg,position,clsName){
		$(elt).siblings("img.validate_loading").remove();
		clsName = clsName?clsName:"";
		var _this = $(elt);
		_this.nextAll().filter(".zhfs_state").hide();
		strHtml = '<span class="zhfs_state zhfs_v_error '+clsName+'" validate="msg" ><i></i><label class="label_tip">'+msg+'</label></span>';
		error_ouput(_this,"msg",{position:position},strHtml);
		_this.addClass("input_border_red");
		var tobj = _this[0];
		setTimeout(function(){
			tobj.focus();
			tobj.select();
		},100);
	}
	UI.extend.validate = function(option){
		var opt = {
			active : null,
			phone : null,
			email : null,
			empty : null,
			pass : ""
		}
		$.extend(opt,option);
		if(opt.active || opt.active===""){
			$(this).focus(function(){
				var posSlt = null;
				if(opt.position && /^[^\:]+/.test(opt.position)){
					posSlt = $(opt.position+" .zhfs_state:visible");
				}else{
					posSlt = $(this).nextAll().filter(".zhfs_state:visible");
				}
				if(posSlt.length>0){
					return;
				}
				var clsName = opt.className?opt.className:"";
				if(opt.active){
					var strHtml = '<span class="zhfs_state zhfs_v_info '+clsName+'" validate="active" ><i></i><label class="label_tip">'+opt.active+'</label></span>';
					error_ouput(this,"active",opt,strHtml);
				}
				$(this).addClass("login_input_color");
			}).blur(function(){
				if(opt.position && /^[^\:]+/.test(opt.position)){
					$(opt.position+" [validate='active']").hide();
				}else{
					$(this).nextAll().filter("[validate='active']").hide();
				}
				$(this).removeClass("login_input_color");
			});
		}
		if(opt.phone || opt.empty || opt.email){
			$(this).change(function(){
				var newObj = {};
				for(var n in opt){
					newObj[n] = opt[n];
				}
				common_validate.call(this,newObj);
			});
			if(opt.email){
				email_auto(this);
			}
		}
		
	}
	window.error_tip = error_tip;
})(jQuery);