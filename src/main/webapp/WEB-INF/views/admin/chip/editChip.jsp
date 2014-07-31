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
body,ul,li{margin: 0;padding: 0;font: 12px normal "宋体", Arial, Helvetica, sans-serif;list-style: none;}
   </style>
	<script type="text/javascript" src="/js/jquery/jquery-1.8.1.min.js"></script>
	<script type="text/javascript" src="/js/jquery/jquery.blockUI.js"></script>
	<script type="text/javascript" src="/js/layer/layer.min.js"></script>
	<script type="text/javascript" src="/js/basic.js"></script>
</head>
<body>
<div align="center">
	<div style="width: 700px;margin-top: 20px;">
	<form action="editChip.htm" name="editChipForm" id="editChipForm" method="post">
	  <table cellpadding="0" cellspacing="0" border="1" bordercolor="#c4c4c4" width="700px">
      	<tbody>
      	<tr style="line-height: 25px;font-size: 16px;">
      		<td colspan="2" align="center">修改碎片</td>
      	</tr>
      	<tr style="line-height: 30px;font-size: 14px;" align="left">
      		<td align="center">当前分类：</td>
      		<td>${caInfo.chip_ca_name}&nbsp;&nbsp;碎片变量:<input type="text" name="chip_var" id="chip_var" value="${chipInfo.chip_var}" style="width: 280px;height: 25px;"/>
      		<span id="var_msg"></span>
      		</td>
      	</tr>
      	<tr style="line-height: 30px;font-size: 14px;">
      		<td>碎片名称：</td>
      		<td width="85%" align="left">
      		<input type="hidden" name="chip_id" value="${chipInfo.chip_id}"/>
      		<input type="text" name="chip_name" id="chip_name" value="${chipInfo.chip_name}" onchange="return checkChipNameExist()" style="width: 280px;height: 25px;"/>
      		<span id="name_msg"></span></td>
      	</tr>
      	<tr style="line-height: 30px;font-size: 14px;" align="center">
      		<td>碎片内容：</td>
      		<td>
      		<input type="hidden" name="chip_ca_id" value="${caInfo.chip_ca_id}"/>
      		<textarea name="chip_con" id="chip_con" style="width: 600px;height: 500px;">${chipInfo.chip_con}</textarea><span id="con_msg"></span></td>
      	</tr>
      	<tr style="line-height: 20px;font-size: 14px;" align="center">
      		<td colspan="2">
      		<!-- <input name="submitChip" id="submitChip" onclick="generatePage('${caInfo.page_url}')" style="height:40px;width: 200px;" type="button" value="提交保存"/> -->
      		&nbsp;&nbsp;
      		<input name="submitEditChip" id="submitEditChip" onclick="editChip()" style="height:40px;width: 200px;" type="button" value="提交预览"/>
      		<a href="javascript:window.history.go(-1)">返回列表</a>
      		</td>
      	</tr>
      	</tbody>
      </table>
      <textarea name="chip_con_bak" id="chip_con_bak" style="visibility: hidden;">${chipInfo.chip_con_bak}</textarea>
      </form>
    </div>
</div>

<script type="text/javascript" src="/js/adminJS/chips.js"></script>
</body>
</html>