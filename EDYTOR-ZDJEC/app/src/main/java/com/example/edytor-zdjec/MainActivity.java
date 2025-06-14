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

    int dzwiek_val = 50;
    int gamma_val = 50;
    int grafika_val = 50;
    int sort = 0;

    String[] gat = {"Dzwiek", "Gamma", "Grafika"};

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
                if (temp_rasa == "Dzwiek") {
                    bar.setEnabled(true);
                    bar.setProgress(dzwiek_val);
                    opcja.setText("Dzwiek:");
                    show.setText("Wartosc: " + String.valueOf(dzwiek_val));
                    sort = 1;
                } else if (temp_rasa == "Gamma") {
                    bar.setEnabled(true);
                    bar.setProgress(gamma_val);
                    opcja.setText("Gamma:");
                    show.setText("Wartosc: " + String.valueOf(gamma_val));
                    sort = 2;
                } else {
                    bar.setEnabled(true);
                    bar.setProgress(grafika_val);
                    opcja.setText("Grafika:");
                    show.setText("Wartosc: " + String.valueOf(grafika_val));
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
                    dzwiek_val = bar.getProgress();
                } else if (sort == 2) {
                    gamma_val = bar.getProgress();
                } else {
                    grafika_val = bar.getProgress();
                }
            }

        });
    }
}