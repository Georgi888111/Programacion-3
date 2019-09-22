
package calculofacturab;

import java.util.ArrayList;
import java.util.Scanner;


public class CalculoFacturaB {
    
    public static ArrayList<Articulo>articulos = new ArrayList();
    private int posicionArticulo;
    public static ArrayList<Cliente>clientes = new ArrayList();

 public void cargaArticulos(){
    
    Articulo articulo = new Articulo(100,"Azucar",20,"U");
    articulos.add(articulo);
   Articulo articulo1 = new Articulo(101,"Leche",30,"U");
   articulos.add(articulo1);
   Articulo articulo2 = new Articulo(102,"Aceite",50,"U");
   articulos.add(articulo2);
   Articulo articulo3 = new Articulo(103,"Sal",45,"U");
   articulos.add(articulo3);
   Articulo articulo4 = new Articulo(104,"Fideos",15,"U");
   articulos.add(articulo4);
   Articulo articulo5 = new Articulo(105,"Arroz",28,"U");
   articulos.add(articulo5);
   Articulo articulo6 = new Articulo(106,"Galletas",26,"U");
   articulos.add(articulo6);
   Articulo articulo7 = new Articulo(107,"Carne Molida",220,"KG");
   articulos.add(articulo7);
    Articulo articulo8 = new Articulo(108,"Shampoo",42,"U");
   articulos.add(articulo8);
   Articulo articulo9 = new Articulo(109,"Queso Mantecoso",178,"KG");
   articulos.add(articulo9);
   Articulo articulo10 = new Articulo(110,"Jamon cocido",320,"KG");
   articulos.add(articulo10);
   Articulo articulo11 = new Articulo(111,"Naranjas",80,"KG");
   articulos.add(articulo11);
 }
 
  public boolean busquedaCodigo(int codigo){
      boolean encontro=false; 
      for (int i = 0; i < articulos.size(); i++) {
        if(articulos.get(i).getCodigo()==codigo){
         encontro=true;
         posicionArticulo =i;
         setPosicionArticulo(posicionArticulo);
      }
  
    }
        return encontro;
  }
  
  
   public void setPosicionArticulo(int posicionArticulo) {
        posicionArticulo = posicionArticulo;
    }
   
   
   public int getPosicionArticulo() {
        return posicionArticulo;
    }
   

   
   public static String tipoDeCantidad(int codigo){
       String tipo = "";
       for (int i = 0; i < articulos.size(); i++) {
       if(articulos.get(i).getCodigo() == codigo){
           tipo = articulos.get(i).getUnidadMedida();
       }    
       }
       return tipo;
   }
   
   
    public static void main(String[] args) {
    String tipoPago, opcion, tipo;
    int cantidad, codigo;
    double cant;
    
   

       CalculoFacturaB calculo = new CalculoFacturaB();
       calculo.cargaArticulos();
   

   Cliente cliente = new Cliente(1,"Cocodrilo",2345623);
   Cliente cliente2 = new Cliente(2,"Marmota",22345345);
   Cliente cliente3 = new Cliente(3, "Serpiente", 21222323);
   clientes.add(cliente);
   clientes.add(cliente2);
   clientes.add(cliente3);

   
   Factura factura = new Factura();
  
        do{
       
        System.out.println("Desea comenzar una facturacion?");
        opcion = new Scanner(System.in).next();
         if(opcion.equalsIgnoreCase("si")){  
             
        System.out.println("Fecha de la factura");
        String fecha = new Scanner(System.in).next();
        System.out.println("Numero de la factura");
        int numero = new Scanner(System.in).nextInt();
        do{
        System.out.println("Tipo de factura");
        tipo = new Scanner(System.in).next();
        }while(!factura.validaLetra(tipo));
        do{
        System.out.println("Tipo de pago");
        tipoPago = new Scanner(System.in).next();
        
    }while(factura.validaTipoPago(tipoPago)==false);

        factura.setDate(fecha);
        factura.setNumero(numero);
        factura.setLetra(tipo);
        factura.setTipoPago(tipoPago);
        
        factura.setCliente(cliente);
        
        do{
        System.out.println("Cuantos articulos desea facturar?");
        cantidad = new Scanner(System.in).nextInt();
        }while(cantidad<=0);
        
       
        
        System.out.println("Articulos a facturar");

     do{
       do{
        System.out.println("Ingrese el código del artículo");
       codigo = new Scanner(System.in).nextInt();
       if (!calculo.busquedaCodigo(codigo)) {
                    System.out.println("No se encontro el codigo, ingrese nuevamente");
                }
       }while(!calculo.busquedaCodigo(codigo));
        if (calculo.busquedaCodigo(codigo)) {     
            if(tipoDeCantidad(codigo).equalsIgnoreCase("KG")){
            System.out.println("Ingrese la cantidad de ese producto que desea");   
            cant = new Scanner(System.in).nextDouble();
       
       DetalleFactura detalle = new DetalleFactura();
       detalle.setCantidad(cant);
       detalle.setArticulo(articulos.get(calculo.getPosicionArticulo()));
       detalle.calcularSubtotal();
       factura.addDetalle(detalle);
       cantidad--;        
       
            }else{
                System.out.println("Ingrese cuantos productos desea llevar");
                cant = new Scanner(System.in).nextDouble();
       
       DetalleFactura detalle = new DetalleFactura();
       detalle.setCantidad(cant);
       detalle.setArticulo(articulos.get(calculo.getPosicionArticulo()));
       detalle.calcularSubtotal();
       factura.addDetalle(detalle);
       cantidad--;        
            }
        

    
   
    
        } 
    
    
}while(cantidad>=1);
     
        System.out.println("El ticket a pagar es:");
        
        System.out.println("Fecha: \t\t\t\t\t\t" + factura.getDate());
        System.out.println("Numero: \t\t\t\t\t\t" + factura.getNumero());
        System.out.println("Cliente: \t\t\t\t\t\t" + cliente.getRazonSocial());
        System.out.println("CUIL: \t\t\t\t\t\t" + cliente.getCuit());
        System.out.println("");
        String[] titulos = {"CodArticulo", "NombreArt", "Precio/u", "Cantidad", "Subtotal"};
        for (int i = 0; i < 5; i++) {
            System.out.print(titulos[i] + "\t");
        }
        System.out.println("");
        for (int i = 0; i <factura.getDetalles().size(); i++) {
            
     System.out.println(factura.getDetalles().get(i).getArticulo().getCodigo() + "\t\t" + factura.getDetalles().get(i).getArticulo().getDenominacion() + "\t\t" +factura.getDetalles().get(i).getArticulo().getPrecio()+ "\t\t" +factura.getDetalles().get(i).getCantidad()+ "\t\t" +factura.getDetalles().get(i).getSubtotal() );   
        }
        System.out.println("");
        System.out.println("\t\t\t\t\t\t\t Tipo de pago: " + factura.getTipoPago());
        factura.calcularTotalItems();
        System.out.println("\t\t\t\t\t\t\t Total: " + factura.getTotalItems());
        factura.calcularConRecargo();
       System.out.println("\t\t\t\t\t\t\t Recargo: " + factura.getRecargo());
       System.out.println("\t\t\t\t\t\t\t Total Final: " + factura.getTotalFinal());
   
       
      
        
         }
}while(opcion.equalsIgnoreCase("si"));
   cliente.addFactura(factura);
   System.out.println("Total de compras de ese cliente: " + cliente.totalComprasCliente()); 
}
     
   }