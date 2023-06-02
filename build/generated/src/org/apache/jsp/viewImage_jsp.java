package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class viewImage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>View Image</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    ");

        // Database connection details
        String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
        String dbUser = "postgres";
        String dbPassword = "1234";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Establish database connection
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

            // Get the image data from the database
            String sql = "SELECT data FROM image WHERE filename = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "<filename>"); // Replace <filename> with the actual filename of the image
            rs = pstmt.executeQuery();

            if (rs.next()) {
                // Retrieve the image data
                Blob imageBlob = rs.getBlob("data");
                byte[] imageData = imageBlob.getBytes(1, (int) imageBlob.length());

                // Set the appropriate content type for the image
                response.setContentType("image/jpeg"); // Change the content type as per your image type

                // Write the image data to the response output stream
                response.getOutputStream().write(imageData);
                response.getOutputStream().flush();
            } else {
                // Image not found in the database
                out.println("Image not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.println("An error occurred while retrieving the image");
        } finally {
            // Close the database connection and resources
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
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
