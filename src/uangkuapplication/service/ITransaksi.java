/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uangkuapplication.service;

import java.sql.SQLException;
import uangkuapplication.entity.*;


/**
 *
 * @author Wildhevire
 */
public interface ITransaksi {
    public void insertTransaksi(Transaksi transaksi) throws SQLException;
    public Transaksi getTransaksi(int id) throws SQLException;
}
