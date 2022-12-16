<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="ch14.users3.*" %>
<%@ page import="java.util.*" %>
<%
	String sessionUid = (String)session.getAttribute("uid");
	List<User> list = (List<User>) request.getAttribute("userList");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>사용자 목록</title>
    <style>
        td { text-align: center; padding: 3px;}
    </style>
</head>
<body style="margin: 40px;">
    <h1>사용자 목록</h1>
<c:if test="${not empty uid}">
 	<button onclick="location.href='/jw/ch14/users3/logout'">로그아웃</button>
 	${uname} 님 환영합니다.
</c:if>
<c:if test="${empty uid}">
   	<button onclick="location.href='/jw/ch14/users3/login'">로그인</button>
</c:if>   
    <hr>
    <table border="1">
        <tr>
            <th>UID</th>
            <th>PWD</th>
            <th>NAME</th>
            <th>Email</th>
            <th>등록일</th>
            <th>액션</th>
        </tr>
    <c:forEach var="user" items="${userList}">
        <tr>
            <td>${user.uid}</td>
            <td>${user.pwd}</td>
            <td>${user.uname}</td>
            <td>${user.email}</td>
            <td>${user.regDate}</td>
            <td>
            <%-- 본인만이 수정권한 있음 --%>
            <c:if test="${(empty uid) or (not (uid eq user.uid))}">
            	 <button disabled>수정</button>
            </c:if>
            <c:if test="${(not empty uid) and (uid eq user.uid)}">
            	 <button onclick="location.href='/jw/ch14/users3/update?uid=${user.uid}'">수정</button>
            </c:if>
            <%-- 관리자 만이 삭제권한 있음 --%>	 
            <c:if test="${(empty uid) or (not (uid eq 'admin'))}">
         		 <button disabled>삭제</button>
         	 </c:if>
         	 <c:if test="${not(empty uid) and (uid eq 'admin')}">
         		<button onclick="location.href='/jw/ch14/users3/delete?uid=${user.uid}'">삭제</button>
         	 </c:if>	 
            </td>
        </tr>
    </c:forEach>
    </table>
    <br>
    <a href="/jw/ch14/users3/register.jsp">회원 가입</a>
</body>
</html>