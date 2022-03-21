package com.example.demogk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Donut> donutList;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnDonut= findViewById(R.id.button);
        Button btnPinkDonut= findViewById(R.id.button2);
        Button btnFloating= findViewById(R.id.button3);
        listView=(ListView) findViewById(R.id.listView);
        donutList= new ArrayList<>();
        donutList.add(new Donut(1,"Tasty Donut","Spicy tasty donut family",20));
        donutList.add(new Donut(2,"Tasty Donut","Spicy tasty donut family",20));
        donutList.add(new Donut(3,"Tasty Donut","Spicy tasty donut family",20));
        donutList.add(new Donut(4,"Tasty Donut","Spicy tasty donut family",20));

        DonutAdapter donutAdapter=new DonutAdapter(this, R.layout.item,donutList);
        listView.setAdapter(donutAdapter);


    }
}