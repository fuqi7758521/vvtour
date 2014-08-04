(function($){
	UI.extend.tab = function(opt){
		var option = {
			tab1 : undefined,
			tab2 : undefined,
			hover : undefined,
			active : undefined,
			onclick : null,
			trigger : "click"
		}
		$.extend(option,opt);
		var tab1 = $(this).find(opt.tab1).children();
		var tab2 = $(this).find(opt.tab2).children().hide();
		var active = opt.active;
		var hover = opt.hover;
		var prev1 = null,prev2 = null;;
		tab1[opt.trigger](function(e,arg1){
			var index = $(this).index();
			if(prev1!=null && prev1[0] != this){
				$(prev1).removeClass(active);
				$(prev2).hide();
			}
			prev1 = $(this).addClass(active);
			prev2 = tab2.eq(index).show();
			(typeof opt.onclick == 'function' && arg1!=1) && opt.onclick.call(this);
		});	
		if(hover){
			tab1.hover(function(){
				$(this).addClass(hover);	
			},function(){
				$(this).removeClass(hover);
			});
		}
		tab1.eq(0).trigger(opt.trigger,[1]);
	}
})(jQuery);