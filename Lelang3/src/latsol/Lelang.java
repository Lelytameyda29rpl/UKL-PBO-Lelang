/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latsol;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author MOKLET-2
 */
public class Lelang {
    private ArrayList<Integer> idPenawar = new ArrayList<Integer>();
    private ArrayList<Integer> idBarang = new ArrayList<Integer>();
    private ArrayList<Integer> hargaTawar = new ArrayList<Integer>();
    
    public Lelang() {
        this.idPenawar.add(0);
        this.idBarang.add(0);
        this.hargaTawar.add(2);
    }

    public void prosesLelang(Masyarakat masyarakat, Lelang lelang, Barang barang) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("==========SILAHKAN LELANG BARANG ANDA!==========");
        System.out.println(" ");
        System.out.print("Masukkan ID Masyarakat Pelelang    : ");
        int idMasyPel = myObj.nextInt();
        
        System.out.println("Selamat datang " + masyarakat.getNama(idMasyPel));
        barang.setIdMasyarakat(idMasyPel);
        
        System.out.println(" ");
        System.out.print("Masukkan Barang yang mau dilelang  : ");
        String namaBarang = myObj.next();
        barang.setNamaBarang(namaBarang);

        System.out.print("Masukkan harga awal lelang         : Rp.");
        int hargaAwal = myObj.nextInt();
        barang.setHargaAwal(hargaAwal);

        System.out.print("Apakah barang bisa ditawar?(yes/no):");
        String answer = myObj.next();
        
        if ("yes".equals(answer)) {
            barang.setStatus(true);
            System.out.println("Barang dapat ditawar");
        } else {
            barang.setStatus(false);
            System.out.println("Barang tidak boleh ditawar");
        }
    }

    static int idPw;
    static int inputIdBarang;
    static String namaPemenang = "";

    public void prosesPenawaran(Masyarakat masyarakat, Lelang lelang, Barang barang) {
        Scanner myObj = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("========== LELANG BARANG DI BUKA ==========");
        System.out.print("Masukkan kode barang              : ");
        inputIdBarang = myObj.nextInt();
        this.idBarang.add(inputIdBarang);
        System.out.println("Barang yang dilelang              : " + barang.getNamaBarang(inputIdBarang));
        
        if (barang.getStatus(inputIdBarang) == true) {
            System.out.println("======SILAHKAN MELAKUKAN PENAWARAN BARANG!======");
            
            int temp = 0;

            do {
                System.out.print("Masukkan ID Masyarakat            : ");
                idPw = myObj.nextInt();
                System.out.println("Selamat datang " + masyarakat.getNama(idPw));

                //ArrayList<Integer> idBarang = new ArrayList<Integer>();
                //ArrayList<Integer> hargaTawar = new ArrayList<Integer>();

                int i = 0;
                do {
                    System.out.print("Lakukan penawaran? [ya = 1 / berhenti = 99] : ");
                    temp = myObj.nextInt();
                
                    if (temp != 99) {
                        //idBarang.add(temp);
                        System.out.print(barang.getNamaBarang(inputIdBarang) + " Harga Tawar          : Rp.");
                        int inputHargaTawar = myObj.nextInt();
                        if (inputHargaTawar > barang.getHargaAwal(inputIdBarang)) {
                            if (inputHargaTawar < Collections.max(this.hargaTawar)) {
                                continue;
                            } else {
                                namaPemenang = masyarakat.getNama(idPw);
                                this.hargaTawar.add(inputHargaTawar);
                            }
                        } else {
                            System.out.println("Harga tawar lebih rendah dari harga awal");
                            System.out.println("Silahkan mengulangi");
                            this.prosesPenawaran(masyarakat, lelang, barang);
                        }
                        i++;
                    }
                } while (temp != 99);
                
                System.out.println();
                System.out.print("Lanjutkan atau matikan 1 / 99 ?   : ");
                temp = myObj.nextInt();
                
            } while (temp != 99);
            
        } else if (barang.getStatus(inputIdBarang) == false) {
            System.out.println("Barang tidak dapat ditawar");
            System.out.println("Masukkan id barang yang dapat ditawar");
            this.prosesPenawaran(masyarakat, lelang, barang);
        }
        
        System.out.println("Barang sudah tidak dapat dilelang");
        barang.editStatus(inputIdBarang, false);
        System.out.println("Status barang saat ini          : " + barang.getStatus(inputIdBarang));
        this.pemenang(barang);

    }
    
        public void pemenang(Barang barang) {
            int total = 0;
            int x = idBarang.size();

            System.out.println("\n =========TABEL PEMENANG LELANG BARANG=========");
            System.out.println("Barang yang dilelang     :  " + barang.getNamaBarang(inputIdBarang));
            System.out.println("Nama pemenang            :  " + namaPemenang);
            System.out.println("Harga Awal               :  Rp." + barang.getHargaAwal(inputIdBarang));
            System.out.println("Harga tertinggi          :  Rp." + Collections.max(this.hargaTawar));
        }
    
    public void setLelang(Barang barang, int idPenawar, int idBarang, int hargaTawar) {
        this.idPenawar.add(idPenawar);
        this.idBarang.add(idBarang);
        this.hargaTawar.add(hargaTawar);
        barang.editStatus(idBarang, barang.getStatus(idBarang));
    }

    public int getIdBarang(int id) {
        return this.idBarang.get(id);
    }

    public int getBanyaknya(int id) {
        return this.hargaTawar.get(id);
    }
    
    public int getIdPenawar(int id) {
        return this.idPenawar.get(id);
    }

    public int getJmlLelang() {
        return this.idPenawar.size();
    }
    
    public void setHargaTawar(int hargaTawar) {
        this.hargaTawar.add(hargaTawar);
    }

    public int getHargaTawar(int idBarang) {
        return this.hargaTawar.get(idBarang);
    }
    
}
    

