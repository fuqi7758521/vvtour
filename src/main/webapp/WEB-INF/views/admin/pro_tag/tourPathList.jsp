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
      <input id="toAddTourPath" type="button" style="height: 25px;width: 120px;" value="添加路线"/>
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

<!-- 发布旅游路线   -->
<div id="addTourPathLayer" style="display: none;height:600px;font-size: 18px;font-family: arial;">
	  <div id="title" align="right" style="padding-right: 10px;"><span id="close" style="cursor:pointer" onclick="closeLayer()">X</span></div>
      <div style="width:800px;height:30px;margin-top: 10px;margin-left: 20px;background-color: #FFFFCC; border: 1px solid #999;text-align: left;padding-top: 8px;">
      	选择旅游路线
      </div> 
      <div class="yqlj" style="width:800px;height:505px;border: 1px solid #999;margin-top: 10px;background-color: #C4C4C4;margin-left: 20px;text-align: left;">
      	<div style="padding-left: 10px;margin-top: 10px;font-size: 14px;float: left;">
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
      				添加相应路线：
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
      				<textarea readonly="readonly" id="path_name" name="path_name" style="height:300px;width: 160px;"></textarea>
					</div>
      			</td>
      		</tr>
      		
      		<tr style="height: 70px;" valign="bottom" align="right">
      			<td colspan="3" align="right" id="checkMsg">&nbsp;</td>
      			<td>
      				<input type="button" id="submitTourPath" onclick="return addTourPath()" value="提交" style="height: 45px;width:120px;">
      			</td>
      		</tr>
      		
      	</table>
      	</div>

	  </div> 
       <div style="width:800px;height:30px;margin-top: 10px;margin-left: 20px;padding-right: 20px;text-align: right;">
      &nbsp;&nbsp;
      </div>     		       
</div>
<!-- 发布产品第一步骤end  -->
<script type="text/javascript">
$('#toAddTourPath').on('click', function(){
	
	$.blockUI({ message: $('#addTourPathLayer'),
		 css: {
			 top:		'200px',
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
	$("#path_name").removeAttr("readonly");
	$("#path_name").focus();
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

function closeLayer(){
	$.unblockUI();
}
</script>
<script type="text/javascript" src="/js/adminJS/tourPath.js"></script>
</body>
</html>