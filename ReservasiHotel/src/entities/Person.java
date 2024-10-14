package entities;

public abstract class Person {
    private final String nama;
    private final String kontak;

    public Person(String nama, String kontak) {
        this.nama = nama;
        this.kontak = kontak;
    }

    public String getNama() {
        return nama;
    }

    public String getKontak() {
        return kontak;
    }

    public abstract void tampilkanInfo();
}
