<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
body,ul,li{margin: 0;padding: 0;font: 12px normal "宋体", Arial, Helvetica, sans-serif;list-style: none;}

</style>
<script type="text/javascript" src="/js/jquery/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="/js/jquery/jquery.blockUI.js"></script>
<script type="text/javascript" src="/js/basic.js"></script>
<title>添加旅游路线</title>

</head>
<body>
<div align="center">
	<div style="width: 822px;margin-top: 20px;" align="left">
      <input id="toPubProduct" type="button" style="height: 25px;width: 120px;" value="发布产品"/>
    </div>
    <div>&nbsp;</div>
    <div>
      <table cellpadding="0" cellspacing="0" border="1" bordercolor="#c4c4c4" width="822px">
      	<tbody>
      	<tr style="line-height: 25px;font-size: 14px;">
      		<td><a href="javascript:void(0)" onclick="checkAll(this)">全选</a></td>
      		<td>编号</td>
      		<td align="center" width="400px;">标题</td>
      		<td>类型</td>
      		<td>发布日期</td>
      		<td>编辑</td>
      	</tr>
      	<tr style="line-height: 30px;">
      		<td><input type="checkbox" name="pro_id" value="10001"/></td>
      		<td>10001</td>
      		<td align="left" style="padding-left: 10px;">途牛聚民品，江中泼水节，亚洲第一漂</td>
      		<td>国内游</td>
      		<td>2014-07-21 11:23:12</td>
      		<td >编辑|报价|删除|</td>
      	</tr>
      	</tbody>
      </table>
    </div>
</div>

<!-- 发布产品第一步骤   -->
<div id="pubSetpOne" style="display: none;height:600px;font-size: 18px;font-family: arial;">
	  <div id="title" align="right" style="padding-right: 10px;"><span id="close" style="cursor:pointer" onclick="closeLayer()">X</span></div>
      <div style="width:800px;height:30px;margin-top: 10px;margin-left: 20px;background-color: #FFFFCC; border: 1px solid #999;text-align: left;padding-top: 8px;">
      	步骤一：选择产品分类
      </div> 
      <div class="yqlj" style="width:800px;height:505px;border: 1px solid #999;margin-top: 10px;background-color: #C4C4C4;margin-left: 20px;text-align: left;">
      	<div style="padding-left: 10px;margin-top: 10px;font-size: 14px;float: left;">
      	<form name="pubProForm" id="pubProForm" action="<c:url value="toAddProduct_second.htm"/>" method="post">
      	<table border="1" width="780px" cellpadding="0" cellspacing="0" style="text-align: center;">
      		<tr style="line-height: 25px;">
      			<td width="20%">
      				选择类型：
      			</td>
      			<td width="27%">
      				选择一级菜单：
      			</td>
      			<td width="27%">
      				选择二级菜单：
      			</td>
      			<td>
      				包含的线路：<input type="button" value="删除" id="delTourPath"/>
      			</td>
      		</tr>
      		<tr height="300px;" align="center">
      			<td>
      				<div style="border:1px solid #333333;width:120px;height:46px;"> 
					<select name="ca_type" id="ca_type" size="2" style="margin:-2;width:120px;background:#eeeeee;font-size: 16px;">
						<option value="domestic">国内游</option>
						<option value="abroad">出境游</option>
					</select>
					</div>
      			</td>
      			<td>
      				<div style="border:1px solid #333333;width:160px;height:310px;"> 
					<select name="category" id="category" size="15" style="margin:-2;width:160px;background:#eeeeee;font-size: 16px;"></select>
					</div>
      			</td>
      			<td>
      				 <div style="border:1px solid #333333;width:160px;height:310px;"> 
					<select name="subcategory" id="subcategory" size="15" style="margin:-2;width:160px;background:#eeeeee;font-size: 16px;"></select>
					</div>
      			</td>
      			<td>
      				<div style="border:1px solid #333333;width:160px;height:310px;"> 
					<select name="tour_path" id="tour_path" size="15" style="margin:-2;width:160px;background:#eeeeee;font-size: 16px;">
					</select>
					<input type="hidden" name="tours" id="tours"/>
					</div>
      			</td>
      		</tr>
      		<tr style="height:80px;" valign="bottom" align="left">
      			<td colspan="3" valign="middle">&nbsp;&nbsp;&nbsp;&nbsp;
      				出发城市：<input type="text" size="8" style="height: 30px;font-size: 28px;" name="start_city" id="start_city"/>
      				&nbsp;&nbsp;&nbsp;&nbsp;
      				到达城市：<input type="text" size="8" style="height: 30px;font-size: 28px;" name="end_city" id="end_city"/>
      			</td>
      			<td align="center" valign="middle">
      				行程天数：<input type="text" size="6" style="height: 30px;font-size: 28px;width: 40px;" name="tour_days" id="tour_days"/>&nbsp;&nbsp;天
      			</td>
      		</tr>
      		
      		<tr style="height: 70px;" valign="bottom" align="right">
      			<td colspan="4" >
      				<input type="button" value="下一步" id="goStepTwo" style="height: 45px;width:120px;">
      			</td>
      		</tr>
      		
      	</table>
      	</form>
      	</div>

	  </div> 
       <div style="width:800px;height:30px;margin-top: 10px;margin-left: 20px;padding-right: 20px;text-align: right;">
      &nbsp;&nbsp;
      </div>     		       
</div>
<!-- 发布产品第一步骤end  -->
<script type="text/javascript">
$('#toPubProduct').on('click', function(){
	
	$.blockUI({ message: $('#pubSetpOne'),
		 css: {
			 top:		'100px',
			 width:		'840px',
			 left:		'28%',
			 textAlign:	'center',
			 border:	'3px solid #ccc'
		 }
	});
	 
});

$('#ca_type').on('change', function(){
	$("#category").empty();
	$("#subcategory").empty();
	//$("#tour_path").empty();
	var ca_type = $(this).val();
	
	$.ajax({
		type:"GET",
		contentType : 'application/json',
		url:"catchCategoryList.htm?ca_type="+ca_type+"&pid="+0,
		dataType:'json',
		success:function(data){
			if (data || data.success == "true"){
				showSelectOptions("category",data.data);
			}
        },
        error:function(xhr,textStatus,errorThrown){}
	});
});

$('#category').on('change', function(){
	$("#subcategory").empty();
	//$("#tour_path").empty();
	var ca_type = $("#ca_type").val();
	var parent_id = $(this).val();
	$.ajax({
		type:"GET",
		contentType : 'application/json',
		url:"catchCategoryList.htm?ca_type="+ca_type+"&pid="+parent_id,
		dataType:'json',
		success:function(data){
			if (data || data.success == "true"){
				showSelectOptions("subcategory",data.data);
			}
        },
        error:function(xhr,textStatus,errorThrown){}
	});
});

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

//进入下一步
$('#goStepTwo').on('click', function(){
	//获取一级类目的id和txt
	if($("#category").val()==null){
		alert("请选择一级分类");
		return false;
	}
	var parent_id = $("#category").val();
	var parent_name = $("#category option:selected").text();
	
	//获取二级类目的id和txt
	if($("#subcategory").val()==null){
		alert("请选择二级分类");
		return false;
	}
	var ca_id = $("#subcategory").val();
	var ca_name = $("#subcategory option:selected").text();
	
	
	if(jQuery("#tour_path option").size()<1){
		alert("线路不能为空");
		return false;
	}
	
	var options="";
	//获取tour_path的所有id和txt 格式:"1006|黄龙,1007|乐山"
	$("#tour_path option").each(function(){ //遍历全部option
			var txt = $(this).text(); //获取option的内容
			var val = $(this).val(); //获取option的内容
			options += val + '|' + txt + ',';
	});
	options = options.substring(0,options.length-1);
	
	//获取start_city end_city
	var start_city = $("#start_city").val();
	if(!checkEmpty(start_city)){
		alert("出发城市不能为空");
		return false;
	}
	
	var end_city = $("#end_city").val();
	if(!checkEmpty(end_city)){
		alert("目的地城市不能为空");
		return false;
	}
	
	//获取tour_days
	var tour_days = $("#tour_days").val();
	if(!checkEmpty(tour_days)){
		alert("行程天数不能为空");
		return false;
	}
	
	//获取ca_type
	var ca_type = $("#ca_type").val();
	
	var url = "toAddProduct2.htm";
	var params = {'ca_type':ca_type,
			'parent_id':parent_id,
			'parent_name':parent_name,
			'ca_id':ca_id,
			'ca_name':ca_name,
			'tour_path':options,
			'tour_days':tour_days,
			'start_city':start_city,
			'end_city':end_city};
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
	  		});
	
});


function closeLayer(){
	$.unblockUI();
}
</script>
</body>
</html>
		