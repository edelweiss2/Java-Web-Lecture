<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="java.util.*" %>
<c:set var="title1" value="Hello World!" />
<c:set var="title2" value="쇼핑몰 중심 JSP Mall" />
<c:set var="str1" value="Hello World!" />

<!DOCTYPE html>
<html lang="ko">
<head>
    <title>Fcuntion</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://kit.fontawesome.com/c274ddffaf.js" crossorigin="anonymous"></script>
</head>
<body>

    <div class="container-fluid p-5 bg-primary text-white text-center">
        <h1>JSTL(JSP Standard Tag Library)</h1>
        <p>3. function</p>
    </div>

    <div class="container mt-5">
        <div class="row">
            <div class="col-2"></div>
            <div class="col-8">
                 <table class="table">
                    <tr><th>표현방법</th><th>값</th></tr>
                    <tr>
                    	<td>fn:length(title1)</td>
                    	<td>${fn:length(title1)}</td>
                    </tr>
                    <tr>
                    	<td>fn:toUpperCase(title1)</td>
                    	<td>${fn:toUpperCase(title1)}</td>
                    </tr>
                    <tr>
                    	<td>fn:substring(title1, 3, 6)</td>
                    	<td>${fn:substring(title1, 3, 6)}</td>
                    </tr>
                    <tr>
                    	<td>fn:replace(title1, " ", "/")</td>
                    	<td>${fn:replace(title1, " ", "/")}</td>
                    </tr>
                    <tr>
                    	<td>fn:indexOf(title2, str1)</td>
                    	<td>${fn:indexOf(title2, str1)}</td>
                    </tr>
                    <tr>
                    	<td>fn:contains(title1)</td>
                    	<td>${fn:contains(title2, str1)}</td>
                    </tr>
                </table>
                
            </div>
            <div class="col-2"></div>
        </div>
    </div>    
</body>
</html>