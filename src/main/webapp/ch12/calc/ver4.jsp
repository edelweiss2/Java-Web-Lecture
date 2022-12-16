<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>한자리수 계산기</title>
    <style>
        button  {height: 50px; width: 50px; text-align: center; font-size: 20px;}
        .result {height: 50px; text-align: right; padding: 0px 5px;
                 font-size: 20px; font-weight: bold; background-color: gainsboro;}
    </style>
</head>
<body style="margin: 50px;">
    <h1>계산기 Ver.3 (한자리수 계산기)</h1>
    <hr>
    <form action="/jw/ch12/calc/ver4" method="post">
        <table>
            <tr>
                <!-- <td class="result" colspan="4"><%= request.getAttribute("eval") %></td> -->
                <td class="result" colspan="4">${eval}</td>			<!-- Expression Language(EL) -->
            </tr>
            <tr>
                <td><button type="submit" name="op" value="C">BS</button></td>
                <td><button type="submit" name="op" value="/">÷</button></td>
                <td><button type="submit" name="op" value="*">×</button></td>
                <td><button type="submit" name="op" value="-">－</button></td>
            </tr>
            <tr>
                <td><button type="submit" name="num" value="7">7</button></td>
                <td><button type="submit" name="num" value="8">8</button></td>
                <td><button type="submit" name="num" value="9">9</button></td>
                <td rowspan="2"><button type="submit" name="op" value="+" style="height: 105px;">＋</button></td>
            </tr>
            <tr>
                <td><button type="submit" name="num" value="4">4</button></td>
                <td><button type="submit" name="num" value="5">5</button></td>
                <td><button type="submit" name="num" value="6">6</button></td>
            </tr>
            <tr>
                <td><button type="submit" name="num" value="1">1</button></td>
                <td><button type="submit" name="num" value="2">2</button></td>
                <td><button type="submit" name="num" value="3">3</button></td>
                <td rowspan="2"><button type="submit" name="op" value="=" style="height: 105px;">＝</button></td>
            </tr>
            <tr>
                <td colspan="3"><button type="submit" name="num" value="0" style="width: 159px;">0</button></td>
            </tr>
        </table>
    </form>
</body>