package com.example.kosmapokosciach;

public class Przepis {
    private String nazwaPrzepisu;
    private String Kategoria;
    private int idObrazka;
    private String skladniki;
    private String opis;

    public Przepis(String nazwaPrzepisu) {
        this.nazwaPrzepisu = nazwaPrzepisu;
        Kategoria = "Cisteczka";
        skladniki = "";
        opis = "";
        idObrazka = R.drawable.ciastka_z_b;
    }

    public Przepis(String nazwaPrzepisu, String kategoria, int idObrazka, String skladniki, String opis) {
        this.nazwaPrzepisu = nazwaPrzepisu;
        this.Kategoria = kategoria;
        this.idObrazka = idObrazka;
        this.skladniki = skladniki;
        this.opis = opis;
    }

    public String getNazwaPrzepisu() {
        return nazwaPrzepisu;
    }

    public void setNazwaPrzepisu(String nazwaPrzepisu) {
        this.nazwaPrzepisu = nazwaPrzepisu;
    }

    public String getKategoria() {
        return Kategoria;
    }

    public void setKategoria(String kategoria) {
        Kategoria = kategoria;
    }

    public int getIdObrazka() {
        return idObrazka;
    }

    public void setIdObrazka(int idObrazka) {
        this.idObrazka = idObrazka;
    }

    public String getSkladniki() {
        return skladniki;
    }

    public void setSkladniki(String skladniki) {
        this.skladniki = skladniki;
    }

    public String getOpis() {
        return opis;
    }
    private int indeks;

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Override
    public String toString() {
        return nazwaPrzepisu;

    }
}
