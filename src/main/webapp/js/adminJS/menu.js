/**
 * 菜单管理
 */
function checkUserNameExist(){
	var menu_name = $("#menu_name").val();
	if(!checkEmpty(menu_name)){
		$("#checkMsg").css("color","red");
		$("#checkMsg").text("菜单名称不能为空");
		return false;
	}
	$.ajax({
		url:"checkMenuName.htm",
		type:"get",
		data:"menu_name="+menu_name,
		dataType:'text',
		success:function(msg,status){
			var info = msg.split('|');
			if(parseInt(info[0])==1){
				$("#checkMsg").css("color","green");
			} else if(parseInt(info[0])==0 || parseInt(info[0])==-1){
				$("#checkMsg").css("color","red");
			}
			
			$("#checkMsg").text(info[1]);
        },
        error:function(xhr,textStatus,errorThrown){}
	});
}

/**
 * 检查菜单名称
 */
function checkAddMenuName(){
	var menu_name = $("#menu_name").val();
	var menu_cnname = $("#menu_cnname").val();
	if(!checkEmpty(menu_name)){
		$("#checkMsg").css("color","red");
		$("#checkMsg").text("不能为空");
		return false;
	}
	if(!checkEmpty(menu_cnname)){
		$("#checkCnMsg").css("color","red");
		$("#checkCnMsg").text("不能为空");
		return false;
	}
	return true;
}

/**
 * 添加菜单名称
 */
function addMenuName(){
	if(!checkAddMenuName()){
		return false;
	}
	var menu_name = $("#menu_name").val();
	var menu_cnname = $("#menu_cnname").val();
	$("#submitMenu").attr("disabled",true);
	var url = "addMenu.htm";
	var params = {'menu_name':menu_name,'menu_cnname':menu_cnname};
	jQuery.post(
	  		url,
	  		params,
	  		function(data,status){
	  			alert("Data: " + data + "\nStatus: " + status);
	  			$.unblockUI();
	  		});
}