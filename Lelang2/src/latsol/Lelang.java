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
        System.out.print("Masukkan ID Masyarakat Pelelang     : ");
        int idMasyPel = myObj.nextInt();
        System.out.println("Selamat datang " + masyarakat.getNama(idMasyPel));
        barang.setIdMasyarakat(idMasyPel);
        System.out.println(" ");
        System.out.print("Masukkan Barang yang mau dilelang   : ");
        String namaBarang = myObj.next();
        barang.setNamaBarang(namaBarang);

        System.out.print("Masukkan harga awal lelang          : Rp.");
        int hargaAwal = myObj.nextInt();
        barang.setHargaAwal(hargaAwal);

        System.out.print("Apakah barang bisa ditawar?(yes/no) : ");
        String answer = myObj.next();
        if (answer.equalsIgnoreCase("yes")) {
            barang.setStatus(true);
            System.out.println("Barang dapat ditawar");
        } else {
            barang.setStatus(false);
            System.out.println("Barang tidak boleh ditawar");
        }
    }

    static String namaPemenang = "";
    static int kode;

    public void prosesPenawaran(Masyarakat masyarakat, Lelang lelang, Barang barang) {
        Scanner myObj = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("========== LELANG BARANG DI BUKA ==========");
        System.out.print("Masukkan kode barang              : ");
        kode = myObj.nextInt();
        this.idBarang.add(kode);
        System.out.println("Barang yang dilelang            : " + barang.getNamaBarang(kode));

        if (barang.getStatus(kode) == true) {
            System.out.println("===== SILAHKAN MELAKUKAN PENAWARAN BARANG =====");

            ArrayList<Integer> idPenawar = new ArrayList<Integer>();
            ArrayList<Integer> hargaTawar = new ArrayList<Integer>();
            
            int temp = 0;
            do {

                System.out.print("Masukkan id masyarakat     : ");
                int id = myObj.nextInt();
                idPenawar.add(id);
                System.out.print("Masukkan harga tawar       : Rp.");
                int tawar = myObj.nextInt();
                hargaTawar.add(tawar);

                if (tawar < Collections.max(this.hargaTawar)) {
                    continue;
                } else {
                    namaPemenang = masyarakat.getNama(id);
                   
                }
             
                System.out.print("\nLanjutkan penawaran atau hentikan 1 / 99 ? : ");
                temp = myObj.nextInt();

            } while (temp != 99);

            System.out.println("Barang sudah tidak dapat dilelang");
            barang.editStatus(kode, false);
            System.out.println("Status barang saat ini          : " + barang.getStatus(kode));

            System.out.println();
            System.out.println("<<< Transaksi lelang " + barang.getNamaBarang(kode) + " sebagai berikut >>>");
            System.out.println("Nama \tHarga Awal \t Harga Tawar");
            int total = 0;
            int x = hargaTawar.size();
            for (int j = 0; j < x; j++) {
                System.out.println(masyarakat.getNama(idPenawar.get(j)) + "\t"
                        + barang.getHargaAwal(kode) + "\t"
                        + hargaTawar.get(j));
                lelang.setLelang(barang, idPenawar.get(j), kode, hargaTawar.get(j));
            }

        } else if (barang.getStatus(kode) == false) {
            System.out.println("Barang tidak bisa ditawar, masukkan kode barang yang bisa ditawar");
            this.prosesPenawaran(masyarakat, lelang, barang);
        }
    }

    public void pemenang(Barang barang) {
        int total = 0;
        int x = idBarang.size();

        System.out.println("\n =========TABEL PEMENANG LELANG BARANG=========");
        System.out.println("Barang yang dilelang     :  " + barang.getNamaBarang(kode));
        System.out.println("Nama pemenang            :  " + namaPemenang);
        System.out.println("Harga awal               :  Rp." + barang.getHargaAwal(kode));
        System.out.println("Harga tertinggi          :  Rp." + Collections.max(this.hargaTawar));
    }

    public void setLelang(Barang barang, int idPenawar, int idBarang, int hargaTawar) {
        this.idPenawar.add(idPenawar);
        this.idBarang.add(idBarang);
        this.hargaTawar.add(hargaTawar);
        barang.editStatus(idBarang, barang.getStatus(idBarang));
    }

    public int getJmlLelang() {
        return this.idPenawar.size();
    }

    public int getIdPenawar(int id) {
        return this.idPenawar.get(id);
    }

    public int getIdBarang(int id) {
        return this.idBarang.get(id);
    }

    public int getHargaTawar(int idBarang) {
        return this.hargaTawar.get(idBarang);
    }

}
