<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content="X-UA-Compatible" content="IE=edge">
<title>某东-欢迎登录</title>
<link href="css/bootstrap.min.css" rel="stylesheet"> 
<script type="text/javascript" src="3rd/bootstrap.min.js"></script>

<style type="text/css">
body {
  padding-top: 40px;
  padding-bottom: 40px;
  background-color: #eee;
}

.form-signin {
  max-width: 330px;
  padding: 15px;
  margin: 0 auto;
}
.form-signin .form-signin-heading,
.form-signin .checkbox {
  margin-bottom: 10px;
}
.form-signin .checkbox {
  font-weight: normal;
}
.form-signin .form-control {
  position: relative;
  height: auto;
  -webkit-box-sizing: border-box;
     -moz-box-sizing: border-box;
          box-sizing: border-box;
  padding: 10px 10px 10px 50px;
  font-size: 16px;
}
.form-signin .form-control:focus {
  z-index: 2;
}
.form-signin input[type="email"] {
  margin-bottom: 20px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}
.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}
.login-label{
    position: absolute;
    z-index: 3;
    width: 45px;
    height: 45px;
    background: #ddd;
    color: #fff;
    line-height: 30px;
    padding: 15px;
    text-align: center;
}

</style>


</head>


<body>
   <div class="container">
     <form class="form-signin">
       <h2 class="form-signin-heading">请登录</h2>
       <label for="inputEmail" class="login-label">
           <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
       </label>
       <input type="email" id="inputEmail" class="form-control" placeholder="用户名" required autofocus>
       <label for="inputPassword" class="login-label" >
            <span class="glyphicon glyphicon-lock" aria-hidden="true"></span>
       </label>
       <input type="password" id="inputPassword" class="form-control" placeholder="密码" required>
       <div class="checkbox">
         <label>
           <input type="checkbox" value="remember-me"> Remember me
         </label>
       </div>
       <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
     </form>
   </div> 
</body>
<script type="text/javascript" src="js/login.js"></script>
</html>