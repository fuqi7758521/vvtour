<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传图片</title>
<script type="text/javascript" src="/js/jquery/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="/js/jquery/ajaxfileupload.js"></script>
<script type="text/javascript">
function ajaxFileUpload(){
	//开始上传文件时显示一个图片,文件上传完成将图片隐藏
	//$("#loading").ajaxStart(function(){$(this).show();}).ajaxComplete(function(){$(this).hide();});
	//执行上传文件操作的函数
	$.ajaxFileUpload({
		//处理文件上传操作的服务器端地址(可以传参数,已亲测可用)
		url:'picUpload.htm?album_id=10001',
		secureuri:false,                           //是否启用安全提交,默认为false 
		fileElementId:'myBlogImage',               //文件选择框的id属性
		dataType:'text',                           //服务器返回的格式,可以是json或xml等
		success:function(data, status){            //服务器响应成功时的处理函数
			data = data.replace(/<pre.*?>/g, '');  //ajaxFileUpload会对服务器响应回来的text内容加上<pre style="....">text</pre>前后缀
			data = data.replace(/<PRE.*?>/g, '');
			data = data.replace("<PRE>", '');
			data = data.replace("</PRE>", '');
			data = data.replace("<pre>", '');
			data = data.replace("</pre>", '');     //本例中设定上传文件完毕后,服务端会返回给前台[0`filepath]
			if(data.substring(0, 1) == 0){         //0表示上传成功(后跟上传后的文件路径),1表示失败(后跟失败描述)
				$("img[id='uploadImage']").attr("src", data.substring(2));
				$('#result').html("图片上传成功<br/>");
			}else{
				$('#result').html('图片上传失败，请重试！！');
			}
		},
		error:function(data, status, e){ //服务器响应失败时的处理函数
			$('#result').html('图片上传失败，请重试！！');
		}
	});
}
</script>
</head>
<body>
<div id="result"></div>
<img id="uploadImage" src="http://www.firefox.com.cn/favicon.ico">

<input type="file" id="myBlogImage" name="myfiles"/>
<input type="button" value="上传图片" onclick="ajaxFileUpload()"/>

<!-- 
AjaxFileUpload简介
官网:http://phpletter.com/Our-Projects/AjaxFileUpload/
简介:jQuery插件AjaxFileUpload能够实现无刷新上传文件,并且简单易用,它的使用人数很多,非常值得推荐
注意:引入js的顺序(它依赖于jQuery)和页面中并无表单(只是在按钮点击的时候触发ajaxFileUpload()方法)
常见错误及解决方案如下
1)SyntaxError: missing ; before statement
  --检查URL路径是否可以访问
2)SyntaxError: syntax error
  --检查处理提交操作的JSP文件是否存在语法错误
3)SyntaxError: invalid property id
  --检查属性ID是否存在
4)SyntaxError: missing } in XML expression
  --检查文件域名称是否一致或不存在
5)其它自定义错误
  --可使用变量$error直接打印的方法检查各参数是否正确,比起上面这些无效的错误提示还是方便很多
 -->
</body>
</html>