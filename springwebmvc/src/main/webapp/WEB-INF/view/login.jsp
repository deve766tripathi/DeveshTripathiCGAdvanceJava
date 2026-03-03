<%@ page isELIgnored="false" %>
<h2>Login</h2>

<span style="color:red">${error}</span>

<form action="login" method="post">
    Username: <input type="text" name="username"/><br><br>
    Password: <input type="password" name="password"/><br><br>
    <input type="submit" value="Login"/>
</form>

<a href="register">Go to Register</a>