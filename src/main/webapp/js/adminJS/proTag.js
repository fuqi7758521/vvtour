/**
 * 检查菜单名称
 */
function checkProType(){
	var ptype_name = $("#ptype_name").val();
	if(!checkEmpty(ptype_name)){
		$("#checkMsg").css("color","red");
		$("#checkMsg").text("不能为空");
		return false;
	}
	return true;
}

/**
 * 添加产品类型
 */
function addProType(){
	if(!checkProType()){
		return false;
	}
	$("#addProTypeForm").submit();
	return true;
/*	var ptype_name = $("#ptype_name").val();
	$("#submitProType").attr("disabled",true);
	var url = "addProType.htm";
	var params = {'ptype_name':ptype_name};
	jQuery.post(
	  		url,
	  		params,
	  		function(data,status){
	  			alert("Data: " + data + "\nStatus: " + status);
	  			$.unblockUI();
	  			//initProType();
	  			toAction("proTypeList.htm?"+parseInt(Math.random()*100000));
	  			//document.location.reload();

	  		});*/
}