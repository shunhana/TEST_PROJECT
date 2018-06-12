<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
	<table>
		<caption>検索結果</caption>
		<tr>
			<th>ID</th>
			<th>名前</th>
			<th>電話番号</th>
		</tr>
		<c:forEach var="info" items="${infoList }">
			<tr>
				<td>${fn:escapeXml(info.userId)}</td>
				<td>${fn:escapeXml(info.userName)}</td>
				<td>${fn:escapeXml(info.telephone)}</td>
			</tr>
		</c:forEach>
	</table>
	<div>
		<a href="menu.jsp">メニューに戻る</a>
	</div>
</body>
</html>
