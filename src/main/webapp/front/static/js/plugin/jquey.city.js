(function($){
	var ui = UI;
	ui.extend.city = function(opt){
		var option = {
			province : undefined,
			city : undefined,
			area : undefined
		}
		$.extend(option,opt);
		var elt = $(this);
		var resource = [
			ui.site+"plugin/city/json-array-of-province.js",
			ui.site+"plugin/city/json-array-of-city.js",
			ui.site+"plugin/city/json-array-of-district.js"
			];
		if(!opt.area){
			resource[1] = ui.site+"plugin/city/json-array-of-city-new.js";
		}

		ui.getJSON("provinceList",resource[0],function(){
			var item = $.provinceList;
			var arr = ["<option value=''>--请选择--</option>"];
			$.each(item,function(i,n){
				arr.push('<option value="'+n.code+'">'+n.name+'</option>');
			});
			elt.find(opt.province).html(arr.join(""));
			window.provinceLoaded && window.provinceLoaded();
		});
		if(elt.find(opt.city).length>0){
			elt.find(opt.province).change(function(){
				var _this = this;
				ui.getJSON("cityList",resource[1],function(){
					var item = $.cityList;
					var key = _this.value;
					item = item[key];
					if(!item){
						return;
					}
					var arr = ["<option value=''>--请选择--</option>"];
					for(var i=0;i<item.length;i++){
						var n = item[i];
						arr.push('<option value="'+n.code+'">'+n.name+'</option>');
					}
					elt.find(opt.city).html(arr.join(""));
					window.cityLoaded && window.cityLoaded();
				});
			});
		}
		return;
		if(elt.find(opt.area).length>0){
			elt.find(opt.city).change(function(){
				var _this = this;
				ui.getJSON("areaList",resource[2],function(){
					var item = $.areaList;
					item = item[_this.value];
					var arr = ["<option value=''>--请选择--</option>"];
					$.each(item,function(i,n){
						arr.push('<option value="'+n.code+'">'+n.name+'</option>');
					});
					elt.find(opt.area).html(arr.join(""));
					window.areaLoaded && window.areaLoaded();
				});
			});
		}
	}
})(jQuery);