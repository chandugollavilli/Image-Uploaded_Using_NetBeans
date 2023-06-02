package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.commons.fileupload.FileItem;
import java.util.List;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;

public final class upload_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
