<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome ${user.name} </h1>

<h2>Your Basic Information:</h2>
<h3>Age:</h3>${user.age}
<h3>Gender:</h3>${user.gender}
<h3>Hobby:</h3>${user.hobby }

</body>
</html>