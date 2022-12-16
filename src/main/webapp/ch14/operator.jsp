<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<body style="height: 2000px;">

    <div class="container-fluid p-5 bg-primary text-white text-center">
        <h1>JSP EL(Expression Language)</h1>
        <p>1.연산자</p>
    </div>

    <div class="container mt-5">
        <div class="row">
            <div class="col-2"></div>
            <div class="col-8">
                <table class="table">
                    <tr>
                        <th>계산식</th>
                        <th>결과</th>
                    </tr>
                    <tr><td>\${100}</td><td>${100}</td></tr>
                    <tr><td>\${"안녕하세요"}</td><td>${"안녕하세요"}</td></tr>
                    <tr><td>\${10+1}</td><td>${10+1}</td></tr>
                    <tr><td>\${"10"+"1"}</td><td>${"10"+"1"}</td></tr>
                    <tr><td>\${null+100}</td><td>${null+100}</td></tr>
                 <%--    <tr><td>\${"안녕"+11}</td><td>${"안녕"+11}</td></tr>  --%>
                 <%--   <tr><td>\${"Hello"+"World"}</td><td>${"Hello"+"World"}</td></tr> --%>
                 	<tr><td></td><td></td></tr>
                 	<tr><td>\${10+10}</td><td>${10+10}</td></tr>
                 	<tr><td>\${3 div 2}</td><td>${3 div 2}</td></tr>
                 	<tr><td>\${100 % 9}</td><td>${100 % 9}</td></tr>
                 	<tr><td>\${100 mod 9}</td><td>${100 mod 9}</td></tr>
                 	<tr><td></td><td></td></tr>
                 	<tr><td>\${10==10}</td><td>${10==10}</td></tr>
                 	<tr><td>\${10 eq 10}</td><td>${10 eq 10}</td></tr>
                 	<tr><td>\${10 > 10}</td><td>${10 > 10}</td></tr>
                 	<tr><td>\${10 gt 10}</td><td>${10 gt 10}</td></tr>
                 	<tr><td>\${"hello" == "hello"}</td><td>${"hello" == "hello"}</td></tr>
                 	<tr><td>\${"hello" eq "hello"}</td><td>${"hello" eq "hello"}</td></tr>
                 	<tr><td></td><td></td></tr>
                 	<tr><td>\${10==10 && 20==20}</td><td>${10==10 && 20==20}</td></tr>
                 	<tr><td>\${10==11 and 20==20}</td><td>${10==11 and 20==20}</td></tr>
                 	<tr><td>\${10==9 and 20==10}</td><td>${10==9 and 20==10}</td></tr>
                 	<tr><td>\${not 10==10}</td><td>${not(10==10)}</td></tr>
                 	<tr><td></td><td></td></tr>
                 	<tr><td>\${empty "hello"}</td><td>${empty "hello"}</td></tr>
                 	<tr><td>\${empty ""}</td><td>${empty ""}</td></tr>
                 	<tr><td>\${empty null}</td><td>${empty null}</td></tr>
                </table>
            </div>
            <div class="col-2"></div>
        </div>
       <strong>파라미터 값은 ${empty param.num ? "입력하지 않음" : param.num } (?num="param.num")입니다. </strong>
    </div>    

</body>

</html>