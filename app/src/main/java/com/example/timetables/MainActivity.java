package com.example.timetables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar bar = findViewById(R.id.seekBar);
        final ListView numbersListView = findViewById(R.id.numbersListView);

        final int[][] tables = new int[20][10];
        for (int j=0; j < tables.length; j++) {
            for (int i=0; i < tables[j].length; i++) {
                tables[j][i] = (j + 1) * (i + 1);
            }
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i: tables[0]) {
            list.add(i);
        }
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        numbersListView.setAdapter(aa);
        bar.setMax(tables.length - 1);
        bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                for (int i: tables[progress]) {
                    list.add(i);
                }
                ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, list);
                numbersListView.setAdapter(adapter);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



    }
}