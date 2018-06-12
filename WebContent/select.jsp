<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
	<p>
		検索したいデータ情報を入力してください<br> ※全て空白の場合は全検索を行います
	</p>
	<c:if test="${not empty msg}">
		<p><font color=#ff0000>${msg}</font></p>
	</c:if>

	<form action="select">
		<fieldset>
			<div>
				<label>ID</label><input type="text" name="id" value = "${defaultId}">
			</div>
			<div>
				<label>名前</label><input type="text" name="name">
			</div>
			<div>
				<label>TEL</label><input type="text" name="tel">
			</div>
		</fieldset>
		<input type="submit" value="検索">
	</form>
	<div>
		<a href="menu.jsp">メニューに戻る</a>
	</div>
</body>
</html>
