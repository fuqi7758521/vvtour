/**
 * js 正则：
 * var reg = /^\d{11}(,\d{11})*$/;   判断手机号码并且要求中间要求逗号隔开
 * var reg = /.*[\u4e00-\u9fa5]+.*$/;	判断是否是汉字
 * var reg = /^[\u4e00-\u9fa5]+(,[\u4e00-\u9fa5]+)*$/;    判断是否是一个或多个汉字词语并且词语之间用逗号隔开
 */
function searchWord(enter_url){
	var word = document.getElementById("searchCon").value;
	if(word == null || word == "null" || word == "" || word == "undefined" || word == "请写入要查询的目的地"){
		return false;
	}
	checkSpace("searchCon");
	var url = enter_url + "?search=" + word;
	url = encodeURI(encodeURI(url));
	window.location.href = url;
	return true;
}

function searchCon(name){
	var word = name;
	if(word == null || word == "null" || word == "" || word == "undefined"){
		alert('没有获取到搜索内容');
		return false;
	}
	var url = "/search.htm?search=" + word;
	url = encodeURI(encodeURI(url));
	window.location.href = url;
	return true;
}

function toUrl(url){
	url = encodeURI(encodeURI(url));
	window.location.href = url;
}

function enterSearch(enter_url){
	var event=arguments.callee.caller.arguments[0]||window.event;//消除浏览器差异  
	if (event.keyCode == 13){
		searchWord(enter_url);  
	}
}

function toAction(name){
	window.location.href = name;
}

function changidateCode(obj) {
	var timenow = new Date().getTime();
	obj.src = "creatidateAction.action?d=" + timenow;
}
function len(s) {
	var l = 0;
	var a = s.split("");
	for (var i = 0; i < a.length; i++) {
		if (a[i].charCodeAt(0)<299) {
			l++;
		} else {
			//l+=2;
			l++;
		}
	}
	return l;
}

function isChinese(str){
	var m = /.*[\u4e00-\u9fa5]+.*$/;
	if(m.test(str)){
		return true;
	}
	return false;
}

function checkEmpty(value){
	if(value == null || value == "" || value == "null"){
		return false;
	}
	return true;
}

function checkMinLen(value, minLen){
	if(len(value) < minLen){
		return false;
	}
	return true;
}

function checkMaxLen(value, maxLen){
	if(len(value) > maxLen){
		return false;
	}
	return true;
}

function checkSpace(id){
	var objUserName = document.getElementById(id);
	var reg = /^\s*(\S+)\s*$/;
	if(reg.test(objUserName.value)){
      //如果用户输入的内容,开头或结尾带有空格,则将空格去掉,重新赋给文本框的value属性
      objUserName.value = RegExp.$1;
	}else{
      //如果用户只输入了空格,则将空格清空
      objUserName.value = "";
	}
}


//复制内容到剪切板
function copyImgUrl(txt){
	if (window.clipboardData) {
        window.clipboardData.clearData();
        window.clipboardData.setData("Text", txt);
	} else if (navigator.userAgent.indexOf("Opera") != -1) {
	        window.location = txt;
	} else if (window.netscape) {
	        try {
	                netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");
	        } catch (e) {
	                alert("您的firefox安全限制限制您进行剪贴板操作，请在新窗口的地址栏里输入'about:config'然后找到'signed.applets.codebase_principal_support'设置为true'");
	                return false;
	        }
	        var clip = Components.classes["@mozilla.org/widget/clipboard;1"].createInstance(Components.interfaces.nsIClipboard);
	        if (!clip)
	                return;
	        var trans = Components.classes["@mozilla.org/widget/transferable;1"].createInstance(Components.interfaces.nsITransferable);
	        if (!trans)
	                return;
	        trans.addDataFlavor('text/unicode');
	        var str = new Object();
	        var len = new Object();
	        var str = Components.classes["@mozilla.org/supports-string;1"].createInstance(Components.interfaces.nsISupportsString);
	        var copytext = txt;
	        str.data = copytext;
	        trans.setTransferData("text/unicode", str, copytext.length * 2);
	        var clipid = Components.interfaces.nsIClipboard;
	        if (!clip)
	                return false;
	        clip.setData(trans, null, clipid.kGlobalClipboard);
	}
}