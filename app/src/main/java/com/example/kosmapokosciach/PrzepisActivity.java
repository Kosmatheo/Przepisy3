package com.example.kosmapokosciach;

import android.os.Bundle;
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
        int indeks = getIntent().getIntExtra("INDEKS" , 0);
        String kategoria = getIntent().getStringExtra("KATEGORIA");
        Przepis przepis = null;
        if(indeks >= 0){
            przepis = RepozytoriumPrzepisow.zwrocPrzepisZDanejKategori(kategoria).get(indeks);
            //Toast.makeText(this, przepis.getNazwaPrzepisu() , Toast.LENGTH_SHORT).show();
            wywswietlPrzepis(przepis);
        }
    }
    private void wywswietlPrzepis(Przepis przepis){
        tytul.setText(""+przepis.getNazwaPrzepisu());
        obraz.setImageResource(przepis.getIdObrazka());
        skladniki.setText(""+przepis.getSkladniki());
        opis.setText(""+przepis.getOpis());
    }
}