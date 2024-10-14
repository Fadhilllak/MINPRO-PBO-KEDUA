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
