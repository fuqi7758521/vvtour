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
</head>
<body>
<div align="center">
	<div style="width: 822px;margin-top: 20px;" align="left" >
	   <div>
	   <c:if test="${!empty caInfo}">
      	<input onclick="window.location.href='toAddChip.htm?chip_ca_id=${caInfo.chip_ca_id}'" type="button" style="height: 25px;width: 120px;" value="添加碎片"/>
      	&nbsp;&nbsp;
      	<input onclick="window.open('${caInfo.page_url}')" type="button" style="height: 25px;width: 120px;" value="预览页面"/>
      	</c:if>
      	&nbsp;&nbsp;
      	<input onclick="window.location.href='chipCategories.htm'" type="button" style="height: 25px;width: 120px;" value="返回分类列表"/>
      </div>
    </div>
    <div>&nbsp;</div>
    <div class="page" style="width:822px;display:inline;padding-left: 50px;">
    	<c:if test="${empty chipcaList}">
				列表暂时没有碎片分类
	 	</c:if>
	 	<c:forEach var="ca_item" items="${chipcaList}" varStatus="status">
	 	<a href="chips.htm?chip_ca_id=${ca_item.chip_ca_id}" class="<c:if test='${!empty caInfo}'><c:if test='${ca_item.chip_ca_id==caInfo.chip_ca_id}'>on</c:if></c:if>">${ca_item.chip_ca_name}</a>&nbsp;
	 	</c:forEach>
      </div>
    <div>
      <table cellpadding="0" cellspacing="0" border="1" bordercolor="#c4c4c4" width="600px">
      	<tbody>
      	<tr style="line-height: 25px;font-size: 14px;" align="center">
      		<td width="50px"><a href="javascript:void(0)" onclick="checkAll(this)">全选</a></td>
      		<td align="center" width="25%">碎片名称</td>
      		<td align="center" width="25%">碎片变量</td>
      		<td colspan="2">编辑</td>
      	</tr>
      	<c:if test="${empty chipList}">
			<tr style="line-height: 30px;" align="center">
				<td colspan="5">列表暂时没有信息</td>
			</tr>
	 	</c:if>
      	<c:forEach var="item" items="${chipList}" varStatus="status">
      	<tr style="line-height: 30px;" align="center" onmouseover="this.style.backgroundColor='#ccc'" onmouseout="this.style.backgroundColor='#ffffff'">
      		<td><input type="checkbox" name="chip_id" value="${item.chip_id }"/></td>
      		<td>${item.chip_name}</td>
      		<td>${item.chip_var }</td>
      		<td><a href="toEditChip.htm?chip_id=${item.chip_id }">编辑</a></td>
      		<td><a href="javascript:void(0)">删除</a></td>
      	</tr>
      	</c:forEach>
      	</tbody>
      </table>
      <!--分页 start{-->
      <div class="page" style="width: 820px;">
	       <c:if test="${totalCount > pageSize}">
					<a href="chips.htm?chip_ca_id=${caInfo.chip_ca_id }">首页</a>
					<c:if test="${currentPage > 1}">
						<a href='chips.htm?p=${currentPage-1}<c:if test="${!empty caInfo} ">&chip_ca_id=${caInfo.chip_ca_id}</c:if>'>上一页</a>
					</c:if>
					<c:forEach begin="0" end="${totalPage-1}" step="1" varStatus="p">
						<c:choose>
							<c:when test="${p.index+1 == currentPage}">
								<a href="javascript:void(0)" class="on">${currentPage}</a>
							</c:when>
							<c:otherwise>
								<a href='chips.htm?p=${p.index+1 }<c:if test="${!empty caInfo} ">&chip_ca_id=${caInfo.chip_ca_id}</c:if>'>${p.index+1 }</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:if test="${totalPage > currentPage}">
						<a href='chips.htm?p=${currentPage+1}<c:if test="${!empty caInfo} ">&chip_ca_id=${caInfo.chip_ca_id}</c:if>'>下一页</a>
					</c:if>
		    </c:if>
      </div>
      <!--}分页 end-->
    </div>
</div>

<!-- 添加菜单层 -->
 <div id="addAlbumlayer" style="text-align: center;height: 290px; display:none;">
        <div style="background-color:#fff; z-index:19891015" class="xubox_main">
		<div class="xubox_page">
			<div class="xuboxPageHtml" id="xuboxPageHtml1">
				<form action="addAlbum.htm" id="addAlbumForm" method="post">
					<ul class="formLib" style="margin-top: 20px;margin-left: 50px;width: 400px;height:220px; ">
						<li style="margin-bottom: 20px; position: relative;line-height: 22px; text-align: left;">
							<label>相册名：</label>
							<input type="text" id="album_name" name="album_name" maxlength="10" style="width: 170px;font-size: 16px;" onchange="return checkAlbumNameExist()" placeholder="2-6位汉字、字母、数字组成" autocomplete="off" />
							<span class="from_msg" id="checkMsg" style="text-align: right;">&nbsp;</span>
						</li>
						<!-- 
						<li style="text-align: left; line-height: 35px;">
							<label>描&nbsp;&nbsp;述：</label>
							<textarea id="album_comment" name="album_comment" style="width: 182px;height: 50px;" placeholder="相册描述"></textarea>
							<span class="from_msg" id="checkCnMsg" style="text-align: left;">&nbsp;</span>
						</li> -->
						<li style="margin-bottom: 20px; position: relative;line-height: 22px; text-align: left;">
							<label>相册类型：</label>
							<select name="album_type" id="album_type" style="height:120px;font-size: 16px;"  size="6">
								<option value="china">国内</option>
								<option value="bj_around">北京周边</option>
								<option value="h_m_t">港澳台</option>
								<option value="madai">马尔代夫</option>
								<option value="island">海岛图</option>
								<option value="aoxink">澳新凯</option>
								<option value="asia">亚洲</option>
								<option value="europe">欧洲</option>
								<option value="america">美洲</option>
								<option value="africa">中东非洲</option>
								<option value="ad">广告图</option>
							</select>
						</li>
						<li style="text-align: center;margin-top: 22px;">
							<input class="BB_button" id="submitAlbum" onclick="return addAlbumName()" value="提交" type="button"><span class="from_msg"><a href="javascript:void(0)" onclick="closeLayer()">关闭弹窗</a></span>
						</li>
					</ul>
				</form>
		</div>
		</div>
		</div>
</div>
<!-- 添加菜单层 -->
<script type="text/javascript">
$('#popAddAlbum').on('click', function(){
	 $.blockUI({ message: $('#addAlbumlayer'),			
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
function closeLayer(){
	$.unblockUI();
}
</script>
<script type="text/javascript" src="/js/adminJS/album.js"></script>
</body>
</html>