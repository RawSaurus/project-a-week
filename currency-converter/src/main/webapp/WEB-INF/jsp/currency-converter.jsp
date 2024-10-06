<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.rawsaurus.currency.model.Currency" %>
<html>
<head>
	<title>Converter</title>
<style>
.converter {
color: red;
text-align: center;
}
</style>
</head>
<body>
    <div class="converter">
        <h1>Converter</h1>
    </div>
    <div>
        <form action="converter" method="POST">
            <input type="text" id="value1" name="value1" value="<%= String value1">
        </form>
        <p>'<%=request.getAttribute("value2")%>'</p>
    </div>
</body>
</html>


