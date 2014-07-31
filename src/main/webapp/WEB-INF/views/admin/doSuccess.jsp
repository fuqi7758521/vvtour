<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>操作成功</title>
<style>
#leamain{
	text-align: center;
}
</style>
</head>
<body>
<div align="center">
	<div align="center" style="width: 450px;height: 150px;padding-top: 15px;border:1px solid #ccc;background:#c4c4c4;">
		<div style="font-size: 20px;font-family:微软雅黑;color: green;">
		${successMsg }
		</div>
		<div>&nbsp;</div>
		<div style="font-size: 12px;">
		您可以：&nbsp;&nbsp;&nbsp;&nbsp;
		<c:if test="${operateType=='pubProduct'}">
		<div>
				<span><a href="/admin/generateProHTML.htm?pro_id=${successData }">生成页面</a></span>&nbsp;&nbsp;&nbsp;&nbsp;
				|<span><a href="toEditProduct.htm?pro_id=${successData }">返回修改</a></span>
				|<span><a href="/admin/products.htm">返回列表</a></span>&nbsp;&nbsp;&nbsp;&nbsp;
		</div>
		</c:if>
		<c:if test="${operateType=='editProduct'}">
		<div>
				<span><a href="/admin/generateProHTML.htm?pro_id=${successData }">生成页面</a></span>&nbsp;&nbsp;&nbsp;&nbsp;
				|<span><a href="toEditProduct.htm?pro_id=${successData }">返回继续修改</a></span>
				|<span><a href="/admin/products.htm">返回列表</a></span>&nbsp;&nbsp;&nbsp;&nbsp;
		</div>
		</c:if>
		<c:if test="${operateType=='addChip'}">
		<div>
				<span><a href="toAddChip.htm?chip_ca_id=${successData.chip_ca_id }">继续添加</a></span>
				|<span><a href="/admin/chips.htm">返回列表</a></span>&nbsp;&nbsp;&nbsp;&nbsp;
		</div>
		</c:if>
		<c:if test="${operateType=='editChip'}">
		<div>
				<span><a href="/admin/generateHTML.htm?chip_ca_id=${successData.chip_ca_id }">生成页面</a></span>&nbsp;&nbsp;&nbsp;&nbsp;
				|<span><a href="toEditChip.htm?chip_id=${successData.chip_id }">返回修改</a></span>
				|<span><a href="/admin/chips.htm">返回列表</a></span>&nbsp;&nbsp;&nbsp;&nbsp;
		</div>
		</c:if>
		</div>
	</div>
</div>

<div id="leamain">
<c:if test="${operateType=='pubProduct'||operateType=='editProduct'}">
       <iframe src="/admin/viewProduct.htm?pro_id=${successData }" marginheight="0" marginwidth="0" frameborder="0" scrolling="no" width="100%" height=100% id="iframepage" name="iframepage" onLoad="iFrameHeight()" ></iframe>
</c:if>
<script type="text/javascript" language="javascript">

    function iFrameHeight() {

        var ifm= document.getElementById("iframepage");

        var subWeb = document.frames ? document.frames["iframepage"].document :

ifm.contentDocument;

            if(ifm != null && subWeb != null) {

            ifm.height = subWeb.body.scrollHeight;

            }

    }

</script>

</div>
</body>
</html>