<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <p>1. core - forEach, if </p> 
    </div>
    
    <div class="container mt-5">
        <div class="row">
            <div class="col-2"></div>
            <div class="col-8">
                <table class="table">
                    <tr><th>아이디</th><th>이름</th><th>주소</th></tr>
                <c:forEach var="member" items="${members}">
                    <tr>
                    	<td>${member.id}</td>
                    	<td>${member.name}</td>
                    	<td>${member.addr}</td>
                    </tr>
                </c:forEach>
                </table>
                <table class="table">
                    <tr><th>아이디</th><th>이름</th><th>주소</th><th>인덱스</th></tr>
                <c:forEach var="member" items="${members}" varStatus="loop">
                    <tr>
                    	<td>
                    	<c:if test="${loop.first}">
                    		<div class="text-bg-success">${member.id}</div>
                    	</c:if>
                    	<c:if test="${not loop.first}">
                    		${member.id}
                    	</c:if>
                    	</td>
                    	<td>
                    	<c:if test="${member.addr.country eq '한국'}">
                    		<div class="text-bg-primary">${member.name}</div>
                    	</c:if>
                    	<c:if test="${member.addr.country eq '미국'}">
                    		<div class="text-bg-info">${member.name}</div>
                    	</c:if>
                    	</td>
                    	<td>
                    	<c:if test="${loop.last}">
                    		<div class="text-bg-danger">${member.addr}</div>
                    	</c:if>
                    	<c:if test="${not loop.last}">
                    		${member.addr}
                    	</c:if>
                    	</td>
                    	<td>${loop.index}/${loop.count}</td>
                    </tr>
                </c:forEach>
                </table>
                <table class="table">
                    <tr><th>아이디</th><th>이름</th><th>주소</th></tr>
                <c:forEach var="member" items="${members}" begin="1" end="3">
                    <tr>
                    	<td>${member.id}</td>
                    	<td>${member.name}</td>
                    	<td>${member.addr}</td>
                    </tr>
                </c:forEach>
                </table>
            </div>
            <div class="col-2"></div>
        </div>
    </div>
</body>
</html>