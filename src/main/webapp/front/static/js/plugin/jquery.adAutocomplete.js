(function($){
	UI.extend.adAutoComplete = function(option){
		/*
			option:{
				type --类型
				main --当type为2、3时，设置它依赖的第一项补全框
			}
		*/
		
		var inputSel = this;
		var input = $(inputSel);
		option.value && input.val(option.value);
		option.channelId && input.attr("channelId",option.channelId);

		if(input.hasClass("adAuto") && !input.next().is(".adAutoI")){
			input.after('<i class="adAutoI"></i>');
			input.next().click(function(){
				input.trigger('keyup',[option.type]);
				input.focus();
				//让光标移到文本框末尾
				var str = input.val();
				input.val(str+"s");
				input.val(str);
				
			});
		}
		var ad_main1 = "ad_main1";
		var ad_data_list = "ad_data_list";
		var str = '<div class="ad_main1" id="'+ad_main1+'">'+
				'	<div class="ad_main2">'+
				'		<div class="ad_title">'+
				'			<span class="ad_bh">编号</span>'+
				'			<span class="ad_qd">渠道</span>'+
				'		</div>'+
				'		<ul class="ad_data_list" id="'+ad_data_list+'">'+
				'		</ul>'+
				'	</div>'+
				'</div>';
		ad_main1 = "#"+ad_main1;
		ad_data_list = "#"+ad_data_list;
		if($(ad_main1).length==0){
			$("body").append(str);
			$(ad_data_list).delegate("li","mousedown",function(){
				var input = $(ad_data_list).data("input");
				input.val($(this).find(".ad_qd").text());
				input.attr("channelId",$(this).find(".ad_bh").text());
			}).delegate("li","mouseover",function(){
				$(this).addClass("hover").siblings(".hover").removeClass("hover");
			}).delegate("li","mouseout",function(){
				$(this).removeClass("hover");
			});
		}
		input.keyup(function(e,type){
			if(/38|40|13|9/.test(e.keyCode)){
				return;
			}
			$(ad_data_list).data("input",$(this));
			$(this).removeAttr("channelId");
			var main = $(ad_main1);
			var datalist = $(ad_data_list);
			if(this.value=="" && !type){
				main.hide();
			}else{
				main.css({
					left : $(this).offset().left,
					top : $(this).offset().top + $(this).outerHeight(true)
				});
				var data = {
					layer : type || option.type,
					keywords : this.value
				}
				if(option.main && option.type!=1){
					var channelId = $(option.main).attr("channelId");
					if(!channelId){
						return false;
					}
					data.channelId = channelId
				}

				$.post("http://super.lvmama.com/pet_back/mark/channel/ajaxMarkChannelQuery.do",data,function(str){
					var data = eval(str);
					if(data instanceof Array && data.length>0){
						var arr = [];
						for(var i=0;i<data.length;i++){
							if(i>=10){
								break;
							}
							var n = data[i];
							arr.push('<li>'+
							'	<span class="ad_bh">'+n.channelId+'</span>'+
							'	<span class="ad_qd">'+n.channelName+'</span>'+
							'</li>');
						}
						datalist.html(arr.join(""));
						main.show();
						$(ad_data_list+" li:first").addClass("hover");
					}else{
						main.hide();
					}
				});
			}
		}).blur(function(){
			setTimeout(function(){
				$("#ad_main1").hide();
			},50);
		}).keyup(function(e){
			if($(ad_data_list).is(":hidden")){
				return false;
			}
			if(e.keyCode==40){
				var li = $(ad_data_list+" li.hover");
				if(li.length==0){
					li = $(ad_data_list+" li:first");
				}else{
					li = li.next();
				}
				li.addClass("hover").siblings(".hover").removeClass("hover");
			}else if(e.keyCode==38){
				var li = $(ad_data_list+" li.hover");
				if(li.length==0){
					li = $(ad_data_list+" li:first");
				}else{
					li = li.prev();
				}
				li.addClass("hover").siblings(".hover").removeClass("hover");
			}else if(e.keyCode==13){
				var currLi = $(ad_data_list+" li.hover");
				input.val(currLi.find(".ad_qd").text());
				input.attr("channelId",currLi.find(".ad_bh").text());
				$(ad_main1).hide();
			}
		});
	}
})(jQuery);