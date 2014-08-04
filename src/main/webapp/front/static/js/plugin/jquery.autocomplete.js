(function($){
	var FUNCTION;
	$.fn.extend({
		hotelAutocomplete : function(parms){
			var img = new Image();
			img.src = "http://pic.lvmama.com/img/new_v/ob_yjdy/y_loading.gif";
			var option = {
				type : -1,
				url : "",
				top10 : false,
				recommend : true,
				city_element : $(this),
				scenic_element : $("#scenic_element"),
				hotel_element : $("#hotel_element"),
				page_count : 10,
				fromDest : "",
				fromDestId : "",
				auto_local : ""
			};
			$.extend(option,parms);
			switch(option.type){
				case 2:
					option.scenic_element = $(this);
					break;
				case 3:
					option.hotel_element = $(this);
					break;
			}
			
			if(option.type!=-1){
				option.auto_local = "auto_local";
			}
			FUNCTION = {
				city_element : option.city_element,
				scenic_element : option.scenic_element,
				city : function(keyword,e,option){//城市自动补全
					if(!FUNCTION.keyCodeFilter(e,option.city_element)){
						return;
					}
					if(option.city_element.attr("cityid")){
						option.city_element.removeAttr("cityid");
					}
					option.city_element.attr("lastvalue",option.city_element.val());
					if($.trim(keyword)==""){
						$("#city_autocomplete").hide();
						return;
					}
					if(option.type==1 && option.city_element.attr("url")){
						option.city_element.removeAttr("url");
					}
					var url = "http://www.lvmama.com/search/autocomplete/hotelSearch.do?keyword="+keyword+"&callback=?";
					url = option.url?(option.url+"?keyword="+keyword+"&fromDest="+(option.fromDest?option.fromDest.find("option:selected").text():"")+"&fromDestId="+(option.fromDest?option.fromDest.val():"")+"&toDest="+keyword+"&callback=?") : url;
					//console.log("5:"+url);
					FUNCTION.loading(option.city_element);
					$.httpAjax && ($.httpAjax.abort());
					$.httpAjax = $.getJSON(url,function(item){
						var strHtml = '<div style="z-index: 9999;position:absolute;" class="PycityAll" id="city_autocomplete"><div class="PycityTit">l,按拼音排序</div><div id="ulcitylist" class="_use"></div><p class="PycityPage _use"><span>1</span><span id="canClick"><a href="javascript:void(0)">2</a></span></p> </div>';
						$("#city_autocomplete").remove();
						var cityauto = $("#city_autocomplete");
						var citylist = $("#ulcitylist");
						if(cityauto.size()==0){
							$("body").append(strHtml);
							cityauto = $("#city_autocomplete");
							citylist = $("#ulcitylist");
							citylist.delegate("a","click",function(){ //点击选择城市
								cityauto.hide();
								option.city_element.val(this.name);
								if(option.type==1){
									option.city_element.attr("url",this.id);
								}else{
									option.city_element.attr("cityid",this.id);	
								}
								option.scenic_element.val("中文/拼音");
								option.hotel_element.val("中文/拼音");
							});
							FUNCTION.keyevent(option.city_element,citylist,option);//键盘上下调整
						}
						var p = $(option.city_element).offset();
						cityauto.css({
							left : p.left,
							top : p.top + $(option.city_element).outerHeight(false)
						});
						if(!FUNCTION.validate(item,cityauto,option.city_element)){
							return;
						}
						FUNCTION.page(cityauto,item);
						var arr = ["<ul>"];
						$.each(item.placeListJson,function(i,n){
							arr.push('<li><a class="'+option.auto_local+'" name="'+n.name+'" id="'+n.pinYin+'" href="javascript:void(0)">'+n.name+'</a></li>');
							if((i+1)%option.page_count==0){
								arr.push("</ul><ul class='dn'>");
							}
						});
						arr.push("</ul>");
						citylist.html(arr.join(""));
						citylist.find("ul:visible").find("a").eq(0).css("backgroundColor","#f1f1f1");  //第一行选中
					});
				},
				scenic : function(keyword,cityId,e,option){//景点自动补全
					if(!FUNCTION.keyCodeFilter(e,option.scenic_element)){
						return;
					}
					if($.trim(keyword)==""){
						$("#scenic_autocomplete").hide();
						return false;
					}
					if(!option.city_element.attr("cityid") && option.type==-1){
						return;
					}
					var url = "http://www.lvmama.com/search/autocomplete/hotelSearch.do?keyword="+keyword+"&cityId="+cityId+"&callback=?";
					url = option.url?(option.url+"?keyword="+keyword+"&fromDest=&toDest="+keyword+"&callback=?") : url;
					//console.log("1:"+url);
					if(option.url.indexOf("callback")>=0){
						url = option.url + "&fromDest="+encodeURI($("#fromDestSelect").find("option:selected").text())+"&fromDestId="+$("#fromDestSelect").val()+"&toDest="+encodeURI($("#searchOthers").val())+"&keyword="+encodeURI($("#searchOthers").val());
					}
					FUNCTION.loading(option.scenic_element);
					$.httpAjax && ($.httpAjax.abort());
					$.httpAjax = $.getJSON(url,function(item){
						var strHtml = '<div style="z-index: 9999;position:absolute;" class="PycityAll" id="scenic_autocomplete"><div class="PycityTit">l,按拼音排序</div><div id="ulsceniclist" class="_use"></div><p class="PycityPage _use" style="display:none"></p> </div>';
						$("#scenic_autocomplete").remove();
						var scenicauto = $("#scenic_autocomplete");
						var sceniclist = $("#ulsceniclist");
						if(scenicauto.size()==0){
							$("body").append(strHtml);
							scenicauto = $("#scenic_autocomplete");
							sceniclist = $("#ulsceniclist");
							sceniclist.delegate("a","click",function(){
								scenicauto.hide();
								option.scenic_element.val(this.name).attr({
									sublabel : $(this).attr("id"),
									url : $(this).attr("pinyin")
								});;
							});
							FUNCTION.keyevent(option.scenic_element,sceniclist,option);//键盘上下调整
						}
						var p = $(option.scenic_element).offset();
						scenicauto.css({
							left : p.left,
							top : p.top + $(option.scenic_element).outerHeight(false)
						});
						scenicauto.nodatahide = true;
						if(!FUNCTION.validate(item,scenicauto,option.scenic_element)){
							return;
						}
						if(option.page){
							FUNCTION.page(scenicauto,item);
						}
						var arr = ["<ul>"];
						$.each(item.placeListJson,function(i,n){
							arr.push('<li><a class="'+option.auto_local+'" name="'+n.name+'" id="'+(n.id || n.pinYin)+'" pinyin="'+n.pinYin+'" href="javascript:void(0)">'+n.name+'</a></li>');
							if((i+1)%option.page_count==0){
								arr.push("</ul><ul class='dn'>");
							}
						});
						arr.push("</ul>");
						sceniclist.html(arr.join(""));
						sceniclist.find("ul:visible").find("a").eq(0).css("backgroundColor","#f1f1f1");  //第一行选中
					});
				},
				hotel : function(keyword,cityId,e,option){ //酒店自动补全
					if(!FUNCTION.keyCodeFilter(e,option.hotel_element)){
						return;
					}
					if($.trim(keyword)==""){
						$("#hotel_autocomplete").hide();
						return false;
					}
					if(!option.city_element.attr("cityid") && option.type==-1){
						return;
					}
					$("#popCity2").hide();
					var url = "http://www.lvmama.com/search/autocomplete/hotelSearch.do?keyword="+keyword+"&cityId="+cityId+"&callback=?";
					//url = option.url?(option.url+"?keyword2=&keyword3="+keyword+"&page=1&callback=?") : url;
					url = option.url?(option.url+"?keyword="+keyword+"&toDest="+keyword+"&callback=?") : url;
					//console.log("2:"+option.url);
					FUNCTION.loading(option.hotel_element);
					$.httpAjax && ($.httpAjax.abort());
					$.httpAjax = $.getJSON(url,function(item){
						var strHtml = '<div style="z-index: 9999;position:absolute;width:'+option.hotel_element.outerWidth()+'px" class="PycityAll" id="hotel_autocomplete"><div class="PycityTit">l,按拼音排序</div><div id="ulhotellist" class="_use"></div><p class="PycityPage _use" style="display:none"></p> </div>';
						$("#hotel_autocomplete").remove();
						var hotelauto = $("#hotel_autocomplete");
						var hotellist = $("#ulhotellist");
						if(hotelauto.size()==0){
							$("body").append(strHtml);
							hotelauto = $("#hotel_autocomplete");
							hotellist = $("#ulhotellist");
							hotellist.delegate("a","click",function(){
								hotelauto.hide();
								option.hotel_element.val(this.name).attr({
									sublabel : $(this).attr("id"),
									url : $(this).attr("pinyin")
								});
							});
							FUNCTION.keyevent(option.hotel_element,hotellist,option);//键盘上下调整
						}
						hotelauto.nodatahide = true;
						if(!FUNCTION.validate(item,hotelauto,option.hotel_element)){
							return;
						}
						var p = $(option.hotel_element).offset();
						hotelauto.css({
							left : p.left,
							top : p.top + $(option.hotel_element).outerHeight(false)
						});
						//FUNCTION.page(hotelauto,item);
						var arr = ["<ul>"];
						$.each(item.placeListJson,function(i,n){
							arr.push('<li><a class="'+option.auto_local+'" name="'+n.name+'" id="'+(n.id || n.pinYin)+'" pinyin="'+n.pinYin+'" href="javascript:void(0)">'+n.name+'</a></li>');
							if((i+1)%option.page_count==0){
								arr.push("</ul><ul class='dn'>");
							}
						});
						arr.push("</ul>");
						hotellist.html(arr.join(""));
						hotellist.find("ul:visible").find("a").eq(0).css("backgroundColor","#f1f1f1"); //第一行选中
					});
				},
				mdd : function(keyword,e,option,isTop10){
					if(!FUNCTION.keyCodeFilter(e,option.city_element) && !isTop10){
						return;
					}
					if($.trim(keyword)=="" && !isTop10){
						$("#mdd_autocomplete").hide();
						return;
					}
					var url = "http://www.lvmama.com/search/autocomplete/hotelSearch.do?keyword="+keyword+"&callback=?";
					url = option.url?(option.url+"?keyword="+keyword+"&fromDest=&fromDestId=&toDest="+keyword+"&callback=?") : url;
					//console.log("3:"+url);
					FUNCTION.loading(option.city_element);
					$.httpAjax && ($.httpAjax.abort());
					$.httpAjax = $.getJSON(url,function(item){
						var strHtml = '<div style="z-index: 9999;position:absolute;" class="PycityAll" id="mdd_autocomplete"><div class="PycityTit">l,按拼音排序</div><div id="ulmddlist" class="_use"></div><p class="PycityPage _use"><span>1</span><span id="canClick"><a href="javascript:void(0)">2</a></span></p> </div>';
						$("#mdd_autocomplete").remove();
						var cityauto = $("#mdd_autocomplete");
						var citylist = $("#ulmddlist");
						if(cityauto.size()==0){
							$("body").append(strHtml);
							cityauto = $("#mdd_autocomplete");
							citylist = $("#ulmddlist");
							citylist.delegate("a","click",function(){ //点击选择城市
								cityauto.hide();
								option.city_element.val(this.name).attr({
									sublabel : $(this).attr("id"),
									url : $(this).attr("id")
								});
								
							});
							FUNCTION.keyevent(option.city_element,citylist,option);//键盘上下调整
						}
						var p = $(option.city_element).offset();
						cityauto.css({
							left : p.left,
							top : p.top + $(option.city_element).outerHeight(false)
						});
						if(!FUNCTION.validate(item,cityauto,option.city_element)){
							return;
						}
						FUNCTION.page(cityauto,item);
						var arr = ["<ul>"];
						$.each(item.placeListJson,function(i,n){
							arr.push('<li><a class="'+option.auto_local+'" name="'+n.name+'" id="'+n.pinYin+'" href="javascript:void(0)">'+n.name+'</a></li>');
							if((i+1)%option.page_count==0){
								arr.push("</ul><ul class='dn'>");
							}
						});
						arr.push("</ul>");
						citylist.html(arr.join(""));
						citylist.find("ul:visible").find("a").eq(0).css("backgroundColor","#f1f1f1");  //第一行选中
					});
				},
				jwjd : function(keyword,e,option){
					if(!FUNCTION.keyCodeFilter(e,option.city_element)){
						return;
					}
					if(/^13$/.test(e.keyCode)){
						return;
					}
					if($.trim(keyword)==""){
						$("#mdd_autocomplete").hide();
						return;
					}
					//http://www.lvmama.com/globalhotel/ajax/fuzzyQueryCityByKeyword.do?value=cityNameCh&label=ID&sublabel=IDCountry&jsoncallback=?
					var url = "http://www.lvmama.com/globalhotel/ajax/fuzzyQueryCityByKeyword.do?keyword="+keyword+"&fromDest=&fromDestId=&toDest="+keyword+"&jsoncallback=?";
					FUNCTION.loading(option.city_element);
					$.httpAjax && ($.httpAjax.abort());
					$.httpAjax = $.getJSON(url,function(item){
						var strHtml = '<div style="z-index: 9999;position:absolute;width:200px" class="PycityAll" id="mdd_autocomplete"><div class="PycityTit">l,按拼音排序</div><div id="ulmddlist" class="_use"></div><p class="PycityPage _use"><span>1</span><span id="canClick"><a href="javascript:void(0)">2</a></span></p> </div>';
						$("#mdd_autocomplete").remove();
						var cityauto = $("#mdd_autocomplete");
						var citylist = $("#ulmddlist");
						if(cityauto.size()==0){
							$("body").append(strHtml);
							cityauto = $("#mdd_autocomplete");
							citylist = $("#ulmddlist");
							citylist.delegate("a","click",function(){ //点击选择城市
								cityauto.hide();
								option.city_element.val(this.name).attr({
									sublabel : $(this).attr("idcountry"),
									url : $(this).attr("id")
								});
								
							});
							FUNCTION.keyevent(option.city_element,citylist,option);//键盘上下调整
						}
						var p = $(option.city_element).offset();
						cityauto.css({
							left : p.left,
							top : p.top + $(option.city_element).outerHeight(false)
						});
						if(!FUNCTION.validate(item,cityauto,option.city_element)){
							return;
						}
						FUNCTION.page(cityauto,item);
						var arr = ["<ul>"];
						$.each(item.placeListJson,function(i,n){
							arr.push('<li><a class="" name="'+n.name+'" id="'+n.ID+'" idcountry="'+n.IDCountry+'" href="javascript:void(0)">'+n.cityNameCh+'</a></li>');
							if((i+1)%option.page_count==0){
								arr.push("</ul><ul class='dn'>");
							}
						});
						arr.push("</ul>");
						citylist.html(arr.join(""));
						citylist.find("ul:visible").find("a").eq(0).css("backgroundColor","#f1f1f1");  //第一行选中
					});
				},
				page : function(auto,item,tag){ //分页
					tag = tag || "ul";
					var pageObj = auto.find("p.PycityPage");
					var pageNum = parseInt(item.placeListJson.length/option.page_count)+(parseInt(item.placeListJson.length%option.page_count)==0?0:1);
					var pageNow = item.page;
					if(pageNum==1){
						pageObj.hide();
						return;
					}
					var arr = [];
					for(var i=1;i<=pageNum;i++){
						if(i!=pageNow){
							arr.push('<span><a href="javascript:void(0)">'+i+'</a></span>');
						}else{
							arr.push('<span>'+i+'</span>');
						}
					}
					pageObj.show().html(arr.join(""));
					var pageSpan = pageObj.find("span");
					var prevA = pageSpan.eq(0);
					var prevUl = null;
					pageSpan.each(function(i){
						this.onclick = function(){
							if(prevA!=null){
								prevUl==null?auto.find(tag).eq(0).addClass("dn"):prevUl.addClass("dn"); //如果第一次状态没有记录，则取第一个UL
								prevA.html('<a href="javascript:void(0)">'+prevA.text()+'</a>');
							}
							prevUl = auto.find(tag).eq(i).removeClass("dn");
							prevA = $(this).html($(this).text());
						}
					});
				},
				validate : function(item,auto,element){ //对结果进行验证
					var tit = auto.find(".PycityTit");
					tit.html(element.val()+",按拼音排序");
					$(element).removeData("preva");
					this.loadoff(element);
					try{
						if(!item || !item.placeListJson || item.placeListJson.length==0){
							element.removeAttr("sublabel");
							if(auto.find("div._use").text()=="" || auto.nodatahide==true){
								auto.hide();
							}
							var p = element.offset();
							auto.css({
								left : p.left,
								top : p.top + element.outerHeight(false)
							});
							return false;
						}else{
							auto.show();
							return true;
						}
					}catch(e){
						return false;
					}
					
				},
				keyevent : function(element,ullist,option){ //键盘上下翻动
					var i = 0;
					element.keydown(function(e){
						var ul = ullist.find("ul:visible");
						if(e.keyCode=="38"){
							i--;
							if(i<0){
								i=0;
							}
							var prevA = $(this).data("preva");
							if(prevA!=null){
								prevA.css("backgroundColor","");
							}else{
								ul.find("a").eq(0).css("backgroundColor","");
							}
							prevA = ul.find("a").eq(i).css("backgroundColor","#f1f1f1");
							$(this).data("preva",prevA);
						}else if(e.keyCode=="40"){
							var prevA = $(this).data("preva");
							var aList = ul.find("a");
							i++;
							if(i>=aList.length){
								i=0;
							}
							if(prevA!=null){
								prevA.css("backgroundColor","");
							}else{
								ul.find("a").eq(0).css("backgroundColor","");
							}
							prevA = aList.eq(i).css("backgroundColor","#f1f1f1");
							$(this).data("preva",prevA);
						}else if(e.keyCode=="13"){
							var prevA = $(this).data("preva");
							prevA = prevA || ullist.find("ul:visible").find("a").eq(0);
							if(!prevA.attr("name")){
								return;
							}
							element.val(prevA.attr("name"));
							if(option.type!=-1){
								if(option.type==1){
									option.city_element.attr("url",prevA.attr("id"));
								}
								element.attr({
									sublabel : prevA.attr("id"),
									url : prevA.attr("pinyin")
								});
								if(option.type==4){ //目的地
									element.attr("url",prevA.attr("id"));
								}
							}else{
								element.attr("cityid",prevA.attr("id"));
								if(option && element[0]==option.city_element[0]){
									option.scenic_element.val("中文/拼音");
									option.hotel_element.val("中文/拼音");
								}
							}
							ullist.parent().hide();
							i = 0;
						}else{
							element.removeAttr("sublabel").removeAttr("url");
						}
					});
				},
				keyCodeFilter : function(e,obj){
					if(/^(13|38|40|9)$/.test(e.keyCode)){
						var lastvalue = obj.attr("lastvalue");
						if(e.keyCode==13 && (/[^\u4e00-\u9fa5]/.test(obj.val()) || lastvalue=="") && lastvalue!=obj.val()){
							return true;
						}
						return false;
					}
					return true;
				},
				loading : function(obj){
					var img2 = "";
					if(obj.css("backgroundPosition")=="-361px -51px"){
						img2 = "_2";
					}
					var str = '<img src="http://pic.lvmama.com/img/new_v/ob_yjdy/y_loading'+img2+'.gif" id="autoLoading'+img2+'" style="position:absolute;z-index:999;display:none"/>';
					if($("#autoLoading"+img2).length==0){
						$("body").append(str);
					}
					var loading = $("#autoLoading"+img2);
					loading.css({
						display : "block",
						left : obj.offset().left + (obj.outerWidth(false)-loading.width())-5,
						top : obj.offset().top + (obj.outerHeight(false)-loading.width())/2
					});
				},
				loadoff : function(obj){
					var img2 = "";
					if(obj.css("backgroundPosition")=="-361px -51px"){
						img2 = "_2";
					}
					$("#autoLoading"+img2).hide();
				}
			}
			var timeOut = 100;
			if(option.type==1 || option.type==-1){
				//城市自动补全部分
				var timeId = null;
				option.city_element.keyup(function(e){
					var keyword = encodeURI($(this).val());
					clearTimeout(timeId);
					timeId = setTimeout(function(){
						FUNCTION.city(keyword,e,option);
						RECOMMEND.cityClose();
					},timeOut);
				});
				RECOMMEND.city(option.city_element,option); //城市推荐
			}
			if(option.type==2 || option.type==-1){
				//景点自动补全部分
				var timeId = null;
				option.scenic_element.keyup(function(e){
					var keyword = encodeURI($(this).val());
					var cityid = option.city_element.attr("cityid");
					clearTimeout(timeId);
					timeId = setTimeout(function(){
						FUNCTION.scenic(keyword,cityid,e,option);
						RECOMMEND.scenicClose(); 
					},timeOut);

				});
				if(option.recommend){
					RECOMMEND.scenic(option.scenic_element,option.city_element,option);//景点推荐
				}
			}
			if(option.type==3 || option.type==-1){
				//酒店自动补全部分
				var timeId = null;
				option.hotel_element.keyup(function(e){
					var keyword = encodeURI($(this).val());
					clearTimeout(timeId);
					timeId = setTimeout(function(){
						var cityid = option.city_element.attr("cityid");
						FUNCTION.hotel(keyword,cityid,e,option);
					},timeOut);
				});
				if(option.recommend){
					RECOMMEND.city(option.hotel_element,option); //城市推荐
				}
			}
			if(option.type==4){
				var timeId = null;
				option.city_element.keyup(function(e){
					var keyword = encodeURI($(this).val());
					clearTimeout(timeId);
					timeId = setTimeout(function(){
						FUNCTION.mdd(keyword,e,option);
					},timeOut);
					RECOMMEND.mddClose();
				});
				if (option.recommend) {
					RECOMMEND.mdd(option.city_element,option);
				}else if(option.top10){
					
					option.city_element.focus(function(e){
						FUNCTION.mdd("",e,option,true);
						return false;
					});
				}
			}
			if(option.type==5){
				var timeId = null;
				option.city_element.keyup(function(e){
					var keyword = encodeURI($(this).val());
					clearTimeout(timeId);
					timeId = setTimeout(function(){
						FUNCTION.jwjd(keyword,e,option);
					},timeOut);
					RECOMMEND.mddClose();
				});
			}
			var tip_init = function(){
				this.tip = this.value;
				$(this).bind({
					focus:function() {
						var input_text = $(this).val();
						var color = parseInt($(this).css("color").replace(/[^\d]/g,""));
						if(color==0){
							return;
						}
						if(input_text==this.tip) {
							!$(this).attr("oldcolor") && $(this).attr("oldcolor",$(this).css("color"));
							$(this).val('').css('color', '#333');
						}else{
							if($.browser.webkit){
								var elt = this;
								setTimeout(function(){
									elt.select();
								},50);
							}else{
								this.select();
							}
						}
					},
					blur:function() { 
						var input_text = $(this).val();
						if(input_text==""){
							$(this).val(this.tip).css('color', $(this).attr("oldcolor"));
						}
						FUNCTION.loadoff($(this));
					}
				});
			}
			$.each([option.city_element,option.scenic_element,option.hotel_element],function(){
				this.size()>0 && tip_init.call(this[0]);
			});
			return this;
		}
	});

	//推荐模块
	var RECOMMEND = {
		city : function(element,option){ //城市推荐
			if(option.type!=3){
				return;
			}
			var url = "http://www.lvmama.com/dest/newplace/commAction!getRecommendInfoWithIdJson.do?callback=?";//上线注意这个URL要换成www.lvmama.com
			var thisObj = this;
			$.getJSON(url, {recommendBlockId : 7142}, function(txt) {
				var arrayRm = txt.rm;
				var strHtml = '<div class="cityAll2" id="popCity2"><div class="cityAllCont"><div class="cityAllContTit"><span>热门城市</span>(可直接选择城市或输入城市全拼)</div><ul class="cityDetail"><li class="cityDetailBlock"><p class="CountryName11" id="r_city_category" style="display:none"><a class="" to="#r_rm">推荐</a><a to="#r_af">A-F</a><a to="#r_gj">G-J</a><a to="#r_kn">K-N</a><a to="#r_pw">P-W</a><a to="#r_xz">X-Z</a></p><p class="CountryNameDetail c2 countryBlock" id="r_rm"></p><p class="CountryNameDetail c2" id="r_af"></p><p class="CountryNameDetail c2" id="r_gj"></p><p class="CountryNameDetail c2" id="r_kn"></p><p class="CountryNameDetail c2" id="r_pw"></p><p class="CountryNameDetail c2" id="r_xz"></p></li></ul><span class="leftCityAll"></span> </div></div>';
				$("#popCity2").length==0&&$("body").append(strHtml);
				var citydiv = $("#popCity2");
				var pc2 = citydiv.find("p.c2");
				pc2.eq(0).html(thisObj.formatCity(arrayRm,option));
				citydiv.find("a:not([to])").each(function(){
					$(this).click(function(){
						element.val(this.title);
						if(this.id!='undefined'){
							element.attr("cityid",this.id);
							//option.scenic_element.val("中文/拼音");
							//option.hotel_element.val("中文/拼音");
						}
						thisObj.cityClose();
					});
				});
			});
			element.click(function(){
				FUNCTION.city_element = $(this);
				$("#popCity2").css({
					left : $(this).offset().left,
					top : $(this).offset().top + $(this).outerHeight(true)
				}).show();
			});
		},
		scenic : function(element,inputCity,option){ //景区推荐
			if(option.type!=-1){
				return;
			}
			var thisObj = this;
			element.click(function(){
				var cityid = inputCity.attr("cityid")
				if(!cityid){
					return false;
				}
				var strHtml = '<div class="cityAll2" id="popScenic2"><div class="cityAllCont cityAllCont01"><div class="cityAllContTit">可直接选择景区或输入景区名称或全拼</div><ul class="cityDetail"><li class="cityDetailBlock"><p class="CountryNameDetail c2 countryBlock"></p><p class="CountryNameDetail c2 countryBlock" id="r_sceniclist"></p></li></ul><span class="leftCityAll"></span><p class="PycityPage _use"></p></div></div>';
				var scenic = $("#popScenic2");
				if(scenic.length==0){
					$("body").append(strHtml);
					scenic = $("#popScenic2");
					$("#r_sceniclist").delegate("a","click",function(){
						element.val(this.title);
						thisObj.scenicClose();
					});
				}else{
					scenic.show();
				}
				$("#popScenic2").css({
					display:"block",
					left : $(this).offset().left,
					top : $(this).offset().top + $(this).outerHeight(true)
				});
				var url = "http://www.lvmama.com/search/autocomplete/hotelSearch.do?keyword=&cityId="+cityid+"&callback=?";
				//console.log("4:"+url);
				$.getJSON(url, function(txt) {
					var item = txt.placeListJson;
					if(!item){
						$("#r_sceniclist").html("抱歉！此城市下面没有周边景区！");
						return false;
					}
					var arr = ["<span>"];
					for(var i=0;i<item.length;i++){
						arr.push('<a class="'+option.auto_local+'" title="'+item[i].name+'" href="javascript:void(0)">'+item[i].name+'</a>');
						if((i+1)%10==0){
							arr.push("</span><span class='dn'>");
						}
					}
					arr.push("</span>");
					$("#r_sceniclist").html(arr.join(""));
					txt.totalResultSize = item.length;
					FUNCTION.page(scenic,txt,"span");
				});
			});
		},
		mdd: function (element, option) {
			var strHtml = '<div class="dstnt_search_pop2" id="dstnt_search_pop2">'+
                         '        <em>热门推荐(可选择或输入目的地名称查找)</em>'+
                         '        <ul class="dstnt_srchpop2_tab1">'+
                         '           <li class="" key="glmdd">国内目的地</li>'+
                         '           <li key="gwmdd">出境目的地</li>'+
                         '        </ul>'+
						 '		  <div id="glmdd" class="dn">'+
                         '			<ul class="dstnt_srchpop2_tab2" id="dstnt_srchpop2_tab1">'+
                         '			   <li key="tj" class="dstnt_srchpop2_tab2_crt">推荐</li>'+
                         '			</ul>'+
						 '			<div id="dstnt_search_pop1_citylist"></div>'+
						 '		  </div>'+
						 '		  <div id="gwmdd" class="dn">'+
                         '			<ul class="dstnt_srchpop2_tab2" id="dstnt_srchpop2_tab2">'+
                         '			   <li key="tj">推荐</li>'+
                         '			   <li key="yz">亚洲</li>'+
                         '			   <li key="oz">欧洲</li>'+
                         '			   <li key="mz">美洲</li>'+
                         '			   <li key="fz">非洲</li>'+
                         '			   <li key="dyz">大洋洲</li>'+
                         '			</ul>'+
						 '			<div id="dstnt_search_pop2_citylist"></div>'+
						 '		  </div>'+
                         '   </div>';
			var mdd = $("#dstnt_search_pop2");
			if(mdd.length==0){
			    reloadData(option);
			}
			function reloadData(option) {
			    $("body").append(strHtml);
			    var mdd = $("#dstnt_search_pop2");
			    $.getJSON("http://www.lvmama.com/dest/newplace/commAction!destInternalJsonData.do?jsoncallback=?", function (jsongl) {
			        $.getJSON("http://www.lvmama.com/dest/newplace/commAction!destAbroadJsonData.do?jsoncallback=?", function (json) {
			            loaddata(option, json, jsongl, element);
			        });
			    });
			    var loaddata = function (option, json, jsongl, element) {
			        var option = option || {};
			        var menuLi = $("#dstnt_srchpop2_tab2 li");
			        //国内数据填充
			        var menuContentGl = $("#dstnt_search_pop1_citylist");
			        var arr = ['<ul class="dstnt_search_pop2_citylist">'];
			        arr.push('');
			        $.each(jsongl.tj, function (i, n) {
			            arr.push('<li class="mddclick"><a class="' + option.auto_local + '" href="javascript:void(0)" pinyin="' + n.PinYin + '">' + n.name + '</a></li>');
			        });
			        arr.push('</ul>');
			        menuContentGl.html(arr.join(""));
			        //国外数据填充
			        var menuContentGw = $("#dstnt_search_pop2_citylist");
			        arr = [];
			        for (var o in json) {
			            var liArr = [];
			            liArr.push('<ul class="dstnt_search_pop2_citylist dn" id="' + o + '">');
			            $.each(json[o], function (i, n) {
			                liArr.push('<li class="mddclick"><a class="' + option.auto_local + '" href="javascript:void(0)" pinyin="' + n.PinYin + '">' + n.name + '</a></li>');
			            });
			            liArr.push('</ul>');;
			            arr.push(liArr.join(""));
			        }
			        menuContentGw.html(arr.join(""));
			        var prevMli = null, prevContent = null;
			        menuLi.mouseover(function () {
			            if (prevMli != null && prevMli != this) {
			                $(prevMli).removeClass("dstnt_srchpop2_tab2_crt");
			                prevContent.addClass("dn");
			            }
			            $(this).addClass("dstnt_srchpop2_tab2_crt");
			            prevMli = this;
			            prevContent = $("#" + $(this).attr("key")).removeClass("dn");
			        }).eq(0).mouseover();
			        var index = 0;
			        if (element.attr("tabtype") == "template_abroad") {
			            index = 1;
			        }
			        mdd.find("ul.dstnt_srchpop2_tab1 li").click(function () {
			            $(this).addClass("dstnt_srchpop2_tab1_crt").siblings().removeClass("dstnt_srchpop2_tab1_crt");
			            $("#" + $(this).attr("key")).removeClass("dn");
			            $("#" + $(this).siblings().attr("key")).addClass("dn");
			        }).eq(index).click();
			        mdd.find("li.mddclick").click(function () {
			            var a = $(this).find("a");
			            element.val(a.html()).attr({
			                sublabel: a.attr("pinyin")
			            });
			            RECOMMEND.mddClose();
			        });
			    }
			};
			element.focus(function(){
				if($("#dstnt_search_pop1_citylist").html()==""){
					$("#dstnt_search_pop2").remove();
					reloadData();
				}
				FUNCTION.city_element = $(this);
				$("#dstnt_search_pop2").css({
					display:"block",
					left : $(this).offset().left,
					top : $(this).offset().top + $(this).outerHeight(true)
				});
				$("#mdd_autocomplete").hide();
				if($.browser.webkit){
					var elt = this;
					setTimeout(function(){
						elt.select();
					},50);
				}else{
					this.select();
				}
			});
		},
		formatCity : function(arr,option){ 
			var strArr = [];
			$.each(arr,function(i,n){
				strArr.push('<a class="'+option.auto_local+'" title="'+n.name+'" id="'+n.id+'" href="javascript:void(0)">'+n.name+'</a>');
			});
			return strArr.join("");
		},
		cityClose : function(){
			$("#popCity2").hide();
		},
		scenicClose : function(){
			$("#popScenic2").hide();
		},
		mddClose : function(){
			$("#dstnt_search_pop2").hide();
		}
	}
	$(function(){
		var lcontains = function(a,b){
			if(a.contains){
				return a.contains(b);
			}else{
				return a.compareDocumentPosition(b)==20;
			}
		}
		$("body").click(function(e){
			var elt = $("#city_autocomplete,#scenic_autocomplete,#hotel_autocomplete,#mdd_autocomplete");
			var s = e.srcElement || e.target;
			if(/li|span/i.test(s.tagName)){
				return;
			}
			
			var r_city = $("#popCity2");
			if(r_city.length>0){
				if(s!=FUNCTION.city_element.get(0) && !lcontains(r_city.get(0),s) && s.tagName.toLowerCase()!="a"){
					$("#ulcitylist ul:visible li").eq(0).find("a").click();
					r_city.hide();
				}
			}
			var r_scenic = $("#popScenic2");
			if(r_scenic.length>0){
				if(s!=FUNCTION.scenic_element.get(0) && !lcontains(r_scenic.get(0),s) && s.tagName.toLowerCase()!="a"){
					r_scenic.hide();
				}
			}
			var r_mdd = $("#dstnt_search_pop2");
			if(r_mdd.length>0){
				if(s!=FUNCTION.city_element.get(0) && !lcontains(r_mdd.get(0),s) && s.tagName.toLowerCase()!="a"){
					$("#ulmddlist ul:visible li").eq(0).find("a").click();
					r_mdd.hide();
				}
			}else if($("#searchDest").length>0){
				if(s!=FUNCTION.city_element.get(0) && !lcontains(document.getElementById("searchDest"),s) && s.tagName.toLowerCase()!="a"){
					//$("#ulmddlist ul:visible li").eq(0).find("a").click();
				}
			}
			elt.each(function(){
				if(!lcontains(this,s) && s.tagName.toLowerCase()!="a" && s.id!="searchDest"){
					$(this).hide();
				}
			});
		});
	});
})(jQuery);
