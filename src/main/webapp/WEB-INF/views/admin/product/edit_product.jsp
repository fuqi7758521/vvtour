<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>代码简洁的滑动门</title>
<style type="text/css">
body,ul,li{margin: 0;padding: 0;font: 12px normal "宋体", Arial, Helvetica, sans-serif;list-style: none;}
a{text-decoration: none;color: #000;font-size: 14px;}
#tabbox{ width:828px; overflow:hidden; margin:0 auto;}
.tab_conbox{border: 1px solid #999;border-top: none;}
.tab_con{ display:none;height:auto;}
.change_tabs{height: 32px;border-bottom:1px solid #999;border-left: 1px solid #999;width: 100%;}
.change_tabs li{height:31px;line-height:31px;float:left;border:1px solid #999;border-left:none;margin-bottom: -1px;background: #e0e0e0;overflow: hidden;position: relative;}
.change_tabs li a {display: block;padding: 0 20px;border: 1px solid #fff;outline: none;}
.change_tabs li a:hover {background: #ccc;}
.change_tabs .thistab,.change_tabs .thistab a:hover{background: #fff;border-bottom: 1px solid #fff;}
.tab_con {padding:12px;font-size: 14px; line-height:175%;}
.input_con{background-color:#FFFFCC;border:1px solid #999;font-size: 20px;padding:2px 8px 0pt 3px}


/*相册图片样式*/
#outer {
	width:100%;
	background:#ffffcc;
	margin:auto;
	text-align:left;
}
.inner {
	width:180px;
	height:120px;
	margin:5px; 
	text-align:center;
	border:2px solid #ccc;
	background: #c4c4c4;
	color: grey;
}
.inner:hover{
	border:#0066FF solid 2px;
}
* html .inner {display:inline}/* for ie*/
html>body #outer {display:table}/*for mozilla */
html>body .inner {display:table;float:left}/*for mozilla */
@media all and (min-width: 0px){/* opera 7 styles */
html>body .inner {display:inline-block;float:none;}

#title{
    background-color : #c4c4c4;
    color : black;
    text-align: right;
    /*控制标题栏的左内边距*/
    padding-left: 3px;
}
#close{
    margin-right: 10px;
    /*当鼠标移动到X上时，出现小手的效果*/
    cursor: pointer;
}

.clearfix{zoom:1;clear:both;}
.yqlj img{float:left; border:1px solid #ccc;margin:10px 10px 0 0;width:186px;height:156px;}
</style>
<link rel="stylesheet" href="/js/kindeditor/themes/default/default.css" />
<script type="text/javascript" src="/js/jquery/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="/js/jquery/jquery.blockUI.js"></script>
<script type="text/javascript" src="/js/basic.js"></script>	
<script charset="utf-8" src="/js/kindeditor/kindeditor-min.js"></script>
<script charset="utf-8" src="/js/kindeditor/lang/zh_CN.js"></script>
<script>
	var editor;
	var editor2;
	var editor_fee;
	var editor_tip;
	var editor_visa;
	KindEditor.ready(function(K) {
		editor = K.create('textarea[name="tour_feature"]', {
			resizeType : 1,
			allowPreviewEmoticons : false,
			allowImageUpload : false,
			items : [
				'source','fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
				'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
				'insertunorderedlist', '|', 'emoticons', 'image', 'link'],
			afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['editProForm'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['editProForm'].submit();
					});
				}
		});
		editor2 = K.create('textarea[name="tour_con"]', {
			resizeType : 1,
			allowPreviewEmoticons : false,
			allowImageUpload : false,
			items : [
				'source','fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
				'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
				'insertunorderedlist', '|', 'emoticons', 'image', 'link'],
			afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['editProForm'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['editProForm'].submit();
					});
				}
		});
		
		/** 费用说明 */
		editor_fee = K.create('textarea[name="tour_fee"]', {
			resizeType : 1,
			allowPreviewEmoticons : false,
			allowImageUpload : false,
			newlineTag : 'div',
			items : [
				'source','fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
				'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
				'insertunorderedlist', '|', 'emoticons', 'link'],
			afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['addProForm'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['addProForm'].submit();
					});
				}
		});
		
		/** 重要提示 */
		editor_tip = K.create('textarea[name="tour_tip"]', {
			resizeType : 1,
			allowPreviewEmoticons : false,
			allowImageUpload : false,
			newlineTag : 'div',
			items : [
				'source','fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
				'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
				'insertunorderedlist', '|', 'emoticons', 'link'],
			afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['addProForm'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['addProForm'].submit();
					});
				}
		});
		
		/** 签证说明 */
		editor_visa = K.create('textarea[name="tour_visa"]', {
			resizeType : 1,
			allowPreviewEmoticons : false,
			allowImageUpload : false,
			newlineTag : 'div',
			items : [
				'source','fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
				'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
				'insertunorderedlist', '|', 'emoticons', 'link'],
			afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['addProForm'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['addProForm'].submit();
					});
				}
		});
	});

</script>
</head>
<body>
<!-- 编辑产品第一步骤   -->
<div id="editSetpOne" style="display: none;font-size: 18px;font-family: arial;">
	  <div id="title" align="right" style="padding-right: 10px;"><span id="close" style="cursor:pointer" onclick="closeLayer()">X</span></div>
      <div style="width:800px;height:30px;margin-top: 10px;margin-left: 20px;background-color: #FFFFCC; border: 1px solid #999;text-align: left;padding-top: 8px;">
      	步骤一：选择产品分类
      </div> 
      <div class="yqlj" style="width:800px;height:490px;border: 1px solid #999;margin-top: 10px;background-color: #C4C4C4;margin-left: 20px;text-align: left;">
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
      				&nbsp;<!-- 包含的线路：<input type="button" value="删除" id="delTourPath"/> -->
      			</td>
      		</tr>
      		<tr height="300px;" align="center">
      			<td>
      				<div style="border:1px solid #333333;width:120px;height:46px;"> 
					<select name="ca_type_edit" id="ca_type_edit" size="2" style="margin:-2;width:120px;background:#eeeeee;font-size: 16px;">
								<option value="domestic">国内游</option>
								<option value="abroad">出境游</option>
					<!-- 
						<c:choose>
							<c:when test="${info.ca_type == 'domestic'}">
								<option value="domestic" selected="selected">国内游</option>
								<option value="abroad">出境游</option>
							</c:when>
							<c:otherwise>
								<option value="domestic">国内游</option>
								<option value="abroad" selected="selected">出境游</option>
							</c:otherwise>
						</c:choose>
						 -->
					</select>
					</div>
      			</td>
      			<td>
      				<div style="border:1px solid #333333;width:160px;height:310px;"> 
					<select name="parent_id_edit" id="parent_id_edit" size="15" style="margin:-2;width:160px;background:#eeeeee;font-size: 16px;"></select>
					</div>
      			</td>
      			<td>
      				 <div style="border:1px solid #333333;width:160px;height:310px;"> 
					<select name="ca_id_edit" id="ca_id_edit" size="15" style="margin:-2;width:160px;background:#eeeeee;font-size: 16px;"></select>
					</div>
      			</td>
      			<td><!-- 
      				<div style="border:1px solid #333333;width:160px;height:310px;"> 
					<select name="tour_path" id="tour_path" size="15" style="margin:-2;width:160px;background:#eeeeee;font-size: 16px;">
					</select>
					<input type="hidden" name="tours" id="tours"/>
					</div> -->
					&nbsp;
      			</td>
      		</tr>
      		<tr style="height:50px;" valign="bottom" align="right">
      			<td colspan="4" >
      				<input type="button" value="保存修改" id="nextBtn" onclick="return editProOne()" style="height: 45px;width:120px;"/>
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

<div id="tabbox">
	<form name="editProForm" id="editProForm" action="<c:url value="editProduct.htm"/>" method="post">
    <ul class="change_tabs" id="change_tabs">
       <li><a href="http://www.clipi.cn/js/nav/" tab="tab1">基本信息</a></li>
       <li><a href="http://www.clipi.cn/js/slide/" tab="tab2">路线标签</a></li>
       <li><a href="http://www.clipi.cn/js/gg/" tab="tab3">产品价格</a></li>
       <li><a href="http://www.clipi.cn/js/gg/" tab="tab4">页面设置</a></li>
    </ul>
    <ul class="tab_conbox">
        <li id="tab1" class="tab_con">
           <p>路线分类：<span id="pathCon">${info.parent_name} -> ${info.ca_name}</span>	<input type="button" id="editCategory" name="editCategory" value="修改分类"/>
           <input type="hidden" id="pro_id" name="pro_id" value="${info.pro_id}"/>
           <input type="hidden" id="ca_type" name="ca_type" value="${info.ca_type}"/>
           <input type="hidden" id="parent_id" name="parent_id" value="${info.parent_id}"/>
           <input type="hidden" id="parent_name" name="parent_name" value="${info.parent_name}"/>
           <input type="hidden" id="ca_id" name="ca_id" value="${info.ca_id}"/>
           <input type="hidden" id="ca_name" name="ca_name" value="${info.ca_name}"/>
           </p>
		    <p><span id="tourDaysCon">行程天数：<input type="text" size="6" id="tour_days" name="tour_days" value="${info.tour_days}"/> 天</span><span></span></p>
        	<p><span>标&nbsp;&nbsp;&nbsp;&nbsp;题：<input type="text" class="input_con" style="width:550px;height: 25px;" value="${info.tour_title}" id="tour_title" name="tour_title"/></span></p>
		    <p><div><span>线路图片：默认第一张为封面</span></div>
				<div id="outer"><input type="hidden" id="tour_images" name="tour_images" value=""/>
				  <div class="inner" id="img1"><img src="${info.tour_images[0]}" width="176px" height="116px" title="1"/></div>
				  <div class="inner" id="img2"><img src="${info.tour_images[1]}" width="176px" height="116px" title="1"/></div>
				  <div class="inner" id="img3"><img src="${info.tour_images[2]}" width="176px" height="116px" title="1"/></div>
				  <div class="inner" id="img4"><img src="${info.tour_images[3]}" width="176px" height="116px" title="1"/></div>
				  <br style="clear:both" /><input type="hidden" id="imgCatched" value=0 name="imgCatched"/>
				</div>
		    </p>
		    <div><span>出发地：<input type="text" value="${info.start_city}" class="input_con" style="width: 100px;height: 25px;" id="start_city" name="start_city"/></span></div>
		    <p><span>到达地：<input type="text" value="${info.end_city}" class="input_con" style="width: 100px;height: 25px;" id="end_city" name="end_city"/></span></p>
		    <p>
		    <span>发团日期：<a href="javascript:void(0)" id="showEditDates" style="color: blue;text-decoration: underline;">修改发团日期/价格</a>
		    <div id="editDatesHtml">&nbsp;
		    				<c:set var="str" value="${fn:split(info.start_dates[0],'|')}" />
							<c:if test="${str[0]=='1'}">
								<c:set var="adult" value="${fn:replace(str[1],'{','')}" />
								<c:set var="child" value="${fn:replace(str[2],'}','')}" />
								天天发团:&nbsp;&nbsp;成人价格:${adult}&nbsp;&nbsp;儿童价格:${child}
							</c:if>
							<c:if test="${str[0]=='2'}">
								<c:set var="adult" value="${fn:replace(str[1],'{','')}" />
								每周:
								<c:forEach var="starts" items="${info.start_dates}" varStatus="status">
									<c:if test="${status.index==0 }">
										<c:set var="oneDayLength" value="${fn:length(starts)}" />
										<c:set var="oneDay" value="${fn:substring(starts,oneDayLength-1,oneDayLength)}" />
										${oneDay }
									</c:if>
									<c:if test="${status.index>0 }">
										,
										<c:choose>
										    <c:when test="${fn:indexOf(starts,'}')>0}">
										     	<c:set var="lastDay" value="${fn:replace(starts,'}','')}" />
												${lastDay }
										    </c:when>
										    <c:otherwise>
										     ${starts }
										    </c:otherwise>
									   </c:choose> 
									</c:if>
								</c:forEach>
								发团&nbsp;&nbsp;成人价格:¥${adult}&nbsp;&nbsp;儿童价格:¥${str[2]}
							</c:if>
							
							<c:if test="${str[0]=='3'}">
								指定日期发团:
								<c:forEach var="item" items="${info.start_dates}" varStatus="status">
									<c:if test="${fn:indexOf(item,'{')>0}">
										<c:set var="firstItem" value="${fn:replace(item,'3|{','')}" />
										<c:set var="prices" value="${fn:split(firstItem,'|')}" />
										<div>(${prices[0]} 成人价格:${prices[1]}&nbsp;&nbsp;儿童价格:${prices[2]})</div>
									</c:if>
									<c:if test="${fn:indexOf(item,'{')<0}">
									<c:set var="forprices" value="${fn:split(item,'|')}" />
									<div>(${forprices[0]} 成人价格:${forprices[1]}&nbsp;&nbsp;儿童价格:${forprices[2]})</div>
									</c:if>
								</c:forEach>
							</c:if>
							
		    </div>
		    
		    <input type="hidden" name="start_dates" id="start_dates" value="${info.start_dates}"/>
		    </span></p>
		    <p><span style="font-size: 20px;color: red">行程特色：<textarea name="tour_feature" id="tour_feature" style="width:790px;height:200px;visibility:hidden;">${info.tour_feature}</textarea></span></p>
		    <p><span style="font-size: 20px;color: red">行程安排：<textarea name="tour_con" id="tour_con" style="width:790px;height:200px;visibility:hidden;">${info.tour_con}</textarea></span></p>
		    <p><span style="font-size: 20px;color: red">费用说明：<textarea id="tour_fee" name="tour_fee" style="width:790px;height:200px;visibility:hidden;">${info.tour_fee}</textarea></span></p>
		    <p><span style="font-size: 20px;color: red">重要提示：<textarea id="tour_tip" name="tour_tip" style="width:790px;height:200px;visibility:hidden;">${info.tour_tip}</textarea></span></p>
		    <p><span style="font-size: 20px;color: red">签证说明：<textarea id="tour_visa" name="tour_visa" style="width:790px;height:200px;visibility:hidden;">${info.tour_visa}</textarea></span></p>
        </li>
<script type="text/javascript">

</script>

        <li id="tab2" class="tab_con">
        	<p><span>往返交通：
            				选择交通类型：
            				<select id="vehicle" name="vehicle">
            				<c:choose>
								<c:when test="${info.vehicle == '直飞往返'}">
									<option value="直飞往返" selected="selected">直飞往返</option>
								</c:when>
								<c:otherwise>
									<option value="直飞往返">直飞往返</option>
								</c:otherwise>
							</c:choose>
            				<c:choose>
								<c:when test="${info.vehicle == '动车往返'}">
									<option value="动车往返" selected="selected">动车往返</option>
								</c:when>
								<c:otherwise>
									<option value="动车往返">动车往返</option>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${info.vehicle == '大巴往返'}">
									<option value="大巴往返" selected="selected">大巴往返</option>
								</c:when>
								<c:otherwise>
									<option value="大巴往返">大巴往返</option>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${info.vehicle == '普通火车'}">
									<option value="普通火车" selected="selected">普通火车</option>
								</c:when>
								<c:otherwise>
									<option value="普通火车">普通火车</option>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${info.vehicle == '双卧火车'}">
									<option value="双卧火车" selected="selected">双卧火车</option>
								</c:when>
								<c:otherwise>
									<option value="双卧火车">双卧火车</option>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${info.vehicle == '车机搭配'}">
									<option value="双卧火车" selected="selected">车机搭配</option>
								</c:when>
								<c:otherwise>
									<option value="双卧火车">车机搭配</option>
								</c:otherwise>
							</c:choose>
            				</select></span>
            				</p>
            <p><span>路线主题：
            				选择主题标签：
            				<select id="topicID" name="topicID" size="10" onchange="selectTopicTag()">
            				<option value="guonei">国内游</option>
            				<option value="zhoubian">周边游</option>
            				<option value="chujing">出境游</option>
            				<option value="haidao">海岛游</option>
            				<option value="ziyou">自由行</option>
            				<option value="miyue">蜜月游</option>
            				<option value="qinzi">亲子游</option>
            				<option value="xiyanghong">夕阳红</option>
            				<option value="youlun">邮轮</option>
            				</select>
            				已添加的标签
            				<textarea id="topic_tag" name="topic_tag" cols="20" rows="10" onblur="javascript:this.value=this.value.replace(/，/ig,',');">${topic_tag }</textarea></span></p>
            <p><span>特色标签：
            				选择游玩特色：
            				<select id="featureID" name="featureID" size="10" onchange="selectFeatureTag()">
            				<option value="国航直飞">国航直飞</option>
            				<option value="特价优惠">特价优惠</option>
            				<option value="青旅成团">青旅成团</option>
            				<option value="五星酒店">五星酒店</option>
            				<option value="白天航班">白天航班</option>
            				<option value="一价全含">一价全含</option>
            				<option value="无自费">无自费</option>
            				<option value="独立成团">独立成团</option>
            				</select>
            				已添加的标签
            				<textarea id="feature_tag" name="feature_tag" cols="20" rows="10" onblur="javascript:this.value=this.value.replace(/，/ig,',');">${feature_tag }</textarea>
            				</span></p>
            				
            <p><span>景点包含：
            				填写旅游景点：
            				<textarea id="views_tag" name="views_tag" cols="60" rows="10" onblur="javascript:this.value=this.value.replace(/，/ig,',');">${search_tag }</textarea></span></p>
            				
        </li>
    
        <li id="tab3" class="tab_con">
            <p>
				<div>
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
						<tbody>
							<tr style="line-height: 35px;" valign="middle">
								<td align="right">会员价格:<input type="hidden" class="input_con" id="member_price" name="member_price" value="${info.member_price}"/></td>
								<td id="member_priceHTML" style="font-size: 22px;font-weight: bold;color: orange;font-family: 微软雅黑;">${info.member_price}元起</td>
							</tr>
							<tr style="line-height: 35px;" valign="middle">
								<td align="right">市场价格:</td>
								<td><input type="text" class="input_con" id="market_price" name="market_price" value="${info.market_price}"/></td>
							</tr>
							<tr style="line-height: 35px;" valign="middle">
								<td align="right">优惠标签:</td>
								<td>
									<select id="discount_tag" name="discount_tag">
            							<option value="网购返现">网购返现</option>
            						</select>
								</td>
							</tr>
							<tr style="line-height: 35px;" valign="middle">
								<td align="right">支付方式:</td>
								<td>
									<select id="pay_form" name="pay_form">
            							<option value="现金支付">现金支付</option>
            							<option value="网银汇款">网银汇款</option>
            						</select>
								</td>
							</tr>
							<tr style="line-height: 35px;" valign="middle">
								<td align="right">促销标题:</td>
								<td><input type="text" style="width:400px;color: #ff3333;" value="${info.sale_title}" id="sale_title" name="sale_title" class="input_con"/></td>
							</tr>
							<tr style="height: 80px;" valign="middle" align="center">
								<td colspan="2">&nbsp;
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</p>
        </li>
    
        <li id="tab4" class="tab_con">
            <p>
				<div>
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
						<tbody>
							<tr style="line-height: 35px;" valign="middle">
								<td align="right">页面标题:</td>
								<td>
									<input style="width:400px;font-size: 22px;font-family: 微软雅黑;" type="text" class="input_con" id="page_title" name="page_title" value="${info.page_title}"/>
								</td>
							</tr>
							<tr style="line-height: 35px;" valign="middle">
								<td align="right">关键字:</td>
								<td><input type="text" style="width:400px;color: #ff3333;" class="input_con" id="page_keyword" name="page_keyword" value="${info.page_keyword}"/></td>
							</tr>
							<tr style="line-height: 35px;" valign="middle">
								<td align="right">描述:</td> 
								<td>
									<textarea id="page_descript" name="page_descript" cols="60" rows="10">${info.page_descript}</textarea>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</p>
        </li>
    </ul>
    <ul>
    <li style="text-align: center;">
    <input style="width: 150px;height: 40px;font-size: 20px;" onclick="return checkPubPro('review')"  type="button" id="reviewTourPath" name="sumbit" value="保存发布"/>
    &nbsp;&nbsp;<!-- <input onclick="return checkPubPro('pub')" id="pubTourPath" style="width: 150px;height: 40px;font-size: 20px;" type="button" value="一键发布"/> -->
    &nbsp;&nbsp;<input style="width: 150px;height: 40px;font-size: 20px;" onclick="window.location.href='products.htm'" type="button" value="返回列表" name="goBack"/></li>
    </ul>
	</form>
</div>

<div id="con">&nbsp;</div>

<!-- 选择路线图片 -->
<div id="selectImgDiv" style="display: none;height:630px;font-size: 18px;font-family: arial;">
<div id="title" align="right" style="padding-right: 10px;"><span id="close" style="cursor:pointer" onclick="closeLayer()">X</span></div>
      <div style="width:800px;height:30px;margin-top: 10px;margin-left: 20px;background-color: #FFFFCC; border: 1px solid #999;text-align: left;">
      	选择类型：<select id="album_type" name="album_type" onchange="changeAlbumType()" style="width: 150px;font-size: 14px;">
      							<option value="all">所有图片</option>
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
      	</select>&nbsp;&nbsp;&nbsp;&nbsp;
      	选择相册：<select name="albumList" id="albumList" onchange="changeAlbum()" style="width: 150px;font-size: 14px;"></select>
      </div> 
      <div class="yqlj" style="width:800px;height:505px;border: 1px solid #999;margin-top: 10px;margin-left: 20px;text-align: left;">
      	<div class="clearfix chooseImg" id="imagesDiv"></div>
      </div>
       <div id="albumPage" style="width:800px;height:30px;margin-top: 10px;margin-left: 20px;padding-right: 20px;text-align: right;">
       <input type="hidden" name="totalPage" id="totalPage"/>
      	<a href="javascript:void(0)" onclick="showAlbumListPage('pre');" style="color: blue;text-decoration: underline;">上一页</a>&nbsp;&nbsp;
      	<a href="javascript:void(0)" onclick="showAlbumListPage('next');" style="color: blue;text-decoration: underline;">下一页</a>
      </div>     		       
</div>
<!-- 选择路线图片 end-->

<!-- 填写发团日期框 -->
<div id="editDatesDiv" style="display: none;font-size: 18px;font-family: arial;">
      
       		<div style="margin-top: 20px;">
       			<a href="javascript:void(0)" onclick="showStartDiv('every')" style="font-size: 22px;color:blue; background-color: #66cdaa">天天发团</a>&nbsp;&nbsp;
       			<a href="javascript:void(0)" onclick="showStartDiv('regular')" style="font-size: 22px;color:blue; background-color: #66cdaa">固定发团</a>&nbsp;&nbsp;
       			<a href="javascript:void(0)" onclick="showStartDiv('custom')" style="font-size: 22px;color:blue; background-color: #66cdaa">指定发团</a>
       		</div>
       		 <form name="selectPubDate" action="few.htm" method="post">
       		<div style="width: 540px;height: 380px;">
       		
       			<div style="line-height:25px;padding-left: 25px;" align="left">
	       			<span style="font-family: arial;color: #333;" id="dateFont">天天发团</span>
	       			<hr style="border:1px dashed #ccc;width: 97%" />
	       		</div>
       			<div style="line-height: 40px;" align="center">
	       			成人价格: <input type="text" class="input_con" style="width: 100px;height: 25px; color: #ff3333;font-weight:bold;" id="adult_price" name="adult_price"/>
	       			<span style="color:grey;font-size:12px;">请填写数字</span>
	       			<br/>
	       			儿童价格: <input type="text" class="input_con" style="width: 100px;height: 25px; color: #ff3333;font-weight:bold;" id="child_price" name="child_price"/>
	       			<span style="color:grey;font-size:12px;">请填写数字</span>
	       		</div>
	       		
	       		<div id="regularDiv" style="display:none;line-height:25px;padding-left: 25px;" align="left">
		       			<a href="javascript:void(0)" style="color: #666;">选择固定日期:</a>
		       			<div style="color: blue;">
		       			 	周一<input type="checkbox" name="week" value="1"/>&nbsp;&nbsp;
	       					周二<input type="checkbox" name="week" value="2"/>&nbsp;&nbsp;
	       					周三<input type="checkbox" name="week" value="3"/>&nbsp;&nbsp;&nbsp;&nbsp;
	       					周四<input type="checkbox" name="week" value="4"/>&nbsp;&nbsp;
	       					周五<input type="checkbox" name="week" value="5"/>&nbsp;&nbsp;
	       					周六<input type="checkbox" name="week" value="6"/>&nbsp;&nbsp;
	       					周日<input type="checkbox" name="week" value="7"/>
	       					</div>
		       	</div>
	       		<div id="customDiv" style="display:none;padding-left: 35px;">
		       		<table border="0" cellpadding="0" cellspacing="0">
		       		<tbody>
		       			<tr style="height: 40px;">
		       				<td align="right">
		       				选择日期:
		       				</td>
		       				<td align="left">
		       				<input class="Wdate" id="datePicker" type="text" onClick="WdatePicker({onpicking:function(dp){addDatePrice(dp.cal.getNewDateStr());}})"/>
		       				</td>
		       			</tr>
		       			<tr style="height: 40px;">
		       				<td align="right">
		       					日期/价钱:
		       				</td>
		       				<td align="left">
		       					<select id="addDateList" name="addDateList" style="width: 300px;" size="12"></select>
		       				</td>
		       			</tr>
		       		</tbody>
		       		</table>
		       		
		       		<!-- 
		       		记录发团类型：天天发，固定发，指定日期发
		       		记录发团日期：数组
		       		
		       		 -->
       			</div>
       	</div>
       		<div>
       			<input type="button" onclick="submitStartDates()" style="width: 200px; height:45px;font-size: 25px;font-family: 微软雅黑;font-weight: bold;" id="editDatesBtn" name="editDatesBtn" value="保存"/>
       			&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" onclick="closeLayer()" style="color: blue">关闭窗口</a>
       		</div>
       	</form>
       
</div>
<!-- 填写发团日期框 end-->

<script type="text/javascript">
var startType = 1;
function showStartDiv(showId){
	$("#everyDiv").hide();
	$("#regularDiv").hide();
	$("#customDiv").hide();
	if(showId=='every'){
		$("#dateFont").text('天天发团');
		$("#everyDiv").show();
		startType = 1;
	}else if(showId=='regular'){
		$("#dateFont").text('固定发团');
		$("#regularDiv").show();
		startType = 2;
	}else {
		$("#dateFont").text('指定发团');
		$("#customDiv").show();
		startType = 3;
	}
	
}


/**
 * 提交保存到一个hidden里   格式为: 1|{}
 * 如果是天天发的 记录数据为:1|{100|50}
 * 固定格式的：2|{100|50|1,3,5,7}
 * 指定格式的：3|{2014-7-2|100|50,2014-7-3|120|60,2014-7-5|100|50}
 */
function submitStartDates(){
	var adult_price = 0;
	var child_price = 0;
	var temp = '';
	var html = '';
 	if(startType==1){
 		adult_price = $("#adult_price").val();
 		child_price = $("#child_price").val();
 		temp = '1|{'+ adult_price +'|' + child_price + '}';
 		html = '天天发团&nbsp;&nbsp;成人价格：'+adult_price+"&nbsp;&nbsp;儿童价格:"+child_price;
 	}else if(startType==2){
 		adult_price = $("#adult_price").val();
 		child_price = $("#child_price").val();
		var s='';
		$('input[name="week"]:checked').each(function(){ 
		  s+=$(this).val()+',';
		});
		if(s.length>0){
			 s = s.substring(0,s.length - 1);
		}
		temp = '2|{'+ adult_price +'|' + child_price + '|'+s+'}';
		html = '每周'+s+'发团&nbsp;&nbsp;成人价格：'+ adult_price +"&nbsp;&nbsp;儿童价格:"+child_price;
 	}else{
 		var count = $("#addDateList").get(0).options.length;
 		var str = '';
 	    for(var i=0;i<count;i++){
 	    	var str_value = $("#addDateList").get(0).options[i].value;
 	    	str += str_value + ',';
			str_value=str_value.substring(str_value.indexOf('|')+1,str_value.length);
			str_value=str_value.substring(0,str_value.indexOf('|'));
			if(adult_price==0||(parseInt(str_value)<parseInt(adult_price))){
				adult_price=str_value;
			}
			
 	    	html+= '<div>'+$("#addDateList").get(0).options[i].text+'</div>';
 	    	
 	    }
 	    if(str.length>0){
 	    	str = str.substring(0,str.length - 1);
		}
 	    temp = '3|{'+str+'}';
 	}
 	
 	
 	$("#member_priceHTML").html(adult_price+"元起");
 	$("#start_dates").val(temp);
 	$("#market_price").val(parseInt(adult_price)+150);
 	$("#member_price").val(adult_price);
 	$("#editDatesHtml").html('');
 	$("#editDatesHtml").html("&nbsp;"+html);
 	
 	closeLayer();
}

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
    $.jqtab("#change_tabs",".tab_con");
    
});
function checkPubPro(type){
	
	$("#tour_feature").val(editor.html());
	$("#tour_con").val(editor2.html());
	$("#tour_fee").val(editor_fee.html());
	$("#tour_tip").val(editor_tip.html());
	$("#tour_visa").val(editor_visa.html());
	//验证tab1信息和封装
	if(!checkTab1()||!checkTab2()||!checkTab3()||!checkTab4()){
		return false;
	}
	$("#pubTourPath").attr("disabled",true);
	$("#reviewTourPath").attr("disabled",true);
	$("#editProForm").submit();
	return true;
}

function checkTab1(){
	//验证产品标题pro_title
	if(!checkEmpty($("#tour_title").val())){
		alert("标题不能为空!");
		$("#tour_title").focus();
		return false;
	}
	//验证产品图片img1,img2,img3,img4
	var img1Src = $("#img1 img").attr("src");
	var img2Src = $("#img2 img").attr("src");
	var img3Src = $("#img3 img").attr("src");
	var img4Src = $("#img4 img").attr("src");
	if(img1Src.indexOf("bg.jpg")>0){
		alert("第一张产品图没有添加图片");
		$("#tour_title").focus();
		return false;
	}
	if(img2Src.indexOf("bg.jpg")>0){
		alert("第二张产品图没有添加图片");
		$("#tour_title").focus();
		return false;
	}
	if(img3Src.indexOf("bg.jpg")>0){
		alert("第三张产品图没有添加图片");
		$("#tour_title").focus();
		return false;
	}
	if(img4Src.indexOf("bg.jpg")>0){
		alert("第四张产品图没有添加图片");
		$("#tour_title").focus();
		return false;
	}
	$("#tour_images").val(img1Src+','+img2Src+","+img3Src+","+img4Src);
	//alert($("#tour_images").val());
	//验证出发地，目的地 
	if(!checkEmpty($("#start_city").val())){
		alert("出发地不能为空!");
		$("#start_city").focus();
		return false;
	}
	if(!checkEmpty($("#end_city").val())){
		alert("目的地不能为空!");
		$("#end_city").focus();
		return false;
	}
	//验证发团日期：startDates
	if(!checkEmpty($("#start_dates").val())){
		alert("发团日期不能为空!");
		$("#start_dates").focus();
		return false;
	}
	//验证推荐理由
	if(!checkEmpty($("#tour_feature").val())){
		alert("行程特色不能为空!");
		$("#tour_feature").focus();
		return false;
	}
	//验证行程安排
	if(!checkEmpty($("#tour_con").val())){
		alert("行程安排不能为空!");
		$("#tour_con").focus();
		return false;
	}
	//验证重要提示
	if(!checkEmpty($("#tour_tip").val())){
		alert("重要提示不能为空!");
		$("#tour_tip").focus();
		return false;
	}
	//如果选择是出境游，验证签证说明
	var pro_type = $("#pro_type").val();
	if(pro_type=="aboard"){
		if(!checkEmpty($("#tour_visa").val())){
			alert("签证说明不能为空!");
			$("#tour_visa").focus();
			return false;
		}
	}
	return true;
}
function checkTab2(){
	//验证产品标题pro_title
	if(!checkEmpty($("#topic_tag").val())){
		alert("路线标签->主题标签不能为空!");
		//$("#pro_title").focus();
		return false;
	}
	
	if(!checkEmpty($("#feature_tag").val())){
		alert("路线标签->特色标签不能为空!");
		//$("#pro_title").focus();
		return false;
	}
	
	if(!checkEmpty($("#views_tag").val())){
		alert("路线标签->旅游景点不能为空!");
		//$("#pro_title").focus();
		return false;
	}
	return true;
}

function checkTab3(){
	//验证产品标题pro_title
	if(!checkEmpty($("#market_price").val())){
		alert("产品价格->市场价不能为空!");
		//$("#pro_title").focus();
		return false;
	}
	
	if(!checkEmpty($("#sale_title").val())){
		alert("产品价格->促销标题不能为空!");
		//$("#pro_title").focus();
		return false;
	}
	return true;
}

function checkTab4(){
	//验证产品标题pro_title
	if(!checkEmpty($("#page_title").val())){
		alert("页面设置->页面标题不能为空!");
		//$("#pro_title").focus();
		return false;
	}
	
	if(!checkEmpty($("#page_keyword").val())){
		alert("页面设置->页面关键字不能为空!");
		//$("#pro_title").focus();
		return false;
	}
	
	if(!checkEmpty($("#page_descript").val())){
		alert("页面设置->页面描述不能为空!");
		//$("#pro_title").focus();
		return false;
	}
	return true;
}

$('#showEditDates').on('click', function(){
	 $.blockUI({ message: $('#editDatesDiv'),
		 css: {
			 top:		'20px',
			 left:		'30%',
			 height:	'500px',
			 width:		'40%',
			 textAlign:	'center',
			 border:	'3px solid #ccc'
		 }
	 });
	 
});

function checkNum(num){
	if(!$.isNumeric(num.value)){
		alert("请输入数字");
		num.value = "";
		num.focus();
		return false;
	}
}

function selectTopicTag(){
	
	var selected = jQuery("#topicID  option:selected").text();
	//alert($("#topic_tag").val().indexOf(selected));
	if($("#topic_tag").val().indexOf(selected)>-1){
		alert("该标签已经添加了");
		return false;
	}
	if($("#topic_tag").val().length>0){
		selected = $("#topic_tag").val()+","+selected;
	}
	$("#topic_tag").val(selected);
}
function selectFeatureTag(){
	
	var selected = jQuery("#featureID  option:selected").text();
	//alert($("#topic_tag").val().indexOf(selected));
	if($("#feature_tag").val().indexOf(selected)>-1){
		alert("该标签已经添加了");
		return false;
	}
	if($("#feature_tag").val().length>0){
		selected = $("#feature_tag").val()+","+selected;
	}
	$("#feature_tag").val(selected);
}

/**
 * 把相应的select的列表div显示
 * 把相应的select列表选择为对应的值
 * 根据ca_type选择相应的值
 * 
 */
 $('#editCategory').on('click', function(){
	 $.blockUI({ message: $('#editSetpOne'),
		 css: {
			 top:		'20px',
			 width:		'840px',
			 height:	'580px',
			 left:		'18%',
			 textAlign:	'center',
			 border:	'3px solid #ccc'
		 }
	});
	 
});

/**
 * 添加方法 
 * (2014-7-2 成人:200 儿童:90)
 **/
function addDatePrice(str){
	var adult_price = $("#adult_price").val();
	var child_price = $("#child_price").val();
	if(!$.isNumeric(adult_price)||!$.isNumeric(child_price)){
		alert("请输入正确的价格");
		$("#adult_price").focus();
		return false;
	}
	var options_value = str + "|"+adult_price+"|"+child_price;
	var options_text = "(" + str + " 成人:" + adult_price + " 儿童:"+child_price+")";
	var options = "<option value='"+ options_value +"'>" + options_text +"</option>"
	//$("#addDateList").get(0).options.add(new Option(options_text,options_value));
	$("#addDateList").html(options + $("#addDateList").html());
}
function closeLayer(){
	$.unblockUI();
}

</script>
<script type="text/javascript" src="/js/adminJS/product.js"></script>
<script type="text/javascript" src="/js/adminJS/category_e.js"></script>
<script language="javascript" type="text/javascript" src="/js/date_picker/WdatePicker.js"></script>
</body>
</html>