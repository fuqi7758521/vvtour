<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/css/uploadify/uploadify.css">
<title>上传图片</title>
<script type="text/javascript" src="/js/jquery/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="/js/jquery/jquery.uploadify.min.js"></script>
<style type="text/css">
body {
	font: 13px Arial, Helvetica, Sans-serif;
}
</style>
</head>
<body>
<body>
	<h1>Uploadify Demo</h1>
	<form>
		<div id="queue"></div>
		<input id="myfiles" name="myfiles" type="file" multiple="true">
	</form>

	<script type="text/javascript">
		$(function() {
			$('#myfiles').uploadify({
				'formData'     : {
					'timestamp' : Math.random()+'',
					'token'     : <%=(new Date()).getTime() %>+''
				},
				'swf'      : '/css/uploadify/uploadify.swf',
				'uploader' : 'picUpload.htm?album_id=10001'
			});
		});
	</script>
</body>
</html>