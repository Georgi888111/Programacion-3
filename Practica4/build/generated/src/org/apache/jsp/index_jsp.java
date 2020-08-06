package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <body>\n");
      out.write("        <form action=\"index.jsp\" method=\"post\" onsubmit=\"return validaCampos()\" name=\"form1\" id=\"form1\">\n");
      out.write("            Nombre<input type=\"text\" name=\"nombre\" id=\"nombre\">  \n");
      out.write("            Apellido<input type=\"text\" name=\"apellido\" id=\"apellido\">  \n");
      out.write("            Telefono<input type=\"number\" name=\"telefono\" id=\"telefono\">\n");
      out.write("            <input type=\"submit\" value=\"Enviar datos\">\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("    \n");
      out.write("    <script>\n");
      out.write("        validaCampos(){\n");
      out.write("            var nombre = document.getElementById('nombre');\n");
      out.write("            var apellido = document.getElementById('apellido');\n");
      out.write("            var telefono = document.getElementById('telefono');\n");
      out.write("            var contador =0;\n");
      out.write("            if(nombre.value ==''||apellido.value==''||telefono.value==''){\n");
      out.write("                alert('Verifique que lleno todos los campos');\n");
      out.write("                contador++;\n");
      out.write("            }else{\n");
      out.write("                if((isNaN(telefono.value))||( !(/^\\d{9}$/.test(telefono.value)))){\n");
      out.write("                    alert('verifique que su telefono esta ingresado correctamente');\n");
      out.write("                    contador++;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            if(contador>0){\n");
      out.write("                return false;\n");
      out.write("            }else{\n");
      out.write("                return true;\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("    </script>\n");
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
