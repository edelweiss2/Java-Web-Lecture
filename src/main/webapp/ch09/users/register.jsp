<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register User</title>
    <style>
        td { text-align: center; padding: 3px;}
    </style>
</head>
<body style="margin: 40px;">
    <h1>사용자 등록</h1>
    <hr>
    <form action="/jw/ch12/users2/register" method="post">        
        <table>
            <tr>
                <td>UID</td>
                <td><input type="text" name="uid" value=""></td>
            </tr>
            <tr>
                <td>PWD</td>
                <td><input type="text" name="pwd" value=""></td>
            </tr>
            <tr>
                <td>이름</td>
                <td><input type="text" name="uname" value="" ></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="text" name="email" value="" ></td>
            </tr>            
            <tr>
                <td colspan="2"><input type="submit" value="사용자등록"></td>
            </tr>
        </table>
    </form>
</body>
</html>