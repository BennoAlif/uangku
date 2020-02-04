/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uangkuapplication.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import uangkuapplication.entity.EntityRencana;

/**
 *
 * @author Rizki Restu
 */
public class ModelTableRencana extends AbstractTableModel{
    
    private List<EntityRencana> list = new ArrayList<EntityRencana>();

    public void setList(List<EntityRencana> list) {
        this.list = list;
    }
    
    

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    public boolean add(EntityRencana e) {
        try {
            return list.add(e);
        } finally {
            fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
        }
    }

    public EntityRencana get(int i) {
        return list.get(i);
    }

    public EntityRencana set(int i, EntityRencana e) {
        try {
            return list.set(i, e);
        } finally {
            fireTableRowsUpdated(i, i);
        }
    }

    public EntityRencana remove(int i) {
        try {
            return list.remove(i);
        } finally{
            fireTableRowsDeleted(i, i);
        }
    }
    
    

    @Override
    public String getColumnName(int column) {
         //To change body of generated methods, choose Tools | Templates.
         switch(column){
             case 0 : return "Nama";
             case 1 : return "Nominal";
             case 2 : return "Tanggal";
             case 3 : return "Catatan";
             default:return null;
         }
    }
    
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0 : return list.get(rowIndex).getId_kategori();
            case 1 : return list.get(rowIndex).getNominal();
            case 2 : return list.get(rowIndex).getTgl_rencana();
            case 3 : return list.get(rowIndex).getCatatan();
            default:return null;
        }
    }
    
}
