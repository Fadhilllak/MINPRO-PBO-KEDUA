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
