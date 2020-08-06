package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Modelo.Alumno;
import java.util.ArrayList;
import Modelo.Catedra;
import Servidor.Servidor;

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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Practica 1</title>\n");
      out.write("    </head>\n");
      out.write("   \n");
      out.write("    <body>\n");
      out.write("        <form name=\"form1\" action=\"Servidor\" >\n");
      out.write("            <select name=catedra id=\"catedra\" onchange=\"llenaTabla()\">\n");
      out.write("           <option value=\"0\">Seleccione una materia</option>    \n");
      out.write("        ");

            Servidor servidor = new Servidor();
            ArrayList<Catedra> catedras = servidor.cargaCatedras(); 
              
            for (Catedra cate : catedras) {
      out.write("\n");
      out.write("          \n");
      out.write("            <option value=\"");
      out.print(cate.getCodigo() );
      out.write("\">\n");
      out.write("                    ");
      out.print(cate.getDenominacion());
      out.write("\n");
      out.write("                </option>\n");
      out.write("            \n");
      out.write("    ");
 }
 

    
      out.write("\n");
      out.write("    \n");
      out.write("</select>  \n");
      out.write("  ");


                
                ArrayList<Alumno> alumnoString = (ArrayList<Alumno>) request.getAttribute("alumnos");
            
    
      out.write("  \n");
      out.write("<table border=\"1\" name>\n");
      out.write("    <tr>\n");
      out.write("    <td>Nombre</td>\n");
      out.write("     <td>Apellido</td>\n");
      out.write("      <td>Legajo</td>\n");
      out.write("    </tr> \n");
      out.write(" \n");
      out.write("        ");

     
            if(alumnoString!=null){
                for (Alumno alu : alumnoString) {
                
      out.write("   \n");
      out.write("               <tr>\n");
      out.write("             <td>");
      out.print(alu.getNombre());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(alu.getApellido());
      out.write("</td>\n");
      out.write("                   <td>");
      out.print(alu.getLegajo());
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("                ");
}

                    }

                
      out.write("  \n");
      out.write("              \n");
      out.write("</table>\n");
      out.write("</form>\n");
      out.write("<script>\n");
      out.write("            function llenaTabla() {\n");
      out.write("                document.forms[\"form1\"].submit();\n");
      out.write("            }\n");
      out.write("             function enviar() {\n");
      out.write("\n");
      out.write("                var list = document.getElementById(\"catedras\");\n");
      out.write("                var item = list.options[list.selectedIndex].value;\n");
      out.write("                window.location.replace(\"index.jsp?item=\" + item);\n");
      out.write("            ");
              String item = "";
                if (request.getParameter("catedra") != null) {
                    item = request.getParameter("catedra");
                }
                session.setAttribute("catedra", item);
            
      out.write("\n");
      out.write("            }\n");
      out.write("         \n");
      out.write("        </script>  \n");
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