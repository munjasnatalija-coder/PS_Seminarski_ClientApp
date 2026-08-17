/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;

import domain.Kupac;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Natalija
 */
public class KupciTableModel extends AbstractTableModel {
    List<Kupac> lista;
    String[]kolone = {"id","Ime", "Prezime", "Broj Telefona", "Mesto"};

    public KupciTableModel(List<Kupac> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Kupac k = lista.get(rowIndex);
        switch(columnIndex){
            case 0: return k.getIdKupac();
            case 1: return k.getIme();
            case 2: return k.getPrezime();
            case 3: return k.getBrojTelefona();
            case 4:return k.getMesto();
            default: return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    
    
}
