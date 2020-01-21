/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uangkuapplication.main;

import java.sql.SQLException;
import uangkuapplication.database.UangkuDatabase;
import uangkuapplication.view.LoginFrame;

/**
 *
 * @author Kyoto
 */
public class UangkuApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        LoginFrame login = new LoginFrame();
        login.setVisible(true);
        UangkuDatabase.getConnection();
    }
    
}
