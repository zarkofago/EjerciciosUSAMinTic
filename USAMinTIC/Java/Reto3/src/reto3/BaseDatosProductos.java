/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author ZarKofAgo
 */
public class BaseDatosProductos {
    
    private HashMap<Integer, Producto> listaProductos = new HashMap<>();

    public BaseDatosProductos() {
        this.listaProductos.put(1, new Producto(1, "Manzanas", 5000.0, 25));
        this.listaProductos.put(2, new Producto(2, "Limones", 2300.0, 15));
        this.listaProductos.put(3, new Producto(3, "Peras", 2700.0, 33));
        this.listaProductos.put(4, new Producto(4, "Arandanos", 9300.0, 5));
        this.listaProductos.put(5, new Producto(5, "Tomates", 2100.0, 42));
        this.listaProductos.put(6, new Producto(6, "Fresas", 4100.0, 3));
        this.listaProductos.put(7, new Producto(7, "Helado", 4500.0, 41));
        this.listaProductos.put(8, new Producto(8, "Galletas", 500.0, 8));
        this.listaProductos.put(9, new Producto(9, "Chocolates", 3500.0, 80));
        this.listaProductos.put(10, new Producto(10, "Jamon", 15000.0, 10));
    }
    
    public List<Producto> getListaProductos() {
        return new ArrayList<>(this.listaProductos.values());
    }
    
    public void setListaProductos(HashMap<Integer, Producto> listaProductos){
        this.listaProductos = listaProductos;
    }
    
    public boolean verificarExistencias(Producto producto){
        return this.listaProductos.containsKey(producto.getCodigo());
    }
    
    public boolean verificarExistencias(String nombre){
        for (Producto p : this.listaProductos.values()){
            if(nombre.toLowerCase().equals(p.getNombre().toLowerCase())){
                return true;
            }
        }
        return false;
    }
    
    public int ultimoCodigo(){
        int codigo = 0;
        for (Producto p : this.listaProductos.values()){
            codigo = p.getCodigo();
        }
        return codigo;
    }
    
    public void agregar(Producto p){
        this.listaProductos.put(p.getCodigo(), p);
    }
    public void actualizar(Producto p){
        this.listaProductos.replace(p.getCodigo(), p);
        
    }
    public void borrar(Producto p){
        this.listaProductos.remove(p.getCodigo(), p);
        }
    public String generarInforme(){
        List<Producto> listaM = obtenerMayores();
        return listaM.get(0).getNombre()+" "+listaM.get(1).getNombre()+" "+listaM.get(2).getNombre();
    }
    
    private List<Producto> obtenerMayores(){
        List<Producto> lista = new ArrayList<>(this.listaProductos.values());
        List<Producto> listaMayores = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            Producto p = new Producto();
            for (Producto pTemp : lista){
                if(pTemp.getPrecio() > p.getPrecio()){
                    p = pTemp;
                }
            }
            listaMayores.add(p);
            lista.remove(p);
        }
        return listaMayores;
    }
}