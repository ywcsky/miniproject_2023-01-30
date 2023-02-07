<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Okky - QnA</title>
  <link rel="stylesheet" href="/css/mainTemplate.css">
  <link rel="stylesheet" href="/css/qna.css">
  <link rel="stylesheet" href="/css/view.css">

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
    <section class="main_section">
      <table>
        <tr><th class="table_subject">${border.borderSubject}</th><td class="table_date">${border.borderDate}</td></tr>
        <tr><td class="table_writer">${border.memberNickname}</td><td class="table_count"><img src="/img/count.svg" class="count_img">${border.borderCount}</td></tr>
        <tr><td colspan="2" class="table_content"><span>${border.borderContent}</span></td></tr>
      </table>
    </section>
    <div class="main_section_button">
      <button class="button_back" onclick="history.back()"></button><button class="button_write" onclick="location.href='/write'"></button>
    </div>
  </main>
</div>
<footer>
  <span>대표이사 : 서정민 | 이메일 : ywcsky2@gmail.com | 사업자 등록번호 : 999-99-99999 | 주소지 : 서울특별시 을지로 KH정보교육원 | 전화번호 : 010.7725.7340</span>
</footer>
</body>
</html>