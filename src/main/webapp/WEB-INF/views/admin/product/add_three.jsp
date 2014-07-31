<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>代码简洁的滑动门（tab）jquery插件</title>
<meta name="keywords" content="jquery特效,JS代码,js特效代码大全,导航菜单代码,焦点幻灯片,企业网页设计欣赏" />
<meta name="description" content="懒人建站为您提供-基于jquery特效，jquery弹出层效果，js特效代码大全，JS广告代码，导航菜单代码，下拉菜单代码和jquery焦点图片代码。" />

<style type="text/css">
body,ul,li{margin: 0;padding: 0;font: 12px normal "宋体", Arial, Helvetica, sans-serif;list-style: none;}
a{text-decoration: none;color: #000;font-size: 14px;}

#tabbox{ width:600px; overflow:hidden; margin:0 auto;}
.tab_conbox{border: 1px solid #999;border-top: none;}
.tab_con{ display:none;}

.tabs{height: 32px;border-bottom:1px solid #999;border-left: 1px solid #999;width: 100%;}
.tabs li{height:31px;line-height:31px;float:left;border:1px solid #999;border-left:none;margin-bottom: -1px;background: #e0e0e0;overflow: hidden;position: relative;}
.tabs li a {display: block;padding: 0 20px;border: 1px solid #fff;outline: none;}
.tabs li a:hover {background: #ccc;}    
.tabs .thistab,.tabs .thistab a:hover{background: #fff;border-bottom: 1px solid #fff;}

.tab_con {padding:12px;font-size: 14px; line-height:175%;}
</style>
<script type="text/javascript" src="/js/jquery/jquery-1.8.1.min.js"></script>
</head>
<body>
<div id="tabbox">
<form name="addProForm" action="<c:url value="pubProduct.htm"/>" method="post">
    <ul class="tabs" id="tabs">
       <li><a href="http://www.clipi.cn/js/nav/" tab="tab1">导航菜单</a></li>
       <li><a href="http://www.clipi.cn/js/slide/" tab="tab2">焦点幻灯片</a></li>
       <li><a href="http://www.clipi.cn/js/gg/" tab="tab3">广告代码</a></li>
       <li><a href="http://www.clipi.cn/js/texiao/" tab="tab4">网页特效</a></li>
    </ul>
    <ul class="tab_conbox">
        <li id="tab1" class="tab_con">
           <p><span><a href="http://www.clipi.cn/">懒人建站</a>只收录实用和能提高用户体验的代码</span><br />
<span>我们只想解放出你的部分写代码时间来思考更高层次的设计，而不是要你懒惰、拼凑。</span>
			</p>
			<p><input type="text" size="12" id="route_days" name="route_days"/></p>
        </li>
            
        <li id="tab2" class="tab_con">
            <p><span><a href="http://www.clipi.cn/">懒人建站</a>只收录实用和能提高用户体验的代码</span><br />
<span>我们只想解放出你的部分写代码时间来思考更高层次的设计，而不是要你懒惰、拼凑。</span></p>
		<p><input type="text" size="12" id="market_price" name="market_price"/></p>
        </li>
    
        <li id="tab3" class="tab_con">
            <p><span><a href="http://www.clipi.cn/">懒人建站</a>只收录实用和能提高用户体验的代码</span><br />
<span>我们只想解放出你的部分写代码时间来思考更高层次的设计，而不是要你懒惰、拼凑。</span>
			</p>
			<p><input type="text" size="20" id="route_feature" name="route_feature"/></p>
        </li>
    
        <li id="tab4" class="tab_con">
            <p><span><a href="http://www.clipi.cn/">懒人建站</a>只收录实用和能提高用户体验的代码</span><br />
<span>我们只想解放出你的部分写代码时间来思考更高层次的设计，而不是要你懒惰、拼凑。</span></p>
        </li>
    </ul>
    <ul>
    <li style="text-align: center;"><input name="submit" type="button" onclick="return pubProduct()" value="提交"/></li>
    </ul>
</form>
</div>
<p>代码简洁的滑动门（tab）jquery插件调用方法："#tabs",".tab_con" 这里的#tabs是jquery选项卡的链接按钮的外层ID，.tab_con是要显示的的内容类名。只要注意这两个地方调用就不会错。一个页面可以多次使用。
</p>
<div id="con">&nbsp;</div>

</div>
<script type="text/javascript">
$(document).ready(function() {
    jQuery.jqtab = function(tabtit,tabcon) {
        $(tabcon).hide();
        $(tabtit+" li:first").addClass("thistab").show();
        $(tabcon+":first").show();
    
        $(tabtit+" li").click(function() {
            $(tabtit+" li").removeClass("thistab");
            $(this).addClass("thistab");
            $(tabcon).hide();
            var activeTab = $(this).find("a").attr("tab");
            $("#"+activeTab).fadeIn();
            return false;
        });
        
    };
    /*调用方法如下：*/
    $.jqtab("#tabs",".tab_con");
    
});
function pubProduct(){
	var tab1 = $("#route_days").val();
	var tab2 = $("#market_price").val();
	var tab3 = $("#route_feature").val();
	
	$("#con").html(tab1+","+tab2+","+tab3);
	
}
</script>
</body>
</html>