# MINPRO-PBO-KEDUA

package management;

import entities.Tamu;
import entities.Hotel;
import java.util.Scanner;

Baris 1: package management;

Baris ini menunjukan bahwa kelas MainApp ada di dalam package management. jadi Package digunakan untuk mengelompokkan kelas-kelas dalam proyek yang lebih besar agar lebih terstruktur.
Baris 3-5: import entities.Tamu;, import entities.Hotel;, import java.util.Scanner; Kelas Tamu dan Hotel diimpor dari package entities. Keduanya mungkin adalah kelas entitas yang mewakili tamu dan hotel di sistem reservasi. Scanner diimpor dari package java.util untuk mengambil input dari pengguna melalui konsol.

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReservasiManager manager = new ReservasiManager();

        System.out.println("=== SISTEM RESERVASI HOTEL ===");

        Baris 7: public class MainApp {

Deklarasi kelas MainApp, yang merupakan kelas utama dalam program ini.
Baris 8: public static void main(String[] args) {

main method adalah titik masuk untuk menjalankan aplikasi ini.
Baris 9: Scanner scanner = new Scanner(System.in);

Membuat objek Scanner untuk membaca input dari pengguna melalui konsol.
Baris 10: ReservasiManager manager = new ReservasiManager();

Membuat objek ReservasiManager yang digunakan untuk mengelola reservasi. Kelas ReservasiManager ini bertanggung jawab untuk operasi CRUD (Create, Read, Update, Delete).
Baris 12: System.out.println("=== SISTEM RESERVASI HOTEL ===");

Menampilkan judul aplikasi di konsol.

while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Reservasi");
            System.out.println("2. Lihat Reservasi");
            System.out.println("3. Perbarui Reservasi");
            System.out.println("4. Hapus Reservasi");
            System.out.println("5. Tampilkan Semua Reservasi");
            System.out.println("0. Keluar");
            System.out.print("Pilih opsi: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();  // Konsumsi newline
Baris 14-24:
while (true): Loop ini membuat program terus berjalan sampai pengguna memilih untuk keluar. Pengguna akan diberikan menu dengan beberapa opsi.
Opsi yang tersedia meliputi:
1: Tambah reservasi.
2: Lihat reservasi berdasarkan nama tamu.
3: Perbarui reservasi.
4: Hapus reservasi.
5: Tampilkan semua reservasi yang ada.
0: Keluar dari aplikasi.
int pilihan = scanner.nextInt();: Program menunggu input angka dari pengguna yang sesuai dengan pilihan di menu.
scanner.nextLine();: Ini untuk membersihkan input newline setelah pengguna memasukkan angka, supaya tidak mengganggu input selanjutnya.

package management;

public interface CrudOperations<T> {
    void create(T item);
    T read(String key);
    void update(String key, T newItem);
    void delete(String key);
}

ini untuk crud  operations nya


package management;

import entities.Tamu;
import entities.Hotel;

public final class Reservasi {
    private final Tamu tamu;
    private final Hotel hotel;
    private String tanggal;
    private String jam;

    public Reservasi(Tamu tamu, Hotel hotel, String tanggal, String jam) {
        if (tamu == null || hotel == null || tanggal == null || jam == null ||
            tanggal.isEmpty() || jam.isEmpty()) {
            throw new IllegalArgumentException("Semua data harus diisi dengan benar!");
        }
        this.tamu = tamu;
        this.hotel = hotel;
        this.tanggal = tanggal;
        this.jam = jam;
    }

    public Tamu getTamu() {
        return tamu;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        if (tanggal != null && !tanggal.isEmpty()) {
            this.tanggal = tanggal;
        }
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        if (jam != null && !jam.isEmpty()) {
            this.jam = jam;
        }
    }

    @Override
    public String toString() {
        return String.format(
            "Reservasi untuk: %s\nHotel: %s, Lokasi: %s\nTanggal: %s | Jam: %s",
            tamu.getNama(), hotel.getNamaHotel(), hotel.getLokasi(), tanggal, jam
        );
    }
}


codingan ini untuk reservasinya

package management;

import entities.Tamu;
import entities.Hotel;

import java.util.ArrayList;
import java.util.List;

public class ReservasiManager {
    private final List<Reservasi> reservasiList;

    public ReservasiManager() {
        this.reservasiList = new ArrayList<>();
    }

    public void create(Reservasi reservasi) {
        reservasiList.add(reservasi);
        System.out.println("Reservasi berhasil ditambahkan.");
    }

    public void read(String nama) {
        for (Reservasi reservasi : reservasiList) {
            if (reservasi.getTamu().getNama().equalsIgnoreCase(nama)) {
                System.out.println(reservasi);
                return;
            }
        }
        System.out.println("Reservasi tidak ditemukan untuk tamu: " + nama);
    }

    public void update(String nama, String tanggalBaru, String jamBaru) {
        for (Reservasi reservasi : reservasiList) {
            if (reservasi.getTamu().getNama().equalsIgnoreCase(nama)) {
                reservasi.setTanggal(tanggalBaru);
                reservasi.setJam(jamBaru);
                System.out.println("Reservasi untuk " + nama + " berhasil diperbarui.");
                return;
            }
        }
        System.out.println("Reservasi tidak ditemukan untuk tamu: " + nama);
    }

    public void delete(String nama) {
        Reservasi reservasiToRemove = null;
        for (Reservasi reservasi : reservasiList) {
            if (reservasi.getTamu().getNama().equalsIgnoreCase(nama)) {
                reservasiToRemove = reservasi;
                break;
            }
        }

        if (reservasiToRemove != null) {
            reservasiList.remove(reservasiToRemove);
            System.out.println("Reservasi untuk " + nama + " berhasil dihapus.");
        } else {
            System.out.println("Reservasi tidak ditemukan untuk tamu: " + nama);
        }
    }

    public void tampilkanSemuaReservasi() {
        if (reservasiList.isEmpty()) {
            System.out.println("Tidak ada reservasi yang tersedia.");
            return;
        }
        System.out.println("\n=== Semua Reservasi ===");
        for (Reservasi reservasi : reservasiList) {
            System.out.println(reservasi);
            System.out.println("-------------------------------");
        }
    }
}


Kelas ReservasiManager ini berfungsi untuk mengelola daftar reservasi hotel dengan menggunakan koleksi List yang menyimpan objek Reservasi. Terdapat beberapa metode seperti create, read, update, dan delete untuk melakukan operasi CRUD pada daftar reservasi. Metode create menambahkan reservasi baru ke daftar, read mencari dan menampilkan reservasi berdasarkan nama tamu, update memperbarui tanggal dan jam reservasi untuk tamu tertentu, dan delete menghapus reservasi dari daftar. Selain itu, terdapat juga metode tampilkanSemuaReservasi yang menampilkan semua reservasi yang telah ditambahkan, dengan pengecekan jika daftar reservasi kosong.



Class Hotel:

package entities;

public class Hotel {
    private String namaHotel;
    private String lokasi;

    public Hotel(String namaHotel, String lokasi) {
        if (namaHotel == null || namaHotel.isEmpty() || lokasi == null || lokasi.isEmpty()) {
            throw new IllegalArgumentException("Nama hotel dan lokasi harus diisi.");
        }
        this.namaHotel = namaHotel;
        this.lokasi = lokasi;
    }

    public String getNamaHotel() {
        return namaHotel;
    }

    public void setNamaHotel(String namaHotel) {
        if (namaHotel != null && !namaHotel.isEmpty()) {
            this.namaHotel = namaHotel;
        }
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        if (lokasi != null && !lokasi.isEmpty()) {
            this.lokasi = lokasi;
        }
    }

    @Override
    public String toString() {
        return String.format("Hotel: %s, Lokasi: %s", namaHotel, lokasi);
    }
}

Kelas `Hotel` ini merepresentasikan entitas hotel dengan dua atribut utama: **`namaHotel`** dan **`lokasi`**. Konstruktor kelas ini menerima dua parameter, yaitu nama hotel dan lokasi, dan memastikan bahwa keduanya tidak null atau kosong. Jika salah satu parameter tidak valid, akan dilempar pengecualian **`IllegalArgumentException`**. Kelas ini menyediakan metode getter dan setter untuk atribut **`namaHotel`** dan **`lokasi`**, dengan validasi di setter untuk memastikan nilai yang diberikan tidak kosong atau null sebelum diperbarui. Metode **`toString`** digunakan untuk memberikan representasi string dari objek hotel, yang menampilkan nama hotel dan lokasinya dalam format yang rapi.


Class Pegawai:

package entities;

public final class Pegawai extends Person {
    private String jabatan;

    public Pegawai(String nama, String kontak, String jabatan) {
        super(nama, kontak);
        this.jabatan = jabatan;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Pegawai: " + getNama() + " | Kontak: " + getKontak() + " | Jabatan: " + jabatan);
    }
}


Class Person:

Kelas **`Person`** adalah kelas abstrak yang merepresentasikan seseorang dengan dua atribut utama: **`nama`** dan **`kontak`**, yang dideklarasikan sebagai final sehingga nilainya tidak bisa diubah setelah objek dibuat. Konstruktor kelas ini menerima dua parameter untuk inisialisasi **`nama`** dan **`kontak`**. Kelas ini juga menyediakan metode **`getNama`** dan **`getKontak`** untuk mengakses nilai dari atribut tersebut. Karena kelas ini abstrak, ia tidak dapat diinstansiasi langsung dan mengandung satu metode abstrak, yaitu **`tampilkanInfo`**, yang harus diimplementasikan oleh subclass-subclassnya untuk menampilkan informasi spesifik dari masing-masing jenis **`Person`**.


Class Tamu:

Kelas Tamu merepresentasikan entitas tamu dengan dua atribut utama yang bersifat final, yaitu nama dan kontak, yang artinya nilainya tidak bisa diubah setelah inisialisasi. Konstruktor kelas ini menerima dua parameter, yaitu nama dan kontak, dan melakukan validasi untuk memastikan bahwa keduanya tidak boleh kosong atau null. Jika ada yang tidak valid, maka akan dilempar pengecualian IllegalArgumentException. Kelas ini menyediakan dua metode akses (getter), yaitu getNama dan getKontak, yang digunakan untuk mengambil nilai dari atribut nama dan kontak tamu
