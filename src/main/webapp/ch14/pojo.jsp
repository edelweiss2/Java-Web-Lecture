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

<body>

    <div class="container-fluid p-5 bg-primary text-white text-center">
        <h1>JSP EL(Expression Language)</h1>
        <p>4.POJO </p>
    </div>

    <div class="container mt-5">
        <div class="row">
            <div class="col-2"></div>
            <div class="col-8">
                <table class="table">
                    <tr><th>표현식</th><th>결과</th></tr>
                    <tr><td>\${m1.id}</td><td>${m1.id}</td></tr>
                    <tr><td>\${m1.name}</td><td>${m1.name}</td></tr>
                    <tr><td>\${m1.addr.city}</td><td>${m1.addr.city}</td></tr>
                    <tr><td></td><td></td></tr>
                    <tr><td>\${m2.id}</td><td>${m2.id}</td></tr>
                    <tr><td>\${m2.name}</td><td>${m2.name}</td></tr>
                    <tr><td>\${m2.addr.city}</td><td>${m2.addr.city}</td></tr>
                    <tr><td></td><td></td></tr>
                    <tr><td>\${members[0].id}</td><td>${members[0].id}</td></tr>
                    <tr><td>\${members[0].name}</td><td>${members[0].name}</td></tr>
                    <tr><td>\${members[0].addr.city}</td><td>${members[0].addr.city}</td></tr>
                    <tr><td></td><td></td></tr>
                    <tr><td>\${members[1].id}</td><td>${members[1].id}</td></tr>
                    <tr><td>\${members[1].name}</td><td>${members[1].name}</td></tr>
                    <tr><td>\${members[1].addr.city}</td><td>${members[1].addr.city}</td></tr>
                    <tr><td></td><td></td></tr>
                </table>
            </div>
            <div class="col-2"></div>
        </div>
    </div>    

</body>

</html>