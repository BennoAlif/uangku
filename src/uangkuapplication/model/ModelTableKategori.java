/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uangkuapplication.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import uangkuapplication.entity.EntityKategori;
import uangkuapplication.main.UangkuApplication;

/**
 *
 * @author Kyoto
 */
public class ModelTableKategori extends AbstractTableModel {

    private List<EntityKategori> list = new ArrayList<EntityKategori>();
    
    public void setList(List<EntityKategori> list) {
        this.list = list;
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    public boolean add(EntityKategori e) {
        try {
            return list.add(e);
        } finally {
            fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
        }
    }

    public EntityKategori get(int i) {
        return list.get(i);
    }

    public EntityKategori set(int i, EntityKategori e) {
        try {
            return list.set(i, e);
        } finally {
            fireTableRowsUpdated(i, i);
        }
    }

    public EntityKategori remove(int i) {
        try {
            return list.remove(i);
        } finally{
            fireTableRowsDeleted(i, i);
        }
    }

    @Override
    public String getColumnName(int i) {
        switch(i){
            case 0:
                return "Id";
            case 1:
                return "Nama Kategori";
            default:
                return null;
        }
    }
    
    @Override
    public Object getValueAt(int i, int i1) {
        switch(i1){
            case 0:
                return list.get(i).getId();
            case 1:
                return list.get(i).getNama_kategori();
            default:
                return null;
        }
    }
    
}
