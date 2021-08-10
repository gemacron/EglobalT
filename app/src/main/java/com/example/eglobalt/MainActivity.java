package com.example.eglobalt;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

public class MainActivity extends AppCompatActivity {

    private PieChartView piechart;
    private AutoCompleteTextView autoCompleteTextView;

    String[] servicios = {"Tigo", "Infonet", "Billetaje"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        piechart = (PieChartView) findViewById(R.id.chart);
        autoCompleteTextView = (AutoCompleteTextView)  findViewById(R.id.autoCompleteTextView);

        List pieData = new ArrayList<>();
        pieData.add(new SliceValue(15, Color.RED).setLabel("Canceled"));
        pieData.add(new SliceValue(25, Color.BLUE).setLabel("Reverse"));
        pieData.add(new SliceValue(10, Color.YELLOW).setLabel("Inicited"));
        pieData.add(new SliceValue(60, Color.GREEN).setLabel("Success"));


        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasLabels(true).setValueLabelTextSize(14);
        piechart.setPieChartData(pieChartData);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item,servicios);

        //autoCompleteTextView.setTextColor(Color.RED);
        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setAdapter(adapter);

        autoCompleteTextView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                autoCompleteTextView.showDropDown();
                autoCompleteTextView.setAdapter(adapter);
            }
        });

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
}