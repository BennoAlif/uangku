/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uangkuapplication.controller;

import javax.swing.JOptionPane;
import uangkuapplication.model.ModelKategori;
import uangkuapplication.view.KategoriFrame;

/**
 *
 * @author Kyoto
 */
public class KategoriController {
    private ModelKategori model;

    public void setModel(ModelKategori model) {
        this.model = model;
    }
    
    public void resetKategori(KategoriFrame view){
        model.resetKategori();
    }
    
    public void insertKategori(KategoriFrame view){
        String nama = view.getTxtNamaKategori().getText();
        
        if (nama.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nama kategori tidak boleh kosong!");
        }else if(nama.length() > 25 ){
            JOptionPane.showMessageDialog(view, "Nama kategori tidak boleh lebih dari 25 karakter!");
        }else{
            model.setNama_kategori(nama);
            
            try {
                model.insertKategori();
                JOptionPane.showMessageDialog(view, "Ketegori berhasil ditambah!");
                model.resetKategori();
            } catch (Throwable e) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi kesalahan pada database dengan pesan ", e.getMessage()});
            }
        }
    }
    
    public void updateKategori(KategoriFrame view){
        if (view.getTableKategori().getSelectedColumnCount()==0) {
            JOptionPane.showMessageDialog(view, "Pilih data yang ingin di ubah!");
            return;
        }
        
        Integer id = Integer.parseInt(view.getTxtIdKategori().getText());
        String nama = view.getTxtNamaKategori().getText();
        
        if (nama.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nama kategori tidak boleh kosong!");
        }else if(nama.length() > 25 ){
            JOptionPane.showMessageDialog(view, "Nama kategori tidak boleh lebih dari 25 karakter!");
        }else{
            model.setId(id);
            model.setNama_kategori(nama);
            
            try {
                model.updateKategori();
                JOptionPane.showMessageDialog(view, "Ketegori berhasil di ubah!");
                model.resetKategori();
            } catch (Throwable e) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi kesalahan pada database dengan pesan ", e.getMessage()});
            }
        }
    }
    
    public void deleteKategori(KategoriFrame view){
        if (view.getTableKategori().getSelectedColumnCount()==0) {
            JOptionPane.showMessageDialog(view, "Pilih data yang ingin di hapus!");
            return;
        }
        
        if (JOptionPane.showConfirmDialog(view, "Apakah anda yakin ingin menghapus kategori ini?") == JOptionPane.OK_OPTION) {
            Integer id = Integer.parseInt(view.getTxtIdKategori().getText());
            model.setId(id);
            
            try {
                model.deleteKategori();
                JOptionPane.showMessageDialog(view, "Ketegori berhasil di hapus!");
                model.resetKategori();
            } catch (Throwable e) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi kesalahan pada database dengan pesan ", e.getMessage()});
            }
        }
    }
    
}
