<%@page import="org.springframework.http.HttpRequest"%>
<%@page import="java.util.Locale"%>
<%@page import="org.springframework.cglib.core.Local"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
    <%
    String lanaguage = "";
    Locale locale = request.getLocale();
    if("zh_CN".equals(locale)){
        lanaguage = "zh_CN";
    }else{
        lanaguage = "en_US";
    }
    
    %>
</body>
<script type="text/javascript">
var lanauage = <%=lanaguage%>
var userId;


</script>


</html>