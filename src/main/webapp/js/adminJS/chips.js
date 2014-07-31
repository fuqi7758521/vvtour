/**
 * 菜单管理
 */
var isExist = false;
function checkCaNameExist(type){
	var chip_ca_name = '';
	var name_msg = '';
	var ca_name_id = '';
	if(type=='add'){
		chip_ca_name = $("#chip_ca_name").val();
		ca_name_id = $("#chip_ca_name");
		name_msg = "#name_msg";
	}else{
		chip_ca_name = $("#edit_chip_ca_name").val();
		ca_name_id = $("#edit_chip_ca_name");
		name_msg = "#edit_name_msg";
	}
	
	if(!checkEmpty(chip_ca_name)){
		$(name_msg).css("color","red");
		$(name_msg).text("分类名称不能为空");
		return false;
	}
	checkSpace('chip_ca_name');
	$.ajax({
		url:"checkChipCaName.htm",
		type:"get",
		data:"chip_ca_name="+encodeURI(encodeURI(chip_ca_name)),
		dataType:'text',
		success:function(msg,status){
			var info = msg.split('|');
			if(parseInt(info[0])==1){
				$(name_msg).css("color","green");
				isExist = false;
			} else if(parseInt(info[0])==0 || parseInt(info[0])==-1){
				$(name_msg).css("color","red");
				ca_name_id.focus();
				isExist = true;
			}
			
			$(name_msg).text(info[1]);
        },
        error:function(xhr,textStatus,errorThrown){}
	});
}

/**
 * 检查菜单名称
 */
function checkChipCAName(type){
	var chip_ca_name = $("#chip_ca_name").val();
	var page_url = $("#page_url").val();
	var name_msg = $("#checkMsg").val();
	var url_msg = $("#url_msg").val();
	if(type=='add'){
		chip_ca_name = $("#chip_ca_name").val();
		page_url = $("#page_url").val();
		name_msg = "#checkMsg";
		url_msg = "#url_msg";
	}else{
		chip_ca_name = $("#edit_chip_ca_name").val();
		page_url = $("#edit_page_url").val();
		name_msg = "#edit_name_msg";
		url_msg = "#edit_url_msg";
	}
	if(!checkEmpty(chip_ca_name)){
		$(name_msg).css("color","red");
		$(name_msg).text("不能为空");
		return false;
	}
	if(!checkEmpty(page_url)){
		$(url_msg).css("color","red");
		$(url_msg).text("不能为空");
		return false;
	}
	return true;
}

/**
 * 添加相册
 */
function addChipCA(){
	if(!checkChipCAName("add")){
		return false;
	}
	if(isExist){
		$("#name_msg").css("color","red");
		$("#name_msg").text("分类名称已经存在");
		$("#chip_ca_name").focus();
		return false;
	}
	
	$("#submitChipCA").attr("disabled",true);
	$("#addChipCAForm").submit();
	return true;
}

/**
 * 修改分类
 */
function editChipCA(){
	if(!checkChipCAName("edit")){
		return false;
	}
	if(isExist){
		$("#edit_name_msg").css("color","red");
		$("#edit_name_msg").text("分类名称已经存在");
		$("#edit_chip_ca_name").focus();
		return false;
	}
	$("#submitEditChipCA").attr("disabled",true);
	var url = "editChipCA.htm";
	var params = {'chip_ca_id':$("#edit_chip_ca_id").val(),'chip_ca_name':$("#edit_chip_ca_name").val(),'page_url':$("#edit_page_url").val()};
	jQuery.post(
	  		url,
	  		params,
	  		function(data,status){
	  			//alert("Data: " + data + "\nStatus: " + status);
	  			$.unblockUI();
	  			toAction("chipCategories.htm");
	  		});
}

//=========================碎片JS ======================

/**
 * 添加相册
 */

function addChip(chip_ca_id){
	if(!checkAddChip()){
		return false;
	}
	if(isChipExist){
		$("#name_msg").css("color","red");
		$("#name_msg").text("该碎片名称已经存在");
		$("#chip_name").focus();
		return false;
	}
	if(isChipVarExist){
		$("#var_msg").css("color","red");
		$("#var_msg").text("该碎片变量名称已经存在");
		$("#chip_var").focus();
		return false;
	}
	
	$("#submitChip").attr("disabled",true);
	$("#addChipForm").submit();
	return true;
}

/**
 * 修改名称
 */

function editChip(){
	if(!checkAddChip()){
		return false;
	}
	if(isChipExist){
		$("#name_msg").css("color","red");
		$("#name_msg").text("该碎片名称已经存在");
		$("#chip_name").focus();
		return false;
	}
	if(isChipVarExist){
		$("#var_msg").css("color","red");
		$("#var_msg").text("该碎片变量名称已经存在");
		$("#chip_var").focus();
		return false;
	}
	
	$("#submitEditChip").attr("disabled",true);
	$("#editChipForm").submit();
	return true;
}


//检查是否为空
function checkAddChip(){
	var chip_name = $("#chip_name").val();
	var chip_con = $("#chip_con").val();
	var chip_var = $("#chip_var").val();
	if(!checkEmpty(chip_name)){
		$("#name_msg").css("color","red");
		$("#name_msg").text("碎片名称不能为空");
		$("#chip_name").focus();
		return false;
	}
	
	if(!checkEmpty(chip_con)){
		$("#con_msg").css("color","red");
		$("#con_msg").text("碎片内容不能为空");
		$("#chip_con").focus();
		return false;
	}
	
	if(!checkEmpty(chip_var)){
		$("#var_msg").css("color","red");
		$("#var_msg").text("碎片变量不能为空");
		$("#chip_var").focus();
		return false;
	}
	return true;
}

//检查是否存在
var isChipExist = false;
function checkChipNameExist(){
	var chip_name = $("#chip_name").val();
	checkSpace('chip_name');
	$.ajax({
		url:"checkChipName.htm",
		type:"get",
		data:"chip_name="+encodeURI(encodeURI(chip_name)),
		dataType:'text',
		success:function(msg,status){
			var info = msg.split('|');
			if(parseInt(info[0])==1){
				$("#name_msg").css("color","green");
				isChipExist = false;
			} else if(parseInt(info[0])==0 || parseInt(info[0])==-1){
				$("#name_msg").css("color","red");
				isChipExist = true;
			}
			
			$("#name_msg").text(info[1]);
        },
        error:function(xhr,textStatus,errorThrown){}
	});
}

//检查是否存在
var isChipVarExist = false;
function checkChipVarExist(){
	var chip_var = $("#chip_var").val();
	checkSpace('chip_var');
	$.ajax({
		url:"checkChipName.htm",
		type:"get",
		data:"chip_var="+encodeURI(encodeURI(chip_var)),
		dataType:'text',
		success:function(msg,status){
			var info = msg.split('|');
			if(parseInt(info[0])==1){
				$("#var_msg").css("color","green");
				isChipVarExist = false;
			} else if(parseInt(info[0])==0 || parseInt(info[0])==-1){
				$("#var_msg").css("color","red");
				isChipVarExist = true;
			}
			
			$("#var_msg").text(info[1]);
        },
        error:function(xhr,textStatus,errorThrown){}
	});
}