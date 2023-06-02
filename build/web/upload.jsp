<%-- 
    Document   : upload
    Created on : 21 May, 2023, 10:05:45 PM
    Author     : chand
--%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@ page import="java.io.*, java.sql.*, javax.servlet.*, javax.servlet.http.*" %>
<%@ page import="org.apache.commons.fileupload.servlet.ServletFileUpload" %>
<%@ page import="org.apache.commons.fileupload.FileItemFactory" %>
<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory" %>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Img Page</title>
    </head>
    <body>
        <%
   // Check if the request is a multipart/form-data
   boolean isMultipart = ServletFileUpload.isMultipartContent(request);

   if (isMultipart) {
      // Create a factory for disk-based file items
      DiskFileItemFactory factory = new DiskFileItemFactory();

      // Set the temporary directory for storing uploaded files
      factory.setRepository(new File("C:/temp")); // Replace with your desired temporary directory

      // Create a new file upload handler
      ServletFileUpload upload = new ServletFileUpload(factory);

      // Parse the request to get file items
      List<FileItem> items = upload.parseRequest(request);

      // Process each file item
      for (FileItem item : items) {
         if (!item.isFormField()) {
            // Retrieve the uploaded file
            String fileName = item.getName();
            InputStream fileContent = item.getInputStream();

            // Database connection details
            String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
            String dbUser = "postgres";
            String dbPassword = "1234";

            Connection conn = null;
            PreparedStatement pstmt = null;

            try {
               // Establish database connection
               Class.forName("org.postgresql.Driver");
               conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

               // Prepare the SQL statement
               String sql = "INSERT INTO image (filename, data) VALUES (?, ?)";
               pstmt = conn.prepareStatement(sql);
               pstmt.setString(1, fileName);
               pstmt.setBinaryStream(2, fileContent);

               // Execute the SQL statement
               pstmt.executeUpdate();

               // Close the database connection and resources
               pstmt.close();
               conn.close();

               // Redirect to a success page
               response.sendRedirect("imagedata.jsp");
            } catch (Exception e) {
               e.printStackTrace();
               // Redirect to an error page
               response.sendRedirect("error.jsp");
            } finally {
               // Close the input stream
               if (fileContent != null) {
                  fileContent.close();
               }
            }
         }
      }
   } else {
      // Handle the case when the request is not a multipart/form-data
      response.sendRedirect("error.jsp");
   }
%>


    </body>
</html>
