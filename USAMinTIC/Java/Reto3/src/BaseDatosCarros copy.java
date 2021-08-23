/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto3;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

/**
 *
 * @author 57315
 */
public class BaseDatosCarros {

    private HashMap<Integer, Carro> listaCarros;

    public BaseDatosCarros() {
        this.listaCarros = new HashMap<>();
        Carro c = new Carro(1, "Chevrolet", 4000, 50);
        this.listaCarros.put(c.getCodigo(), c);
        c = new Carro(2, "Renault", 5000, 10);
        this.listaCarros.put(c.getCodigo(), c);
        c = new Carro(3, "Mazda", 8000, 20);
        this.listaCarros.put(c.getCodigo(), c);
        c = new Carro(4, "Nissan", 15000, 10);
        this.listaCarros.put(c.getCodigo(), c);
    }

    public void agregarCarro(Carro c) {
        this.listaCarros.put(c.getCodigo(), c);
    }

    public void borrarCarro(Carro c) {
        this.listaCarros.remove(c.getCodigo());
    }

    public void actualizarCarro(Carro c) {
        this.listaCarros.replace(c.getCodigo(), c);
    }

    public Carro obtenerCarro(String marca) {

        Carro c = null;
        for (Carro cT : this.listaCarros.values()) {
            if (cT.getMarca().toLowerCase().equals(marca.toLowerCase())) {
                c = cT;
            }
        }
        return c;

    }

    public boolean validarExistencia(Carro c) {
        return this.listaCarros.containsKey(c.getCodigo());
    }

    public boolean validarExistencia(String marca) {

        boolean valido = false;
        for (Carro c : this.listaCarros.values()) {
            if (c.getMarca().toLowerCase().equals(marca.toLowerCase())) {
                valido = true;
            }
        }
        return valido;
    }

    public void generarInforme() {
        System.out.println("Informe");
    }

    public String generarInformeUI() {
        List<Carro> listaMayores = extraerMayores();
        return listaMayores.get(0).getMarca() + ", " + listaMayores.get(1).getMarca() + ", "
                + listaMayores.get(2).getMarca();
    }

    private List<Carro> extraerMayores() {
        List<Carro> lista = new ArrayList<>(this.listaCarros.values());
        List<Carro> listaMayores = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Carro c = new Carro();
            for (Carro cTem : lista) {
                if (cTem.getPrecio() > c.getPrecio()) {
                    c = cTem;
                }
            }
            listaMayores.add(c);
            lista.remove(c);
        }
        return listaMayores;
    }

    public List<Carro> obtenerListaCarros() {
        return new ArrayList<>(this.listaCarros.values());
    }

}
