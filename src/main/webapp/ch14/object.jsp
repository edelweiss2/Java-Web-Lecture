<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("pName", "페이지");
	pageContext.setAttribute("name", "페이지");
%>    

<!DOCTYPE html>
<html lang="ko">

<head>
    <title>JSP EL(Expression Language)</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://kit.fontawesome.com/c274ddffaf.js" crossorigin="anonymous"></script>
</head>

<body>

    <div class="container-fluid p-5 bg-primary text-white text-center">
        <h1>JSP EL(Expression Language)</h1>
        <p>2.내장 객체 (Built-in Object)</p>
    </div>

    <div class="container mt-5">
        <div class="row">
            <div class="col-2"></div>
            <div class="col-8">
                <table class="table">
                    <tr><th>표현식</th><th>결과</th></tr>
                    <tr><td>\${param.id}</td><td>${param.id}</td></tr>
                    <tr><td>\${param.name}</td><td>${param.name}</td></tr>
                    <tr><td></td><td></td></tr>
                    <tr><td>\${applicationScope.aName}</td><td>${applicationScope.aName}</td></tr>
                    <tr><td>\${sessionScope.sName}</td><td>${sessionScope.sName}</td></tr>
                    <tr><td>\${requestScope.rName}</td><td>${requestScope.rName}</td></tr>
                    <tr><td>\${pageScope.rName}</td><td>${pageScope.rName}</td></tr>
                    <tr><td>\${aName}</td><td>${aName}</td></tr>
                    <tr><td>\${sName}</td><td>${sName}</td></tr>
                    <tr><td>\${rName}</td><td>${rName}</td></tr>
                    <tr><td>\${pName}</td><td>${pName}</td></tr>
                    <!-- 우선순위 page>request>session>application -->
                    <tr><td>\${name}</td><td>${name}</td></tr>
                    <tr><td></td><td></td></tr>
                    <tr><td>\${header.host}</td><td>${header.host}</td></tr>
                    <tr><td>\${header["User-Agent"]}</td><td>${header["User-Agent"]}</td></tr>
                    <tr><td></td><td></td></tr>
                    <tr><td>\${cookies.JSESSIONID.name}</td><td>${cookies.JSESSIONID.name}</td></tr>
                    <tr><td>\${cookies.JSESSIONID.value}</td><td>${cookies.JSESSIONID.value}</td></tr>
                </table>
            </div>
            <div class="col-2"></div>
        </div>
    </div>    

</body>

</html>