/**
 * 检查路线名称
 */
function checkTourPath(){
	var path_name = $("#path_name").val();
	if(!checkEmpty(path_name)){
		$("#checkMsg").css("color","red");
		$("#checkMsg").text("不能为空");
		return false;
	}
	/*var reg = /^[\u4e00-\u9fa5](\+[\u4e00-\u9fa5]+)+(,[\u4e00-\u9fa5]+)*$/;		//判断是否是一个或多个汉字词语并且词语之间用逗号隔开
	if(!reg.test(path_name)){
		$("#checkMsg").css("color","red");
		$("#checkMsg").text("不符合要求，请输入汉字名称,多个菜单请使用英文逗号隔开");
		return false;
	}*/
	return true;
}

/**
 * 添加一级菜单名称
 */
function addTourPath(){
	if(!checkTourPath()){
		return false;
	}
	
	var path_name = $("#path_name").val();
	var ca_id = $("#subcategory").val();
	var ca_name = jQuery("#subcategory  option:selected").text();
	alert(ca_id+":"+ca_name+":"+path_name);return false;
	$("#submitTourPath").attr("disabled",true);
	var url = "addTourPath.htm";
	var params = {'path_name':path_name,'ca_id':ca_id,'ca_name':ca_name};
	jQuery.post(
	  		url,
	  		params,
	  		function(data,status){		//data msg的消息 status：状态
	  			var temp = data.split('|');
	  			if(temp[0]==0||temp[0]==-1){
	  				alert(temp[1]);
	  				$("#path_name").val('');
	  				$("#submitTourPath").attr("disabled",false);
	  				return false;
	  			}
	  			alert(temp[1]);
	  			$.unblockUI();
	  			toAction("tourPathList.htm?ver="+parseInt(Math.random()*100000));

	  		});
}

/**
 * 修改路线名称
 * */
function editTourPath(){
	alert("不能为空");
	var change_path_id = $("#change_path_id").val();
	var change_path_name = $("#change_path_name").val();
	var current_visit_id = $("#current_visit_id").val();
	var current_path_name = $("#current_path_name").val();
	if(!checkEmpty(change_path_name)||!checkEmpty(current_visit_id)){
		alert("不能为空");
		return false;
	}
	if(change_path_name==change_path_name){
		alert("没有任何修改操作，不能提交");
		return false;
	}
	$("#editTourPath").attr("disabled",true);
	var url = "editTourPath.htm";
	var params = {'visit_id':current_visit_id,'path_id':change_path_id,'path_id':current_path_name};
	jQuery.post(
	  		url,
	  		params,
	  		function(data,status){		//data msg的消息 status：状态
	  			var temp = data.split('|');
	  			if(temp[0]==0||temp[0]==-1){
	  				alert(temp[1]);
	  				$("#change_path_name").val('');
	  				$("#editTourPath").attr("disabled",false);
	  				return false;
	  			}
	  			alert(temp[1]);
	  			$.unblockUI();
	  			toAction("tourPathList.htm?ver="+parseInt(Math.random()*100000));

	  		});
}

