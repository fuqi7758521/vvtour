/**
 * 检查一级菜单名称
 */
function checkVParentTag(){
	var vparent_name = $("#vparent_name").val();
	if(!checkEmpty(vparent_name)){
		$("#checkVPMsg").css("color","red");
		$("#checkVPMsg").text("不能为空");
		return false;
	}
	var reg = /^[\u4e00-\u9fa5]+(,[\u4e00-\u9fa5]+)*$/;		//判断是否是一个或多个汉字词语并且词语之间用逗号隔开
	if(!reg.test(vparent_name)){
		$("#checkVPMsg").css("color","red");
		$("#checkVPMsg").text("不符合要求，请输入汉字名称,多个菜单请使用英文逗号隔开");
		return false;
	}
	return true;
}

/**
 * 添加一级菜单名称
 */
function addVParentTag(){
	if(!checkVParentTag()){
		return false;
	}
//	$("#addVParentForm").submit();
//	return true;
	
	var vparent_name = $("#vparent_name").val();
	var vparent_type = $("#vparent_type").val();
	$("#submitVParentTag").attr("disabled",true);
	var url = "addVParentTag.htm";
	var params = {'vparent_name':vparent_name,'vparent_type':vparent_type};
	jQuery.post(
	  		url,
	  		params,
	  		function(data,status){		//data msg的消息 status：状态
	  			var temp = data.split('|');
	  			if(temp[0]==0||temp[0]==-1){
	  				alert(temp[1]);
	  				$("#vparent_name").val('');
	  				$("#submitVParentTag").attr("disabled",false);
	  				return false;
	  			}
	  			alert(temp[1]);
	  			$.unblockUI();
	  			toAction("vparentList.htm?ver="+parseInt(Math.random()*100000));

	  		});
}


/**
 * 检查二级目的地名称
 */
function checkVisitTag(){
	var visit_name = $("#visit_name").val();
	if(!checkEmpty(visit_name)){
		$("#checkMsg").css("color","red");
		$("#checkMsg").text("不能为空");
		return false;
	}
	var reg = /^[\u4e00-\u9fa5]+(,[\u4e00-\u9fa5]+)*$/;		//判断是否是一个或多个汉字词语并且词语之间用逗号隔开
	if(!reg.test(visit_name)){
		$("#checkMsg").css("color","red");
		$("#checkMsg").text("不符合要求");
		return false;
	}
	return true;
}

/**
 * 添加二级目的地名称
 */
function addVisitTag(){
	if(!checkVisitTag()){
		return false;
	}
//	$("#addVParentForm").submit();
//	return true;
	
	var vparent_id = $("#vparent_id").val();
	var visit_name = $("#visit_name").val();
	$("#submitVisitTag").attr("disabled",true);
	var url = "addVisitTag.htm";
	var params = {'visit_name':visit_name,'vparent_id':vparent_id};
	jQuery.post(
	  		url,
	  		params,
	  		function(data,status){		//data msg的消息 status：状态
	  			var temp = data.split('|');
	  			if(temp[0]==0||temp[0]==-1){
	  				alert(temp[1]);
	  				$("#visit_name").val('');
	  				$("#submitVisitTag").attr("disabled",false);
	  				return false;
	  			}
	  			alert(temp[1]);
	  			$.unblockUI();
	  			//initProType();
	  			toAction("visitTagList.htm?vparent_id="+vparent_id);
	  			//document.location.reload();

	  		});
}

function editVisitTag(vparent_id){
	var visit_id = $("#edit_id").val();
	var edit_name = $("#edit_name").val();
	var current_name = $("#current_name").val();
	if(current_name==edit_name){
		alert("没有任何修改操作，不能提交");
		return false;
	}
	$("#editVisitTag").attr("disabled",true);
	var url = "editVisitTag.htm";
	var params = {'visit_id':visit_id,'visit_name':edit_name,'vparent_id':vparent_id};
	jQuery.post(
	  		url,
	  		params,
	  		function(data,status){		//data msg的消息 status：状态
	  			var temp = data.split('|');
	  			if(temp[0]==0||temp[0]==-1){
	  				alert(temp[1]);
	  				$("#edit_name").val('');
	  				$("#editVisitTag").attr("disabled",false);
	  				return false;
	  			}
	  			alert(temp[1]);
	  			$.unblockUI();
	  			toAction("visitTagList.htm?vparent_id="+vparent_id);

	  		});
}

