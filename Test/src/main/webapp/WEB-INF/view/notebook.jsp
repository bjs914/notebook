<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<style>
textarea {
	vertical-align: top;
}

table, td, th {
	border: 1px solid black;
	border-collapse: collapse;
}

.table {
	
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${note }</h1><p/>
	${text }<p/>
	<%-- <c:if test="${delCount eq 1}">메모 "${delSeqNo}"번 삭제됨</c:if> --%>
	<form:form method="POST" modelAttribute="memo">
	<div>
		<label for="memoContent">메모</label>
		<form:textarea id="memoContent" path="content" rows="3" cols="30"/>
	<input type="submit" id="btnAdd" value="저장" />
	</div>
	<hr>
		<table>
			<th>번호</th>
			<th>내용</th>
			<th>연산1</th>
			<c:forEach items="${memoList}" var="mList"><!-- items : model이름을 의미 -->
				<c:url var="deleteLink" value="/deleteMemo">
					<c:param name="seqNo" value="${mList.seqNo}" />
				</c:url>
				<tr>
					<td>${mList.seqNo}</td>
					<td>${mList.content}</td>
					<td>
					<button>
					<%-- <a href="${deleteLink}"
						onclick="if(!(confirm('정말'+${mList.seqNo}+'번글을 삭제하시겠습니까?)))"></a> --%>
					삭제</button>	</td>
				</tr>
			</c:forEach>
		</table>
	</form:form>
<!-- 	<script type="text/javascript">
		function memoDelete(seqNo){
			if (!(confirm('정말' + seqNo + '번글을 삭제하겠습니까?'))) return false;
		function checkContent(){
			if(document.getElementById("memoContent").value.trim()=='')
				{
				alert("내용이 있어야 저장됩니다.");
				return false;
				}
		}
		}
	</script> -->
</body>
</html>