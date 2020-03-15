/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Data.Conexion;
import Modelo.Persona;
import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author Georgi
 */
public class ControladorPersona extends HttpServlet {
String agregar= "persona.jsp";
String mostrarTodos = "tablaPersonas.jsp";

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
            out.println("<title>Servlet ControladorPersona</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorPersona at " + request.getContextPath() + "</h1>");
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

            String action = request.getParameter("action");
            if(action.equalsIgnoreCase("agregar")){
            int dni = Integer.parseInt(request.getParameter("dni"));
            String nombre = request.getParameter("name");
            String domicilio = request.getParameter("address");
            Persona p = new Persona();
            p.setDni(dni);
            p.setNombre(nombre);
            p.setDomicilio(domicilio);
                try {
                    p.cargaPersona(p);
                } catch (SQLException ex) {
                          
                    Logger.getLogger(ControladorPersona.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }else{
                if(action.equalsIgnoreCase("mostrarTodos")){
                 
                    RequestDispatcher vista = request.getRequestDispatcher(action);
                    vista.forward(request, response);
                 //  retornaPersonas();
                    
                  
                }
            }
    }
    
    public ArrayList<Persona> retornaPersonas(){
          Persona persona = new Persona();
      ArrayList<Persona>perso = new ArrayList();
                    perso = persona.mostrarTodos();   
                    return perso;
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
