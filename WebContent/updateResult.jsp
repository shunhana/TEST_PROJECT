<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新結果確認画面</title>
</head>
<body>
	<c:if test="${not empty name}">
		<p>実行者:${name}</p>
	</c:if><p>正常に更新されました</p>
<form action="select.jsp">
  <input type="submit" value="検索">
</form>
<div>
  <a href="menu.jsp">メニューに戻る</a>
</div>
</body>
</html>