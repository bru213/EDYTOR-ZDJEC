package com.example.ustawienia_gry;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    int efekty_val = 50;
    int jasnosc_val = 50;
    int rozmycie_val = 50;
    int sort = 0;

    String[] gat = {"Efekty", "Jasnosc", "Rozmycie"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ListView list = findViewById(R.id.list);
        TextView opcja = findViewById(R.id.opcja);
        SeekBar bar = findViewById(R.id.bar);
        TextView show = findViewById(R.id.show);

        bar.setEnabled(false);




        ArrayAdapter<String> arr;
        arr = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, gat);
        list.setAdapter(arr);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String temp_rasa = (String) adapterView.getItemAtPosition(i);
                if (temp_rasa == "Efekty") {
                    bar.setEnabled(true);
                    bar.setProgress(efekty_val);
                    opcja.setText("Efekty:");
                    show.setText("Wartosc: " + String.valueOf(efekty_val));
                    sort = 1;
                } else if (temp_rasa == "Jasnosc") {
                    bar.setEnabled(true);
                    bar.setProgress(jasnosc_val);
                    opcja.setText("Jasnosc:");
                    show.setText("Wartosc: " + String.valueOf(jasnosc_val));
                    sort = 2;
                } else {
                    bar.setEnabled(true);
                    bar.setProgress(rozmycie_val);
                    opcja.setText("Rozmycie:");
                    show.setText("Wartosc: " + String.valueOf(rozmycie_val));
                    sort = 3;
                }
            }
        });

        bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar bar, int i, boolean b) {
                int val = bar.getProgress();
                String vals = String.valueOf(val);
                show.setText("Wartosc: " + vals);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (sort == 1){
                    efekty_val = bar.getProgress();
                } else if (sort == 2) {
                    jasnosc_val = bar.getProgress();
                } else {
                    rozmycie_val = bar.getProgress();
                }
            }

        });
    }
}
