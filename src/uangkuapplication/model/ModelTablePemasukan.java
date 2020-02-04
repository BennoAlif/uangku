/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uangkuapplication.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import uangkuapplication.entity.EntityTransaksi;

import javax.swing.JOptionPane;
/**
 *
 * @author Wildhevire
 */
public class ModelTablePemasukan extends AbstractTableModel {
    private List<EntityTransaksi> list = new ArrayList<EntityTransaksi>();

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }
    
    @Override
    public Object getValueAt(int i, int i1) {
        switch(i1){
            case 0:
                return list.get(i).getNominal();
            case 1:
                return list.get(i).getNominal();
            case 2:
                return list.get(i).getTgl_transaksi().toString();
                
            
                       
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int i) {
        switch(i){
            case 0:
                return "Kategori";
            case 1:
                return "Nominal";
            case 2:
                return "Tanggal";
              
            
            default:
                return null;
        }
    }
    
    
    public boolean add(EntityTransaksi e) {
        try {
            
            return list.add(e);
             
        } finally {
            fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
        }
       
    }

    public EntityTransaksi get(int i) {
        return list.get(i);
    }

    public EntityTransaksi set(int i, EntityTransaksi e) {
        try {
            return list.set(i, e);
        } finally {
            fireTableRowsUpdated(i, i);
        }
    }

    public EntityTransaksi remove(int i) {
        try {
            return list.remove(i);
        } finally{
            fireTableRowsDeleted(i, i);
        }
    }
    
    public void setList(List<EntityTransaksi> list) {
        this.list = list;
    }
    
    
    
}
