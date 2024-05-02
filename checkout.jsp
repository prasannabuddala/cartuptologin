<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Checkout</title>
    <style>
     body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f2f2f2;
        }

        .container {
            max-width: 600px;
            margin: 50px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center;
        }

        h1 {
            margin-bottom: 20px;
        }

        p {
            margin-bottom: 20px;
        }

        button {
            padding: 10px 20px;
            cursor: pointer;
            background-color: #007bff; /* Blue color */
            color: #fff;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            transition: background-color 0.3s ease;
        }

        button a {
            color: #fff;
            text-decoration: none;
        }

        button:hover {
            background-color: #0056b3; /* Darker blue color on hover */
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Order Placed Successfully!</h1>
    <% 
        String totalAmount = request.getParameter("totalAmount");
        if (totalAmount != null) { 
    %>
    <p>Your order total is: <%= totalAmount %></p>
    <% } else { %>
    <p>Unable to retrieve total amount.</p>
    <% } %>
    <br />
    <button><a href="index.jsp">back to homepage</a></button>
    </div>
</body>
</html>
