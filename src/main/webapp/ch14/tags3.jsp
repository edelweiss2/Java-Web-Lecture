<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*" %>

<c:set var="price" value="123456789" />
<c:set var="now" value="<%= new Date() %>" />
<!DOCTYPE html>
<html lang="ko">
<head>
    <title>Formatting</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <div class="container-fluid p-3 bg-primary text-white text-center">
        <h1>JSTL(JSP Standard Tag Library)</h1>
        <p>2. formatting </p> 
    </div>
    
    <div class="container mt-5">
        <div class="row">
            <div class="col-2"></div>
            <div class="col-8">
                <table class="table">
                    <tr><th>표현방법</th><th>값</th></tr>
                    <tr>
                    	<td>일반 숫자</td>
                    	<td>${price}</td>
                    </tr>
                    <tr>
                    	<td>숫자(천단위 구분 기호 포함)</td>
                    	<td><fmt:formatNumber type="number" value="${price}" /></td>
                    </tr>
                    <tr>
                    	<td>통화</td>
                    	<td><fmt:formatNumber type="currency" currencySymbol="KRW " value="${price}" /></td>
                    </tr>
                    <tr>
                    	<td>통화</td>
                    	<td><fmt:formatNumber type="currency" currencySymbol="$" value="${price}" /></td>
                    </tr>
                    <tr>
                    	<td>퍼센트</td>
                    	<td><fmt:formatNumber type="percent" value="${price}" /></td>
                    </tr>
                    <tr><td></td><td></td></tr>
                    <tr>
                    	<td>일반 날짜</td>
                    	<td>${now}</td>
                    </tr>
                    <tr>
                    	<td>full date</td>
                    	<td><fmt:formatDate value="${now}" type="date" dateStyle="full" /></td>
                    </tr>
                    <tr>
                    	<td>short date</td>
                    	<td><fmt:formatDate value="${now}" type="date" dateStyle="short" /></td>
                    </tr>
                    <tr>
                    	<td>time</td>
                    	<td><fmt:formatDate value="${now}" type="time" /></td>
                    </tr>
                    <tr>
                    	<td>both</td>
                    	<td><fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full" /></td>
                    </tr>
                    <tr>
                    	<td>pattern("YYYY-MM-dd HH:mm:ss")</td>
                    	<td><fmt:formatDate value="${now}" pattern="YYYY-MM-dd HH:mm:ss" /></td>
                    </tr>
                </table>
            </div>
            <div class="col-2"></div>
        </div>
    </div>
</body>
</html>