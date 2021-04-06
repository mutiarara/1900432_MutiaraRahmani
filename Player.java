import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.String.format;

public class Player {
    private Item objCincin = new Item("Cincin Emas");
    private ArrayList<Item> arrItem;
    private Ruangan ruanganAktif;
    private int kesehatan = 100;
    private String nama = "budiwati";
    private Scanner sc = new Scanner(System.in);
    private GameInfo objGameInfo;

    public int getKesehatan() {
        return kesehatan;
    }

    public void setKesehatan(int kesehatan) {
        this.kesehatan = kesehatan;
    }

    public GameInfo getObjGameInfo() {
        return objGameInfo;
    }

    public void setObjGameInfo(GameInfo objGameInfo) {
        this.objGameInfo = objGameInfo;
        objCincin.setObjGameInfo(objGameInfo);
    }

    public Player() {
        arrItem = new ArrayList<>();
        objCincin.setDeskripsi("Cincin emas bertuliskan suatu kalimat..");
        arrItem.add(objCincin);
    }

    public void addItem(Item objItem) {
        arrItem.add(objItem);
    }

    public boolean cariItem(String namaItem) {
        for (Item objItem:arrItem) {
            if (namaItem.equals(objItem.getNama())) {
                return (true);
            }
        }
        return(false);
    }

    public void printPlayer() {
        System.out.println("Nama Player:"+nama);
        System.out.println("Kesehatan Player:"+kesehatan);
    }

    public void printItem() {
        System.out.println("Item milik player");
        int cc = 0;
        for (Item objItem:arrItem) {
            cc++;
            System.out.printf("%d. %s%n",cc,objItem.getNama());
            System.out.println(objItem.getDeskripsi());
        }
    }

    public void hapusItem(Item objItem) {
        arrItem.remove(objItem);
    }


    public void pilihanAksi() {
        System.out.println("**** Pilihan Aksi pada Player *** ");

        int urutPil = 0;
        int subPil;
        System.out.println("Item yang dimiliki player");
        for (Item objItem:arrItem) {
            urutPil++;
            subPil = 0;
            System.out.println(objItem.getNama());

            ArrayList <String> arrPil = objItem.getAksi();

            for (String strPil:arrPil) {
                subPil++;
                System.out.printf("%d%d. %s %n", urutPil, subPil, strPil);
            }
        }

        //menggunakan inheritance terkait info player
        urutPil++;
        subPil = 0;
        int pilInfoPlayer  = urutPil;
        System.out.println("Info Player");

        subPil++;
        System.out.printf("%d%d. info player%n", urutPil, subPil);

        System.out.print("Pilihan anda?");
        String strPil = sc.next();
        System.out.println("--");

        int pil    =  Integer.parseInt(strPil.substring(0,1));
        subPil     =  Integer.parseInt(strPil.substring(1,2));

        if (pil == pilInfoPlayer) {
            printPlayer();
        } else {
            Item objItemPilih = arrItem.get(pil-1);
            objItemPilih.prosesAksi(subPil);
        }
//        System.out.println("2. Item milik player");
//        System.out.print("Pilihan anda?");
//        int pil = sc.nextInt();
//        System.out.println("--");
//        if (pil==1) {
//            printPlayer();
//        } else if (pil==2) {
//            printItem();
//        }
    }

    public void setRuanganAktif(Ruangan ruanganAktif) {
        this.ruanganAktif = ruanganAktif;
    }
    public Ruangan getRuanganAktif() {
        return ruanganAktif;
    }

}
