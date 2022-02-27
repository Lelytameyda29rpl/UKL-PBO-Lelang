/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latsol;

/**
 *
 * @author MOKLET-2
 */
public class Laporan {
     public void laporan(Barang barang, Masyarakat masyarakat) {
        int x = barang.getJmlBarang();

        System.out.println();
        System.out.println("========== TABEL BARANG LELANG ==========");
        System.out.println("ID \tNama Barang \tHarga \t\tStatus \tPemilik");
        for (int i = 0; i < x; i++) {
            System.out.println(i +".\t" + 
                    barang.getNamaBarang(i) + "\t\t" + 
                    "Rp." + barang.getHargaAwal(i) + "\t" + 
                    barang.getStatus(i) + "\t" + 
                    masyarakat.getNama(barang.getIdMasyarakat(i)));
        }
    }

    public void laporan(Masyarakat masyarakat) {
        int x = masyarakat.getJmlMasyarakat();
        System.out.println("========== TABEL MASYARAKAT ==========");
        System.out.println("ID \tNama \tAlamat \t\tTelepon ");
        for (int i = 0; i < x; i++) {
            System.out.println(i + ".\t"+ masyarakat.getNama(i) + "\t"
                    + masyarakat.getAlamat(i) + "\t\t" + masyarakat.getTelepon(i));
        }
    }
    
    public void laporan(Lelang lelang, Masyarakat masyarakat, Barang barang) {
        int x = lelang.getJmlLelang();
        System.out.println("========== TABEL LELANG ==========");
        System.out.println("ID/NO \tNama penawar \tNama barang \tHarga Tawar ");
        for (int i = 0; i < x; i++) {
            System.out.println(i + ".\t"+ masyarakat.getNama(lelang.getIdPenawar(i)) + "\t\t"
                    + barang.getNamaBarang(lelang.getIdBarang(i)) + "\t" + lelang.getHargaTawar(i));
        }
    }
    
}

//    public void laporan(Petugas petugas) {
//        int x = petugas.getJmlPetugas();
//        System.out.println("===========TABEL PETUGAS============");
//        System.out.println("ID \tNama \tAlamat \t\tTelepon");
//        for (int i = 0; i < x; i++) {
//            System.out.println(i + ".\t" + petugas.getNama(i) + "\t"
//                    + petugas.getAlamat(i) + "\t" + petugas.getTelepon(i));
//        }
//    }

    

