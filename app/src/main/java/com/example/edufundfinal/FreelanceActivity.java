package com.example.edufundfinal;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FreelanceActivity extends AppCompatActivity {

    // Array of strings
    String[] skillTitle = new String[]{
            "Skill 1 - ₹100/hr", "Skill 2 - ₹200/hr", "Skill 3 - ₹150/hr", "Skill 4 - ₹300/hr",
            "Skill 5 - ₹250/hr", "Skill 6 - ₹180/hr", "Skill 7 - ₹220/hr", "Skill 8 - ₹120/hr",
    };
    int[] skillImage = new int[]{
            R.drawable.item_image, R.drawable.item_image, R.drawable.item_image, R.drawable.item_image,
            R.drawable.item_image, R.drawable.item_image, R.drawable.item_image, R.drawable.item_image,
    };
    String[] skillShortDescription = new String[]{
            "Skill description", "Skill description", "Skill description", "Skill description",
            "Skill description", "Skill description", "Skill description", "Skill description",
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_imgtext);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();
        for (int i = 0; i < 8; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("skill_title", skillTitle[i]);
            hm.put("skill_description", skillShortDescription[i]);
            hm.put("skill_image", Integer.toString(skillImage[i]));
            aList.add(hm);
        }
        String[] from = {"skill_image", "skill_title", "skill_description"};
        int[] to = {R.id.item_image, R.id.list_item_title, R.id.item_description};

        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.skill_list, from, to);

        ListView androidListView = findViewById(R.id.skill_list);
        androidListView.setAdapter(simpleAdapter);
    }
}

