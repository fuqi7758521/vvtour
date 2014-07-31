/**
 * 检查一级菜单名称
 */
function checkCategory(){
	var ca_name = $("#ca_name").val();
	if(!checkEmpty(ca_name)){
		$("#checkCAMsg").css("color","red");
		$("#checkCAMsg").text("不能为空");
		return false;
	}
	var reg = /^[\u4e00-\u9fa5]+(,[\u4e00-\u9fa5]+)*$/;		//判断是否是一个或多个汉字词语并且词语之间用逗号隔开
	if(!reg.test(ca_name)){
		$("#checkCAMsg").css("color","red");
		$("#checkCAMsg").text("不符合要求，请输入汉字名称,多个菜单请使用英文逗号隔开");
		return false;
	}
	return true;
}

/**
 * 添加一级菜单名称
 */
function addCategory(){
	if(!checkCategory()){
		return false;
	}
	
	var ca_type = $('input[name="ca_type"]:checked').val();
	var ca_name = $("#ca_name").val();
	$("#submitCategory").attr("disabled",true);
	var url = "addCategory.htm";
	var params = {'ca_type':ca_type,'ca_name':ca_name,'parent_id':0};
	jQuery.post(
	  		url,
	  		params,
	  		function(data,status){		//data msg的消息 status：状态
	  			var temp = data.split('|');
	  			if(temp[0]==0||temp[0]==-1){
	  				alert(temp[1]);
	  				$("#ca_name").val('');
	  				$("#submitCategory").attr("disabled",false);
	  				return false;
	  			}
	  			alert(temp[1]);
	  			$.unblockUI();
	  			toAction("categoryList.htm?ver="+parseInt(Math.random()*100000));

	  		});
}


/**
 * 检查二级目的地名称
 */
function checkSubCategory(){
	var subca_name = $("#subca_name").val();
	if(!checkEmpty(subca_name)){
		$("#checkSubMsg").css("color","red");
		$("#checkSubMsg").text("不能为空");
		return false;
	}
	var reg = /^[\u4e00-\u9fa5]+(,[\u4e00-\u9fa5]+)*$/;		//判断是否是一个或多个汉字词语并且词语之间用逗号隔开
	if(!reg.test(subca_name)){
		$("#checkSubMsg").css("color","red");
		$("#checkSubMsg").text("不符合要求");
		return false;
	}
	return true;
}

/**
 * 添加二级目的地名称
 */
function addSubCategory(){
	if(!checkSubCategory()){
		return false;
	}
	//	$("#addVParentForm").submit();
	//	return true;
	
	var temp = $("#parent_id").val().split('|');
	var parent_id = temp[0];
	var ca_type = temp[1];
	var subca_name = $("#subca_name").val();
	//alert("pid:"+parent_id+",ca_type:"+ca_type+",subca_name:"+subca_name);
	//return false;
	$("#submitSubCategoryTag").attr("disabled",true);
	var url = "addCategory.htm";
	var params = {'ca_type':ca_type,'ca_name':subca_name,'parent_id':parent_id};
	jQuery.post(
	  		url,
	  		params,
	  		function(data,status){		//data msg的消息 status：状态
	  			var temp = data.split('|');
	  			if(temp[0]==0||temp[0]==-1){
	  				alert(temp[1]);
	  				$("#subca_name").val('');
	  				$("#submitSubCategoryTag").attr("disabled",false);
	  				return false;
	  			}
	  			alert(temp[1]);
	  			$.unblockUI();
	  			//initProType();
	  			toAction("categoryList.htm?ver="+parseInt(Math.random()*100000));
	  			//document.location.reload();

	  		});
}

function editVisitTag(ca_id){
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

