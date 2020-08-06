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
      out.write("        <form action=\"http://localhost:8080/FinalMayoCrespo2/muestraDatos.jsp\" onsubmit=\"return validaDatos()\" method=\"post\">\n");
      out.write("            <table border=\"1\">\n");
      out.write("                <tr>\n");
      out.write("                    <td>Legajo</td> \n");
      out.write("                       <td><input type=\"text\" name=\"legajo\" id=\"legajo\"></td> \n");
      out.write("                </tr>\n");
      out.write("                  <tr>\n");
      out.write("                    <td>Nombre empleado</td> \n");
      out.write("                    <td><input type=\"text\" name=\"nombre\" id=\"nombre\"></td> \n");
      out.write("                </tr>\n");
      out.write("                  <tr>\n");
      out.write("                    <td>Numero de bono</td> \n");
      out.write("                    <td><input type=\"number\" name=\"numero\" id=\"numero\"></td> \n");
      out.write("                </tr>\n");
      out.write("                  <tr>\n");
      out.write("                    <td>Mes</td> \n");
      out.write("                            <td>\n");
      out.write("                        <select name=\"meses\">\n");
      out.write("                            <option value=\"Enero\">Enero</option>\n");
      out.write("                             <option value=\"Febrero\">Febrero</option>\n");
      out.write("                              <option value=\"Marzo\">Marzo</option>\n");
      out.write("                               <option value=\"Abril\">Abril</option>\n");
      out.write("                                <option value=\"Mayo\">Mayo</option>\n");
      out.write("                                 <option value=\"Junio\">Junio</option>\n");
      out.write("                                  <option value=\"Julio\">Julio</option>\n");
      out.write("                                   <option value=\"Agosto\">Agosto</option>\n");
      out.write("                                    <option value=\"Septiembre\">Septiembre</option>\n");
      out.write("                                    <option value=\"Octubre\">Octubre</option>\n");
      out.write("                                    <option value=\"Noviembre\">Noviembre</option>\n");
      out.write("                                    <option value=\"Diciembre\">Diciembre</option>\n");
      out.write("                        </select>\n");
      out.write("                            </td> \n");
      out.write("                </tr>\n");
      out.write("                  <tr>\n");
      out.write("                    <td>Año</td> \n");
      out.write("                       <td><input type=\"number\" name=\"año\" id=\"año\"></td> \n");
      out.write("                </tr> \n");
      out.write("                <tr>\n");
      out.write("                    <td>Total</td> \n");
      out.write("                       <td><input type=\"number\" name=\"total\" id=\"total\"></td> \n");
      out.write("                </tr>\n");
      out.write("                \n");
      out.write("                \n");
      out.write("            </table>\n");
      out.write("            <input type=\"submit\" value=\"Enviar Datos\">\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("    \n");
      out.write("    <script>\n");
      out.write("        function validaDatos(){\n");
      out.write("            var contador =0;\n");
      out.write("          var legajo = document.getElementById('legajo');\n");
      out.write("          var nombre = document.getElementById('nombre');\n");
      out.write("           var numero = document.getElementById('numero');\n");
      out.write("             var año = document.getElementById('año');\n");
      out.write("               var total = document.getElementById('total');\n");
      out.write("               \n");
      out.write("               if(legajo.value==''||nombre.value==''||numero.value==''||año.value==''||total.value==''){\n");
      out.write("                   alert('Debe llenar todos los campos');\n");
      out.write("                   contador++;\n");
      out.write("               }else{\n");
      out.write("                   if(isNaN(numero.value)||isNaN(año.value)||isNaN(total.value)){\n");
      out.write("                     alert(\"Verifique que haya ingresado números donde corresponda\");\n");
      out.write("                     contador++;\n");
      out.write("                   }\n");
      out.write("               }\n");
      out.write("               \n");
      out.write("               if(contador>0){\n");
      out.write("                   return false;\n");
      out.write("               }else{\n");
      out.write("                   return true;\n");
      out.write("               }\n");
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
