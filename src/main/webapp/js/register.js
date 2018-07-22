(function($){
    
    var Register = {};
    
    // 使用原生态的js的ajax来
    
    function createXHR(url,callback){
    	var xhr;
    	// 首先判断浏览器是否支持ActiveX IE6之前的版本
    	if (window.ActiveXObject){
    		xhr = new ActiveXObject("Microsoft.XMLHTTP");
    	}else if (window.XMLHttpRequest){   // 针对IE7，firefox，chorm
    		xhr = new XMLHttpRequest();
    	}
    	if (xhr!=undefined && xhr!=null){
        	xhr.onreadystatechange=function(){
        		if(xhr.readyState == 4 && xhr.status==200){ // 异步调用完毕 //请求成功
        			var flag = xhr.responseText;// 获取响应结果
        			if (callback){
        				callback(flag);
        			}
        		}
            }
        };
    	xhr.open("GET",url);
    	xhr.send(null);
    }
    
    // 主要是用户名校验以及密码校验
    Register.validate = function(){
		// 用户名唯一性校验
        validateName : {
            $("input[type='text']").blur(function(e){
                if (!$(this).val()){
                	$("#warnInfo").text("用户名不能为为空!");
                	return false;
                }
                var name = $(this).val();
                createXHR("../validateName?userName=" + name,function(msg){
                	var tip = document.getElementById("warnInfo");
        			if (msg){
        				tip.innerHTML="用户合法";
        			}else{
        				tip.innerHTML="输入的用户名已存在，请重新输入!"
        			}
                })
            });
            $("input[type='text']").focus(function(e){
                $("#warnInfo").text("");
            });
        };
        // 校验两次密码是否一致
        validatePassword : {
        	$("input[type='password']").blur(function(e){
        		var password = $(this).val();
    			if (password == null){
    				$("")
    			}
    			
        	    if (e.target.getName == 'repassword'){
	        		var firstPassword = $("input[type='password']:eq(0)").val();
	        		var secondPassword = $(this).val();
	        		if (firstPassword != secondPassword){
	        			$("#passWarn").css("color:red").text("两次密码输入不一致");
	        		}else{
	        			$("#passWarn").text("");
	        		}
        	    }
        	});
        }
    }
    window.Register = Register;
    
})(jQuery);

$(function(){
	// 初始化校验
	Register.validate();
});

