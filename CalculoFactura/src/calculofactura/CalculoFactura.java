package calculofactura;


import java.util.ArrayList;
import java.util.Scanner;

public class CalculoFactura {

    private static String articulos[][];
    private int posicionFila;

  public void cargaArticulos() {
        articulos = new String[12][4];

        articulos[0][0] = "100";
        articulos[1][0] = "101";
        articulos[2][0] = "102";
        articulos[3][0] = "103";
        articulos[4][0] = "104";
        articulos[5][0] = "105";
        articulos[6][0] = "106";
        articulos[7][0] = "107";
        articulos[8][0] = "108";
        articulos[9][0] = "109";
        articulos[10][0] = "110";
        articulos[11][0] = "111";
        articulos[0][1] = "Azucar";
        articulos[1][1] = "Leche";
        articulos[2][1] = "Aceite";
        articulos[3][1] = "Sal";
        articulos[4][1] = "Fideos";
        articulos[5][1] = "Arroz";
        articulos[6][1] = "Galletas";
        articulos[7][1] = "Carne Molida";
        articulos[8][1] = "Shampoo";
        articulos[9][1] = "Queso Mantecoso";
        articulos[10][1] = "Jamon Cocido";
        articulos[11][1] = "Naranjas";
        articulos[0][2] = "20";
        articulos[1][2] = "30";
        articulos[2][2] = "50";
        articulos[3][2] = "45";
        articulos[4][2] = "15";
        articulos[5][2] = "28";
        articulos[6][2] = "26";
        articulos[7][2] = "220";
        articulos[8][2] = "42";
        articulos[9][2] = "178";
        articulos[10][2] = "320";
        articulos[11][2] = "80";
        articulos[0][3] = "U";
        articulos[1][3] = "U";
        articulos[2][3] = "U";
        articulos[3][3] = "U";
        articulos[4][3] = "U";
        articulos[5][3] = "U";
        articulos[6][3] = "U";
        articulos[7][3] = "KG";
        articulos[8][3] = "U";
        articulos[9][3] = "KG";
        articulos[10][3] = "KG";
        articulos[11][3] = "KG";
    }

    public boolean busquedaCodigo(String cod) {
        boolean encontro = false;

        for (int i = 0; i < articulos.length; i++) {
            for (int j = 0; j < articulos[i].length; j++) {
                if (articulos[i][0].equalsIgnoreCase(cod)) {
                    encontro = true;
                    posicionFila = i;

                    setPosicionFila(posicionFila);

                }

            }
        }

        return encontro;
    }
    
    
   public void setPosicionFila(int posicionFila) {
        posicionFila = posicionFila;
    }

    public int getPosicionFila() {
        return posicionFila;
    }

    public String subtotal(String cantidad, String precioUnitario) {

        int cant = Integer.parseInt(cantidad);
        int precio = Integer.parseInt(precioUnitario);
        int calculo = precio * cant;
        String subtotal = String.valueOf(calculo);
        return subtotal;
    }
    
    public String subtotalKilos(String cantidad, String precioKg){
        double cant = Double.parseDouble(cantidad);
        double precio = Double.parseDouble(precioKg);
        double calculo = precio * cant;
        String subtotal = String.valueOf(calculo);
        return subtotal;
        
    }
    
    public String tipoDeCantidad(String codigo){
        boolean encontro=false;
        String tipoCantidad ="";
         for (int i = 0; i < articulos.length; i++) {
            for (int j = 0; j < articulos[i].length; j++) {
                if(articulos[i][0].equals(codigo)){
                   encontro = true;
                   tipoCantidad = articulos[i][3];
                }
            }
            
         
    }
            return tipoCantidad;
    }
    public static void main(String[] args) {
   

    CalculoFactura calculo = new CalculoFactura();
        calculo.cargaArticulos();
        Factura factura = new Factura();
        String pago, codigo;
        int cantidad, cantidadArray = 0;
        double recargo;
        double total;

        System.out.println("Ingrese la fecha de la factura");
        String fecha = new Scanner(System.in).nextLine();
        System.out.println("Ingrese el numero de la factura");
        long numeroFac = new Scanner(System.in).nextLong();
        System.out.println("Ingrese el nombre del cliente");
        String nombre = new Scanner(System.in).nextLine();
        System.out.println("Ingrese el cuit del cliente");
        long cuitCliente = new Scanner(System.in).nextLong();
        do {
            System.out.println("Ingrese el tipo de pago");
            pago = new Scanner(System.in).nextLine();
        } while (factura.validaPago(pago) == false);

        factura.setRazonSocial(nombre);
        factura.setFecha(fecha);
        factura.setNroFactura(numeroFac);
        factura.setTipoPago(pago);

        do {
            System.out.println("Ingrese la cantidad de articulos: ");
            cantidad = new Scanner(System.in).nextInt();
        } while (factura.cantidadArt(cantidad) == false);
        factura.crearArray(cantidad);

        System.out.println("Articulos a facturar");
        do {
            do {
                System.out.println("Ingrese el codigo del articulo");
                codigo = new Scanner(System.in).next();
                calculo.busquedaCodigo(codigo);
                if (calculo.busquedaCodigo(codigo) == false) {
                    System.out.println("No se encontro el codigo, ingrese nuevamente");
                }
            } while (calculo.busquedaCodigo(codigo) == false);
            if (calculo.busquedaCodigo(codigo) == true) {
                factura.setItemsFactura(cantidadArray, 0, codigo);
                factura.setItemsFactura(cantidadArray, 1, articulos[calculo.getPosicionFila()][1]);
                factura.setItemsFactura(cantidadArray, 2, articulos[calculo.getPosicionFila()][2]);
                if(calculo.tipoDeCantidad(codigo).equals("U")){
                 System.out.println("Ingrese la cantidad de productos");    
                String cantArt = new Scanner(System.in).next();
                factura.setItemsFactura(cantidadArray, 3, cantArt);
                factura.setItemsFactura(cantidadArray, 4, calculo.subtotal(cantArt, articulos[calculo.getPosicionFila()][2]));
                cantidadArray++;
                }else if(calculo.tipoDeCantidad(codigo).equals("KG")){
                    System.out.println("Ingrese la cantidad que desea llevar de ese producto");
                    String cantidadProducto = new Scanner(System.in).next();
                    factura.setItemsFactura(cantidadArray, 3, cantidadProducto);
                    factura.setItemsFactura(cantidadArray, 4,calculo.subtotalKilos(cantidadProducto, articulos[calculo.getPosicionFila()][2]));
                    cantidadArray ++;
                }
              
                
                

            }
        } while (cantidad > cantidadArray);

        System.out.println("Fecha: \t\t\t\t\t\t" + factura.getFecha());
        System.out.println("Numero: \t\t\t\t\t\t" + factura.getNroFactura());
        System.out.println("Cliente: \t\t\t\t\t\t" + factura.getRazonSocial());
        System.out.println("");
        String[] titulos = {"CodArticulo", "NombreArt", "Precio/u", "Cantidad", "Subtotal"};
        for (int i = 0; i < 5; i++) {
            System.out.print(titulos[i] + "\t");
        }
     
        for (int i = 0; i < cantidad; i++) {
            for (int j = 0; j < 5; j++) {

                if (factura.getItemsFactura(i, j).length() < 8) {
                    System.out.print(factura.getItemsFactura(i, j) + "\t\t");
                } else {
                    System.out.print(factura.getItemsFactura(i, j) + "\t");
                }

            }
            System.out.println("");
        }
        System.out.println("\t\t\t\t\t\t\t Tipo de pago: " + factura.getTipoPago());
        total = factura.total();
        System.out.println("\t\t\t\t\t\t\t Total: " + total);
      
        if(factura.getTipoPago().equalsIgnoreCase("TD")){
        recargo =total*0.05;
       }else if(factura.getTipoPago().equalsIgnoreCase("TC")){
           recargo = total*0.1;
        }else{
            recargo = 0;
        }
        
       System.out.println("\t\t\t\t\t\t\t Recargo: " + recargo);
       System.out.println("\t\t\t\t\t\t\t Total Final: " + (total + recargo));
        
    
    
}
        

}