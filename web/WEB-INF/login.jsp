<%--
Created by IntelliJ IDEA.
User: ywcsk
Date: 2023-01-30
Time: 오후 6:12
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인</title>
    <link rel="stylesheet" href="../css/login.css">
</head>
<body>
    <form action="/login" method="post">
    <div id="container">
        <header>
            <a href="../index.jsp"><section></section></a>
            <hr>
        </header>
        <nav><p id="hello">OKKY에 오신것을 환영합니다.</p><p>OKKY는 소프트웨어 개발자를 위한 지식공유 플랫폼입니다.</p></nav>
        <main>
            <section>
                <p id="userId">아이디</p>
                <input type="text" name="memberId">
                <p id="userPwd">비밀번호</p>
                <input type="password" name="memberPw">
                <section id="findUser">
                <a href="#">계정찾기</a>
                </section>
                <section id="loginButton">
                    <Button type="submit"><p id="login-text">로그인</p></Button>
                    <span>
                        아직 회원이 아니신가요? <a href="/join">회원가입</a>
                    </span>
                </section>
            </section>
        </main>

    </div>
    </form>
    <footer>
        <span>대표이사 : 서정민 | 이메일 : ywcsky2@gmail.com | 사업자 등록번호 : 999-99-99999 | 주소지 : 서울특별시 을지로 KH정보교육원 | 전화번호 : 010.7725.7340</span>
    </footer>
</body>
</html>