/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uangkuapplication.main;

import java.sql.SQLException;
import java.util.List;
import uangkuapplication.database.UangkuDatabase;
import uangkuapplication.entity.Kategori;
import uangkuapplication.error.KategoriException;
import uangkuapplication.service.KategoriDao;
import uangkuapplication.view.LoginFrame;

/**
 *
 * @author Kyoto
 */
public class UangkuApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, KategoriException {
        LoginFrame login = new LoginFrame();
        login.setVisible(true);

//        KategoriDao dao = UangkuDatabase.getKategoriDao();
//        dao.deleteKategori(2);
    }
    
}
