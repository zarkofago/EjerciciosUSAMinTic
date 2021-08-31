/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto3;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ZarKofAgo
 */
public class TableModelProducto extends AbstractTableModel{
    
private String[] columnas = {"Codigo", "Nombre", "Precio", "Inventario"};
private List<Producto> producto = new ArrayList<>();

public TableModelProducto (private List<Producto> prod){
    @Override
    public int getRowCount() {
    }

    @Override
    public int getColumnCount() {
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    }
    
}
