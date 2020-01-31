/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uangkuapplication.entity;

import java.util.Objects;

/**
 *
 * @author Kyoto
 */
public class EntityKategori {
    private Integer id;
    private String nama_kategori;
    
    public EntityKategori(){
        
    }
<<<<<<< HEAD:src/uangkuapplication/entity/Kategori.java
    
    public Kategori(String nama_kategori) {
=======

    public EntityKategori(String nama_kategori) {
>>>>>>> 5d8175e987891e957ffbc2f3875ffc8ba362b6e0:src/uangkuapplication/entity/EntityKategori.java
        this.nama_kategori = nama_kategori;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama_kategori() {
        return nama_kategori;
    }

    public void setNama_kategori(String nama_kategori) {
        this.nama_kategori = nama_kategori;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.nama_kategori);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EntityKategori other = (EntityKategori) obj;
        if (!Objects.equals(this.nama_kategori, other.nama_kategori)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
