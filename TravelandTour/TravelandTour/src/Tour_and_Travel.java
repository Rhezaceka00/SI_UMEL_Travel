import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.text.DateFormat;
import java.util.Date;
import java.util.Scanner;
//import javax.swing.JOptionPane;

class Pesan {
//deklrasi variable
    Scanner in = new Scanner(System.in);
    //awal mula membuat array list
    ArrayList Wisata = new ArrayList();
    ArrayList WisataHarian = new ArrayList();
    ArrayList Ziarah = new ArrayList();

    Connection conn = new Koneksi().connect();
//    String[][] wisata = {{"", "Bali", "Lombok", "Danau Toba",},
//    {"", "3H/2M", "4H/3M", "5H/4M"},
//    {"", "1728000", "4250000", "3280000"}};
//    String[][] ziarah = {{"", "Pamijahan (Tasikmalaya)", "Walisongo (jawa-madura)", "Wali9+wali7 (jawa-bali)"},
//    {"", "3H/2M", "7H/5M", "8H/6M"},
//    {"", "300000", "1500000", "2500000"}};
//    String[][] custom = {{"", "Bali", "Lombok", "Danau Toba", "P.Komodo", "Belitung"},
//    {"", "525000", "675000", "720000", "759000", "473000"}};
    
    String nt, tujuan, lama;
    int plh, wst, zrh, ctm, org, hari, harga, total, tw, tz, tc, tagihan1, tagihan2, tagihan3, uang, sisa;
    boolean bayar = true, metode = true, prsn = true, day = true;
    float dsc;

    void init() {
        String sql = "";

        //cara kConnection conn = new Koneksi().connect();onesi ke databasenya
        sql = "select * from wisata";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            int i = 0;
            while (hasil.next()) {
                Wisata.add(new ArrayList());
                ((ArrayList) Wisata.get(i)).add(hasil.getString("TempatWisata"));
                ((ArrayList) Wisata.get(i)).add(hasil.getString("LamaWisata"));
                ((ArrayList) Wisata.get(i)).add(hasil.getString("HargaWisata"));
                i++;
            }
        } catch (Exception e) {
        }

        sql = "select * from wisataharian";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            int a = 0;
            while (hasil.next()) {
                WisataHarian.add(new ArrayList());
                ((ArrayList) WisataHarian.get(a)).add(hasil.getString("TempatCustom"));
                ((ArrayList) WisataHarian.get(a)).add(hasil.getString("HargaPerhari"));
                a++;
            }
        } catch (Exception e) {
        }

        sql = "select * from ziarah";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            int b = 0;
            while (hasil.next()) {
                Ziarah.add(new ArrayList());
                ((ArrayList) Ziarah.get(b)).add(hasil.getString("TempatZiarah"));
                ((ArrayList) Ziarah.get(b)).add(hasil.getString("LamaZiarah"));
                ((ArrayList) Ziarah.get(b)).add(hasil.getString("HargaZiarah"));
                b++;
            }
        } catch (Exception e) {
        }
    }
//menu
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
        String tempat = "";
        String lama = "";
        String harga = "";
        String perhari = "";
        switch (plh) {
            case 1: //WISATA
                System.out.println("\nDaftar Traveling Wisata Yang Tersedia");
                for (int i = 1; i <= 41; i++) {
                    System.out.print("=");
                }
                System.out.println("\n|\tTempat  |  Lama |     Harga     |");
                for (int i = 1; i <= 41; i++) {
                    System.out.print("-");
                }
                System.out.println();
                for (int i = 0; i < Wisata.size(); i++) {
                    tempat = (String) ((ArrayList) Wisata.get(i)).get(0);
                    lama = (String) ((ArrayList) Wisata.get(i)).get(1);
                    harga = (String) ((ArrayList) Wisata.get(i)).get(2);
                    System.out.println("| " + i + ". " + tempat + "\t| " + lama + " | Rp." + harga + ",- |");
                }
                for (int i = 1; i <= 41; i++) {
                    System.out.print("-");
                }
                System.out.print("\n Pilih Paket Wisata : ");
                wst = in.nextInt();
                wisata();
                break;
            case 2: //ZIARAH
                System.out.println("\n\t\t= Paket Tour Ziarah =");
                for (int i = 1; i <= 56; i++) {
                    System.out.print("=");
                }
                System.out.println("\n|\t\tTempat  \t|  Lama |     Harga    |");
                for (int i = 1; i <= 56; i++) {
                    System.out.print("-");
                }
                System.out.println();
                for (int i = 0; i < Ziarah.size(); i++) {
                    tempat = (String) ((ArrayList) Ziarah.get(i)).get(0);
                    lama = (String) ((ArrayList) Ziarah.get(i)).get(1);
                    harga = (String) ((ArrayList) Ziarah.get(i)).get(2);
                    System.out.println("| " + i + ". " + tempat + " \t| " + lama + " | Rp." + harga + ",- |");
                }
                for (int i = 1; i <= 56; i++) {
                    System.out.print("-");
                }
                System.out.print("\n Pilih Paket Ziarah : ");
                zrh = in.nextInt();
                ziarah();
                break;
            case 3: //CUSTOM HARIAN
                System.out.println("\nPilihan Tujuan Yang Tersedia");
                for (int i = 1; i <= 29; i++) {
                    System.out.print("=");
                }
                System.out.println("\n|    Tempat    |   perhari   |");
                for (int i = 1; i <= 29; i++) {
                    System.out.print("-");
                }
                System.out.println();
                for (int i = 0; i < WisataHarian.size(); i++) {
                    tempat = (String) ((ArrayList) WisataHarian.get(i)).get(0);
                    perhari = (String) ((ArrayList) WisataHarian.get(i)).get(1);
                    System.out.println("| " + i + ". " + tempat + "\t| Rp." + perhari + " |");
                }
                for (int i = 1; i <= 29; i++) {
                    System.out.print("-");
                }
                System.out.println("\n*nb : minimal pengambilan 3 hari dan 2 org.");
                System.out.print("\n Pilih Tujuan Daily Tour : ");
                ctm = in.nextInt();
                custom();
                break;
                //TIDAK ADA YANG DIPILIH
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
            case 0:
                System.out.print("Nomor Transaksi : ");
                nt = in.next();
                System.out.print(" masukan jumlah org : ");
                org = in.nextInt();
                tujuan = (String) ((ArrayList) Wisata.get(wst)).get(0);
                lama = (String) ((ArrayList) Wisata.get(wst)).get(1);
                harga = Integer.parseInt((String) ((ArrayList) Wisata.get(wst)).get(2));
                tw = harga * org;
                break;
            case 1:
                System.out.print("Nomor Transaksi : ");
                nt = in.next();
                System.out.print(" masukan jumlah org : ");
                org = in.nextInt();
                tujuan = (String) ((ArrayList) Wisata.get(wst)).get(0);
                lama = (String) ((ArrayList) Wisata.get(wst)).get(1);
                harga = Integer.parseInt((String) ((ArrayList) Wisata.get(wst)).get(2));
                tw = harga * org;
                break;
            case 2:
                System.out.print("Nomor Transaksi : ");
                nt = in.next();
                System.out.print(" masukan jumlah org : ");
                org = in.nextInt();
                tujuan = (String) ((ArrayList) Wisata.get(wst)).get(0);
                lama = (String) ((ArrayList) Wisata.get(wst)).get(1);
                harga = Integer.parseInt((String) ((ArrayList) Wisata.get(wst)).get(2));
                tw = harga * org;
                break;
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
        System.out.println("NomorTransaksi   : " + nt);
        System.out.println("Perjalanan       : " + tujuan);
        System.out.println("Lama perjalanan  : " + lama);
        System.out.println("jumlah pembelian : " + org + " Kursi");
        System.out.println("Harga            : Rp." + harga + ",-/org");
        System.out.println("Total harga      : Rp." + tw + ",-");

        String sql = "INSERT INTO rinciandana(`NomorTransaksi`,`Perjalanan`,`Lama Perjalanan`,`Jumlah Pembelian`,`Harga`, `Total Harga`, `Diskon`) value(?,?,?,?,?,?,?)";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, nt);
            stat.setString(2, tujuan);
            stat.setString(3, lama);
            stat.setInt(4, org);
            stat.setInt(5, harga);
            stat.setInt(6, tw);
            stat.setDouble(7, dsc);
            stat.execute();
        } catch (Exception e) {
        }
//        System.out.println(e.toString());
    }

    void ziarah() {
        switch (zrh) {
            case 0:
                System.out.print("Nomor Transaksi : ");
                nt = in.next();
                System.out.print(" masukan jumlah org : ");
                org = in.nextInt();
                tujuan = (String) ((ArrayList) Ziarah.get(zrh)).get(0);
                lama = (String) ((ArrayList) Ziarah.get(zrh)).get(1);
                harga = Integer.parseInt((String) ((ArrayList) Ziarah.get(zrh)).get(2));
                tz = harga * org;
                break;
            case 1:
                System.out.print("Nomor Transaksi : ");
                nt = in.next();
                System.out.print(" masukan jumlah org : ");
                org = in.nextInt();
                tujuan = (String) ((ArrayList) Ziarah.get(zrh)).get(0);
                lama = (String) ((ArrayList) Ziarah.get(zrh)).get(1);
                harga = Integer.parseInt((String) ((ArrayList) Ziarah.get(zrh)).get(2));
                tz = harga * org;
                break;
            case 2:
                System.out.print("Nomor Transaksi : ");
                nt = in.next();
                System.out.print(" masukan jumlah org : ");
                org = in.nextInt();
                tujuan = (String) ((ArrayList) Ziarah.get(zrh)).get(0);
                lama = (String) ((ArrayList) Ziarah.get(zrh)).get(1);
                harga = Integer.parseInt((String) ((ArrayList) Ziarah.get(zrh)).get(2));
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
        System.out.println("NomorTransaksi   : " + nt);
        System.out.println("Perjalanan       : " + tujuan);
        System.out.println("Lama perjalanan  : " + lama);
        System.out.println("jumlah pembelian : " + org + " Kursi");
        System.out.println("Harga            : Rp." + harga + ",-/org");
        System.out.println("Total harga      : Rp." + tz + ",-");

        String sql = "INSERT INTO rinciandana(`NomorTransaksi`,`Perjalanan`,`Lama Perjalanan`,`Jumlah Pembelian`,`Harga`, `Total Harga`, `Diskon`) value(?,?,?,?,?,?,?)";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, nt);
            stat.setString(2, tujuan);
            stat.setString(3, lama);
            stat.setInt(4, org);
            stat.setInt(5, harga);
            stat.setInt(6, tz);
            stat.setDouble(7, dsc);
            stat.execute();
        } catch (Exception e) {
        }

    }

    void custom() {
        switch (ctm) {
            case 0:
                System.out.print("Nomor Transaksi : ");
                nt = in.next();
                tujuan = (String) ((ArrayList) WisataHarian.get(ctm)).get(0);
                harga = Integer.parseInt((String) ((ArrayList) WisataHarian.get(ctm)).get(1));
                break;
            case 1:
                System.out.print("Nomor Transaksi : ");
                nt = in.next();
                tujuan = (String) ((ArrayList) WisataHarian.get(ctm)).get(0);
                harga = Integer.parseInt((String) ((ArrayList) WisataHarian.get(ctm)).get(1));
                break;
            case 2:
                System.out.print("Nomor Transaksi : ");
                nt = in.next();
                tujuan = (String) ((ArrayList) WisataHarian.get(ctm)).get(0);
                harga = Integer.parseInt((String) ((ArrayList) WisataHarian.get(ctm)).get(1));
                break;
            case 3:
                System.out.print("Nomor Transaksi : ");
                nt = in.next();
                tujuan = (String) ((ArrayList) WisataHarian.get(ctm)).get(0);
                harga = Integer.parseInt((String) ((ArrayList) WisataHarian.get(ctm)).get(1));
                break;
            case 4:
                System.out.print("Nomor Transaksi : ");
                nt = in.next();
                tujuan = (String) ((ArrayList) WisataHarian.get(ctm)).get(0);
                harga = Integer.parseInt((String) ((ArrayList) WisataHarian.get(ctm)).get(1));
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
            if (hari < 3) {
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
        System.out.println("NomorTransaksi   : " + nt);
        System.out.println("Perjalanan       : " + tujuan);
        System.out.println("Lama perjalanan  : " + hari);
        System.out.println("jumlah pembelian : " + org + " Kursi");
        System.out.println("Harga            : Rp." + harga + ",-/hari");
        System.out.println("Total Pembayaran : Rp." + tc + ",-");

        String sql = "INSERT INTO rinciandana(`NomorTransaksi`,`Perjalanan`,`Lama Perjalanan`,`Jumlah Pembelian`,`Harga`, `Total Harga`, `Diskon`) value(?,?,?,?,?,?,?)";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, nt);
            stat.setString(2, tujuan);
            stat.setInt(3, hari);
            stat.setInt(4, org);
            stat.setInt(5, harga);
            stat.setInt(6, tc);
            stat.setDouble(7, dsc);
            stat.execute();
        } catch (Exception e) {
        }
    }

    void hitung() {

        total = total + tagihan1 + tagihan2 + tagihan3;

        System.out.println("diskon           : Rp." + dsc + ",-");
        System.out.println("====================================");
        System.out.println("Total Tagihan    : Rp." + total + ",-\n");
    }

    void bayar() {
        while (metode) {
            System.out.print("Nomor Transaksi : ");
            String nt = in.next();
            System.out.print("Masukkan nama anda : ");
            String data = in.next();
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");  
            Date date = new Date();
            System.out.println("\nNomor Transaksi " + nt + "\n");
            System.out.println("\nAtas nama " + data + "\n");
            System.out.println("\nTanggal Transaksi " + date + "\n");
            System.out.print("Metode Pembayaran [Cash/Transfer] : ");
            String pembayaran = in.next();
            if (pembayaran.equalsIgnoreCase("CASH") || pembayaran.equalsIgnoreCase("C") || pembayaran.equals("1")) {
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
            
            String sql = "INSERT INTO struk(`NomorTransaksi`,`Nama`,`Tanggal`,`Saldo`,`SisaCash`) value(?,?,?,?,?)";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, nt);
            stat.setString(2, data);
            stat.setString(3, date.toString());
            stat.setInt(4, uang);
            stat.setInt(5, sisa);
            stat.execute();
        } catch (Exception e) {
        }
            
        }
    }
}

public class Tour_and_Travel {
    
        

    public static void main(String[] args) {
        Pesan pesan = new Pesan();
        pesan.init();
        int i = 0;
        int j = 0;
        // display contents of matrix
        //menampilkan  array list
        System.out.println("Paket Wisata :");
        for (i = 0; i < pesan.Wisata.size(); i++) {
            for (j = 0; j < ((ArrayList) pesan.Wisata.get(i)).size(); j++) {
                System.out.print((String) ((ArrayList) pesan.Wisata.get(i)).get(j) + "  ");
            }
            System.out.println();
        }
        System.out.println(" ");
        i = 0;
        j = 0;
        System.out.println("Paket Harian(Custom) :");
        for (i = 0; i < pesan.WisataHarian.size(); i++) {
            for (j = 0; j < ((ArrayList) pesan.WisataHarian.get(i)).size(); j++) {
                System.out.print((String) ((ArrayList) pesan.WisataHarian.get(i)).get(j) + "  ");
            }
            System.out.println();
        }
        System.out.println(" ");
        i = 0;
        j = 0;
        System.out.println("Paket Ziarah :");
        for (i = 0; i < pesan.Ziarah.size(); i++) {
            for (j = 0; j < ((ArrayList) pesan.Ziarah.get(i)).size(); j++) {
                System.out.print((String) ((ArrayList) pesan.Ziarah.get(i)).get(j) + "  ");
            }
            System.out.println();
        }
       
        SimpleDateFormat tgl;
        tgl = new SimpleDateFormat("E,dd/MMM/yy hh:mm:ss a");
        
//        for (int i = 1; i <= 56; i++) {
//            System.out.print("_");
//        }
        System.out.println("\n_______________[ TRIP_and_TRAVEL__SI UMEL ]_______________");
        System.out.println("                _Solusi_Perjalanan_Anda_");
//111
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
