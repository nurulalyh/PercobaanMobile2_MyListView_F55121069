package com.nurulaliyah_f55121069.mylistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] data_Name;
    private String[] data_Description;
    private TypedArray data_Photo;
    private HeroAdapter adapter;
    private ArrayList<Hero> heroes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new HeroAdapter(this);
        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);
        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 10) {
                    startActivity(new Intent(MainActivity.this, nurul.class));
                }
                else {
                    Toast.makeText(MainActivity.this, heroes.get(position).getName(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void addItem() {
        heroes = new ArrayList<>();

        for (int i = 0; i < data_Name.length; i++) {
            Hero hero = new Hero();
            hero.setPhoto(data_Photo.getResourceId(i, -1));
            hero.setName(data_Name[i]);
            hero.setDescription(data_Description[i]);
            heroes.add(hero);
        }
        adapter.setHeroes(heroes);
    }

    private void prepare() {
        data_Name = getResources().getStringArray(R.array.data_name);
        data_Description = getResources().getStringArray(R.array.data_description);
        data_Photo = getResources().obtainTypedArray(R.array.data_photo);
    }
}