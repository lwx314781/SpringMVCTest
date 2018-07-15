<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../3rd/jquery-3.2.1.min.js"></script>

<style type="text/css">
    
    .modelContent{
        width: 380px;
        height: 150px;
        margin: 100px 200px;
        background-color: #FFFFFF;
        z-index: 1050;
        position: absolute;
        
    }
    
    .hidden{
        display: none;
    }
    
   .content {  
	    position: relative;  
	    width: 350px;
	    margin: 30px 20px;
	    
}  
  
.txt {  
    height: 22px;  
    border: 1px solid #cdcdcd;  
    width: 180px;  
    vertical-align: middle;  
    margin: 0;  
    padding: 0  
}  
  
.btn {  
    border: 1px solid #CDCDCD;  
    height: 24px;  
    width: 70px;  
    vertical-align: middle;  
    margin: 0;  
    padding: 0  
}  
  
.file {  
    position: absolute;  
    top: 0;  
    left: 190px;  
    height: 24px;  
    filter: alpha(opacity :   0);  
    opacity: 0;  
    width: 70px;  
    vertical-align: middle;  
    margin: 0;  
    padding: 0  
}  

.backdrop{
    position: fixed;
    z-index: 1040;
    background-color: #333;
    opacity: .5;
    width: 100%;
    height: 100%;
}

.header{
    padding: 15px;
    border-bottom: 1px solid #e5e5e5;
}

.close:focus, .close:hover {
	color: #000;
	text-decoration: none;
	cursor: pointer;
	opacity: .5;
}

.close{
	float: right;
	margin-top: -9px;
}

</style>
</head>

<body>
<!-- 附于body之上的div -->
<div class="hidden backdrop" id="backDiv"></div>

<!-- 定义上传按钮 -->
<button type="button" class="btn btn-default" title="导入" id="export">
</button>

<!-- 定义上传对话框 -->
<div class="modelContent hidden" id="uploadDialog">
    <!-- 标题 -->
    <div class="header">
        <span class="close">x</span>
    </div>
    <!-- 内容 -->
    <div class="content">
        <input type="text" id="textfield" class="txt" disabled="disabled"/>  
        <input type="button" class="btn" value="浏览..." /> 
        <input  type="file" name="file" class="file" id="file" multiple/>
<!--         onchange="document.getElementById('textfield').value=this.value"   -->
        <input type="submit" id="submit" class="btn" value="上传"/>  
    </div>
    <!-- 上传进度条 -->
    <div class="hidden" id="progressDiv" style="margin: 0px 15px;">
	    <progress id="progressbar" value="0" max="100" style="width: 308px;">
	    </progress>
	    <span id="percentage" style="color: blue;"></span>
    </div>
</div>
</body>

<script type="text/javascript">
$(function(){
	$("#export").click(function(){
		$("#uploadDialog,#backDiv").removeClass("hidden");
		$("body").css("background-color","#fff");
	});
	
	//将选择的文件写到text中
	$("#file").change(function(e){
		var nameArray = [];
		var files = $("#file")[0].files;
		$.each(files,function(index,val){
			nameArray.push(val.name);
		});
		$("#textfield").val(nameArray.join());
	})
	
	//关闭上传对话框
	$(".close").click(function(e){
		$("#uploadDialog,#backDiv").addClass("hidden");
		$("#textfield").val("");
	});
	
	//点击上传，由于非form表单上传，因此采用
	$("#submit").click(function(e){
		//显示进度条
		$("#progressDiv").show();
		//获取上传文件
		var fileObj = $("#file")[0].files[0];
		console.log(fileObj);
		//使用formdata实现无刷新上传
		var formData = new FormData();
		formData.append("file",fileObj);
		//后台使用springmvc接收请求
		var url = "http://localhost:8080/SpringMVCTest/index/fileUpload";
		//ajax
		var xhr = new XMLHttpRequest();
		xhr.open("POST",url,true);
		//定义上传对象的进度事件
		xhr.upload.onprogress=function(event){
		 var progressBar = document.getElementById("progressbar") ;
         var percentageDiv = document.getElementById("percentage");
         if (event.lengthComputable) {
        	 progressBar.max = event.total;  
        	 progressBar.value = event.loaded;  
        	 percentageDiv.innerHTML = Math.round(event.loaded / event.total * 100)+ "%";  
        	}  
		};
		
// 		//当状态为4，
		xhr.onload = function(event){
			//获取相应的状态
			var data = xhr.responseText;
			//关闭进度条，并显示上传成功状态
// 			$("#progressDiv").addClass("hidden");
			//
		};
		xhr.send(formData);
	});
})
</script>
</html>