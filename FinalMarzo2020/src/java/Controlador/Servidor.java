/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Alumno;
import Modelo.Catedra;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.Document;




/**
 *
 * @author Georgi
 */
@WebServlet(name = "Servidor", urlPatterns = {"/Servidor"})
public class Servidor extends HttpServlet {

    Catedra catedra = new Catedra();
    Alumno alumno = new Alumno();
    ArrayList<Alumno> alumnos = new ArrayList();

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
            /* TODO output your page here. You may use following sample code. */
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
            throws ServletException, IOException {
     
        alumnos = this.traeAlumnos(Integer.parseInt(request.getParameter("catedra")));
        request.setAttribute("alumnos", alumnos);
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
        
        String reporte = request.getParameter("action");
        if(reporte.equalsIgnoreCase("Itext")){
          
                    llenaReporteItext();
            
                }
            
        }

    

    public ArrayList<Catedra> traeCatedras() {

        ArrayList<Catedra> catedras = new ArrayList();
        catedras = this.catedra.traeCatedras();
        return catedras;

    }

    public ArrayList<Alumno> traeAlumnos(int id) {
        ArrayList<Alumno> alumnos = new ArrayList();
        alumnos = this.alumno.traeAlumnos(id);
        return alumnos;
    }
    
     public void llenaReporteItext(){
  //Document doc = new Document();
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

}
