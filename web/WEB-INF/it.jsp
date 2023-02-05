<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Okky - IT</title>
    <link rel="stylesheet" href="/css/mainTemplate.css">
    <link rel="stylesheet" href="/css/qna.css">

</head>
<body>
<div class="container">
    <header>
        <section id="logocon" ><a href="/"> <img src="/img/okky-logo-big.png" alt="" id="logo"></a></section>
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
                    <button class="login_info_button">내정보수정</button><button onclick="location.href='/logout'" class="login_info_button">로그아웃</button>
                </div>
            </div>
        </c:if>
    </header>
    <hr style="margin: 0; color: #ccc;">
    <main>
        <aside id="menu">슬라이드 이미지</aside>
        <section id="section">
            <section id="main">
                <section id="main-container">
                    <div class="content_banner">
                        <p id="main-icon">IT</p><p id="qna-ment">여러분의 지식을 나눠주세요!</p><img src="/img/questions.svg" alt="qna아이콘" id="icon">
                    </div>
                    <div class="content_list">
                        <ul class="main_list">
                            <c:forEach items="${bList }" var="border">
                                <li class="main_list_li"><span>${border.memberNickname}</span> · <span>${border.borderDate}</span>
                                    <br><span class="li_subject">${border.borderSubject}</span> <img src="/img/count.svg" class="count_img"><span class="li_count">${border.borderCount}</span>
                                </li><hr>
                            </c:forEach>
                            <li class="border_paging_li">
                                ${pageNavi }
                            </li>
                        </ul>
                    </div>
                </section>
            </section>
        </section>
    </main>
    <footer></footer>
    </div>
</body>
</html>