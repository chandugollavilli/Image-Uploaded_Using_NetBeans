<%-- 
    Document   : img_upload
    Created on : 21 May, 2023, 10:04:46 PM
    Author     : chand
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Image Upload Form</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f2f2f2;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }

    .container {
      background-color: #ffffff;
      padding: 20px;
      border-radius: 5px;
      box-shadow: 0 2px 5px rgba(0, 0, 0, 0.3);
    }

    h1 {
      text-align: center;
      margin-bottom: 20px;
    }

    .form-group {
      margin-bottom: 20px;
    }

    label {
      display: block;
      font-weight: bold;
      margin-bottom: 5px;
    }

    input[type="file"] {
      display: block;
      margin-top: 5px;
    }

    input[type="submit"] {
      border: none;
      background-color: #4CAF50;
      color: white;
      padding: 10px 20px;
      border-radius: 5px;
      cursor: pointer;
    }

    .success-message {
      text-align: center;
      margin-top: 20px;
      color: green;
    }

    .error-message {
      text-align: center;
      margin-top: 20px;
      color: red;
    }
  </style>
</head>
<body>
  <div class="container">
    <h1>Image Upload Form</h1>
    <form action="upload.jsp" method="POST" enctype="multipart/form-data">
      <div class="form-group">
        <label for="image">Select Image:</label>
        <input type="file" id="image" name="image" accept="image/*" required>
      </div>
      <input type="submit" value="Upload Image">
    </form>
  </div>
</body>
</html>

