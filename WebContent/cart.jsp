<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>cart</title>
<link rel="stylesheet" type="text/CSS" href="./style/style.css" />
</head>

<body>
	<header> <span>truYum</span> <img
		src="./images/truyum-logo-light.png" /> <a id="cart" href="ShowCart">Cart</a>
	<a id="menu" href="ShowMenuItemListCustomer">Menu</a> </header>

	<div>
		<h1 class="cont">Cart</h1>
		<p>${msg}</p>
		<table class="cont">
			<tr>
				<th class="txt-left">Name</th>
				<th class="txt-left">Free Delivery</th>
				<th class="txt-right">Price</th>
				<th></th>

			</tr>
			<c:forEach items="${menuItemList}" var="menu">
				<tr>
					<td class="txt-left">${menu.name}</td>
					<td class="txt-center"><c:if test="${menu.freeDelivery}">Yes</c:if>
						<c:if test="${!menu.freeDelivery}">No</c:if></td>
					<td class="txt-right">Rs.${menu.price}</td>
					<td class="txt-center"><a
						href="RemoveCart?menuItemId=${menu.id}" target="_blank">Delete</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td class="txt-left"></td>
				<th class="txt-left">total</th>
				<th class="txt-right">Rs."${total}"</th>
			</tr>
		</table>
	</div>

	<footer>
	<span>Copyright@2019</span></footer>

</body>
</html>