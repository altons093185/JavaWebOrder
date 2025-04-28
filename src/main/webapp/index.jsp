<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
		<link rel="stylesheet" href="/JavaWebOrder/css/buttons.css">
		
		 <script>
        document.addEventListener("DOMContentLoaded", function() {
            fetch('<%=request.getContextPath()%>/api/products')
                .then(response => response.json())
                .then(data => {
                    const ul = document.getElementById("productList");
                    data.forEach(product => {
                        const li = document.createElement("li");
                        li.textContent = product;
                        ul.appendChild(li);
                    });
                })
                .catch(error => {
                    console.error('Error fetching product list:', error);
                });
        });
    </script>
		
	</head>
	<body style="padding: 20px">
	
	<form class="pure-form" method="post" action="/JavaWebOrder/order">
		<fieldset>
				<legend>訂單</legend>
				品名: 
				<select name="item">
					<c:forEach var="product" items="${products}">
				 		<option value="${product.item}">${product.item}</option>
  				 	</c:forEach>
				</select>
				<p />
				<button type="submit" class="button-success pure-button">送出訂單</button>
		</fieldset>
	</form>
	
	<form class="pure-form" action="/JavaWebOrder/order" method="get">
		<button type="submit" class="button-secondary pure-button">查看歷史資料</button>
	</form>
	
	</body>
</html>