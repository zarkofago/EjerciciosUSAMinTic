package Reto3;

import javax.swing.JFrame;
import javax.swing.JTable;

public class Reto3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        JFrame jf = new JFrame();
        JTable t = new JTable();
        t.removeColumn(t.getColumnModel().getColumn(0));
    }

}