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
import uangkuapplication.impl.Pengguna;
import uangkuapplication.view.LoginFrame;
import uangkuapplication.view.MainFrame;
import uangkuapplication.model.ModelTableKategori;
import uangkuapplication.controller.TransaksiController;
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
    public static String UserFullname;
    
    public static void main(String[] args) throws SQLException {
        //prefs = Preferences.userRoot().node(UangkuApplication.class.getClass().getName());
        prefs = Preferences.userNodeForPackage(uangkuapplication.main.UangkuApplication.class);
        boolean isLoggedIn = prefs.getBoolean("isLoggedIn", false);
        Pengguna pengguna = new Pengguna(UangkuDatabase.getConnection());
        LoginFrame login = new LoginFrame();
        
        
        if(isLoggedIn==false){
            login.setVisible(true);
            
        }
        else{
            
            UserID = prefs.getInt("UserID",0);
            //Uang = prefs.getInt("Uang", 0);
            UserFullname = pengguna.getFullname(UserID);
            Uang = pengguna.getUang(UserID);
            MainFrame.getInstance(UserFullname).setVisible(true);
        }
        
        kategoriList = UangkuDatabase.getKategori().getAllKategori();
        UangkuDatabase.getConnection();
        
        
        
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
