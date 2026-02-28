<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Cart</title>
</head>
<body>

<h2>Your Cart</h2>

<table border="1">
<tr>
    <th>Product</th>
    <th>Quantity</th>
    <th>Total</th>
</tr>

<c:forEach var="item" items="${cartItems}">
<tr>
    <td>${item.product.name}</td>
    <td>${item.quantity}</td>
    <td>${item.totalPrice}</td>
</tr>
</c:forEach>

</table>

<h3>Total Amount: ${total}</h3>

<a href="products">Continue Shopping</a>

</body>
</html>