/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uangkuapplication.event;

import uangkuapplication.entity.Kategori;
import uangkuapplication.model.KategoriModel;

/**
 *
 * @author Kyoto
 */
public interface KategoriListener {
    public void onChange(KategoriModel model);
    public void onInsert(Kategori kategori);
    public void onDelete();
    public void onUpdate(Kategori kategori);
}
