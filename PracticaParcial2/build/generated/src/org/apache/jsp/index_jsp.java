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
      out.write("         <link rel=\"stylesheet\" href=\"estilo.css\" type=\"text/css\"/>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Carga Usuario</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Carga usuario</h1>\n");
      out.write("       <form action=\"ServletPersona\" onsubmit=\" return validaDatos(this)\">\n");
      out.write("           \n");
      out.write("           <p style =\"margin-left: 13px\"><span class=\"tachado\">Nombre:</span> <input type=\"text\"  name =\"name\" ></p>\n");
      out.write("             <p style = \"margin-left: 7px\">Apellido <input type=\"text\"  name =\"apellido\"></p>\n");
      out.write("               <p style = \"margin-left: 7px\">Usuario <input type=\"text\"  name =\"usu\"></p>\n");
      out.write("                 <p style = \"margin-left: 7px\">Contraseña <input type=\"text\"  name =\"pass\" id =\"pass\"></p>\n");
      out.write("                  <p style = \"margin-left: 7px\">Confirmar contraseña <input type=\"text\"  name =\"confimar\" id =\"confirmar\"></p>\n");
      out.write("                  <input type=\"submit\" name=\"agregarUsu\" value = \"Agregar\">\n");
      out.write("                  <script>\n");
      out.write("                      function validaDatos(f){\n");
      out.write("                       var ok;\n");
      out.write("                         var nombre = f.elements[0];\n");
      out.write("                           var apellido = f.elements[1];\n");
      out.write("                      var usuario = f.elements[2];\n");
      out.write("                       var contraseña = f.elements[3];\n");
      out.write("                       var contraseñaRepe = f.elements[4];\n");
      out.write("  var msg = \"Las contraseñas no concuerdan\";\n");
      out.write("  if(nombre.value===\"\"||apellido.value===\"\"||usuario.value===\"\"||contraseña.value===\"\"||contraseñaRepe===\"\"){\n");
      out.write("      alert(\"Todos los campos deben estar llenos\");\n");
      out.write("      ok=false;\n");
      out.write("  }else  if(contraseña.value!==contraseñaRepe.value){\n");
      out.write("      alert(msg);\n");
      out.write("      ok=false;\n");
      out.write("}else{\n");
      out.write("    alert(\"Persona agregada\");\n");
      out.write("ok=true;\n");
      out.write("}\n");
      out.write("return ok;\n");
      out.write("                      }\n");
      out.write("                      </script>\n");
      out.write("          \n");
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
