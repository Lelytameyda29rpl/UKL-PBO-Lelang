/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latsol;
import java.util.Scanner;

/**
 *
 * @author MOKLET-2
 */
public class Pengaplikasian {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       Scanner input = new Scanner(System.in);
        
        Transaksi tr1 = new Transaksi();
        Barang br1 = new Barang();
        Masyarakat ms1 = new Masyarakat();
        Lelang lel1 = new Lelang();
        Laporan lap1 = new Laporan();
        
        System.out.println("Selamat datang di toko lelang");
        System.out.println("Ketik 1 jika anda mau melelang barang");
        System.out.println("Ketik 2 jika anda mau membeli barang");
        System.out.println("Ketik 3 jika anda mau melihat daftar barang lelang");
        System.out.println("Ketik 4 jika anda mau melihat laporan transaksi");
        System.out.println("Ketik 0 untuk keluar");
        int pilih;
        do{
            System.out.print("Masukkan pilihan anda disini : ");
            pilih = input.nextInt();
            if(pilih == 1){
                tr1.LelangBarang(br1, ms1);
            } else if(pilih == 2){
                tr1.TawarBarang(lel1, ms1, br1, lap1);
            }else if(pilih == 3){
                lap1.laporan(tr1, br1);
            }else if(pilih==4){
                lap1.laporan(tr1, br1, lel1);
            }
        }while(pilih != 0);
        
    }
    
}


