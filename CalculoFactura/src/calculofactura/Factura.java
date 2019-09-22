package calculofactura;

public class Factura {

    private String fecha;
    private long nroFactura;
    private String razonSocial;
    private long cuitCliente;
    private String tipoPago;
    private double montoTotalItems;
    private double recargo;
    private double montoFinal;
    private String[][] itemsFactura;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public long getNroFactura() {
        return nroFactura;
    }

    public void setNroFactura(long nroFactura) {
        this.nroFactura = nroFactura;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public long getCuitCliente() {
        return cuitCliente;
    }

    public void setCuitCliente(long cuitCliente) {
        this.cuitCliente = cuitCliente;
    }

 

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public double getMontoTotalItems() {
        return montoTotalItems;
    }

    public void setMontoTotalItems(double montoTotalItems) {
        this.montoTotalItems = montoTotalItems;
    }

    public double getRecargo() {
        return recargo;
    }

    public void setRecargo(double recargo) {
        this.recargo = recargo;
    }

    public double getMontoFinal() {
        return montoFinal;
    }

    public void setMontoFinal(double montoFinal) {
        this.montoFinal = montoFinal;
    }

    public String getItemsFactura(int fila, int columna) {
        return itemsFactura[fila][columna];
    }

    public void setItemsFactura(int fila, int columna, String valor) {
        itemsFactura[fila][columna] = valor;
    }

    public void crearArray(int filas) {
        itemsFactura = new String[filas][5];
    }

    public boolean validaPago(String p) {
        boolean valido = false;
        if (p.equalsIgnoreCase("C") || p.equalsIgnoreCase("TC") || p.equalsIgnoreCase("TD")) {
            valido = true;
        } else {
            System.out.println("Ingrese los datos nuevamente");
        }
        return valido;
    }

    public boolean cantidadArt(int cant) {
        boolean val = false;
        if (cant > 0) {
            val = true;
        } else {
            System.out.println("Debe ingresar una cantidad de articulos mayor a cero");
        }
        return val;
    }

    public double total() {
        String suma = "";
        Double calculoSuma;
        for (int i = 0; i < itemsFactura.length; i++) {
            for (int j = 0; j < itemsFactura[i].length; j++) {
                if (j == 4) {
                    suma = itemsFactura[i][j];
                    calculoSuma = Double.parseDouble(suma);
                    montoFinal = montoFinal + calculoSuma;

                }
            }
        }
        return montoFinal;
    }

}
