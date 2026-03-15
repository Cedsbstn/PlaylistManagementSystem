/*
Cedric Sebastian - 2902735603
DAVID MARSEN PURBA - 2802527513
LULU NUR AINI - 2902722342 
MUHAMMAD RAFLI - 2902724291
SHAHIRA ALYA MUJAHIDAH - 2902721945
*/

class Lagu { // Kelas untuk merepresentasikan sebuah lagu
    private String judul;
    private String artis;
    private double durasi;

    // Constructor
    public Lagu(String judul, String artis, double durasi) {
        this.judul  = judul;
        this.artis = artis;
        this.durasi = durasi;
    }

    // Method untuk menampilkan informasi lagu
    public void tampilkanInfo() {
        System.out.println("Judul: " + judul);
        System.out.println("Artist: " + artis);
        System.out.println("Durasi: " + durasi + " menit");
    }

    // Getter untuk atribut
    public String getJudul() {
        return judul;
    }

    public String getArtis() {
        return artis;
    }

    public double getDurasi() {
        return durasi;
    }

    // Setter untuk atribut
    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setArtis(String artis) {
        this.artis = artis;
    }

    public void setDurasi(double durasi) {
        this.durasi = durasi;
    }
}

class User {

    protected String nama; // menyimpan nama user

    // Constructor untuk membuat user
    public User(String nama){
        this.nama = nama;
    }

    // Method untuk menampilkan semua lagu di playlist
    public void lihatPlaylist(Lagu[] playlist, int jumlahLagu){

        if(jumlahLagu == 0){
            System.out.println("Playlist kosong.");
            return;
        }

        for(int i = 0; i < jumlahLagu; i++){
            playlist[i].tampilkanInfo();
        }
    }

    // Method untuk mencari lagu berdasarkan judul
    public void cariLaguByJudul(Lagu[] playlist, int jumlahLagu, String judulCari){

        for(int i = 0; i < jumlahLagu; i++){

            if(playlist[i].getJudul().equalsIgnoreCase(judulCari)){
                System.out.println("Lagu ditemukan:");
                playlist[i].tampilkanInfo();
                return;
            }
        }

        System.out.println("Lagu tidak ditemukan.");
    }

    // Method umum untuk menjelaskan hak akses user
    public void tampilkanAkses(){
        System.out.println("Member");
    }
}

class Admin extends User {

    // Constructor admin
    public Admin(String nama){
        super(nama);
    }

    // Override method untuk menunjukkan akses admin
    @Override
    public void tampilkanAkses(){
        System.out.println("Admin dapat menambah lagu, melihat playlist, dan mencari lagu.");
    }

    // Method untuk menambahkan lagu ke playlist
    public int tambahLagu(Lagu[] playlist, Lagu laguBaru, int jumlahLagu){

        if(jumlahLagu < playlist.length){
            playlist[jumlahLagu] = laguBaru;
            jumlahLagu++;
            System.out.println("Lagu berhasil ditambahkan.");
        } else {
            System.out.println("Playlist penuh.");
        }

        return jumlahLagu;
    }
}

class Member extends User {

    // constructor untuk membuat objek member
    public Member(String namaMember) {
        super(namaMember);
    }

    // polymorphism: isi method berbeda dengan class User
    @Override
    public void tampilkanAkses() {
        System.out.println("Member hanya dapat melihat daftar lagu dan mencari judul lagu.");
    }

    // method untuk menampilkan playlist lagu
    @Override
    public void lihatPlaylist(Lagu[] playlist, int jumlahLagu) {
        System.out.println("\n=== Daftar Lagu ===");

        if (jumlahLagu == 0) {
            System.out.println("Playlist kosong.");
        } else {
            for (int i = 0; i < jumlahLagu; i++) {
                System.out.println("Data lagu " + (i + 1));
                playlist[i].tampilkanInfo();
                System.out.println();
            }
        }
    }

    @Override
    public void cariLaguByJudul(Lagu[] playlist, int jumlahLagu, String judulCari) {
        boolean ditemukan = false;

        System.out.println("\nHasil pencarian untuk lagu: " + judulCari);

        for (int i = 0; i < jumlahLagu; i++) {
            if (playlist[i].getJudul().equalsIgnoreCase(judulCari)) {
                playlist[i].tampilkanInfo();
                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Lagu tidak ditemukan.");
        }
    }
}

public class PlaylistOOP {
    public static void main(String[] args) {
        Lagu[] playlist = new Lagu[10];
        int jumlahLagu = 0;

        Admin admin = new Admin("Admin1");
        Member member = new Member("Member1");

        System.out.println("=== Akses Pengguna ===");
        admin.tampilkanAkses();
        member.tampilkanAkses();
        System.out.println();

        System.out.println("=== Admin Menambahkan Lagu ===");
        Lagu lagu1 = new Lagu("Dear God", "Avenged Sevenfold", 3.5);
        Lagu lagu2 = new Lagu("Just the way you are", "Bruno Mars", 4.2);
        
        jumlahLagu = admin.tambahLagu(playlist, lagu1, jumlahLagu);
        jumlahLagu = admin.tambahLagu(playlist, lagu2, jumlahLagu);

        System.out.println("\n=== Member Melihat Playlist ===");
        member.lihatPlaylist(playlist, jumlahLagu);

        System.out.println("=== Member Mencari Lagu ===");
        member.cariLaguByJudul(playlist, jumlahLagu, "Dear God");
        member.cariLaguByJudul(playlist, jumlahLagu, "Just the way you are");
    }
}