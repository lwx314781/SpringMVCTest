window.upload = (function($,module){
	
	function init()
	{
		$("#selectFile").click(function(){
			$("input[type ='file']").trigger('click');
		});	
		
		$("#submit1").click(function(){
			var files = document.getElementById("file").files;
			if (files.length>0){
				$("#name").val(getFileName(files));
			}
			
			var option = {
				url : '../up/fileUpload.do',
				type : 'POST',
				dataType : 'json',
                success : function(data) {
                    alert(JSON.stringify(data));
                },
                beforeSubmit : function(){
                	var fileName = $("#name").val();
                	if (!fileName){
                		alert("请选择文件");
                		return false;
                	}
                	else{
                		if(!fileName.match(/.jpg|.jpeg|.gif|.png|.txt/i)){
                			alert("文件格式不正确");
                			return false;
                		}
                	}
                },
	            error: function(data) {
                    alert(JSON.stringify(data) + "--上传失败,请刷新后重试");
                }
			}
			$("#myform").ajaxSubmit(option);
			return false;
		});
		
		
//		$("#submit1").click(function(){
//			var form = new FormData(document.getElementById("myform"));
//			$.ajax({
//				 url:"../up/fileUpload.do",
//	                type:"post",
//	                data:form,
//	                processData:false,
//	                contentType:false,
//	                success:function(data){
//	                    console.log("over..");
//	                },
//	                error:function(e){
//	                    alert("错误！！");
//	                }
//			});
//		});
		
	}
	
	function getFileName(files){
		var nameArray = [];
		$.each(files,function(id,file){
			nameArray.push(file.name);
		});
		return nameArray.join();
	}
	
	
	function ajaxSubmitForm(){
		var option = {
				url : '../up/fileUpload.do',
				type : 'POST',
				dataType : 'json',
                success : function(data) {
                    alert(JSON.stringify(data));
                },
                beforeSubmit : function(){
                	var fileName = $("#file").val();
                	if (!fileName){
                		alert("请选择文件");
                		return false;
                	}
                	else{
                		alert(fileName);
                		if(!fileName.match("/.jpg|.jpeg|.gif|.png|.txt/i")){
                			alert("文件格式不正确");
                		}
                	}
                },
	            error: function(data) {
                    alert(JSON.stringify(data) + "--上传失败,请刷新后重试");
                }
			}
			$("#myform").ajaxSubmit(option);
			return false;
	}
	
	
	module.init = init;
	module.ajaxSubmitForm = ajaxSubmitForm;
	return module;
	
})($,window.upload || {})


$(function(){
	upload.init();
});

