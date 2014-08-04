(function($){
	UI.extend.roller = function(opt){
		var option = {
			roller1 : undefined,
			roller2 : undefined,
			effect : undefined,
			selectedIndex : undefined,
			hover : undefined,
			active : undefined
		}
		$.extend(option,opt);
		var r1 = $(this).find(opt.roller1);
		var r2 = $(this).find(opt.roller2);
		var effect = opt.effect;
		var selectedIndex = opt.selectedIndex;
		var hover = opt.hover;
		var active = opt.active;
		var parm = ["click","slideUp","slideToggle"];
		switch(effect){
			case "hover":
				parm = ["mouseenter","hide","show"];
				break;
		}
		var prev = null,prevThis = null;;
		r1.each(function(i){
			$(this)[parm[0]](function(){
				if(prev!=null && prevThis!=this){
					prev[parm[1]]();
					active&&$(prevThis).removeClass(active);
				}
				prev = r2.eq(i)[parm[2]]();
				active&&$(this).addClass(active);
				prevThis = this;
			});
			if(hover){
				$(this).hover(function(){
					$(this).addClass(hover);
				},function(){
					$(this).removeClass(hover);
				});
			}
		});
		if(selectedIndex){
			r1.eq(parseInt(selectedIndex))[parm[0]]();
		}
	}
})(jQuery);