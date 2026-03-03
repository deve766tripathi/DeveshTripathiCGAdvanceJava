<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<style>
    body { text-align:center; font-family:Arial; }
    button {
        padding:10px 25px;
        margin:10px;
        font-size:16px;
        cursor:pointer;
    }
</style>
</head>
<body>

<h1>Welcome to User Portal</h1>

<form action="login" method="get" style="display:inline;">
    <button type="submit">Login</button>
</form>

<form action="register" method="get" style="display:inline;">
    <button type="submit">Register</button>
</form>

</body>
</html>