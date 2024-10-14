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
