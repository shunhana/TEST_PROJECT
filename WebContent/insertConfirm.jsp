<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録確認画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
	<c:if test="${not empty msg}">
		<p><font color=#ff0000>${msg}</font></p>
	</c:if>

	<p>これでよろしいですか？</p>

	<form action="insertConfirm" method="post">
		<fieldset class="label-110">
			<div>
				<c:if test="${not empty userName}">
					<label>名前</label>
					<input type="text" name="name" value="${userName}" readonly>
				</c:if>
			</div>
			<div>
			<c:if test="${not empty telephone}">
				<label>TEL</label><input type="text" name="tel" value="${telephone}" readonly>
					</c:if>
			</div>
			<div>
				<label>PASS（再入力）</label><input type="password" name="rePass">
			</div>
		</fieldset>
		<div>
			<input type="submit" name="button" value="登録">

			 <input	type="submit" name="button" value="戻る"
				onclick="location.href='insert.jsp'; return false;">
		</div>
	</form>
	<div>
		<a href="menu.jsp">メニューに戻る</a>
	</div>
</body>
</html>
