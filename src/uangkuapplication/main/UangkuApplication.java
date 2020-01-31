/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uangkuapplication.main;
import java.util.prefs.Preferences;
import java.sql.SQLException;
import java.util.List;
import uangkuapplication.database.UangkuDatabase;
import uangkuapplication.entity.EntityKategori;
import uangkuapplication.error.KategoriException;
import uangkuapplication.service.IKategori;
import uangkuapplication.view.LoginFrame;
import uangkuapplication.view.MainFrame;

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
        }
        
        UangkuDatabase.getConnection();
    }
    
   
}
