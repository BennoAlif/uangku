/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uangkuapplication.event;

import uangkuapplication.entity.EntityRencana;
import uangkuapplication.model.ModelRencana;

/**
 *
 * @author Rizki Restu
 */
public interface RencanaListener {
    
    public void onChange(ModelRencana model);
    public void onInsert(EntityRencana rencana);
    public void onDelete();
    public void onUpdate(EntityRencana rencana);

    public void onChange();
    public void onBayar(EntityRencana rencana);
}
