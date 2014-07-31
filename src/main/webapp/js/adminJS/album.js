/**
 * 菜单管理
 */
var isExist = false;
function checkAlbumNameExist(){
	var album_name = $("#album_name").val();
	if(!checkEmpty(album_name)){
		$("#checkMsg").css("color","red");
		$("#checkMsg").text("相册不能为空");
		return false;
	}
	checkSpace('album_name');
	$.ajax({
		url:"checkAlbumName.htm",
		type:"get",
		data:"album_name="+encodeURI(encodeURI(album_name)),
		dataType:'text',
		success:function(msg,status){
			var info = msg.split('|');
			if(parseInt(info[0])==1){
				$("#checkMsg").css("color","green");
				isExist = false;
			} else if(parseInt(info[0])==0 || parseInt(info[0])==-1){
				$("#checkMsg").css("color","red");
				isExist = true;
			}
			
			$("#checkMsg").text(info[1]);
        },
        error:function(xhr,textStatus,errorThrown){}
	});
}

/**
 * 检查菜单名称
 */
function checkAddAlbumName(){
	var album_name = $("#album_name").val();
	//var album_comment = $("#album_comment").val();
	if(!checkEmpty(album_name)){
		$("#checkMsg").css("color","red");
		$("#checkMsg").text("不能为空");
		return false;
	}
	/*if(!checkEmpty(album_comment)){
		$("#checkCnMsg").css("color","red");
		$("#checkCnMsg").text("不能为空");
		return false;
	}*/
	return true;
}

/**
 * 添加相册
 */
function addAlbumName(){
	if(!checkAddAlbumName()){
		return false;
	}
	if(isExist){
		alert('该名称已经存在');
		return false;
	}
	var album_name = $("#album_name").val();
	var album_comment = "";//$("#album_comment").val();
	/*if(album_comment=='相册描述'){
		album_comment = '';
	}*/
	var album_type = $("#album_type").val();
	if(album_type==null){
		alert('请选择相应类型');
		return false;
	}
	$("#submitMenu").attr("disabled",true);
	var url = "addAlbum.htm";
	var params = {'album_name':album_name,'album_comment':album_comment,'album_type':album_type};
	jQuery.post(
	  		url,
	  		params,
	  		function(data,status){
	  			alert("Data: " + data + "\nStatus: " + status);
	  			$.unblockUI();
	  			toAction("album_list.htm");
	  		});
}