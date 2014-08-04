(function($){
	UI.extend.slideMenu = function(opt){
		var option = {
			menu1 : undefined,
			menu2 : undefined,
			hover : "",
			effect : "show"
		}
		$.extend(option,opt);
		var menu1 = $(this).find(opt.menu1);
		var menu2 = $(this).find(opt.menu2);
		var hover = opt.hover;
		var effect = opt.effect;
		if(menu1.length>0){
			menu1.openMenu({
				slt : menu2,
				hover : hover,
				position : true,
				effect : effect
			});
		}
	}
	function outEvent(thisObj,settings){
		switch(settings.effect){
			case "show":
				$(settings.slt).hide();
				break;
			case "fadeIn":
				$(settings.slt).fadeOut("fast");
				break;
			case "slideDown":
				$(settings.slt).slideUp("fast");
				break;
		}
		if(typeof settings.hover=="string"){
			$(thisObj).removeClass(settings.hover);
		}else if(typeof settings.hover=="object"){
			$(settings.hover.slt).removeClass(settings.hover.hover);
		}
	}
	$.fn.openMenu = function(options){
		var settings = {
			slt : undefined,
			position : undefined,
			event : "mouseenter",
			hover : undefined,
			effect : "show"
		};
		if (options) {
			$.extend(settings, options)
		}
		$(settings.slt).hide();
		var thisObj = this;
		if(settings.position){
			$(settings.slt).css({
				position : "absolute",
				zIndex : 999,
				left : $(this).position().left + (settings.left||0),
				top : $(this).position().top + $(this).height() + (settings.top||0)
			});
		}
		$(thisObj)[settings.event](function(){
			if(settings.effect=="show"){
				$(settings.slt)[settings.effect]();
			}else{
				$(settings.slt)[settings.effect]("fast");
			}
			if(typeof settings.hover=="string"){
				$(thisObj).addClass(settings.hover);
			}else if(typeof settings.hover=="object"){
				$(settings.hover.slt).addClass(settings.hover.hover);
			}
		}).mouseout(function(e){
			var s = e.toElement || e.relatedTarget;
			if(document.all){
				if(!this.contains(s)){
					var bl = (e.clientX+(settings.left||0) > ($(this).offset().left + $(this).width()));
					if(e.clientY+$(window).scrollTop()-5 <= $(this).offset().top || e.clientX-5 <$(this).offset().left || bl){
						outEvent(thisObj,settings);
					}
				}
			}else{
				var res = this.compareDocumentPosition(s);
				if(!(res==20 || res==0)){
					var bl = (e.clientX+(settings.left||0) > ($(this).offset().left + $(this).width()));
					if(e.clientY+$(window).scrollTop() < $(this).offset().top || e.clientX <$(this).offset().left || bl){
						outEvent(thisObj,settings);
						
					}
				}
			}
		});
		$(settings.slt).mouseout(function(e){
			var s = e.toElement || e.relatedTarget;
			if(document.all){
				if(!this.contains(s)){
					outEvent(thisObj,settings);					
				}
			}else{
				var res = this.compareDocumentPosition(s);
				if(!(res==20 || res==0)){
					outEvent(thisObj,settings);
				}
			}
		});
	}
})(jQuery);