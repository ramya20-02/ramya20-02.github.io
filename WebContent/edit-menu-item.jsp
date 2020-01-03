<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Edit Menu Item</title>
<link rel="stylesheet" type"text/css" href="./style/style.css" />
<script src="./js/script.js" type="text/javascript"></script>
</head>
<body>
	<header> <span>truYum</span> <img class="img"
		src="./images/truyum-logo-light.png" /> 
		<a id="menu" href="ShowMenuItemListAdmin" />Menu</a> </header>
	<div>
		<h1 class="cont">Edit Menu Item</h1>
		<form class="cont" name="form" onSubmit="return validation()"
			method="post" action="EditMenuItem?menuItemId=${menuItem.id}">
			<table>
				<tr>
					<td colspan="4"><label for="txtName"> Name</label></td></tr>
					<tr>
					<td colspan="4"><input type="text" id="txtName" name="txtName"
						size="100" value="${menuItem.name}"></td>
					</tr>
			    <tr>
					<td><label for="txtPrice">Price(Rs.)</label></td>
					<td>Active</td>
					<td><label for="txtDOL">Date of Launch</label></td>
					<td><label for="Category">Category</label></td>
				</tr>
				<tr>
					
						
		           <td><input type="textbox" id="txtPrice" name="txtPrice"
					        value="${menuItem.price}"></td>

					<td><label for="rdYes">
						<input type="radio" id="rdYes" name="active" value="Yes" <c:if test="${menuItem.active eq 'true'}"> checked="checked"</c:if>>Yes</label> 
						<label for="rdNo"><input type="radio" id="rdNo" name="active" value="No" <c:if test="${menuItem.active eq 'false'}"> checked="checked" </c:if>>No</label>

					</td>
					<td> <fmt:formatDate type="date" pattern="dd/MM/yyyy" value="${menuItem.dateOfLaunch}" var="format"/> <input type="text" id="txtDOL" name="txtDOL"
						value="${format}"/></td>

					<td><select name="category" id="Category">
							<option value="Starters"/>Starters</option>
							<option value="Main Course">Main Course</option>
							<option value="Dessert">Dessert</option>
							<option value="Drinks">Drinks</option>
						</select></td>
				
				<tr>
					<td colspan="2"><input type="checkbox" id="cbDelivery"
						name="freeDelivery" value="Yes"
						<c:if test="${menuItem.freeDelivery eq 'true'}">checked="checked" </c:if>
						<c:if test="${menuitem.freeDelivery eq 'false'}"></c:if>>Free Delivery</label></td>
				</tr>
				<tr>
					<td colspan="2"><input class="color" type="submit"
						value="Save" onclick="validation()"></td>
				</tr>
			</table>
		</form>
	</div>
	<footer> <span>Copyright@2019<span></footer>
</body>
</html>
