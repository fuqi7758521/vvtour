<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/css/uploadify/uploadify.css">
<title>上传图片</title>
<script type="text/javascript" src="/js/basic.js"></script>
<script type="text/javascript" src="/js/jquery/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="/js/jquery/jquery.uploadify.min.js"></script>
<script type="text/javascript" src="/js/basic.js"></script>
<style type="text/css">
body,div,ul,li{margin:0;padding:0;}
#box ul{width:768px;height:192px;list-style-type:none;margin:10px auto;}
#box ul div{width:170px;height:30px;border:1px solid #ddd;margin:5px 0px;}
#box li{float:left;width:170px;height:170px;cursor:pointer;display:inline;border:1px solid #ddd;margin:0 10px;}
#box li.active{border:1px solid #a10000;}
#box li img{width:170px;height:170px;vertical-align:top;}
#big{position:absolute;width:400px;height:400px;border:2px solid #ddd;display:none;}
#big div{position:absolute;top:0;left:0;width:400px;height:400px;opacity:0.5;filter:alpha(opacity=50);background:#fff url(/images/loading.gif) 50% 50% no-repeat;}

/*------------分页------------*/
.page{padding:24px 0;height:36px;line-height:34px;font-size:14px;text-align:right}
.page a{display:inline-block;border:#e2e2e2 1px solid;padding:0 16px;height:36px}
.page a:hover,.page a.on{background:#248cff;color:#fff;border:#cde6ff 1px solid; text-decoration:none}
.page span{display:inline-block;padding:0 16px}

</style>
<script type="text/javascript">

</script>
<style type="text/css">
body {
	font: 13px Arial, Helvetica, Sans-serif;
}
</style>
</head>
<body>
<body>

<div align="center">
	<div style="width: 822px;margin-top: 20px;" align="left" >
	   <div style="float: left;width:220px;display:inline;">
      	<form>
			<div id="queue"></div>
			<input id="myfiles" name="myfiles" type="file" multiple="true">
		</form>
      </div>
      <input type="button" onclick="toAction('/admin/album_list.htm')" value="返回相册"/>
      <div style="width:450px;padding-left: 150px;">
      	<h3>当前相册：${album_name}</h3> 
      </div>
    </div>
    
    <div>
      <table cellpadding="0" cellspacing="0" border="1" bordercolor="#c4c4c4" width="822px">
      	<tbody>
      	<tr style="line-height: 25px;font-size: 14px;">
      		<td><a href="javascript:void(0)" onclick="checkAll(this)">全选</a></td>
      		<td>图片</td>
      		<td align="center">图片名称</td>
      		<td colspan="3">编辑</td>
      	</tr>
      	<c:if test="${empty picList}">
			<tr style="line-height: 30px;">
				<td colspan="4">列表暂时没有信息</td>
			</tr>
	 	</c:if>
      	<c:forEach var="item" items="${picList}" varStatus="status">
      	<tr style="line-height: 30px;">
      		<td><input type="checkbox" name="album_id" value="${item.album_id }"/></td>
      		<td><a href="javascript:void(0)" onclick="copyImgUrl('${item.pic_url}');alert('复制成功！');"><img src="${item.pic_url}" width="178px" height="133px" border="0"/></a></td>
      		<td>${item.pic_name}</td>
      		<td><a href="delAlbumPic.htm?album_id=${item.album_id}&pic_id=${item.pic_id}">删除图片</a></td>
      	</tr>
      	</c:forEach>
      	</tbody>
      </table>
      <!--分页 start{-->
      <div class="page" style="width: 820px;">
	       <c:if test="${totalCount > pageSize}">
					<a href="/admin/picture_list.htm?album_id=${album_id }">首页</a>
					<c:if test="${currentPage > 1}">
						<a href='/admin/picture_list.htm?album_id=${album_id }&p=${currentPage-1}'>上一页</a>
					</c:if>
					<c:forEach begin="0" end="${totalPage-1}" step="1" varStatus="p">
						<c:choose>
							<c:when test="${p.index+1 == currentPage}">
								<a href="javascript:void(0)" class="on">${currentPage}</a>
							</c:when>
							<c:otherwise> 
								<a href='/admin/picture_list.htm?album_id=${album_id }&p=${p.index+1 }'>${p.index+1 }</a>
							</c:otherwise>
						</c:choose>
						
					</c:forEach>
					<c:if test="${totalPage > currentPage}">
						<a href='/admin/picture_list.htm?album_id=${album_id }&p=${currentPage+1}'>下一页</a>
					</c:if>
		    </c:if>
      </div>
      <!--}分页 end-->
    </div>
</div>
	<script type="text/javascript">
		$(function() {
			$('#myfiles').uploadify({
				'formData'     : {
					'timestamp' : Math.random()+'',
					'token'     : <%=(new Date()).getTime() %>+''
				},
				'swf'      : '/css/uploadify/uploadify.swf',
				'uploader' : 'picUpload.htm?album_id=${album_id}',
				onQueueComplete : function(stats) {//当队列中的所有文件全部完成上传时触发
					alert('上传成功！');
					toAction("picture_list.htm?album_id=${album_id}");
				}
			});
			

		});
	</script>
</body>
</html>