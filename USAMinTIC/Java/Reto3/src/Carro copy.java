package Reto3;

public class Carro {

    private int codigo;
    private String marca;
    private double precio;
    private int inventario;

    public Carro() {
    }

    public Carro(int codigo, String marca, double precio, int inventario) {
        this.codigo = codigo;
        this.marca = marca;
        this.precio = precio;
        this.inventario = inventario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getInventario() {
        return inventario;
    }

    public void setInventario(int inventario) {
        this.inventario = inventario;
    }

    @Override
    public String toString() {
        return "Carro{" + "codigo=" + codigo + ", marca=" + marca + ", precio=" + precio + ", inventario=" + inventario
                + '}';
    }

}
