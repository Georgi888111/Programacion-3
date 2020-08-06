/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practaccdatoshiber;

import Controlador.ControladorComprobanteCompra;
import Controlador.ControladorDatosAfip;
import Controlador.ControladorDetalle;
import Controlador.ControladorProducto;
import Controlador.ControladorProveedor;
import Modelo.ComprobanteCompra;
import Modelo.Producto;
import Modelo.Proveedor;
import java.util.ArrayList;

/**
 *
 * @author Georgi
 */
public class PractAccDatosHiber {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
     ArrayList<ComprobanteCompra> comprobantes = new ArrayList();
        ComprobanteCompra comp = new ComprobanteCompra();
        comp.setFecha("12/11/2018");
        comp.setNumero(1211);
        
        ComprobanteCompra comp1 = new ComprobanteCompra();
        comp.setFecha("12/11/2018");
        comp.setNumero(1212);
        comprobantes.add(comp);
        comprobantes.add(comp1);
        
        ArrayList<Proveedor> proveedores = new ArrayList();
        Proveedor prove = new Proveedor();
        prove.setCategoria("Limpieza");
        prove.setCuit(21345345);
        prove.setRazonSocial("Amigos S.A");
        comp.setProveedor(prove);
        comp1.setProveedor(prove);
        prove.setComprobantes(comprobantes);
        proveedores.add(prove);
        
         ArrayList<Producto> productos = new ArrayList();
        Producto producto = new Producto();
        producto.setCodigoBarras("2222");
        producto.setNombre("Fideos");
        producto.setPrecio(23.0);
        
         Producto producto1 = new Producto();
        producto.setCodigoBarras("3333");
        producto.setNombre("Manteca");
        producto.setPrecio(25.0);
        productos.add(producto);
        productos.add(producto1);
        prove.setProductos(productos);
        producto.setProveedores(proveedores);
        
        ControladorComprobanteCompra ccc = new ControladorComprobanteCompra();

        ControladorDatosAfip cda= new  ControladorDatosAfip();
        ControladorDetalle cd = new ControladorDetalle();
        ControladorProducto cp = new ControladorProducto();
        ControladorProveedor cpee = new ControladorProveedor();
 
         } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        
      
    
}
}
