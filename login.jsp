<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</head>
<body>
<p style="display:none" id="msg"></p>
<form action="" method="post">
<label for="username">enter username: </label><input type="text" name="username" id = "username"> <br />
<label for="password">enter password: </label><input type="text" name="password" id="password"> <br />
<input type="submit" value="login" id="sub"/>
</form>
</body>
<script>
$(document).ready(function(){
	$("#sub").click(function(e){
		e.preventDefault();
		$.ajax({
			url:"LoginServlet",
			method : "POST",
			data : {username : $("#username").val(),password : $("#password").val()},
			success : function(res){
				if(res.status == "success"){
					alert("you have successfully loggedin, you can proceed to checkout now");
					window.location.href = "cart.jsp";
				}
				else{
					$("#username").val("");
					$("#password").val("");
					$("#msg").css("display","block");
					$("#msg").css("color","red");
					$("#msg").text("invalid username or password");
				}
			}
		})
	})
})
</script>
</html>