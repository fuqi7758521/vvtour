(function($) {
	var p = null;
	$.fn.openDialog = function(options){
		if(this.size()==0){
			return null
		}
		var settings = {
			dymamic : false,
			opacity : 0.2,
			backgroundColor : "#aaa",
			positionTo : "",
			speed : 300,
			clickOtherClose : false,
			border : false
		};
		if (options) {
			$.extend(settings, options)
		};
		if(settings.dialogType!="ui"){
			p = settings;
		}
		
		var width = $(document).width();
		var height = $(document).height();
		var thisObj = this;
		var bl = !!settings.zIndex;
		settings.zIndex = settings.zIndex || 1000; //打开第一个dialog的时候，他的zIndex值设定为10000，同时打开第N的时候，zIndex增大
		if(settings.border){
			var pwidth = thisObj.show().width();
			thisObj = thisObj.wrap('<div style="position: relative;width:'+pwidth+'px" class="popwrap"><div class="popcon faceImg_pop"></div></div>').parent().after('<b class="bg_mask" style="width:'+(pwidth+20)+'px"></b>').parent();
		}
		var allOpenDialog = $(thisObj[0].tagName+".open_dialog_jquery");
		if(allOpenDialog.size()>0){
			var arr = allOpenDialog.toArray().sort(function(a,b){
				return $(a).css("zIndex")<$(b).css("zIndex");
			});
			if(!bl)
			settings.zIndex = parseInt($(arr[0]).css("zIndex"))+2;
		}
		$(this).addClass("open_dialog_jquery");
		var bgZIndex = settings.zIndex-1;
		var bgId = $(this).attr("bgid");
		if(!bgId){
			bgId = "#bg_x_" + bgZIndex;
			$(this).attr("bgid",bgId);
		}
		/************************屏蔽弹层**************************/
		//settings.backgroundColor = false;
		if(settings.backgroundColor){
			if($(bgId).size()==0){
				$("body").append("<div style=\"position:absolute;left:0px;top:0px;width:100%;height:"+height+"px;background-color:"+settings.backgroundColor+";z-index:"+bgZIndex+";display:none;\" id='"+bgId.substring(1)+"'></div>");
			}else{
				$(bgId).css("height",$(document).height());
			}
		}
		thisObj.hide();
		if(settings.backgroundColor){
			if(settings.dymamic){
				$(bgId).fadeTo(0,0).show().fadeTo(settings.speed,settings.opacity,function(){
					positionInit(thisObj,settings,width,height);
				});
			}else{
				var b = $(bgId);
				if(!b.attr("isOpacity")){
					b.fadeTo(0,settings.opacity);
					b.attr("isOpacity",true);
				}
				b.css("display","block");
				positionInit(thisObj,settings,width,height);
			}
		}else{
			positionInit(thisObj,settings,width,height)
		}
			
		if(p && p.clickOtherClose){
			$(bgId).one("click",function(){
				$(thisObj).closeDialog();
				if(typeof p.onclose == 'function'){
					p.onclose();
				}
			});
		}
		if(p && p.close){
			thisObj.find(p.close).one("click",function(){
				$(thisObj).closeDialog();
				if(typeof p.onclose == 'function'){
					p.onclose();
				}
			});
		}
	}
	$.fn.closeDialog = function(){
		this.hide();
		this.removeClass("open_dialog_jquery");
		var bgId = $(this).attr("bgid");
		if(p && $(bgId).length>0){
			if(p.dymamic){
				$(bgId).fadeOut(300);
			}else{
				$(bgId).hide();
			}
		}
		if(p && p.onclose){
			p.onclose();
		}
		return this;
	}
	function positionInit(thisObj,settings,width){
		var positionTo = settings.positionTo;
		var tmpHeight = 0;
		var tmpScrollTop = $(window).scrollTop();
		var top = 0;
		var left = 0;
		if(positionTo){ //如果指定了基于哪个层进行定位
			var p = null,addLeft=0,addTop=0;
			if(typeof positionTo=="string"){
				p = $(positionTo);
			}else if(typeof positionTo=="object"){
				p = $(positionTo.slt);
				addLeft = positionTo.left || 0;
				addTop = positionTo.top || 0;
			}
			tmpHeight = p.height();
			width = p.width();
			top = p.offset().top + addTop;
			left = p.offset().left + addLeft;
		}else{
			tmpHeight = $(window).height();
			top = (tmpHeight - thisObj.height())/2 + tmpScrollTop;
			left = (width - thisObj.width())/2;
			
		}
		if(top<0){
			top = 0;
		}
		if(left<0){
			left = 0;
		}
		thisObj.css({
			position:"absolute",margin:"0 0 0 0",zIndex:settings.zIndex,top:top-20,left:left,display:"block"
		});
	}
})(jQuery);
