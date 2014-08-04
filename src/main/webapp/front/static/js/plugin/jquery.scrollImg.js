(function($){
	UI.extend.scrollImg = function(opt){
		var option = {
			prev : null,
			next : null,
			scrollImg : null
		}
		$.extend(option,opt);
		var prev = $(this).find(opt.prev);
		var next = $(this).find(opt.next);
		var si = $(this).find(opt.scrollImg);
		var sicr = si.children();
		var num = Math.round(si.parent().width()/sicr.width());
		si.css("width",sicr.width()*(sicr.length+num));
		var index = 1;
		var speed = 700;
		var len = sicr.length;
		for(var i=num;i>0;i--){
			sicr.eq(0).before(sicr.eq(len-i).clone());
		}
		si.css("left",-sicr.width()*num);
		var maxIndex = Math.ceil(len/num);
		prev.click(function(){
			if(si.filter(":animated").length>0){
				return;
			}
			index--;
			if(index<0){
				index = maxIndex;
				si.css("left",-si.parent().width()*index);
				index--;
			}
			si.animate({
				left : -si.parent().width()*index
			},speed);
		});
		next.click(function(){
			if(si.filter(":animated").length>0){
				return;
			}
			index++;
			if(index>maxIndex){
				index = 1;
				si.css("left",0);
			}
			si.animate({
				left : -si.parent().width()*index
			},speed);
		});
	}
})(jQuery);