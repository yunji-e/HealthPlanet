
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Health Planet</title>
    <style>
       .title {
          font-size: 300%;
       }
       .subTitle { color: lightgray; }
    </style>
    <link rel="stylesheet" th:href="@{/css/cards.css}"/>
    <script type="text/javascript" th:src="@{/js/cards.js}"></script>
</head>
<body>
    
   <h2 th:if="${session.username}">Welcome, <span th:text="${session.username}"></span>!</h2>
    
   <!-- nav html 생성 및 삽입 필요 -->
   
   <div align="center" style="line-height:50%; margin: 10%;">
      <h1 class="title">Health Planet</h1>
      <p class="subTitle">당신의 운동 모임 서비스</p>
      <br><br><br>
      <a href="/logout" th:if="${session.username}">Logout</a>
        <a href="/myPage" th:if="${session.username}">myPage</a>
        <a href="/signup" th:unless="${session.username}">회원가입</a>
        <a href="/login" th:unless="${session.username}">로그인</a>
   </div>
   
   <a href="/meetings/search">Search Meetings</a>
   
   <a href="/popular/list">실시간 인기 모임</a>
   <div th:replace="~{postTemplete :: flipCards}"></div>
   
   <p>전체 글 view(css 개선 필요)</p>
   <div th:replace="~{postTemplete :: posts}"></div>
   <a th:href="@{/meetings/register}"><button>모임 생성하기</button></a>
   
</body>
</html>
