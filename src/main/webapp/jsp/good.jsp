<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品管理</title>

<link href="../css/jquery-ui.min.css" type="text/css" rel="stylesheet">
<!-- <link href="../css/jquery-ui.theme.min.css" type="text/css" rel="stylesheet"> -->
<!-- <link href="../css/jquery-ui.structure.min.css" type="text/css" rel="stylesheet"> -->
<link href="../css/ui.jqgrid.css" type="text/css" rel="stylesheet">
<script type="text/javascript">
var size = ${jqpage.pageSize};
var count = ${jqpage.count};
var pageNo = ${jqpage.currentNo};
</script>
<style type="text/css">
.main {
padding: 10px 0px 10px 0px;
margin: 10px 0px 10px 0px
}
</style>

</head>

<body>
<div class="main">
    <table id="table"></table>
   <div id="pager"></div>
</div>
</body>
<script type="text/javascript" src="../3rd/jquery-1.9.0.js"></script>
<script type="text/javascript" src="../3rd/jquery-ui.min.js"></script>
<script type="text/javascript" src="../3rd/grid.locale-cn.js"></script>
<script type="text/javascript" src="../3rd/jquery.jqGrid.min.js"></script>
<script type="text/javascript" src="../js/good.js"></script>
</html>

