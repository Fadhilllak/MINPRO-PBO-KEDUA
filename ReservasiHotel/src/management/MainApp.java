package management;

import entities.Tamu;
import entities.Hotel;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReservasiManager manager = new ReservasiManager();

        System.out.println("=== SISTEM RESERVASI HOTEL ===");

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

            if (pilihan == 0) break;

            switch (pilihan) {
                case 1 -> tambahReservasi(scanner, manager);
                case 2 -> {
                    System.out.print("Nama Tamu: ");
                    String nama = scanner.nextLine();
                    manager.read(nama);
                }
                case 3 -> perbaruiReservasi(scanner, manager);
                case 4 -> {
                    System.out.print("Nama Tamu: ");
                    String nama = scanner.nextLine();
                    manager.delete(nama);
                }
                case 5 -> manager.tampilkanSemuaReservasi();
                default -> System.out.println("Opsi tidak valid.");
            }
        }

        System.out.println("Terima kasih telah menggunakan sistem reservasi.");
    }

    private static void tambahReservasi(Scanner scanner, ReservasiManager manager) {
        System.out.print("Nama Tamu: ");
        String namaTamu = scanner.nextLine();
        System.out.print("Kontak: ");
        String kontak = scanner.nextLine();
        Tamu tamu = new Tamu(namaTamu, kontak);

        System.out.print("Nama Hotel: ");
        String namaHotel = scanner.nextLine();
        System.out.print("Lokasi: ");
        String lokasi = scanner.nextLine();
        Hotel hotel = new Hotel(namaHotel, lokasi);

        System.out.print("Tanggal Reservasi (YYYY-MM-DD): ");
        String tanggal = scanner.nextLine();
        System.out.print("Jam Reservasi (HH:mm): ");
        String jam = scanner.nextLine();

        try {
            Reservasi reservasi = new Reservasi(tamu, hotel, tanggal, jam);
            manager.create(reservasi);
        } catch (IllegalArgumentException e) {
            System.out.println("Gagal menambahkan reservasi: " + e.getMessage());
        }
    }

    private static void perbaruiReservasi(Scanner scanner, ReservasiManager manager) {
        System.out.print("Nama Tamu: ");
        String nama = scanner.nextLine();
        System.out.print("Tanggal Baru (YYYY-MM-DD): ");
        String tanggalBaru = scanner.nextLine();
        System.out.print("Jam Baru (HH:mm): ");
        String jamBaru = scanner.nextLine();

        try {
            manager.update(nama, tanggalBaru, jamBaru);
        } catch (IllegalArgumentException e) {
            System.out.println("Gagal memperbarui reservasi: " + e.getMessage());
        }
    }
}
