/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;


import Datos.Conexion;
import Modelo.Alumno;
import Modelo.Catedra;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;

import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;






/**
 *
 * @author Georgi
 */
@WebServlet(name = "Servidor", urlPatterns = {"/Servidor"})
public class Servidor extends HttpServlet {
  
    Conexion conexion = new Conexion();
    private static final String FILE = "C:\\Users\\Georgi\\Desktop\\";
     private final String PHP_URL = "http://localhost/Practica1/index.php/";
 
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
          
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servidor</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servidor at " + request.getContextPath() + "</h1>");
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
            throws ServletException, IOException, FileNotFoundException {
     
        
      
        
        int idCatedra = Integer.parseInt(request.getParameter("catedra"));
        if(idCatedra != 0){
        ArrayList<Alumno>alumnos = conexion.traeAlumnosCatedra(idCatedra);
        try {
            llenaReporteItext(idCatedra);
            llenaReportePOI(idCatedra);
            //response.sendRedirect(PHP_URL + "?codigoCatedra=" + idCatedra);
        } catch (DocumentException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("alumnos", alumnos);
        
         RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
       
          rd.forward(request, response);
        }
       
          
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
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
   public ArrayList<Catedra> cargaCatedras(){
     ArrayList<Catedra> catedras = new ArrayList();
     catedras = conexion.traeCatedras();
     return catedras;
   }
   
    public void llenaReporteItext(int idCatedra) throws FileNotFoundException, DocumentException{
    ArrayList<Alumno>alumnos = conexion.traeAlumnosCatedra(idCatedra);
    Document documento = new Document();
    FileOutputStream  ficheroPDF = new FileOutputStream(FILE + "Alumnos.pdf");
        PdfWriter.getInstance(documento, ficheroPDF);
    documento.open();
    
        Paragraph titulo = new Paragraph("Grilla de alumnos \n\n", 
                FontFactory.getFont("Arial",
                22,
                Font.BOLD,
                BaseColor.BLACK)
                );
    documento.add(titulo);
        PdfPTable tabla = new PdfPTable(3);
        tabla.addCell("Nombre");
           tabla.addCell("Apellido");
              tabla.addCell("Legajo");
              
              for (Alumno alu : alumnos) {
             tabla.addCell(alu.getNombre());
              tabla.addCell(alu.getApellido());
              tabla.addCell(String.valueOf(alu.getLegajo()));
        }
         documento.add(tabla);
         
     
    documento.close();
}
    
    public void llenaReportePOI(int idCatedra){
   HSSFWorkbook libro = new HSSFWorkbook();
    ArrayList<Alumno>alumnos = conexion.traeAlumnosCatedra(idCatedra);
    HSSFSheet hoja = libro.createSheet();
   String []header = new String[]{"Nombre","Apellido","Legajo"};
      
      
           HSSFRow fila = hoja.createRow(0); 
            for (int j = 0; j < header.length; j++) {
             
                   
                   HSSFCell celda = fila.createCell((short)j);
                   celda.setCellValue(header[j]);
            }
            int contador =1;
            for (Alumno alu : alumnos) {
            
                  HSSFRow fila2 = hoja.createRow(contador);
                  HSSFCell celda = fila2.createCell((short)0); 
                  celda.setCellValue(alu.getNombre());
                  HSSFCell celda2 = fila2.createCell((short)1); 
                  celda2.setCellValue(alu.getApellido());
                  HSSFCell celda3 = fila2.createCell((short)2); 
                  celda3.setCellValue(alu.getLegajo());
                  contador++;
               }
            
        
       try {
   FileOutputStream elFichero = new FileOutputStream(FILE+"alumnos.xls");
   libro.write(elFichero);
   elFichero.close();
} catch (Exception e) {
   e.printStackTrace();
}
            
        }

    }

