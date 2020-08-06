/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalmayocrespo;

/**
 *
 * @author Georgi
 */
 //@Entity
//@Table(name = "ItemBono")
public class ItemBono {
    private int codigo;
    private String descripcion;
    private double monto;
    private boolean esRemunerativo;
    private BonoSueldo bono;

    public ItemBono(int codigo, String descripcion, double monto, boolean esRemunerativo, BonoSueldo bono) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.monto = monto;
        this.esRemunerativo = esRemunerativo;
        this.bono = bono;
    }

    public ItemBono() {
    }

  //@Id
 //@GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public boolean isEsRemunerativo() {
        return esRemunerativo;
    }

    public void setEsRemunerativo(boolean esRemunerativo) {
        this.esRemunerativo = esRemunerativo;
    }

   //@ManyToOne(fetch = FetchType.LAZY)
   //@JoinColumn(name = "id_bono")
    public BonoSueldo getBono() {
        return bono;
    }

    public void setBono(BonoSueldo bono) {
        this.bono = bono;
    }
    
    
}
