package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class BookTaxies_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Book a taxi</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
 //request.setAttribute("bookerr"," ");
      out.write("\n");
      out.write("\n");
      out.write("        <h1>Book a Taxi</h1>\n");
      out.write("        <form action=\"checkBook\" method=\"post\">\n");
      out.write("            Enter the PickUp Location :\n");
      out.write("            <select name=\"start_loc\" required>\n");
      out.write("                <option value=\"1\">DLF</option>\n");
      out.write("                <option value=\"2\">Velachery</option>\n");
      out.write("                <option value=\"3\">Tambaram</option>\n");
      out.write("                <option value=\"4\">T Nagar</option>\n");
      out.write("                <option value=\"5\">Nungambakkam</option>\n");
      out.write("            </select><br><br>\n");
      out.write("            Enter the Drop Location :\n");
      out.write("            <select name=\"drop_loc\" required>\n");
      out.write("                <option value=\"1\">DLF</option>\n");
      out.write("                <option value=\"2\">Velachery</option>\n");
      out.write("                <option value=\"3\">Tambaram</option>\n");
      out.write("                <option value=\"4\">T Nagar</option>\n");
      out.write("                <option value=\"5\">Nungambakkam</option>\n");
      out.write("            </select><br><br>\n");
      out.write("            Enter the PickUp Time\n");
      out.write("            <input type=\"text\" name=\"user_time\" autocomplete=\"off\" required>\n");
      out.write("            <br><br>\n");
      out.write("            <div style=\"color: red\">\n");
      out.write("                ");

                    try {
                        String temperr = request.getAttribute("bookerr").toString();
                        if (temperr != null) {
                            out.println(temperr);
                        }
                    } catch (Exception e) {
                        System.out.println("Exception " + e);
                    }
                
      out.write("\n");
      out.write("                ");
request.removeAttribute("bookerr");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <input type=\"submit\" name=\"bookbtn\" value=\"Book\">\n");
      out.write("            <br>\n");
      out.write("        </form><br>\n");
      out.write("        <form action=\"logout\" method=\"get\">\n");
      out.write("            <button type=\"submit\" name=\"logbtn\">Logout</button>\n");
      out.write("        </form>\n");
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
