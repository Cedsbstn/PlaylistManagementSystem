# Dalam sistem ini, terdapat dua peran utama:

- Admin Playlist, bertugas untuk menambahkan lagu ke dalam sistem dan melihat daftar lagu yang tersimpan.
- Pengguna Playlist, dapat menelusuri lagu yang ada, melihat detail lagu tertentu, serta menghitung rata-rata durasi lagu dalam playlist.
- Sistem ini harus dapat mengelola data lagu menggunakan konsep Object-Oriented Programming (OOP) dan memanfaatkan array untuk menyimpan kumpulan lagu.

# Konsep OOP secara lengkap:
- Enkapsulasi: Pada class Lagu, atribut dibuat private (private String judul;, dll.) dan Anda sudah menyediakan getter (getJudul(), dll.) serta setter (setJudul(), dll.).
- Inheritance: Class Admin dan Member sudah menggunakan keyword extends untuk mewarisi class User (class Admin extends User, class Member extends User).
- Polymorphism: Method tampilkanAkses() pada class User telah di-override (@Override) dengan implementasi yang berbeda di class Admin dan Member. Class Member juga melakukan override pada method lihatPlaylist dan cariLaguByJudul.
