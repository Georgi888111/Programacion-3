/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Georgi
 */
public class Controlador extends HttpServlet {
    private static final String FILE = "C:\\Users\\Georgi\\Desktop\\practica.pdf";
    private final String PHP_URL = "http://localhost/PracticaGlobal/index.php";
String legajo;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
        response.setContentType("text/html;charset=UTF-8");
               try (PrintWriter out = response.getWriter()) {
         out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            legajo = request.getParameter("lega");
            if(legajo.equalsIgnoreCase("123")){
            out.print("<p style=\"color: red\">" + legajo);
         
            out.print("</p>");
            } else{
             out.print("<b>");    
            out.print("<p style=\"color: red\">" + "La validación de la carga no se ha cumplido.");       
            out.print("</p>");
            out.print("</b>");    
       
            }
               out.print("<button class=\"enlace\" role=\"link\" onclick=\"window.location='index.jsp'\">volver</button> ");
            out.println("</body>");
            out.println("</html>");
    }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
           String action = request.getParameter("action");
          legajo = request.getParameter("lega");
         if(action.equalsIgnoreCase("Servlet")){
        response.sendRedirect(PHP_URL + "?legajo=" + legajo);
//            try {
//                creaItext();
//           
//            } catch (DocumentException ex) {
//                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
//            }
//         }else{
//             
//         }
    }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.io.FileNotFoundException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, FileNotFoundException {
        processRequest(request, response);
      
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
 
    public void creaItext() throws FileNotFoundException, DocumentException{
   Document doc = new Document();
  PdfWriter.getInstance(doc, new FileOutputStream(FILE));
  doc.open();  
  doc.add(new Paragraph("Legajo" + legajo));
  doc.close();
    }
}
