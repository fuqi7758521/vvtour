<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
body,ul,li{margin: 0;padding: 0;font: 12px normal "宋体", Arial, Helvetica, sans-serif;list-style: none;}
/*------------分页------------*/
.page{padding:24px 0;height:36px;line-height:34px;font-size:14px;text-align:right}
.page a{display:inline-block;border:#e2e2e2 1px solid;padding:0 16px;height:36px}
.page a:hover,.page a.on{background:#248cff;color:#fff;border:#cde6ff 1px solid; text-decoration:none}
.page span{display:inline-block;padding:0 16px}

</style>
<script type="text/javascript" src="/js/jquery/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="/js/jquery/jquery.blockUI.js"></script>
<script type="text/javascript" src="/js/basic.js"></script>
<title>添加旅游路线</title>
<script type="text/javascript">
Date.prototype.format=function(fmt) {        
    var o = {        
    "M+" : this.getMonth()+1, //月份        
    "d+" : this.getDate(), //日        
    "h+" : this.getHours()%12 == 0 ? 12 : this.getHours()%12, //小时        
    "H+" : this.getHours(), //小时        
    "m+" : this.getMinutes(), //分        
    "s+" : this.getSeconds(), //秒        
    "q+" : Math.floor((this.getMonth()+3)/3), //季度        
    "S" : this.getMilliseconds() //毫秒        
    };        
    var week = {        
    "0" : "\u65e5",        
    "1" : "\u4e00",        
    "2" : "\u4e8c",        
    "3" : "\u4e09",        
    "4" : "\u56db",        
    "5" : "\u4e94",        
    "6" : "\u516d"       
    };        
    if(/(y+)/.test(fmt)){        
        fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));        
    }        
    if(/(E+)/.test(fmt)){        
        fmt=fmt.replace(RegExp.$1, ((RegExp.$1.length>1) ? (RegExp.$1.length>2 ? "\u661f\u671f" : "\u5468") : "")+week[this.getDay()+""]);        
    }        
    for(var k in o){        
        if(new RegExp("("+ k +")").test(fmt)){        
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));        
        }        
    }        
    return fmt;        
};
function showDatesFromLong(id,fmt){
	var t=fmt;
	var d=	new Date();
	d.setTime(t);
	var s=d.format('MM-dd HH:mm:ss');
	$("#"+id).text(s);
}

/* function EnterPress(e){ //传入 event 
	var e = e || window.event; 
	if(e.keyCode == 13){
		alert(2);
		$("#searchForm").submit(function(){  
			return false;
		});
		return false;
		//$("#searchForm").submit();
		//return true;
	}
} */

function delPro(id){
	if(!checkEmpty(id)){
		alert('不能为空');
		return false;
	}
	//toAction("/admin/delProduct.htm?pro_id="+id+"&redirect_url="+window.location.href);
}
function generateList(){
	var openUrl = window.location.href;
	var openParams = '';
	if(openUrl.indexOf('?')>0){
		openParams ='&generate=all';
	}else{
		openParams ='?generate=all';
	}
	window.open(window.location.href+openParams);
}
</script>
</head>
<body>
<div align="center">
	<div style="width: 822px;margin-top: 20px;line-height: 30px;" align="left" >
	<div style="float: left;width: 120px;display:inline;">
      <input id="toPubProduct" type="button" style="height: 25px;width: 120px;" value="发布产品"/>
      </div>
      <div style="width: 450px;display:inline;padding-left: 170px;">
      搜索路线：<input id="searchCon" name="searchCon" type="text" style="width: 400px;height: 30px;font-size: 28px;color: #c4c4c4;" onkeydown="enterSearch('/admin/searchPro.htm')" value="可以输入路线编号、目的地名称" onFocus="if(this.value=='可以输入路线编号、目的地名称'){this.value=''}" onblur="if(this.value==''){this.value='可以输入路线编号、目的地名称'}"/>
      </div>
    </div>
   
    <div>&nbsp;</div>
    <div>
      <table cellpadding="0" cellspacing="0" border="1" bordercolor="#c4c4c4" width="1100px">
      	<tbody>
      	<tr style="line-height: 25px;font-size: 14px;" align="center">
      		<td><a href="javascript:void(0)" onclick="checkAll(this)">复制地址</a></td>
      		<td>编号</td>
      		<td align="center" width="620px;">标题 &nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void" onclick="generateList()">生成当前页面所有路线</a></td>
      		<td width="70px;">一级分类</td>
      		<td width="70px;">二级分类</td>
      		<td width="70px;">状态</td>
      		<td>编辑</td>
      	</tr>
      	<c:forEach var="item" items="${proList}" varStatus="status">
      	<tr style="line-height: 30px;" align="center" onmouseover="this.style.backgroundColor='#ccc'" onmouseout="this.style.backgroundColor='#ffffff'">
      		<td><input type="hidden" name="pro_id" value="${item.pro_id }"/><input type="button" size="6" onclick="copyImgUrl('${item.link_url}${item.pro_id}.html')" value="复制"/></td>
      		<td>${item.pro_id }</td>
      		<td align="left" style="padding-left: 10px;"><a href="/admin/viewProduct.htm?pro_id=${item.pro_id}" target="_blank">${item.tour_title }</a></td>
      		<td>${item.parent_name }</td>
      		<td>${item.ca_name }</td>
      		<td id="status_${item.pro_id }">
      		<c:if test="${item.status==0 }"><font color="grey">未生成</font></c:if>
      		<c:if test="${item.status==1 }"><font color="green">已生成</font></c:if>
      		</td>
      		<!-- <td id="dates${status.index}"><script type="text/javascript">showDatesFromLong('dates${status.index}','${item.pub_time}');</script></td> -->
      		<td><a href="javascript:void(0)" onclick="viewHTML('${item.pro_id }','${item.status}','${item.link_url}${item.pro_id}.html')">预览页面</a>&nbsp;&nbsp;
      		|&nbsp;&nbsp;<a href="javascript:void(0)" onclick="generateHTML('${item.pro_id }');">更新页面</a>&nbsp;&nbsp;
      		|&nbsp;&nbsp;<a href="toEditProduct.htm?pro_id=${item.pro_id }">编辑</a>&nbsp;&nbsp;
      		|&nbsp;&nbsp;<a href="javascript:void(0)" onclick="delPro('${item.pro_id }')">删除</a></td>
      	</tr>
      	</c:forEach>
      	</tbody>
      </table>
      <!--分页 start{-->
      <div class="page" style="width: 820px;">
	       <c:if test="${totalCount > pageSize}">
					<a href="/admin/products.htm">首页</a>
					<c:if test="${currentPage > 1}">
						<a href='/admin/products.htm?p=${currentPage-1}<c:if test="${!empty pid} ">&pid=${pid}</c:if><c:if test="${!empty cid} ">&cid=${cid}</c:if>'>上一页</a>
					</c:if>
					<c:forEach begin="0" end="${totalPage-1}" step="1" varStatus="p">
						<c:choose>
							<c:when test="${p.index+1 == currentPage}">
								<a href="javascript:void(0)" class="on">${currentPage}</a>
							</c:when>
							<c:otherwise>
								<a href='/admin/products.htm?p=${p.index+1 }<c:if test="${!empty pid} ">&pid=${pid}</c:if><c:if test="${!empty cid} ">&cid=${cid}</c:if>'>${p.index+1 }</a>
							</c:otherwise>
						</c:choose>
						
					</c:forEach>
					<c:if test="${totalPage > currentPage}">
						<a href='/admin/products.htm?p=${currentPage+1}<c:if test="${!empty pid} ">&pid=${pid}</c:if><c:if test="${!empty cid} ">&cid=${cid}</c:if>'>下一页</a>
					</c:if>
		    </c:if>
      </div>
      <!--}分页 end-->
    </div>
</div>

<!-- 发布产品第一步骤   -->
<div id="pubSetpOne" style="display: none;font-size: 18px;font-family: arial;">
	  <div id="title" align="right" style="padding-right: 10px;"><span id="close" style="cursor:pointer" onclick="closeLayer()">X</span></div>
      <div style="width:800px;height:30px;margin-top: 10px;margin-left: 20px;background-color: #FFFFCC; border: 1px solid #999;text-align: left;padding-top: 8px;">
      	步骤一：选择产品分类
      </div> 
      <div class="yqlj" style="width:800px;height:490px;border: 1px solid #999;margin-top: 10px;background-color: #C4C4C4;margin-left: 20px;text-align: left;">
      	<div style="padding-left: 10px;margin-top: 10px;font-size: 14px;float: left;">
      	<form name="pubProForm" id="pubProForm" action="<c:url value="toAddProduct2.htm"/>" method="post">
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
					<select name="ca_type" id="ca_type" size="2" style="margin:-2;width:120px;background:#eeeeee;font-size: 16px;">
						<option value="domestic">国内游</option>
						<option value="abroad">出境游</option>
					</select>
					</div>
      			</td>
      			<td>
      				<div style="border:1px solid #333333;width:160px;height:310px;"> 
					<select name="parent_id" id="parent_id" size="15" style="margin:-2;width:160px;background:#eeeeee;font-size: 16px;"></select>
					<input type="hidden" name="parent_name" id="parent_name"/>
					</div>
      			</td>
      			<td>
      				 <div style="border:1px solid #333333;width:160px;height:310px;"> 
					<select name="ca_id" id="ca_id" size="15" style="margin:-2;width:160px;background:#eeeeee;font-size: 16px;"></select>
					<input type="hidden" name="ca_name" id="ca_name"/>
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
      		<tr style="height:80px;" valign="bottom" align="left">
      			<td colspan="3" valign="middle">&nbsp;&nbsp;&nbsp;&nbsp;
      				出发城市：<input type="text" size="8" style="height: 30px;font-size: 28px;" name="start_city" id="start_city"/>
      				&nbsp;&nbsp;&nbsp;&nbsp;
      				到达城市：<input type="text" size="8" style="height: 30px;font-size: 28px;" name="end_city" id="end_city"/>
      			</td>
      			<td align="center" valign="middle">
      				行程天数：<input type="text" size="6" style="height: 30px;font-size: 28px;width: 40px;" name="tour_days" id="tour_days"/>&nbsp;&nbsp;天
      			</td>
      		</tr>
      		
      		<tr style="height:50px;" valign="bottom" align="right">
      			<td colspan="4" >
      				<input type="button" value="下一步" id="nextBtn" onclick="return pubProOne()" style="height: 45px;width:120px;"/>
      			</td>
      		</tr>
      		
      	</table>
      	</form>
      	</div>

	  </div> 
       <div style="width:800px;height:30px;margin-top: 10px;margin-left: 20px;padding-right: 20px;text-align: right;">
      &nbsp;&nbsp;
      </div>     		       
</div>
<!-- 发布产品第一步骤end  -->
<script type="text/javascript">
$('#toPubProduct').on('click', function(){
	
	$.blockUI({ message: $('#pubSetpOne'),
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



function pubProOne(){
	if(!checkProOne()){
		return false;
	}
/* 	alert($("#ca_name").val());
	return false; */
	$("#nextBtn").attr("disabled",true);
	$("#pubProForm").submit();
	return true;
}

//进入下一步
$('#goStepTwo').on('click', function(){
	
	
	var url = "toAddProduct2.htm";
	var params = {'ca_type':ca_type,
			'parent_id':parent_id,
			'parent_name':parent_name,
			'ca_id':ca_id,
			'ca_name':ca_name,
			'tour_path':options,
			'tour_days':tour_days,
			'start_city':start_city,
			'end_city':end_city};
	jQuery.post(
	  		url,
	  		params,
	  		function(data,status){		//data msg的消息 status：状态
	  			var temp = data.split('|');
	  			if(temp[0]==0||temp[0]==-1){
	  				alert(temp[1]);
	  				$("#path_name").val('');
	  				$("#submitTourPath").attr("disabled",false);
	  				return false;
	  			}
	  		});
	
});

var isGenError =false;
//生成页面
function generateHTML(pro_id){
	//链接不能点了
	$("#status_"+pro_id).html("<img src='/images/loading_32_32.gif' width='28px' height='28px'/>");
	$.ajax({
		url:"generatePro.htm",
		type:"get",
		data:"pro_id="+pro_id,
		dataType:'text',
		success:function(msg,status){
			var info = msg.split('|');
			if(parseInt(info[0])==1){
				$("#status_"+pro_id).html('<font color="green">已生成</font>');
				isGenError = false;
			} else if(parseInt(info[0])==0 || parseInt(info[0])==-1){
				alert(info[1]);
				isGenError = true;
			}
			
			//$("#checkMsg").text(info[1]);
        },
        error:function(xhr,textStatus,errorThrown){}
	});
}

function viewHTML(pro_id,status,url){
	if($("#status_"+pro_id).html().indexOf('已')>-1){
		window.open(url);
	}else if(status==0){
		alert('还未生成静态页面');
		return false;
	}else{
		window.open(url);
	}
}

function closeLayer(){
	$.unblockUI();
}

function popWaitGen(){
	$.blockUI({message: "生成中，请稍后...<img src='/images/loading_32_32.gif'/>",});
}

//循环生成
function eachGenHTML(list){
	if(list!=null){
		popWaitGen();
		jQuery.each(
				list,
				function(index,entry){
					//alert(entry.pro_id);
					generateHTML(entry.pro_id);
					//setTimeout('alert(2)', 3000);
					if(isGenError){
						alert('生成编号为:'+entry.pro_id+'时有问题');
						closeLayer();
						return false;
					}
				}
		);
		//alert(1);
		/* if(!isGenError){
			closeLayer();
		} */
	}
	
}

//生成当前页面
function gengerAllPro(params){
	
	$.ajax({
		type:"GET",
		contentType : 'application/json',
		url:"catchProducts.htm"+params,
		dataType:'json',
		success:function(data){
			if (data || data.success == "true"){
				var list = data.data;
				//alert((list!=null)+","+data.msg);
				eachGenHTML(list);
				
			}else{
				alert(data.msg);
			}
        },
        error:function(xhr,textStatus,errorThrown){}
	});
}
</script>
<%

	if(request.getParameter("generate")!=null&&request.getParameter("generate").toString().equals("all")){
		//获取当前list 然后遍历 generateHTML()
		//判断isGenError是否是true,如果为true则跳出循环
		%>
		
		<script type="text/javascript">
		var genUrl = window.location.href;
		var params = '';
		if(genUrl.indexOf('?')>0){
			params =genUrl.substring(genUrl.indexOf('?'), genUrl.length);
		}
		gengerAllPro(params);
		/* jQuery.each(
				${proList}+'',
				function(index,entry){
					alert(entry.proid);
					return false;
					//generateHTML('${genItem.pro_id}');
				}
		); */
		</script>
<%		}

%>


<script type="text/javascript" src="/js/adminJS/category_c.js"></script>
</body>
</html>
		