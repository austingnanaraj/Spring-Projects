<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix = "form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>

<h1>Welcome, Please Login In:</h1>
<form:form method = "POST" commandName="user">
     <table>
         <tr>
              <td>Enter Your Name:</td>
              <td><form:input path="name"/></td>
              <td><form:errors path="name" cssStyle="color:#ff0000"></form:errors>
         </tr>
         <tr>
             <td>Enter Your Password</td>
             <td><form:input path="password"/></td>
             <td><form:errors path="password" cssStyle="color:#ff0000"/></td>
         </tr>
         <tr>
             <td><input type = "submit" name="submit" value="Submit"/></td>
         </tr>
         
     </table>
</form:form>


</body>
</html>
