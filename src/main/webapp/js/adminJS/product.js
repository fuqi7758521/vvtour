/**
 * 发布产品时初始化图片分页
 * */
function initImagesListAjax(pageNo,album_id){
	var html="";
	if(album_id!=null){
		html+="&album_id="+album_id;
	}
	$.ajax({
		type:"GET",
		contentType : 'application/json',
		url:"catchImagesList.htm?pageNo="+pageNo+html,
		dataType:'json',
		success:function(data){
			if (data || data.success == "true"){
				showImagesList(data.data);
				$("#totalPage").val(data.totalPage);
			}else{
				$("#imagesDiv").html(data.msg);
			}
        },
        error:function(xhr,textStatus,errorThrown){}
	});	
}

function showImagesList(picList){
	var html = "";
	if(picList!=null){
		var i=1;
		jQuery.each(
				picList,
				function(index,entry){
					html += '<a href="javascript:void(0)" onclick="chooseTourImg(\'pic\'+'+i+')">';
					html += '<img id="pic'+i+'" src="'+entry.pic_url+'" title="'+ entry.pic_name +'" width="186" height="156" /></a>';
					i++;
		});
		
		$("#imagesDiv").html(html);
	}else{
		$("#imagesDiv").html("该相册暂时没有图片");
	}
}


/**
 * 初始化相册
 * */
function initAlbumOptions(){
	$.ajax({
		type:"GET",
		contentType : 'application/json',
		url:"catchAlbumList.htm",
		dataType:'json',
		success:function(data){
			if (data || data.success == "true"){
				showAlbumOptions(data.data);
			}else{
				alert(data.msg);
			}
        },
        error:function(xhr,textStatus,errorThrown){}
	});	
}
function showAlbumOptions(albumList){
	$("#albumList").empty();
	var options = '<option value="0">查看全部</option>';
	if(albumList!=null){
		jQuery.each(
				albumList,
				function(index,entry){
					options += '<option value="' + entry.album_id + '">' + entry.album_name + '</option>';
		});
		$("#albumList").append(options);
	}else{
		$("#albumList").append("<option value='0'>无</option>");
	}
}
function changeAlbum(){
	var album_id = $("#albumList").val();
	currentAlbumID = album_id;
	initImagesListAjax(1,album_id);
}

//点击背景选择图片
var id_front = '';
$('.inner').on('click', function(){
	
	var i=$(".inner").index($(this));
	if(i==0){
		id_front = "img1";
	}else if(i==1){
		id_front = "img2";
	}else if(i==2){
		id_front = "img3";
	}else{
		id_front = "img4";
	}
	$.blockUI({ message: $('#selectImgDiv'),
		 css: {
			 top:		' 0px',
			 width:		'840px',
			 left:		'22%',
			 textAlign:	'center',
			 border:	'3px solid #ccc'
		 }
	 });
	
	var imgCatched = $("#imgCatched").val();
	if(imgCatched==0){				//图片还没有加载过
		initImagesListAjax(1,null);	
		initAlbumOptions();
	}
});

function chooseTourImg(id){
	
	if(id_front==''||id_front==null){
		alert('出错');
	}
	//获取id的src
	//获取所点击封面的id
	//将pic的id的src赋值给封面id
	var img_url = $('#'+id).attr("src");
	if(img_url.indexOf("http:")>-1){
		img_url = img_url.substring(img_url.indexOf("/upload"),img_url.length);
	}
	//alert(img_url);
	$('#'+id_front+" img").attr("src",img_url);
	$("#imgCatched").val(1);
	closeLayer();
}
var currentPage = 1;
var currentAlbumID = 0;
function showAlbumListPage(item){
	var totalPage = $("#totalPage").val();
	if(item=='pre'){			//点击上一页
		if(parseInt(currentPage)<=1){		//当前页面
			alert('已经到达首页');
			return false;
		}
		$("#imagesDiv").html("");
		currentPage = parseInt(currentPage)-1;
		initImagesListAjax(currentPage,currentAlbumID);
	}else{
		if(parseInt(currentPage)>=totalPage){		//当前页面
			alert('已经到达尾页');
			return false;
		}
		$("#imagesDiv").html("");
		currentPage = parseInt(currentPage)+1;
		initImagesListAjax(currentPage,currentAlbumID);
	}
}

//选择相册类型
function changeAlbumType(){
	var album_type = $('#album_type').val();
	if(album_type=='all'){
		initImagesListAjax(1,0);
	}
	$.ajax({
		type:"GET",
		contentType : 'application/json',
		url:"catchAlbumList.htm?album_type="+album_type,
		dataType:'json',
		success:function(data){
			if (data || data.success == "true"){
				showAlbumOptions(data.data);
			}
        },
        error:function(xhr,textStatus,errorThrown){}
	});
}
