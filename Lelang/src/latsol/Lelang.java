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
public class Lelang {

    private ArrayList<Integer> idPenawar = new ArrayList<Integer>();
    private ArrayList<Integer> idBarang = new ArrayList<Integer>();
    private ArrayList<Integer> hargaTawar = new ArrayList<Integer>();
    
    public Lelang(){
//        this.idPenawar.add(0);
//        this.idBarang.add(1);
//        this.hargaTawar.add(1000000);
    }
    
    public void setIdPenawar(int idPenawar){
        this.idPenawar.add(idPenawar);
    }
    
    public void setIdBarang(int idBarang){
        this.idBarang.add(idBarang);
    }
    
    public void setHargaTawar(int harga){
        this.hargaTawar.add(harga);
    }
    
    public int getIdPenawar(int id){
        return this.idPenawar.get(id);
    }
    
    public int getIdBarang(int id){
        return this.idBarang.get(id);
    }
    
    public int getHargaTawar(int id){
        return this.hargaTawar.get(id);
    }
}