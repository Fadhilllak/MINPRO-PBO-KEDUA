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
