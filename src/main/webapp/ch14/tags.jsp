<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	pageContext.setAttribute("pid", "페이지 아이디");
%>
<c:set var="cid" value="코어 아이디"></c:set>
<!DOCTYPE html>
<html lang="ko">
<head>
    <title>JSTL</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <div class="container-fluid p-3 bg-primary text-white text-center">
        <h1>JSTL(JSP Standard Tag Library)</h1>
        <p>1. core</p> 
    </div>
    
    <div class="container mt-5">
        <div class="row">
            <div class="col-2"></div>
            <div class="col-8">
                <table class="table">
                    <tr><th>표현식</th><th>결과</th></tr>
                    <tr><td>\${pid}</td><td>${pid}</td></tr>
                    <tr><td>\${cid}</td><td>${cid}</td></tr>
					<c:set var="cid2" value="코어 아이디2" />
                    <tr><td>\${cid2}</td><td>${cid2}</td></tr>
                </table>
                <c:set var="member1" value="${members[0]}" />
                <table class="table">
                    <tr><th>아이디</th><th>이름</th><th>주소</th></tr>
                    <tr>
                    	<td>${member1.id}</td>
                    	<td>${member1.name}</td>
                    	<td>${member1.addr}</td>
                    </tr>
                </table>
            </div>
            <div class="col-2"></div>
        </div>
    </div>
</body>
</html>