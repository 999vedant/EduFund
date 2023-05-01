package com.example.edufundfinal;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ThriftStoreActivity extends AppCompatActivity {

    // Array of strings for ListView Title
    String[] listviewTitle = new String[]{
            "Item 1 - ₹10", "Item 2 - ₹20", "Item 3 - ₹15", "Item 4 - ₹30",
            "Item 5 - ₹25", "Item 6 - ₹18", "Item 7 - ₹22", "Item 8 - ₹12",
    };

    int[] listviewImage = new int[]{
            R.drawable.item_image, R.drawable.item_image, R.drawable.item_image, R.drawable.item_image,
            R.drawable.item_image, R.drawable.item_image, R.drawable.item_image, R.drawable.item_image,
    };

    String[] listviewShortDescription = new String[]{
            "Item description", "Item description", "Item description", "Item description",
            "Item description", "Item description", "Item description", "Item description",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_with_image_and_text);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < 8; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("listview_title", listviewTitle[i]);
            hm.put("listview_description", listviewShortDescription[i]);
            hm.put("listview_image", Integer.toString(listviewImage[i]));
            aList.add(hm);
        }

        String[] from = {"listview_image", "listview_title", "listview_description"};
        int[] to = {R.id.item_image, R.id.list_item_title, R.id.item_description};

        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.list_item, from, to);

        ListView androidListView = findViewById(R.id.items_list);
        androidListView.setAdapter(simpleAdapter);
    }
}
