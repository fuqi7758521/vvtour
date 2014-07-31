$('#ca_type_edit').on('change', function(){
	$("#parent_id_edit").empty();
	$("#ca_id_edit").empty();
	//$("#tour_path").empty();
	var ca_type = $(this).val();
	
	$.ajax({
		type:"GET",
		contentType : 'application/json',
		url:"catchCategoryList.htm?ca_type="+ca_type+"&pid="+0,
		dataType:'json',
		success:function(data){
			if (data || data.success == "true"){
				showSelectOptions("parent_id_edit",data.data);
			}
        },
        error:function(xhr,textStatus,errorThrown){}
	});
});

$('#parent_id_edit').on('change', function(){
	$("#ca_id_edit").empty();
	//$("#tour_path").empty();
	var ca_type = $("#ca_type_edit").val();
	var parent_id = $(this).val();
	$.ajax({
		type:"GET",
		contentType : 'application/json',
		url:"catchCategoryList.htm?ca_type="+ca_type+"&pid="+parent_id,
		dataType:'json',
		success:function(data){
			if (data || data.success == "true"){
				showSelectOptions("ca_id_edit",data.data);
			}
        },
        error:function(xhr,textStatus,errorThrown){}
	});
});
/*
$('#subcategory').on('change', function(){
	//获取当前选择的ID和NAME
	var ca_id = $(this).val();
	var ca_name = jQuery("#subcategory  option:selected").text();
	var options = '';
	var ishave =0;
	if($("#tour_path option").size()>0){
		//获取当前tour_path的所有线路
		$("#tour_path option").each(function(){ //遍历全部option
				var txt = $(this).text(); //获取option的内容
				var val = $(this).val(); //获取option的内容
				if(txt == ca_name && val == ca_id){
					alert("已经选择了该选项,不能再次添加");
					ishave = 1;
					return false;
				}
				options += '<option value="' + val + '">' + txt + '</option>';
		});
	}
	if(ishave==1){
		return false;
	}
	options += '<option value="' + ca_id + '">' + ca_name + '</option>';
	$("#tour_path").empty();
	$("#tour_path").append(options);
	
});

$('#delTourPath').on('click', function(){
	//获取当前选择的ID和NAME
	var ca_id = jQuery("#tour_path").val();
	jQuery("#tour_path option[value='" + ca_id + "']").remove();
});
*/


function showSelectOptions(id,list){
	var options = "";
	if(list!=null){
		jQuery.each(
				list,
				function(index,entry){
					options += '<option value="' + entry.ca_id + '">' + entry.ca_name + '</option>';
				}
		);
		
		$("#"+id).append(options);
	}
}


function editProOne(){
	if(!checkProOne()){
		return false;
	}
/* 	alert($("#ca_name").val());
	return false; */
	var parent_name = $("#parent_id_edit option:selected").text();
	var ca_name = $("#ca_id_edit option:selected").text();
	$("#parent_id").val($("#parent_id_edit").val());
	$("#parent_name").val(parent_name);
	$("#ca_id").val($("#ca_id_edit").val());
	$("#ca_name").val(ca_name);
	$("#pathCon").html( parent_name +" -> "+ ca_name);
	closeLayer();
}

function checkProOne(){
	//获取一级类目的id和txt
	if($("#parent_id_edit").val()==null){
		alert("请选择一级分类");
		return false;
	}
	
	//获取二级类目的id和txt
	if($("#ca_id_edit").val()==null){
		alert("请选择二级分类");
		return false;
	}
	
	//获取ca_type
	var ca_type = $("#ca_type_edit").val();
	if(!checkEmpty(ca_type)){
		alert("请选择出游类型");
		return false;
	}
	return true;
}