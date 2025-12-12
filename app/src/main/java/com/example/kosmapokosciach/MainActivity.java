package com.example.kosmapokosciach;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.kosmapokosciach.databinding.ActivityListaPrzepisowBinding;

public class MainActivity extends AppCompatActivity {
ListView listViewkategorie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        listViewkategorie = findViewById(R.id.listViewkategorie);
        listViewkategorie.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        view.setBackgroundColor(Color.GRAY);
                        //Toast.makeText(MainActivity.this, "Kliknięto element: "+i, Toast.LENGTH_SHORT).show();
                        String wybranaKategoria = adapterView.getItemAtPosition(i).toString();
                        Intent intent = new Intent(MainActivity.this , ListaPrzepisowActivity.class);
                        intent.putExtra("KATEGORIA" , wybranaKategoria);
                        startActivity(intent);
                    }
                }
        );
    }
}