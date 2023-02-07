<%--
  Created by IntelliJ IDEA.
  User: ywcsk
  Date: 2023-02-04
  Time: 오후 2:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Okky : 내정보관리</title>
</head>
<body>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Okky - All That Developer</title>
  <link rel="stylesheet" href="/css/mainTemplate.css">
  <link rel="stylesheet" href="/css/index.css">
</head>
<body>
<div class="container">
  <header>
    <section id="logocon"><a href="index_1.jsp"> <img src="./img/okky-logo-big.png" alt="" id="logo"></a></section>
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
      <div class="login_info_container">
        <span class="login_info">${sessionScope.memberId}님 환영합니다.</span>
        <input type="hidden" id="member-Id" value="${sessionScope.memberId}">
        <div class="login_info_button_container">
          <button class="login_info_button">내정보수정</button><a href="/logout"><button class="login_info_button">로그아웃</button></a>
        </div>
      </div>
    </c:if>
  </header>
  <section class="content_container">

  </section>
</div>
</body>
</html>
