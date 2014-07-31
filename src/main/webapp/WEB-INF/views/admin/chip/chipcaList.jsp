<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
  <title>网站相册</title>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   <link href="/js/admin/css/dpl-min.css" rel="stylesheet" type="text/css" />
   <link href="/js/admin/css/page-min.css" rel="stylesheet" type="text/css" />
   <link href="/css/layer.css" rel="stylesheet" type="text/css" />
   <style type="text/css">
    code {
      padding: 0px 4px;
      color: #d14;
      background-color: #f7f7f9;
      border: 1px solid #e1e1e8;
    }
body,ul,li{margin: 0;padding: 0;font: 12px normal "宋体", Arial, Helvetica, sans-serif;list-style: none;}
/*------------分页------------*/
.page{padding:24px 0;height:36px;line-height:34px;font-size:14px;text-align:right}
.page a{display:inline-block;border:#e2e2e2 1px solid;padding:0 16px;height:36px}
.page a:hover,.page a.on{background:#248cff;color:#fff;border:#cde6ff 1px solid; text-decoration:none}
.page span{display:inline-block;padding:0 16px}

   </style>
	<script type="text/javascript" src="/js/jquery/jquery-1.8.1.min.js"></script>
	<script type="text/javascript" src="/js/jquery/jquery.blockUI.js"></script>
	<script type="text/javascript" src="/js/layer/layer.min.js"></script>
	<script type="text/javascript" src="/js/basic.js"></script>
<script type="text/javascript">
function generate(url){
	$.ajax({
		url:"generateChannel.htm",
		type:"get",
		data:"gen_url="+url+"&ver="+Math.random(),
		dataType:'text',
		success:function(msg,status){
			var info = msg.split('|');
			if(parseInt(info[0])==1){
				alert('生成成功!');
			} else if(parseInt(info[0])==0 || parseInt(info[0])==-1){
				alert(info[1]);
			}
			
			//$("#checkMsg").text(info[1]);
        },
        error:function(xhr,textStatus,errorThrown){}
	});
}
</script>
</head>
<body>
<div align="center">
	<div style="width: 822px;margin-top: 20px;" align="left" >
	   <div style="width: 120px;">
      	<input id="popAddChipCa" type="button" style="height: 25px;width: 120px;" value="添加碎片分类"/>
      </div>
    </div>
    <div>
      <table cellpadding="0" cellspacing="0" border="1" bordercolor="#c4c4c4" width="822px">
      	<tbody>
      	<tr style="line-height: 25px;font-size: 14px;" align="center">
      		<td><a href="javascript:void(0)" onclick="checkAll(this)">全选</a></td>
      		<td align="center" width="125px;">分类名称</td>
      		<td colspan="5">编辑</td>
      	</tr>
      	<c:if test="${empty chipcaList}">
			<tr style="line-height: 30px;">
				<td colspan="7">列表暂时没有信息</td>
			</tr>
	 	</c:if>
      	<c:forEach var="item" items="${chipcaList}" varStatus="status">
      	<tr style="line-height: 30px;" align="center" onmouseover="this.style.backgroundColor='#ccc'" onmouseout="this.style.backgroundColor='#ffffff'">
      		<td><input type="checkbox" name="sel" value="${intem.chip_ca_id}"></td>
      		<td><a href="chips.htm?chip_ca_id=${item.chip_ca_id}">${item.chip_ca_name }</a></td>
      		<td><a href="javascript:void(0)" onclick="generate('${item.page_url}')">生成页面</a></td>
      		<td><a href="toAddChip.htm?chip_ca_id=${item.chip_ca_id}" target="_blank">添加碎片</a></td>
      		<td><a href="/${item.page_url}" target="_blank">预览页面</a></td>
      		<td><a href="javascript:void(0)" onclick="toEditChipCA('${item.chip_ca_id}','${item.chip_ca_name}','${item.page_url}')">编辑名称</a></td>
      		<td><a href="javascript:void(0)">删除</a></td>
      	</tr>
      	</c:forEach>
      	</tbody>
      </table>
      <!--分页 start{-->
      <div class="page" style="width: 820px;">
	       <c:if test="${totalCount > pageSize}">
					<a href="/admin/chipCategories.htm">首页</a>
					<c:if test="${currentPage > 1}">
						<a href='/admin/chipCategories.htm?p=${currentPage-1}'>上一页</a>
					</c:if>
					<c:forEach begin="0" end="${totalPage-1}" step="1" varStatus="p">
						<c:choose>
							<c:when test="${p.index+1 == currentPage}">
								<a href="javascript:void(0)" class="on">${currentPage}</a>
							</c:when>
							<c:otherwise>
								<a href='/admin/chipCategories.htm?p=${p.index+1 }'>${p.index+1 }</a>
							</c:otherwise>
						</c:choose>
						
					</c:forEach>
					<c:if test="${totalPage > currentPage}">
						<a href='/admin/chipCategories.htm?p=${currentPage+1}'>下一页</a>
					</c:if>
		    </c:if>
      </div>
      <!--}分页 end-->
    </div>
</div>

<!-- 添加菜单层start -->
 <div id="addChipCalayer" style="text-align: center;height: 290px; display:none;">
        <div style="background-color:#fff; z-index:19891015" class="xubox_main">
		<div class="xubox_page">
			<div class="xuboxPageHtml" id="xuboxPageHtml1">
				<form action="addChipCA.htm" id="addChipCAForm" method="post">
					<ul class="formLib" style="margin-top: 20px;margin-left: 50px;width: 400px;height:220px; ">
						<li style="margin-bottom: 20px; position: relative;line-height: 22px; text-align: left;">
							<label>分类名称：</label>
							<input type="text" id="chip_ca_name" name="chip_ca_name" maxlength="10" style="width: 170px;font-size: 16px;" onchange="return checkCaNameExist('add')" placeholder="2-6位汉字、字母、数字组成" autocomplete="off" />
							<span class="from_msg" id="name_msg" style="text-align: right;">&nbsp;</span>
						</li>
						<li style="text-align: left; line-height: 35px;">
							<label>所属页面：</label>
							<input type="text" id="page_url" name="page_url"/>
							<span class="from_msg" id="url_msg" style="text-align: left;">&nbsp;</span>
						</li>
						<li style="text-align: center;margin-top: 22px;">
							<input class="BB_button" id="submitChipCA" onclick="return addChipCA()" value="提交" type="button"><span class="from_msg"><a href="javascript:void(0)" onclick="closeLayer()">关闭弹窗</a></span>
						</li>
					</ul>
				</form>
		</div>
		</div>
		</div>
</div>
<!-- 添加菜单层end-->

<!-- 编辑分类层start -->
 <div id="editChipCalayer" style="text-align: center;height: 290px; display:none;">
        <div style="background-color:#fff; z-index:19891015" class="xubox_main">
		<div class="xubox_page">
			<div class="xuboxPageHtml" id="xuboxPageHtml1">
				<form action="editChipCA.htm" id="editChipCAForm" method="post">
					<ul class="formLib" style="margin-top: 20px;margin-left: 50px;width: 400px;height:220px; ">
						<li style="margin-bottom: 20px; position: relative;line-height: 22px; text-align: left;">
							<label>分类名称：</label>
							<input type="text" id="edit_chip_ca_name" name="edit_chip_ca_name" maxlength="10" style="width: 170px;font-size: 16px;height: 25px;" onchange="return checkCaNameExist('edit')" placeholder="2-6位汉字、字母、数字组成" autocomplete="off" />
							<input type="hidden" name="edit_chip_ca_id" value="1" id="edit_chip_ca_id"/><span class="from_msg" id="edit_name_msg" style="text-align: right;">&nbsp;</span>
						</li>
						<li style="text-align: left; line-height: 35px;">
							<label>所属页面：</label>
							<input type="text" id="edit_page_url" name="edit_page_url" style="width: 200px;font-size: 16px;height: 25px;"/>
							<span class="from_msg" id="edit_url_msg" style="text-align: left;">&nbsp;</span>
						</li>
						<li style="text-align: center;margin-top: 22px;">
							<input class="BB_button" id="submitEditChipCA" onclick="return editChipCA()" value="提交" type="button"><span class="from_msg"><a href="javascript:void(0)" onclick="closeLayer()">关闭弹窗</a></span>
						</li>
					</ul>
				</form>
		</div>
		</div>
		</div>
</div>
<!-- 编辑分类层end-->
<script type="text/javascript">
$('#popAddChipCa').on('click', function(){
	 $.blockUI({ message: $('#addChipCalayer'),			
		 css: {
			padding:	0,
			margin:		0,
			width:		'450px',
			top:		'200px',
			left:		'35%',
			textAlign:	'center',
			color:		'#000',
			border:		'3px solid #aaa',
			backgroundColor:'#fff'
		} 
	 });
	 
});

function toEditChipCA(id,name,url){
	$.blockUI({ message: $('#editChipCalayer'),			
		 css: {
			padding:	0,
			margin:		0,
			width:		'450px',
			top:		'200px',
			left:		'35%',
			textAlign:	'center',
			color:		'#000',
			border:		'3px solid #aaa',
			backgroundColor:'#fff'
		} 
	 });
	$("#edit_chip_ca_id").val(id);
	$("#edit_chip_ca_name").val(name);
	$("#edit_page_url").val(url);
}

function closeLayer(){
	$.unblockUI();
}
</script>
<script type="text/javascript" src="/js/adminJS/chips.js"></script>
</body>
</html>