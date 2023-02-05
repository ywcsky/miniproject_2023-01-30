<%--
Created by IntelliJ IDEA.
User: ywcsk
Date: 2023-01-30
Time: 오후 6:12
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Okky</title>
    <link rel="stylesheet" href="./css/join.css">
</head>
<body>
    <div id="container">
        <header>
            <a href="../index.jsp"><section></section></a>
            <hr>
        </header>
        <nav><p id="hello">OKKY에 오신것을 환영합니다.</p><p>OKKY는 소프트웨어 개발자를 위한 지식공유 플랫폼입니다.</p></nav>
        <main>
            <form action="/join" method="post">
            <section>
                <p class="join-form">아이디</p>
                <input type="text" placeholder="4~15자 이내로 입력해주세요" name="memberId">
                <p class="join-form">비밀번호</p>
                <input type="password" placeholder="최소 6자 이상(알파벳, 숫자 필수)" name="memberPw">
                <p class="join-form">닉네임</p>
                <input type="text" placeholder="별명을 알파벳, 한글, 숫자를 이용하여 10글자 이내로 입력해주세요" name="memberNickName">
                <p class="join-form">이메일</p>
                <input type="email" placeholder="exam@okky.com" name="memberEmail">
                </section>
                <section id="joinButton">
                    <Button type="submit"><p id="join-text">회원가입</p></Button>
                </section>
            </section>
            </form>

        </main>
        <footer></footer>
    </div>
</body>
</html>