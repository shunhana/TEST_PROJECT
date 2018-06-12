<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
<c:if test="${not empty msg}">
</c:if>
    <p><font color=#ff0000>${msg}</font></p>
<form action="login" method="post">
  <fieldset>
    <div>
      <label>ID</label><input type="text" name="id">
    </div>
    <div>
      <label>PASS</label><input type="password" name="pass">
    </div>
  </fieldset>
  <input type="submit" value="ログイン">
</form>
<div>
  <a href="index.jsp">TOP画面へ</a>
</div>
</body>
</html>