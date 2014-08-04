(function(){
	UI.extend.preview = function(option){
		var opt = {
			showWait : 2000,
			hideWait : 5000,
			speed : 400
		};
		$.extend(opt,option);
		var elt = $(this);
		elt.find("img").eq(0).load(function(){
			elt.delay(opt.showWait).slideDown(opt.speed).delay(opt.hideWait).slideUp(opt.speed);
		});
		elt.find("a").click(function(){
			elt.stop().slideUp(opt.speed);
		});
	}
})(jQuery);