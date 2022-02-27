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
public class Masyarakat implements User {
    private ArrayList<String> namaMasyarakat = new ArrayList<String>();
    private ArrayList<String> alamat = new ArrayList<String>();
    private ArrayList<String> telepon = new ArrayList<String>();

    public Masyarakat() {
        this.namaMasyarakat.add("Nayla");
        this.alamat.add("Blitar");
        this.telepon.add("081223445678");

        this.namaMasyarakat.add("Ayura");
        this.alamat.add("Malang");
        this.telepon.add("085806752070");
        
        this.namaMasyarakat.add("Nadya");
        this.alamat.add("Kediri");
        this.telepon.add("087654332112");
    }

    public int getJmlMasyarakat() {
        return this.namaMasyarakat.size();
    }
    @Override
    public void setNama(String namaMasyarakat) {
        this.namaMasyarakat.add(namaMasyarakat);
    }
    
    @Override
    public void setAlamat(String alamat) {
        this.alamat.add(alamat);
    }
    
    @Override
    public void setTelepon(String telepon) {
        this.telepon.add(telepon);
    }

    @Override
    public String getNama(int idMasyarakat) {
        return this.namaMasyarakat.get(idMasyarakat);
    }
    
    @Override
    public String getAlamat(int idMasyarakat) {
        return this.alamat.get(idMasyarakat);
    }
    
    @Override
    public String getTelepon(int idMasyarakat) {
        return this.telepon.get(idMasyarakat);
    }

}

    

