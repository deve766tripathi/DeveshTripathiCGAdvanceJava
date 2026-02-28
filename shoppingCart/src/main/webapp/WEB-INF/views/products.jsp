<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Products</title>
</head>
<body>

<h2>Product Catalog</h2>

<table border="1">
<tr>
    <th>Name</th>
    <th>Price</th>
    <th>Quantity</th>
    <th>Action</th>
</tr>

<c:forEach var="p" items="${products}">
<form action="addToCart" method="post">
<tr>
    <td>${p.name}</td>
    <td>${p.price}</td>
    <td>
        <input type="number" name="quantity" value="1"/>
        <input type="hidden" name="productId" value="${p.id}"/>
    </td>
    <td>
        <input type="submit" value="Add to Cart"/>
    </td>
</tr>
</form>
</c:forEach>

</table>

<a href="cart">View Cart</a>

</body>
</html>