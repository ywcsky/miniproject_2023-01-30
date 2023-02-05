<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Okky - 공지사항</title>
    <link rel="stylesheet" href="./css/mainTemplate.css">

</head>
<body>
    <div id="container">
        <header>
            <section id="logocon" ><a href="../index.jsp"> <img src="./img/okky-logo-big.png" alt="" id="logo"></a></section>
            <nav id="category">
                <ul id="category_list">
                    <li class="menu"><a href="/border/qna">Q&A</a></li>
                    <li class="menu"><a href="/border/community">커뮤니티</a></li>
                    <li class="menu"><a href="/border/it">지식</a></li>
                    <li class="menu"><a href="/border/notice">공지사항</a></li>
                </ul>
            </nav>
            <section id="searchcon">
                <input type="text" id="searchbar" placeholder="검색">
            </section>
            <c:if test="${sessionScope.memberId eq null}">
                <section id="member">
                    <button id="login" onclick="location.href='/login'">로그인</button>
                    <button id="join" onclick="location.href='/join'">회원가입</button>
                </section>
            </c:if>
            <c:if test="${sessionScope.memberId ne null}">
                <span>${sessionScope.memberId}님 환영합니다.</span>
                <input type="hidden" id="member-Id" value="${sessionScope.memberId}">
            </c:if>
        </header>
        <hr style="margin: 0; color: #ccc;">
        <main>
            <aside id="menu">슬라이드 이미지</aside>
            <section id="section">
            <section id="main">

            </section>
        </section>
        </main>
        <footer></footer>
    </div>
</body>
</html>