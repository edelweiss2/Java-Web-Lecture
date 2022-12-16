<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ch14.users3.*" %>
<%
	User u = (User)request.getAttribute("user");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 수정</title>
    <style>
        td { text-align: center; padding: 3px; }
    </style>
</head>
<body style="margin: 40px;">
    <h1>회원 수정</h1>
    <hr>
    <form action="/jw/ch14/users3/update" method="post">
        <input type="hidden" name="uid" value=" ${user.uid}">
        <table>
            <tr>
                <td>아이디:</td>
                <td><input type="text" name="uid" value=" ${user.uid}" disabled></td>
            </tr>
            <tr>
                <td>이름:</td>
                <td><input type="text" name="uname" value=" ${user.uname}"></td>
            </tr>
            <tr>
                <td>이메일:</td>
                <td><input type="email" name="email" value=" ${user.email}"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="수정">
                <input type="reset" value="취소"></td>
            </tr>
        </table>
    </form>
</body>
</html>