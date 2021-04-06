import java.util.ArrayList;

public class Item{
    private String deskripsi;
    private String nama;
    private ArrayList<String> arrAksi = new ArrayList<>(); //pilihan aksi untuk item
    private Ruangan objRuangan;  //ruangan tempat item, jika null artinya item dipegang npc atau plyaer
    private GameInfo objGameInfo;

    //constructor
    public Item(String nama) {
        this.nama = nama;
    }

    //dapat dijadikan inheritance
    public void prosesAksi(int pil) {
        if (pil==1) {
            System.out.println(deskripsi);
        } else  if (pil==2) {
            if (objRuangan==null) {
                dibuang();
            } else {
                //ada di ruangan, diambil player
                diambil();
            }
        }
    }

    private void dibuang() {
        System.out.println("Item dibuang player ke ruangan");
        objGameInfo.getObjPlayer().hapusItem(this); //hapus dari player
        objGameInfo.getObjRuangan().addItem(this);  //tambah ke ruangan
        objRuangan = objGameInfo.getObjRuangan(); // set ruangan
    }


    //pindahkan item dari ruangan ke player
    //tidak perlu diinhenritance
    private void diambil() {
        System.out.println("Item diambil player");
        objGameInfo.getObjPlayer().addItem(this);     //tambahkan  objek ini (this) pada player
        objRuangan.hapusItem(this);                    //hapus dari ruangan
        objRuangan = null;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    //inheritance ruangan dengan memanggil deskripsi yang sudah ada di ruangan
    public void printItem() {
        System.out.println(deskripsi);
    }

    public ArrayList<String> getAksi() {
        //aksi dinamik tergantung ada di ruangan atau dipegang player/npc
        ArrayList<String> arrOut = new ArrayList<>();
        if (objRuangan==null) {
            //ada di player, ada opsi buang
            arrOut.add("Deskripsi Item");
            arrOut.add("Buang item");
        } else {
            //ada di ruangan ada opsi ambil
            arrOut.add("Deskripsi Item");
            arrOut.add("Ambil item");
        }
        return(arrOut);
    }

    public void setObjGameInfo(GameInfo objGameInfo) {
        this.objGameInfo = objGameInfo;
    }

    public void setObjRuangan(Ruangan objRuangan) {
        this.objRuangan = objRuangan;
    }
    public String getDeskripsi() {
        return deskripsi;
    }
    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }


}
