<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学员登录</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <div align="center">
    <form name="form1" method="post" action="loginServlet">
      <table width="398" height="159" border="0" cellspacing="0">
        <tr>
          <td colspan="3" align="center">学员登录</td>
        </tr>
        <tr>
          <td width="108" height="41" align="right">班级：</td>
          <td width="15">&nbsp;</td>
          <td width="253"><label>
          <select name="class" style="width:120px">
          	<option value=0 selected="selected">--请选择--</option>
          	<c:forEach items="${className}" var="name" varStatus="stat">
          		<option value="${name }" >${name }</option>
          	</c:forEach>          	
          </select>
          </label></td>
        </tr>
        <tr>
          <td height="44" align="right">姓名：</td>
          <td>&nbsp;</td>
          <td><label>
            <input type="text" name="name" style="width:120px">
          </label></td>
        </tr>
        <tr>
          <td colspan="3" align="center"><label>
            <input type="submit" name="Submit" value="登陆">&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="reset" name="Submit2" value="取消">
          </label></td>
        </tr>
      </table>
    </form>
  </div>
  </body>
</html>
