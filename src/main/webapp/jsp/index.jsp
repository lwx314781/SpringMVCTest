<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/font-awesome.css">
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/font-change.css">
<script type="text/javascript" src="3rd/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="3rd/bootstrap.min.js"></script>
<!--IE兼容,使用最高版本的IE内核-->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>医药管理平台</title>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.jsp">XXXX.com</a>
		</div>

		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="###" onclick="showAtRight('userList.jsp')"><i
						class="fa fa-users"></i> 用户列表</a></li>
				<li><a href="###" onclick="showAtRight('productList.jsp')"><i
						class="fa fa-list-alt"></i> 产品列表</a></li>
				<li><a href="###" onclick="showAtRight('recordList.jsp')"><i
						class="fa fa-list"></i> 订单列表</a></li>
			</ul>
		</div>
	</div>
	</nav>

	<div class="container-fluid">
		<div class="row-fluie">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<!-- 一级菜单 -->
					<li class="active"><a href="#sysMan"
						class="nav-header menu-first collapsed" data-toggle="collapse">
							<i class="fa fa-user"></i>&nbsp; 系统管理 <span class="sr-only">(current)</span>
					</a></li>
					<ul id="sysMan" class="nav nav-list collapse menu-second">
						<li><a href="###" onclick="showAtRight('userList.jsp')"><i
						class="fa fa-users"></i> 用户管理</a></li>
						<li><a href="###" onclick="showAtRight('userList.jsp')"><i
						class="fa fa-users"></i> 角色权限设置</a></li>
						<li><a href="###" onclick="showAtRight('userList.jsp')"><i
						class="fa fa-users"></i> 医生设置</a></li>
						<li><a href="###" onclick="showAtRight('userList.jsp')"><i
						class="fa fa-users"></i> 医院及科室设置</a></li>
						<li><a href="###" onclick="showAtRight('userList.jsp')"><i
						class="fa fa-users"></i> 参数设置</a></li>
					</ul>

					<li><a href="#patientMan"
						class="nav-header menu-first collapsed" data-toggle="collapse">
							<i class="fa fa-globe"></i>&nbsp; 患者管理 <span class="sr-only">(current)</span>
					</a></li>
					<ul id="patientMan" class="nav nav-list collapse menu-second">
						<li><a href="###" onclick="showAtRight('productList.jsp')"><i
						class="fa fa-list-alt"></i> 患者基本信息</a></li>
						<li><a href="###" onclick="showAtRight('productList.jsp')"><i
						class="fa fa-list-alt"></i> 病例管理</a></li>
						<li><a href="###" onclick="showAtRight('productList.jsp')"><i
						class="fa fa-list-alt"></i> 咨询记录</a></li>
						<li><a href="###" onclick="showAtRight('productList.jsp')"><i
						class="fa fa-list-alt"></i> 药品清单</a></li>
						<li><a href="###" onclick="showAtRight('productList.jsp')"><i
						class="fa fa-list-alt"></i> 代购记录</a></li>
						<li><a href="###" onclick="showAtRight('productList.jsp')"><i
						class="fa fa-list-alt"></i> 专属医生</a></li>
						<li><a href="###" onclick="showAtRight('productList.jsp')"><i
						class="fa fa-list-alt"></i> 专属客服</a></li>
					</ul>

					<li><a href="#doctorMan"
						class="nav-header menu-first collapsed" data-toggle="collapse">
							<i class="fa fa-file-text"></i>&nbsp; 医生管理 <span class="sr-only">(current)</span>
					</a></li>
					<ul id="doctorMan" class="nav nav-list collapse menu-second">
						<li><a href="###" onclick="showAtRight('recordList.jsp')"><i
						 class="fa fa-list"></i> 医生基本信息</a></li>
						 <li><a href="###" onclick="showAtRight('recordList.jsp')"><i
						 class="fa fa-list"></i> 服务患者</a></li>
						 <li><a href="###" onclick="showAtRight('recordList.jsp')"><i
						 class="fa fa-list"></i> 所属客服</a></li>
					</ul>

					<li><a href="#orderMan"
						class="nav-header menu-first collapsed" data-toggle="collapse">
							<i class="fa fa-file-text"></i>&nbsp; 咨询订单管理 <span
							class="sr-only">(current)</span>
					</a></li>
					<ul id="orderMan" class="nav nav-list collapse menu-second">
					    <li><a href="###" onclick="showAtRight('recordList.jsp')"><i
						 class="fa fa-list"></i> 咨询记录</a></li>
						 <li><a href="###" onclick="showAtRight('recordList.jsp')"><i
						 class="fa fa-list"></i> 药品清单</a></li>
					</ul>
					
					<li><a href="#dragAgency"
						class="nav-header menu-first collapsed" data-toggle="collapse">
							<i class="fa fa-file-text"></i>&nbsp; 药品代购管理 <span
							class="sr-only">(current)</span>
					</a></li>
					<ul id="dragAgency" class="nav nav-list collapse menu-second">
					    <li><a href="###" onclick="showAtRight('recordList.jsp')"><i
						 class="fa fa-list"></i> 代购记录</a></li>
						 <li><a href="###" onclick="showAtRight('recordList.jsp')"><i
						 class="fa fa-list"></i> 快递信息</a></li>
					</ul>
					
<!-- 					<li><a href="#recordMeun" -->
<!-- 						class="nav-header menu-first collapsed" data-toggle="collapse"> -->
<!-- 							<i class="fa fa-file-text"></i>&nbsp; 客服中心 <span class="sr-only">(current)</span> -->
<!-- 					</a></li> -->

<!-- 					<li><a href="#recordMeun" -->
<!-- 						class="nav-header menu-first collapsed" data-toggle="collapse"> -->
<!-- 							<i class="fa fa-file-text"></i>&nbsp; 统计 <span class="sr-only">(current)</span> -->
<!-- 					</a></li> -->

<!-- 					<li><a href="#recordMeun" -->
<!-- 						class="nav-header menu-first collapsed" data-toggle="collapse"> -->
<!-- 							<i class="fa fa-file-text"></i>&nbsp; 消息推送 <span class="sr-only">(current)</span> -->
<!-- 					</a></li> -->

<!-- 					<li><a href="#recordMeun" -->
<!-- 						class="nav-header menu-first collapsed" data-toggle="collapse"> -->
<!-- 							<i class="fa fa-file-text"></i>&nbsp; APP咨询管理 <span -->
<!-- 							class="sr-only">(current)</span> -->
<!-- 					</a></li> -->
				</ul>
			</div>
		</div>
	</div>

	<!-- 右侧内容展示==================================================   -->
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<h1 class="page-header">
			<i class="fa fa-cog fa-spin"></i>&nbsp;控制台<small>&nbsp;&nbsp;&nbsp;欢迎使用XXX后台管理系统</small>
		</h1>
		<!-- 载入左侧菜单指向的jsp（或html等）页面内容 -->
		<div id="content">
			<h4>
				<strong>使用指南：</strong><br> <br>
				<br>默认页面内容……
			</h4>
		</div>
	</div>
</body>
<script type="text/javascript" src="js/index.js"></script>
</html>

