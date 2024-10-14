package entities;

public class Tamu {
    private final String nama;
    private final String kontak;

    public Tamu(String nama, String kontak) {
        if (nama == null || nama.isEmpty() || kontak == null || kontak.isEmpty()) {
            throw new IllegalArgumentException("Nama dan kontak tamu tidak boleh kosong!");
        }
        this.nama = nama;
        this.kontak = kontak;
    }

    public String getNama() {
        return nama;
    }

    public String getKontak() {
        return kontak;
    }
}
