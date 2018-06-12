<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/commons.css" rel="stylesheet">
<style>
.col {
  float: left;
}

.col-clear {
  clear: both;
}

#arrow {
  margin-top: 60px;
}
</style>
</head>
<body>
<c:if test="${not empty msg}">

    <p>${msg}</p>
</c:if>
<p>これでよろしいですか？</p>

<form action="updateConfirm" method="post">
<c:forEach var="update" items="${updateUser}">
  <fieldset>
    <div>
      <label>ID</label><input type="text" name="id" value="${fn:escapeXml(update.userId)}" readonly>
    </div>
  </fieldset>

  <fieldset class="col">

    <legend>変更前</legend>
    <div>
      <label>名前</label><input type="text" value="${fn:escapeXml(update.userName)}" disabled>
    </div>
    <div>
      <label>TEL</label><input type="text" value="${fn:escapeXml(update.telephone)}" disabled>
    </div>
    <div>
      <label>PASS</label><input type="password" value="${fn:escapeXml(update.password)}" disabled>
    </div>

  </fieldset>
</c:forEach>
  <div id="arrow" class="col">⇒</div>

  <fieldset class="col label-110">
    <legend>変更後</legend>
    <div>
      <label>名前</label><input type="text" name="newName" value="${inputName}" readonly>
    </div>
    <div>
      <label>TEL</label><input type="text" name="newTel" value="${inputTel}" readonly>
    </div>
    <div>
      <label>PASS(再入力)</label><input type="password" name="rePass" value ="${samePass}">
    </div>
  </fieldset>

  <div class="col-clear">
    <input type="submit" name="button" value="更新">
    <input type="submit" name="button" value="戻る" onclick="location.href='updateInput.jsp'; return false;">
  </div>
</form>
<div>
  <a href="menu.jsp">メニューに戻る</a>
</div>
</body>
</html>
