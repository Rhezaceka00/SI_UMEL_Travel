/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class Pesan {

    Scanner in = new Scanner(System.in);

    String[][] wisata = {{"", "Bali", "Lombok", "Danau Toba",},
    {"", "3H/2M", "4H/3M", "5H/4M"},
    {"", "1728000", "4250000", "3280000"}};
    String[][] ziarah = {{"", "Pamijahan (Tasikmalaya)", "Walisongo (jawa-madura)", "Wali9+wali7 (jawa-bali)"},
    {"", "3H/2M", "7H/5M", "8H/6M"},
    {"", "300000", "1500000", "2500000"}};
    String[][] custom = {{"", "Bali", "Lombok", "Danau Toba", "P.Komodo", "Belitung"},
    {"", "525000", "675000", "720000", "759000", "473000"}};
    String tujuan, lama;
    int plh, wst, zrh, ctm, org, hari, harga, total, tw, tz, tc, tagihan1, tagihan2, tagihan3, uang, sisa;
    boolean bayar = true, metode = true, prsn = true, day = true;
    float dsc;

    void menu() {
        for (int i = 1; i <= 56; i++) {
            System.out.print("=");
        }
        System.out.println("\n        __________SELAMAT_____DATANG__________");
        System.out.println("_______________Menu_____Pilihan______TRIP_______________");
        System.out.println("|1.Paket Wisata |2.Paket Ziarah |3.Paket Harian(custom)|");

        for (int i = 1; i <= 56; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    void pilih() {
        switch (plh) {
            case 1:
                System.out.println("\nDaftar Traveling Wisata Yang Tersedia");
                for (int i = 1; i <= 41; i++) {
                    System.out.print("=");
                }
                System.out.println("\n|\tTempat  |  Lama |     Harga     |");
                for (int i = 1; i <= 41; i++) {
                    System.out.print("-");
                }
                System.out.println();
                for (int i = 1; i < wisata[0].length; i++) {
                    System.out.println("| " + i + ". " + wisata[0][i] + "\t| " + wisata[1][i] + " | Rp." + wisata[2][i] + ",- |");
                }
                for (int i = 1; i <= 41; i++) {
                    System.out.print("-");
                }
                System.out.print("\n Pilih Paket Wisata : ");
                wst = in.nextInt();
                wisata();
                break;
            case 2:
                System.out.println("\n\t\t= Paket Tour Ziarah =");
                for (int i = 1; i <= 56; i++) {
                    System.out.print("=");
                }
                System.out.println("\n|\t\tTempat  \t|  Lama |     Harga    |");
                for (int i = 1; i <= 56; i++) {
                    System.out.print("-");
                }
                System.out.println();
                for (int i = 1; i < ziarah[0].length; i++) {
                    System.out.println("| " + i + ". " + ziarah[0][i] + " \t| " + ziarah[1][i] + " | Rp." + ziarah[2][i] + ",- |");
                }
                for (int i = 1; i <= 56; i++) {
                    System.out.print("-");
                }
                System.out.print("\n Pilih Paket Ziarah : ");
                zrh = in.nextInt();
                ziarah();
                break;
            case 3:
                System.out.println("\nPilihan Tujuan Yang Tersedia");
                for (int i = 1; i <= 29; i++) {
                    System.out.print("=");
                }
                System.out.println("\n|    Tempat    |   perhari   |");
                for (int i = 1; i <= 29; i++) {
                    System.out.print("-");
                }
                System.out.println();
                for (int i = 1; i < custom[0].length; i++) {
                    System.out.println("| " + i + ". " + custom[0][i] + "\t| Rp." + custom[1][i] + " |");
                }
                for (int i = 1; i <= 29; i++) {
                    System.out.print("-");
                }
                System.out.println("\n*nb : minimal pengambilan 3 hari dan 2 org.");
                System.out.print("\n Pilih Tujuan Daily Tour : ");
                ctm = in.nextInt();
                custom();
                break;
            default:
                System.out.println("Menu yang anda pilih tidak ada");
                System.out.print("Masukan Menu Yng Tersedia : ");
                plh = in.nextInt();
                pilih();
                break;
        }
    }

    void wisata() {
        switch (wst) {
            case 1:
                System.out.print(" masukan jumlah org : ");
                org = in.nextInt();
                tujuan = wisata[0][wst];
                lama = wisata[1][wst];
                harga = Integer.parseInt(wisata[2][wst]);
                tw = harga * org;
                break;
//            case 2:
//                System.out.print(" masukan jumlah org : ");
//                org = in.nextInt();
//                tujuan = wisata[0][wst];
//                lama = wisata[1][wst];
//                harga = Integer.parseInt(wisata[2][wst]);
//                tw = harga * org;
//                break;
//            case 3:
//                System.out.print(" masukan jumlah org : ");
//                org = in.nextInt();
//                tujuan = wisata[0][wst];
//                lama = wisata[1][wst];
//                harga = Integer.parseInt(wisata[2][wst]);
//                tw = harga * org;
//                break;
            default:
                break;
        }
        if (org <= 5) {
            System.out.println(" diskon 5%");
            dsc = (int) (tw * 0.05);
        } else if (org <= 15) {
            System.out.println(" diskon 10%");
            dsc = (int) (tw * 0.10);
        } else if (org <= 40) {
            System.out.println(" diskon 20%");
            dsc = (int) (tw * 0.20);
        } else if (org >= 50) {
            System.out.println(" diskon 25%");
            dsc = (int) (tw * 0.25);
        }
        tagihan1 = (int) (tw - dsc);
        System.out.println("\nRincian perjalanan Wisata anda");
        System.out.println("----------------------------------");
        System.out.println("Perjalanan       : " + tujuan);
        System.out.println("Lama perjalanan  : " + lama);
        System.out.println("jumlah pembelian : " + org + " Kursi");
        System.out.println("Harga            : Rp." + harga + ",-/org");
        System.out.println("Total harga      : Rp." + tw + ",-");
    }

    void ziarah() {
        switch (zrh) {
            case 1:
                System.out.print(" masukan jumlah org : ");
                org = in.nextInt();
                tujuan = ziarah[0][zrh];
                lama = ziarah[1][zrh];
                harga = Integer.parseInt(ziarah[2][zrh]);
                tz = harga * org;
                break;
            case 2:
                System.out.print(" masukan jumlah org : ");
                org = in.nextInt();
                tujuan = ziarah[0][zrh];
                lama = ziarah[1][zrh];
                harga = Integer.parseInt(ziarah[2][zrh]);
                tz = harga * org;
                break;
            case 3:
                System.out.print(" masukan jumlah org : ");
                org = in.nextInt();
                tujuan = ziarah[0][zrh];
                lama = ziarah[1][zrh];
                harga = Integer.parseInt(ziarah[2][zrh]);
                tz = harga * org;
                break;
            default:
                break;
        }
        if (org <= 5) {
            System.out.println(" diskon 5%");
            dsc = (int) (tz * 0.05);
        } else if (org <= 15) {
            System.out.println(" diskon 10%");
            dsc = (int) (tz * 0.10);
        } else if (org <= 40) {
            System.out.println(" diskon 20%");
            dsc = (int) (tz * 0.20);
        } else if (org >= 50) {
            System.out.println(" diskon 25%");
            dsc = (int) (tz * 0.25);
        }
        tagihan2 = (int) (tz - dsc);
        System.out.println("\nRincian perjalanan Ziarah anda");
        System.out.println("----------------------------------");
        System.out.println("Perjalanan       : " + tujuan);
        System.out.println("Lama perjalanan  : " + lama);
        System.out.println("jumlah pembelian : " + org + " Kursi");
        System.out.println("Harga            : Rp." + harga + ",-/org");
        System.out.println("Total harga      : Rp." + tz + ",-");
    }

    void custom() {
        switch (ctm) {
            case 1:
                tujuan = custom[0][ctm];
                harga = Integer.parseInt(custom[1][ctm]);
                break;
            case 2:
                tujuan = custom[0][ctm];
                harga = Integer.parseInt(custom[1][ctm]);
                break;
            case 3:
                tujuan = custom[0][ctm];
                harga = Integer.parseInt(custom[1][ctm]);
                break;
            case 4:
                tujuan = custom[0][ctm];
                harga = Integer.parseInt(custom[1][ctm]);
                break;
            case 5:
                tujuan = custom[0][ctm];
                harga = Integer.parseInt(custom[1][ctm]);
                break;
            default:
                System.out.println("Daily Tour tidak ada");
                break;
        }
        while (prsn) {
            System.out.print(" masukan jumlah org : ");
            org = in.nextInt();
            if (org < 2) {
                System.out.println("minimal 2 org.");
                prsn = true;
            } else {
                prsn = false;
            }
        }
        while (day) {
            System.out.print(" masukan jumlah Hari : ");
            hari = in.nextInt();
            if (org < 3) {
                System.out.println("minimal 3 Hari.");
                day = true;
            } else {
                day = false;
            }
        }
        tc = harga * hari * org;
        if (org <= 5) {
            System.out.println(" diskon 5%");
            dsc = (int) (tc * 0.05);
        } else if (org <= 15) {
            System.out.println(" diskon 10%");
            dsc = (int) (tc * 0.10);
        } else if (org <= 40) {
            System.out.println(" diskon 20%");
            dsc = (int) (tc * 0.20);
        } else if (org >= 50) {
            System.out.println(" diskon 25%");
            dsc = (int) (tc * 0.25);
        }
        tagihan3 = (int) (tc - dsc);
        System.out.println("\nRincian Daily Tour anda");
        System.out.println("----------------------------------");
        System.out.println("Perjalanan       : " + tujuan);
        System.out.println("Lama perjalanan  : " + hari + " hari");
        System.out.println("jumlah pembelian : " + org + " Kursi");
        System.out.println("Harga            : Rp." + harga + ",-/hari");
        System.out.println("Total Pembayaran : Rp." + tc + ",-");
    }

    void hitung() {

        total = total + tagihan1 + tagihan2 + tagihan3;

        System.out.println("diskon           : Rp." + dsc + ",-");
        System.out.println("====================================");
        System.out.println("Total Tagihan    : Rp." + total + ",-\n");
    }

    void bayar() {
        while (metode) {
            System.out.print("Masukkan nama anda : ");
            String data = in.next();
            System.out.println("\nAtas nama "+data+"\n");
            System.out.print("Metode Pembayaran [Cash/Transfer] : ");
            String pembayaran = in.next();
            if (pembayaran.equalsIgnoreCase("CASh") || pembayaran.equalsIgnoreCase("C") || pembayaran.equals("1")) {
                while (bayar) {
                    System.out.print("\nmasukan saldo        = Rp.");
                    uang = in.nextInt();
                    sisa = uang - total;
                    if (uang == total) {
                        bayar = false;
                    } else if (uang >= total) {
                        System.out.println("=======================================");
                        System.out.println("Sisa Cash            = Rp." + sisa);
                        bayar = false;
                    } else if (uang <= total) {
                        System.out.println("Uang Anda Kurang     = Rp." + sisa + "\n");
                        bayar = true;
                    }
                }
                metode = false;
            } else if (pembayaran.equalsIgnoreCase("Transfer") || pembayaran.equalsIgnoreCase("T") || pembayaran.equals("2")) {
                System.out.println("\nTotal Tagihan   : Rp." + total + ",-\n");
                System.out.println("No Rekening Transfer ---751 223 4438---");
                metode = false;
            } else {
                System.out.println("\nMetode tidak ada / salah input");
                System.out.println("Silahkan Masukan Metode yang tersedia\n");
                metode = true;
            }
        }
    }
}

public class Tour_and_Travel {

    public static void main(String[] args) {
        Date Tanggal = new Date();
        SimpleDateFormat tgl;
        tgl = new SimpleDateFormat("E,dd/MMM/yy hh:mm:ss a");
        Pesan pesan = new Pesan();

        for (int i = 1; i <= 56; i++) {
            System.out.print("_");
        }
        System.out.println("\n_______________[ TRIP_and_TRAVEL__SI UMEL ]_______________");
        System.out.println("                _Solusi_Perjalanan_Anda_");
        System.out.println("\t\t" + tgl.format(Tanggal));
        pesan.menu();
        System.out.print("Masukkan menu pilihan anda : ");
        pesan.plh = pesan.in.nextInt();
        pesan.pilih();
        pesan.hitung();
        pesan.bayar();
        System.out.println("\n         ---- TERIMAKASIH ----");
        System.out.println("    Selamat Ber-Traveling-ria Bapak/Ibu");
        System.out.println("   Kepercayaan Anda, Kepuasan Bagi Kami");
        System.out.println("==========================================");
    }

}
