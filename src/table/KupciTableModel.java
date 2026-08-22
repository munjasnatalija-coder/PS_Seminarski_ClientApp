/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;

import domain.Kupac;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.table.AbstractTableModel;
import controller.Controller;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Natalija
 */
public class KupciTableModel extends AbstractTableModel implements Runnable{
    private List<Kupac> lista;
    String[]kolone = {"ID","Ime", "Prezime", "email","Broj telefona", "Mesto"};
    private String paramImePrezime = "";
    private String paramMesto = "";

    public KupciTableModel(List<Kupac> lista) {
        this.lista = lista;
    }

    public KupciTableModel() {
        lista = new ArrayList<>();
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

    public List<Kupac> getLista() {
        return lista;
    }

      public void setParametar(String paramImePrezime, String paramMesto) {
        this.paramImePrezime = paramImePrezime;
        this.paramMesto = paramMesto;
        refreshTable();
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(10000);
                refreshTable();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(KupciTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    public void refreshTable() {
        try {
            lista = Controller.getInstance().ucitajKupce();
            
            if (!paramImePrezime.equals("")) {
                ArrayList<Kupac> novaLista = new ArrayList<>();
                for (Kupac k : lista) {
                    if (k.getIme().toLowerCase().contains(paramImePrezime.toLowerCase())
                            || k.getPrezime().toLowerCase().contains(paramImePrezime.toLowerCase())) {
                        novaLista.add(k);
                    }
                }
                lista = novaLista;
            }
            if (!paramMesto.equals("")) {
                ArrayList<Kupac> novaLista = new ArrayList<>();
                for (Kupac k : lista) {
                    if (k.getMesto().getNaziv().contains(paramMesto)) {
                        novaLista.add(k);
                    }
                }
                lista = novaLista;
            }
//            if (!paramImePrezime.equals("") && !paramMesto.equals("")) {
//                ArrayList<Kupac> novaLista = new ArrayList<>();
//                for (Kupac k : lista) {
//                    if ((k.getIme().toLowerCase().contains(paramImePrezime.toLowerCase())
//                            || k.getPrezime().toLowerCase().contains(paramImePrezime.toLowerCase())) && k.getMesto().getNaziv().contains(paramMesto)) {
//                        novaLista.add(k);
//                    }
//                }
//                lista = novaLista;
//            }

            fireTableDataChanged();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public Kupac getSelectedKupac(int row) {
        return lista.get(row);
    }
    
    
    
}
