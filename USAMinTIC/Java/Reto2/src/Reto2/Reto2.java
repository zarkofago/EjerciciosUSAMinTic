package Reto2;
import java.util.Scanner;

import Reto3.Producto;

import java.util.HashMap;
import java.util.Map;

class Reto2 {

    private final Scanner scanner = new Scanner(System.in);

    public String read() {
        return this.scanner.nextLine();
    }

    public void run() {

        BasedeDatosProductos listaProductos = new BasedeDatosProductos();

        String operacion = read();
        String[] input = read().split(" ");

        Producto producto = new Producto(Integer.parseInt(input[0]), input[1], Double.parseDouble(input[2]),
                Integer.parseInt(input[3]));

        if (operacion.equals("AGREGAR") && !listaProductos.verificarExisistencias(producto)) {
            listaProductos.agregar(producto);
            listaProductos.generarInforme();
        } else if (operacion.equals("BORRAR") && listaProductos.verificarExisistencias(producto)) {
            listaProductos.borrar(producto);
            listaProductos.generarInforme();
        } else if (operacion.equals("ACTUALIZAR") && listaProductos.verificarExisistencias(producto)) {
            listaProductos.actualizar(producto);
            listaProductos.generarInforme();
        } else {
            System.out.println("ERROR");
        }

    }

}

class BasedeDatosProductos {

    private Map<Integer, Producto> listaProductos = new HashMap<Integer, Producto>();

    public BasedeDatosProductos() {

        listaProductos.put(1, new Producto(1, "Manzanas", 5000.0, 25));
        listaProductos.put(2, new Producto(2, "Limones", 2300.0, 15));
        listaProductos.put(3, new Producto(3, "Peras", 2700.0, 33));
        listaProductos.put(4, new Producto(4, "Arandanos", 9300.0, 5));
        listaProductos.put(5, new Producto(5, "Tomates", 2100.0, 42));
        listaProductos.put(6, new Producto(6, "Fresas", 4100.0, 3));
        listaProductos.put(7, new Producto(7, "Helado", 4500.0, 41));
        listaProductos.put(8, new Producto(8, "Galletas", 500.0, 8));
        listaProductos.put(9, new Producto(9, "Chocolates", 3500.0, 80));
        listaProductos.put(10, new Producto(10, "Jamon", 15000.0, 10));

    }

    public void agregar(Producto producto) {
        listaProductos.put(producto.getCodigo(), producto);
    }

    public void borrar(Producto producto) {
        listaProductos.remove(producto.getCodigo());
    }

    public void actualizar(Producto producto) {
        listaProductos.replace(producto.getCodigo(), producto);

    }

    public boolean verificarExisistencias(Producto producto) {
        return listaProductos.containsKey(producto.getCodigo());
    }

    public String productoPrecioMayor() {
        String nombre = listaProductos.values().iterator().next().getNombre();
        double precio = listaProductos.values().iterator().next().getPrecio();

        for (Producto producto : listaProductos.values()) {
            if (producto.getPrecio() > precio) {
                nombre = producto.getNombre();
                precio = producto.getPrecio();
            }
        }
        return nombre;
    }

    public String productoPrecioMenor() {
        String nombre = listaProductos.values().iterator().next().getNombre();
        double precio = listaProductos.values().iterator().next().getPrecio();
        for (Producto producto : listaProductos.values()) {
            if (producto.getPrecio() < precio) {
                nombre = producto.getNombre();
                precio = producto.getPrecio();
            }
        }
        return nombre;
    }

    public double promedioPrecios() {
        double suma = 0;
        for (Producto producto : listaProductos.values()) {
            suma += producto.getPrecio();
        }
        return suma / (listaProductos.size());
    }

    public double totalInventario() {
        double totalInventario = 0;
        for (Producto producto : listaProductos.values()) {
            totalInventario += producto.getPrecio() * producto.getInventario();
        }
        return totalInventario;
    }

    public void generarInforme() {
        System.out.println(productoPrecioMayor() + " " + productoPrecioMenor() + " "
                + String.format("%.1f", promedioPrecios()) + " " + String.format("%.1f", totalInventario()));
    }

}

class Producto {

    private int codigo;
    private String nombre;
    private double precio;
    private int inventario;

    public Producto(int codigo, String nombre, double precio, int inventario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.inventario = inventario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

}