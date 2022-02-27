/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latsol;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author MOKLET-2
 */
public class Transaksi {
//private ArrayList<Integer> idMasyarakat = new ArrayList<Integer>();
//kalau mau beli
//private ArrayList<Integer> idBarang = new ArrayList<Integer>();
//private ArrayList<Integer> hargaTawar = new ArrayList<Integer>();
//kalau mau jual
//private ArrayList<String> namaBarang = new ArrayList<String>();
//private ArrayList<Integer> hargaAwal = new ArrayList<Integer>();
    
        ArrayList<Integer> idMasyarakatPelelang = new ArrayList<Integer>();
        ArrayList<Integer> idMasyarakatPenawar = new ArrayList<Integer>();
        ArrayList<String> namaBarang = new ArrayList<String>();
        ArrayList<Integer> hargaAwal = new ArrayList<Integer>();
        ArrayList<Integer> hargaTawar = new ArrayList<Integer>();
    
    Scanner input = new Scanner(System.in);
    public void LelangBarang(Barang barang, Masyarakat masyarakat){
//        ArrayList<Integer> idMasyarakat = new ArrayList<Integer>();
//        ArrayList<String> namaBarang = new ArrayList<String>();
//        ArrayList<Integer> hargaAwal = new ArrayList<Integer>();
        
        System.out.println("=== LELANG BARANG ===\nSilahkan isi data berikut ini");
        
        System.out.print("Id masyarakat : ");
        int idMas = input.nextInt();
        idMasyarakatPelelang.add(idMas);
        
        System.out.print("Nama Barang : ");
        String nama = input.next();
        namaBarang.add(nama);
        barang.setNamaBarang(nama);
        System.out.println(namaBarang);
        
        System.out.print("Harga Awal : ");
        int harga = input.nextInt();
        hargaAwal.add(harga);
        barang.setHargaAwal(harga);
        
        barang.setStatus(true);
    }
    
    public void TawarBarang(Lelang lelang, Masyarakat masyarakat, Barang barang, Laporan laporan){
        System.out.println("=== TAWAR BARANG ===\nSilahkan isi data berikut ini");
        
        System.out.print("Id masyarakat : ");
        int idMas = input.nextInt();
        idMasyarakatPenawar.add(idMas);
        
        laporan.laporan(this, barang);
        System.out.print("No Barang : ");
        int idBrg = input.nextInt();
        
        
        int inputHargaTawar;
        do {
            System.out.print("Harga Tawar : ");
            inputHargaTawar = input.nextInt();
            
            if (inputHargaTawar > barang.getHargaAwal(idBrg)) {
                System.out.println("Anda berhasil menawar barang ini");
                barang.editStatus(idBrg, false);
                hargaTawar.add(inputHargaTawar);
                lelang.setHargaTawar(inputHargaTawar);
                
            } else {
                System.out.println("Anda harus menawar dengan harga yang lebih tinggi");
            }
        } while (inputHargaTawar < barang.getHargaAwal(idBrg));
       
        System.out.println("Berikut detail penawaran barang yang anda lakukan : ");
        System.out.println("Nama \t Barang \t Harga Awal \t Harga Akhir \t Status");
        System.out.println(masyarakat.getNama(idMas) + "\t" + barang.getNamaBarang(idBrg) + " \t " + barang.getHargaAwal(idBrg) + "\t\t" + lelang.getHargaTawar(idBrg) +"\t"+ barang.getStatus(idBrg));
    }
    
    public String getNamaBarang(int id){
        return this.namaBarang.get(id);
    }
    
    public int getHargaTawar(int id){
        return this.hargaTawar.get(id);
    }
}