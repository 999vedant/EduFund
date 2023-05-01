package com.example.edufundfinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.edufundfinal.R;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button budgetButton = findViewById(R.id.budgetButton);
        Button transactionButton = findViewById(R.id.transactionButton);
        Button thriftButton = findViewById(R.id.thriftButton);
        Button freelanceButton = findViewById(R.id.freelanceButton);

        budgetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BudgetPlannerActivity.class);
                startActivity(intent);
            }
        });

        transactionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TransactionTrackerActivity.class);
                startActivity(intent);
            }
        });


        thriftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ThriftStoreActivity.class);
                startActivity(intent);
            }
        });

        freelanceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FreelanceActivity.class);
                startActivity(intent);
            }
        });
    }
}
