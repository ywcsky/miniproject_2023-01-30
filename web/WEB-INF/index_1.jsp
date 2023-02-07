<%--
  Created by IntelliJ IDEA.
  User: ywcsk
  Date: 2023-01-30
  Time: 오후 5:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Okky - All That Developer</title>
    <link rel="stylesheet" href="/css/mainTemplate.css">
    <link rel="stylesheet" href="/css/index.css">
</head>
<body>
<div class="container">
<header>
    <section id="logocon"><a href="/"> <img src="./img/okky-logo-big.png" alt="" id="logo"></a></section>
    <nav id="category">
        <ul id="category_list">
            <li class="menu"><a href="/border/qna?page=1">Q&A</a></li>
            <li class="menu"><a href="/border/community?page=1">커뮤니티</a></li>
            <li class="menu"><a href="/border/it?page=1">지식</a></li>
            <li class="menu"><a href="/border/notice?page=1">공지사항</a></li>
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
        <div class="login_info_container">
            <span class="login_info">${sessionScope.memberId}님 환영합니다.</span>
            <input type="hidden" id="member-Id" value="${sessionScope.memberId}">
        <div class="login_info_button_container">
            <button class="login_info_button">내정보수정</button><a href="/logout"><button class="login_info_button">로그아웃</button></a>
        </div>
        </div>
    </c:if>
</header>
<div class="content_container">
    <hr style="margin: 0; color: #ccc;">
    <main>
        <aside id="menu">슬라이드 이미지</aside>
        <section id="section">
            <section id="qna">
                <ul>
                    <li><a href="/border/qna?page=1">
                        <div id="qna-container" class="mainPageList"><p class="icon-name">Q&A</p><img
                                src="./img/questions.svg" alt="" class="icon"></div>
                    </a></li>
                        <c:forEach items="${bList_1 }" var="border">
                            <li class="index"><span>${border.memberNickname}</span> · <span>${border.borderDate}</span><br><span><a href="/border?no=${border.borderNo}">${border.borderSubject}</a></span></li>
                            <hr>
                        </c:forEach>
            </section>
            <section id="comunity">
                <ul>
                    <li>
                        <a href="/border/community">
                            <div id="comunity-container" class="mainPageList">
                                <p class="icon-name">커뮤니티</p>
                                <img src="./img/community.svg" alt="" class="icon">
                            </div>
                        </a></li>
                    <c:forEach items="${bList_2 }" var="border">
                        <li class="index"><span>${border.memberNickname}</span> · <span>${border.borderDate}</span><br><span><a href="/border?no=${border.borderNo}">${border.borderSubject}</a></span></li>
                        <hr>
                    </c:forEach>
                </ul>
            </section>
            <section id="it">
                <ul>
                    <li><a href="/border/it">
                        <div id="it-container" class="mainPageList"><p class="icon-name">지식</p><img src="./img/it.svg"
                                                                                                    alt="" class="icon">
                        </div>
                    </a></li>
                    <c:forEach items="${bList_3 }" var="border">
                        <li class="index"><span class="index_border_span">${border.memberNickname} · ${border.borderDate}</span><br><span class="index_border_span_subject"><a href="/border?no=${border.borderNo}">${border.borderSubject}</a></span></li>
                        <hr>
                    </c:forEach>
                </ul>
            </section>
            <section id="notice">
                <ul>
                    <li><a href="/border/notice">
                        <div id="notice-container" class="mainPageList"><p class="icon-name">공지사항</p><img
                                src="./img/notice.svg" alt="" class="icon"></div>
                    </a></li>
                    <c:forEach items="${bList_4 }" var="border">
                        <li class="index"><span>${border.memberNickname}</span> · <span>${border.borderDate}</span><br><span><a href="/border?no=${border.borderNo}">${border.borderSubject}</a></span></li>
                        <hr>
                    </c:forEach>
                </ul>
            </section>
        </section>
    </main>
</div>
</div>
<footer>
    <span>대표이사 : 서정민 | 이메일 : ywcsky2@gmail.com | 사업자 등록번호 : 999-99-99999 | 주소지 : 서울특별시 을지로 KH정보교육원 | 전화번호 : 010.7725.7340</span>
</footer>
<script>

</script>
</body>
</html>
