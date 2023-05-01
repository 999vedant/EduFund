package com.example.edufundfinal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TransactionTrackerActivity extends AppCompatActivity {

    private EditText spentOnEditText, spentAmountEditText, modeEditText;
    private Button addButton;
    private TextView transactionHistoryTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_tracker);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Initialize UI elements
        spentOnEditText = findViewById(R.id.spentOnEditText);
        spentAmountEditText = findViewById(R.id.spentAmountEditText);
        modeEditText = findViewById(R.id.modeEditText);
        addButton = findViewById(R.id.addButton);
        transactionHistoryTextView = findViewById(R.id.transactionHistoryTextView);

        // Set click listener for the add button
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTransaction();
            }
        });
    }

    private void addTransaction() {
        // Get input values
        String spentOn = spentOnEditText.getText().toString();
        String spentAmount = spentAmountEditText.getText().toString();
        String mode = modeEditText.getText().toString();

        // Validate input values
        if (spentOn.isEmpty()) {
            spentOnEditText.setError("Item name is required");
            return;
        }
        if (spentAmount.isEmpty()) {
            spentAmountEditText.setError("Item cost is required");
            return;
        }

        // Parse spent amount as double
        double amount;
        try {
            amount = Double.parseDouble(spentAmount);
        } catch (NumberFormatException e) {
            spentAmountEditText.setError("Invalid item cost");
            return;
        }

        // Add transaction to history
        String transaction = "Spent on: " + spentOn + "\n" +
                "Amount: " + amount + "\n" +
                "Mode: " + mode + "\n\n";
        transactionHistoryTextView.append(transaction);

        // Clear input fields
        spentOnEditText.setText("");
        spentAmountEditText.setText("");
        modeEditText.setText("");

        // Scroll to the bottom of the transaction history
        ScrollView scrollView = findViewById(R.id.transactionHistoryScrollView);
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(View.FOCUS_DOWN);
            }
        });
    }
}