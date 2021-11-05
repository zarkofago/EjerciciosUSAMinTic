/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author USUARIO
 */
public class BaseDatosProductos {
    
     private Map<Integer, Producto> listaProductos = new HashMap<Integer, Producto>();

    public BaseDatosProductos() {
        
        listaProductos.put(1, new Producto(1,"Manzanas",5000.0,25));
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
    
    public List <Producto> getBasedeDatos(){
        return new ArrayList<> (this.listaProductos.values());
    
    }
    
    public int codigoMayor(){
        int codigoAUX = 0;
        for(Producto items: listaProductos.values()){
            if (items.getCodigo() > codigoAUX){
                codigoAUX = items.getCodigo();
            }
        }
    return codigoAUX;
    }
    
     public int consultarCodigo(String nombre){
        int codigo = 0;
        for(Producto items: listaProductos.values()){
            if(nombre.equals(items.getNombre())){
            codigo = items.getCodigo();
            }
        }
    return codigo;
    }
    public Producto productoSeleccionadoBaseDatos(int i){
        return this.listaProductos.get(i);
    
    }
    
    
    
    
    
    
    public void agregar(Producto producto){
        listaProductos.put(producto.getCodigo(), producto);
    }
    
     public void borrar(Producto producto){
        listaProductos.remove(producto.getCodigo());
    }
      public void actualizar(Producto producto){
        listaProductos.replace(producto.getCodigo(), producto);
    }
       public boolean verificarExistencia(Producto producto){
        return listaProductos.containsKey(producto.getCodigo());
    }
       
    public Producto productosPrecioMayor(){
        Producto producto = listaProductos.values().iterator().next();
        
        for(Producto pro: listaProductos.values()){
            if(pro.getPrecio() > producto.getPrecio()){
                producto = pro;
            }
        }
        return producto;
    }
    
    public String[] generarInforme(){
     return nombresMayores();
    }
    public String[] nombresMayores(){
        double cont = 0;
        
        String arreglo[] = new String[3];
        arreglo[0] = "";
        arreglo[1] = "";
        arreglo[2] = "";
        int i = 0;
        while (i != 3){
            for (int key : listaProductos.keySet()) {
            Producto miProducto = listaProductos.get(key);
            double precio3 = miProducto.getPrecio();
            String cont3 = miProducto.getNombre();
            if (precio3 > cont && arreglo[0].equals(cont3) == false
                                &&  arreglo[1].equals(cont3) == false
                               &&   arreglo[2].equals(cont3) == false ){
                           
            cont = precio3;
            arreglo[i] = cont3;            
            
            }
        }
        i+= 1;
        cont = 0;
        
        }
    return arreglo;
    
    }
    
}
