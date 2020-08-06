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
      out.write("        <title>Practica Final Febrero 2020</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form method=\"POST\"  action=\"destino.jsp\">\n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Letra</td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"text\" name=\"letra\" value=\"\"id=\"letra\">\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Numero</td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"number\" name=\"numero\" value=\"\" id=\"numero\">\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Tipo</td>\n");
      out.write("                    <td>\n");
      out.write("                        <select name=\"tipo\">\n");
      out.write("                            <option value=\"E\">E</option>\n");
      out.write("                            <option value=\"N\">N</option>\n");
      out.write("                            <option value=\"M\">M</option>\n");
      out.write("                        </select>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Descripcion</td>\n");
      out.write("                    <td>\n");
      out.write("                        <textarea name=\"descripcion\" rows=\"4\" cols=\"20\" id=\"descripcion\">\n");
      out.write("                        </textarea>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("\n");
      out.write("                    <td>Ambito</td>\n");
      out.write("                    <td>\n");
      out.write("                        N<input type=\"radio\" name=\"ambitoRadio\" value=\"N\" checked=\"checked\" />\n");
      out.write("                        P<input type=\"radio\" name=\"ambitoRadio\" value=\"P\"/> \n");
      out.write("                        M<input type=\"radio\" name=\"ambitoRadio\" value=\"M\" />\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"submit\" value=\"JSP\">\n");
      out.write("                        <input type=\"button\" value=\"JavaScript\" onclick=\"validaDatos()\">\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("\n");
      out.write("        </form> \n");
      out.write("        <script>\n");
      out.write("            function validaDatos() {\n");
      out.write("                var letra = document.getElementById('letra');\n");
      out.write("                var numero = document.getElementById('numero');\n");
      out.write("                var descripcion = document.getElementById('descripcion');\n");
      out.write("\n");
      out.write("                if (letra.value == '' || numero.value == '' || descripcion.value == '') {\n");
      out.write("                    alert(\"Verifique que lleno los campos modelo y marca y que la validacion sea la correcta\");\n");
      out.write("                }else{\n");
      out.write("                    alert(\"Letra: \" + letra + \\n + \"Numero: \" + numero)\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                if(numero.value != '' &&  isNaN(parseInt(numero.value))){\n");
      out.write("                    alert(\"El dato ingresado no es un numero o verifique que lo cargo correctamente\");\n");
      out.write("                }\n");
      out.write("\n");
      out.write("            }\n");
      out.write("        </script>\n");
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
