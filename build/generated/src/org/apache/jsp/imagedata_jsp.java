package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class imagedata_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <style>\n");
      out.write("    body {\n");
      out.write("      font-family: Arial, sans-serif;\n");
      out.write("      background-color: #f2f2f2;\n");
      out.write("      display: flex;\n");
      out.write("      justify-content: center;\n");
      out.write("      align-items: center;\n");
      out.write("      height: 100vh;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .container {\n");
      out.write("      background-color: #ffffff;\n");
      out.write("      padding: 20px;\n");
      out.write("      border-radius: 5px;\n");
      out.write("      box-shadow: 0 2px 5px rgba(0, 0, 0, 0.3);\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    h1 {\n");
      out.write("      text-align: center;\n");
      out.write("      margin-bottom: 20px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .form-group {\n");
      out.write("      margin-bottom: 20px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    label {\n");
      out.write("      display: block;\n");
      out.write("      font-weight: bold;\n");
      out.write("      margin-bottom: 5px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    input[type=\"file\"] {\n");
      out.write("      display: block;\n");
      out.write("      margin-top: 5px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    input[type=\"submit\"] {\n");
      out.write("      border: none;\n");
      out.write("      background-color: #4CAF50;\n");
      out.write("      color: white;\n");
      out.write("      padding: 10px 20px;\n");
      out.write("      border-radius: 5px;\n");
      out.write("      cursor: pointer;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .success-message {\n");
      out.write("      text-align: center;\n");
      out.write("      margin-top: 20px;\n");
      out.write("      color: green;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .error-message {\n");
      out.write("      text-align: center;\n");
      out.write("      margin-top: 20px;\n");
      out.write("      color: red;\n");
      out.write("    }\n");
      out.write("  </style>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <h1>Image Upload</h1>\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                \n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("        </di>\n");
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
