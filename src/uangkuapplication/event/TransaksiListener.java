/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uangkuapplication.event;

import uangkuapplication.entity.EntityTransaksi;
import uangkuapplication.model.ModelTransaksi;

/**
 *
 * @author Wildhevire
 */
public interface TransaksiListener {
    public void onChange(ModelTransaksi model);
    public void onInsert(EntityTransaksi transaksi);
    public void onDelete();
    public void onUpdate(EntityTransaksi transaksi);
}
