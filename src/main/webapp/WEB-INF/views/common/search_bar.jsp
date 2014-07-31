<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLDecoder" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + path + "/";
%>

      <div class="m1 pr">
         <!--
     <div class="p1"><span class="span"></span>北京</div>
鼠标点击时显示          
        <div class="p2">
           <span class="span"></span>北京
        </div>
       <dl>
          <dt>热门出发城市</dt>
          <dd class="dd1 clearfix">
              <a href="#">北京</a>
              <a href="#">北京</a>
              <a href="#">北京</a>
              <a href="#">北京</a>
              <a href="#">北京</a> 
              <a href="#">北京</a>
              <a href="#">北京</a>
              <a href="#">北京</a>
              <a href="#">北京</a>
          </dd>
       </dl>
     --> 
     <%
     	String searched = "马尔代夫";
     	if(request.getParameter("search")!=null&&request.getParameter("search").toString()!=null){
     		searched = request.getParameter("search").toString();
     		searched = URLDecoder.decode(searched, "UTF-8");
     	}
     %>
     <div class="p3">
        <input id="searchCon" name="searchCon" type="text" onkeydown="enterSearch('/search.htm')" value="<%=searched %>" onFocus="if(this.value=='马尔代夫'){this.value=''}" onblur="if(this.value==''){this.value='马尔代夫'}"/>
     </div>
       <div class="p4"><a href="javascript:void(0)" onclick="searchWord('/search.htm')"></a></div>
     </div>
     <div class="m2">
        <a href="#">巴厘岛</a>
        <a href="#">俄罗斯</a>
        <a href="#">三亚</a>
        <a href="#">呼伦贝尔草原</a>
   </div>