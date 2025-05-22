<form action="login" method="post">
    <label>Email:</label>
    <input type="text" name="email" required><br>
    <label>Password:</label>
    <input type="password" name="password" required><br>
    <input type="submit" value="Login">
</form>

<% if (request.getParameter("error") != null) { %>
    <p style="color:red;">Invalid email or password!</p>
<% } %>
