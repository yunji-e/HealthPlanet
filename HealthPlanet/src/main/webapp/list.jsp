<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 이후 스타일시트로 분리 필요 -->
<style type="text/css">
	.card {
		display: inline-block;
		border-radius: 5px;
		padding: 5px;
		margin: 5px;
		box-shadow: 2px 2px 10px 3px;
	}
</style>


</head>
<body>
<c:forEach var="post" items="${postList}">
	<a href='<c:url value="/shop/viewProduct.do">
          <c:param name="postid" value="${post.postid}"/></c:url>'>
		<div class="card" onClick="" style="cursor:pointer;">
			<h5>${post.title}</h5>
			<p>${post.custid}</p>
			<p>${post.schedule}</p>
			<!-- 참여상태체크 -->
			<c:choose>
				<c:when test="${post.myState}">
					<a>신청취소</a>
				</c:when>
				<c:otherwise>
					<a>신청하기</a>
				</c:otherwise>
			</c:choose>
		</div>
	</a>
</c:forEach>




</body>
</html>