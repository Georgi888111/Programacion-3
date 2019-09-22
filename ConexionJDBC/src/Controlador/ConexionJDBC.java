
package Controlador;

import Vista.ConexionVista;

public class ConexionJDBC {

    
    public static void main(String[] args) {
        ConexionVista vista = new ConexionVista();
      Controlador control = new Controlador(vista);
    }
    
}
