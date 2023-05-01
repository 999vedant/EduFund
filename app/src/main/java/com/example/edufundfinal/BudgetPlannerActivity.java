package com.example.edufundfinal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



import androidx.appcompat.app.AppCompatActivity;

public class BudgetPlannerActivity extends AppCompatActivity {

    private EditText allowanceEditText, daysEditText;
    private TextView resultTextView;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);   //back button

        // Initialize UI components
        allowanceEditText = findViewById(R.id.allowanceEditText);
        daysEditText = findViewById(R.id.daysEditText);
        resultTextView = findViewById(R.id.resultTextView);
        calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateDailyBudget();
            }
        });
    }

    private void calculateDailyBudget() {
        // Get user input
        double allowance = Double.parseDouble(allowanceEditText.getText().toString());
        int days = Integer.parseInt(daysEditText.getText().toString());

        // Calculate daily budget
        double dailyBudget = allowance / days;

        // Display result
        resultTextView.setText(String.format("You can spend ₹%.2f per day to make it last for %d days", dailyBudget, days));
    }
}