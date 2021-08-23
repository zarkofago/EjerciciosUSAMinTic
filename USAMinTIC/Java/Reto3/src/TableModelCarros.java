/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto3;

import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.List;

/**
 *
 * @author 57315
 */
public class TableModelCarros implements TableModel {

    private List<Carro> lista;
    private String[] columnNames;
    private TableModelListener tableModelListener;

    public TableModelCarros(List<Carro> lista) {
        this.lista = new ArrayList<>();
        this.lista = lista;
        columnNames = new String[] { "Codigo", "Marca", "Precio", "Inventario" };
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return this.columnNames.length;
    }

    @Override
    public String getColumnName(int i) {
        return this.columnNames[i];
    }

    @Override
    public Class<?> getColumnClass(int i) {

        switch (i) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return Double.class;
            case 3:
                return Integer.class;
        }

        return null;
    }

    @Override
    public boolean isCellEditable(int i, int i1) {
        return this.lista.contains(i);

    }

    @Override
    public Object getValueAt(int i, int i1) {
        Carro c = this.lista.get(i);
        switch (i1) {
            case 0:
                return c.getCodigo();
            case 1:
                return c.getMarca();
            case 2:
                return c.getPrecio();
            case 3:
                return c.getInventario();
        }
        return null;
    }

    @Override
    public void setValueAt(Object o, int i, int i1) {
        Carro c = this.lista.get(i);
        switch (i1) {
            case 0:
                c.setCodigo((int) o);
                break;
            case 1:
                c.setMarca(String.valueOf(o));
                break;
            case 2:
                c.setPrecio((double) o);
                break;
            case 3:
                c.setInventario((int) o);
                break;
        }
        this.lista.set(i, c);
    }

    @Override
    public void addTableModelListener(TableModelListener tl) {
        this.tableModelListener = tl;
    }

    @Override
    public void removeTableModelListener(TableModelListener tl) {
        this.tableModelListener = null;
    }

}
