/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latsol;

import java.util.ArrayList;

/**
 *
 * @author MOKLET-2
 */
public class Barang {
    private ArrayList<Integer> idMasyarakat = new ArrayList<Integer>();
    private ArrayList<String> namaBarang = new ArrayList<String>();
    private ArrayList<Integer> hargaAwal = new ArrayList<Integer>();
    private ArrayList<Boolean> status = new ArrayList<Boolean>();
    
    public Barang(){
//        this.idMasyarakat.add(0);
//        this.namaBarang.add("Televisi");
//        this.hargaAwal.add(300000);
//        this.status.add(true);
    }
    
    public void setIdMasyarakat(int id){
        this.idMasyarakat.add(id);
    }
    
    public void setNamaBarang(String nama){
        this.namaBarang.add(nama);
    }
    
    public void setHargaAwal(int harga){
        this.hargaAwal.add(harga);
    }
    
    public void setStatus(boolean status){
        this.status.add(status);
    }
    
    public int getIdMasyarakat(int id){
        return this.idMasyarakat.get(id);
    }
    
    public String getNamaBarang(int id){
        return this.namaBarang.get(id);
    }
    
    public int getHargaAwal(int id){
        return this.hargaAwal.get(id);
    }
    
    public boolean getStatus(int id){
        return this.status.get(id);
    }
    
    public void editStatus(int id, Boolean status){
        this.status.set(id, status);
    }
    
}



