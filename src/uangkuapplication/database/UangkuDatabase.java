/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uangkuapplication.database;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import uangkuapplication.service.*;
import uangkuapplication.impl.*;

/**
 *
 * @author Kyoto
 */
public class UangkuDatabase {
    private static Connection connection;
    private static IKategori kategori;
    private static Transaksi transaksi;
    private static IPengguna pengguna;
    
    public static Connection getConnection() throws SQLException{
        if (connection == null) {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUrl("jdbc:mysql://localhost:3306/db_uangku");
            dataSource.setUser("root");
            dataSource.setPassword("");
            connection = dataSource.getConnection();
        }
        
        return connection;
    }
    
    public static IKategori getKategori() throws SQLException{
            if (kategori == null) {
                kategori = new Kategori(getConnection());
            }
            return kategori;
    }
    public static Transaksi getTransaksi() throws SQLException{
        if(transaksi == null){
            transaksi = new Transaksi(getConnection());
        }
        
        return transaksi;
    }
    public static IPengguna getPengguna() throws SQLException{
        if(pengguna == null){
            pengguna = new Pengguna(getConnection());
        }
        
        return pengguna;
    }
}
