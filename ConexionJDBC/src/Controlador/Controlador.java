/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Data.Conexion;
import Modelo.ModeloPersona;

import Vista.ConexionVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Georgi
 */
public class Controlador implements ActionListener {

    private ConexionVista conexionV;
    private Conexion conexionBase = new Conexion();
    private ModeloPersona modelo = new ModeloPersona(conexionBase);
    private DefaultTableModel modeloTabla = new DefaultTableModel(null, dameColumnas());
    private JTable tabla;
    private ArrayList<ModeloPersona> modeloPer = new ArrayList();

    public Controlador(ConexionVista conexionV) {
        this.conexionV = conexionV;
        this.conexionV.setVisible(true);
        this.conexionV.getEjecuta().addActionListener(this);
    }

    public String[] dameColumnas() {
        String[] Columna = {"Nombre", "Apellido", "Edad", "Fecha Alta"};
        return Columna;
    }

    public void pasarPersonasTable(JTable tabla, String query) {
        Object personas[] = new Object[4];
        this.modeloPer = modelo.traerPersonas(query);
        if (modeloPer.size() > 0) {
            for (int i = 0; i < modeloPer.size(); i++) {

                modelo = modeloPer.get(i);
                personas[0] = modelo.getNombre();
                personas[1] = modelo.getApellido();
                personas[2] = modelo.getEdad();
                personas[3] = modelo.getFecha();

                modeloTabla.addRow(personas);

            }

        }

        tabla.setModel(modeloTabla);
        modeloTabla.fireTableDataChanged();

    }

    public void limpiarTabla(JTable tabla) {
        DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
        int a = tabla.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource().equals(this.conexionV.getEjecuta())) {
            if (this.conexionV.getBase().getText().equals("") || this.conexionV.getHost().getText().equals("") || this.conexionV.getPuerto().getText().equals("") || this.conexionV.getSentencia().getText().equals("") || this.conexionV.getUsuario().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios para poder realizar la consulta");
            } else {
                String host = this.conexionV.getHost().getText();
                String puerto = this.conexionV.getPuerto().getText();
                String user = this.conexionV.getUsuario().getText();
                String password = this.conexionV.getClave().getText();
                String base = this.conexionV.getBase().getText();
                conexionBase.estableceConexion(host, puerto, user, password, base);

                if (this.conexionV.getSentencia().getText().contains("INSERT")) {
                    modelo.insertarPersona(conexionV.getSentencia().getText());
                    conexionV.getSentencia().setText("");
               

                } else if (this.conexionV.getSentencia().getText().contains("DELETE")) {
                    modelo.borrarPersona(conexionV.getSentencia().getText());
                    conexionV.getSentencia().setText("");
                    

                } else if (this.conexionV.getSentencia().getText().contains("UPDATE")) {
                    modelo.modificarPersona(conexionV.getSentencia().getText());
                    conexionV.getSentencia().setText("");
               
                } else if (this.conexionV.getSentencia().getText().contains("SELECT")) {
                    pasarPersonasTable(conexionV.getPersona(), conexionV.getSentencia().getText());
                    conexionV.getSentencia().setText("");

                }
            }
        }

    }

}
