/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uangkuapplication.main;
import java.util.prefs.Preferences;
import java.sql.SQLException;
import java.sql.Date;
import java.util.List;
import uangkuapplication.database.UangkuDatabase;
import uangkuapplication.entity.EntityKategori;
import uangkuapplication.entity.EntityTransaksi;
import uangkuapplication.error.KategoriException;
import uangkuapplication.service.IKategori;
import uangkuapplication.service.ITransaksi;
import uangkuapplication.view.LoginFrame;
import uangkuapplication.view.MainFrame;
import uangkuapplication.model.ModelTableKategori;

/**
 *
 * @author Kyoto
 */
public class UangkuApplication {

    /**
     * @param args the command line arguments
     */
    
   
    public static Preferences  prefs;
    public static int UserID;
    public static int Uang;
    public static List<EntityKategori> kategoriList;
    public static void main(String[] args) throws SQLException {
        prefs = Preferences.userRoot().node(UangkuApplication.class.getClass().getName());
        
        boolean isLoggedIn = prefs.getBoolean("isLoggedIn", false);
        
        LoginFrame login = new LoginFrame();
        MainFrame main = new MainFrame(prefs.get("UserFullName", ""));
        
        
        if(isLoggedIn==false){
            login.setVisible(true);
            
        }
        else{
            main.setVisible(true);
            UserID = prefs.getInt("UserID", 0);
            Uang = prefs.getInt("Uang", 0);
        }
        
        kategoriList = UangkuDatabase.getKategori().getAllKategori();
        
        UangkuDatabase.getConnection();
        
//        java.util.Date date = new java.util.Date();
//        
//        EntityTransaksi transaksi = new EntityTransaksi();
//        ITransaksi dao = UangkuDatabase.getTransaksi();
//        transaksi.setId_kategori(5);
//        transaksi.setUid(2);
//        transaksi.setNominal(200);
//        transaksi.setTgl_transaksi(new Date(date.getTime()));
//        transaksi.setCatatan("dadada");
//        transaksi.setUang_sekarang(2000);
//        dao.insertPemasukan(transaksi);
    }
    
    public static int findKategoriID(String name){
        int index;
        for (index = 0; index < kategoriList.size(); index++){
            if(kategoriList.get(index).getNama_kategori() == null ? name == null : kategoriList.get(index).getNama_kategori().equals(name)){
                return kategoriList.get(index).getId();
            }
        }
        return index;
    }
    
    
    
   
}
