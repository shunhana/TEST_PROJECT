<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新内容入力画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
<p>１箇所以上の項目を変更してください<br>
<c:if test="${not empty msg}">

	<p><font color=#ff0000>${msg}</font></p>
</c:if>
※IDは変更できません</p>

<form action="updateInput" method="post">
<c:forEach var="update" items="${updateUser}">
  <fieldset>
    <div>
      <label>ID</label><input type="text" name="id" value="${fn:escapeXml(update.userId)}" readonly>
    </div>
    <div>
      <label>名前</label><input type="text" name="newName" value="${fn:escapeXml(update.userName)}">
    </div>
    <div>
      <label>TEL</label><input type="text" name="newTel" value="${fn:escapeXml(update.telephone)}">
    </div>
    <div>
      <label>PASS</label><input type="password" name="newPass" value="${fn:escapeXml(update.password)}">
    </div>
  </fieldset>
  </c:forEach>
  <div>
    <input type="submit" name="button" value="確認">
    <input type="submit" name="button" value="戻る" onclick="location.href='update.jsp'; return false;">
  </div>
</form>
<div>
  <a href="menu.jsp">メニューに戻る</a>
</div>

</body>
</html>