package com.example.kosmapokosciach;

import java.util.ArrayList;

public class RepozytoriumPrzepisow {
    private static ArrayList<Przepis> przepisy;
    private static void wygenerujPrzepisy(){
        przepisy = new ArrayList<>();
        przepisy.add(new Przepis("ciastka z borówkami" , "ciasteczka",R.drawable.ciastka_z_b, "jaja , czekolada , borówki" , "opis"));
        przepisy.add(new Przepis("ciastka francuskie" , "ciasteczka",R.drawable.ciastka_francuskie, "jaja , czekolada , borówki" , "opis"));
        przepisy.add(new Przepis("ciastka" , "ciasteczka",R.drawable.ciastkajpg, "jaja , czekolada , borówki" , "opis"));
        przepisy.add(new Przepis("deser z truskawkami" , "ciasteczka",R.drawable.deser_t, "jaja , czekolada , borówki" , "opis"));
        przepisy.add(new Przepis("sernik" , "git",R.drawable.sernik, "jaja , czekolada , borówki" , "opis"));
        przepisy.add(new Przepis("kakao" , "napoj",R.drawable.kakao, "jaja , czekolada , borówki" , "opis"));
        przepisy.add(new Przepis("deser z truskawkami" , "ciasteczka",R.drawable.deser_t, "jaja , czekolada , borówki" , "opis"));
    }
    public static ArrayList<Przepis> zwrocPrzepisy(){
        wygenerujPrzepisy();
        return przepisy;
    }
    public static ArrayList<Przepis> zwrocPrzepisZDanejKategori(String kategoria){
        wygenerujPrzepisy();
        ArrayList<Przepis> wybranePrzepisy = new ArrayList<>();
        for(Przepis przepis: przepisy){
            if(przepis.getKategoria().equals(kategoria)){
                wybranePrzepisy.add(przepis);
            }
        }
        return wybranePrzepisy;
    }

}
