package com.example.kosmapokosciach;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PrzepisActivity extends AppCompatActivity {
    private TextView tytul;
    private ImageView obraz;
    private TextView skladniki;
    private TextView opis;
    private Button button;
    Przepis przepis = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_przepis);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tytul = findViewById(R.id.tytul);
        obraz = findViewById(R.id.imageView);
        skladniki = findViewById(R.id.textView2);
        opis = findViewById(R.id.textView3);
        button = findViewById(R.id.button);
        int indeks = getIntent().getIntExtra("INDEKS" , 0);
        String kategoria = getIntent().getStringExtra("KATEGORIA");

        if(indeks >= 0){
            przepis = RepozytoriumPrzepisow.zwrocPrzepisZDanejKategori(kategoria).get(indeks);
            //Toast.makeText(this, przepis.getNazwaPrzepisu() , Toast.LENGTH_SHORT).show();
            wywswietlPrzepis(przepis);
        }
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intentWyslij = new Intent();
                        intentWyslij.setAction(Intent.ACTION_SEND);
                        intentWyslij.putExtra(Intent.EXTRA_TEXT," Przepis: "+przepis.getNazwaPrzepisu()+" Kategoria: "+przepis.getKategoria()+" Opis "+przepis.getOpis()+" Składniki: "+przepis.getSkladniki());
                        intentWyslij.setType("text/plain");
                        Intent podzielintent = Intent.createChooser(intentWyslij , null);
                        startActivity(podzielintent);

                    }
                }
        );
    }
    private void wywswietlPrzepis(Przepis przepis){
        tytul.setText(""+przepis.getNazwaPrzepisu());
        obraz.setImageResource(przepis.getIdObrazka());
        skladniki.setText(""+przepis.getSkladniki());
        opis.setText(""+przepis.getOpis());
    }
}