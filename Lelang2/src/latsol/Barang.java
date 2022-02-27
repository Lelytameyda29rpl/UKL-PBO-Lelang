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
   
    public Barang() {
        this.idMasyarakat.add(0);
        this.namaBarang.add("Mobil");
        this.hargaAwal.add(30000000);
        this.status.add(true);
    }

    public int getJmlBarang() {
        return this.namaBarang.size();
    }
    
    public void setIdMasyarakat(int id){
        this.idMasyarakat.add(id);
    }
    
    public void setNamaBarang(String namaBarang) {
        this.namaBarang.add(namaBarang);
    }

    public void setHargaAwal(int hargaAwal) {
        this.hargaAwal.add(hargaAwal);
    }

    public void setStatus(boolean status) {
        this.status.add(status);
    }
    
    public int getIdMasyarakat(int id){
        return this.idMasyarakat.get(id);
    }
    
    public String getNamaBarang(int idBarang) {
        return this.namaBarang.get(idBarang);
    }

    public int getHargaAwal(int idBarang) {
        return this.hargaAwal.get(idBarang);
    }

    public boolean getStatus(int idBarang) {
        return this.status.get(idBarang);
    }

    public void editStatus(int idBarang, boolean status) {
        this.status.add(idBarang, status);
    }
    
}