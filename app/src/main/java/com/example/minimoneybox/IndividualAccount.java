package com.example.minimoneybox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class IndividualAccount extends AppCompatActivity {

    /////////////// Views \\\\\\\\\\\\\\\\
    //Textviews
    TextView accountNameTV;

    ////////////// Variables \\\\\\\\\\\\\\\
    String account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_account);

        gettingIntentExtras();
        fetchingViews();
        displayingTitle();
    }

    private void displayingTitle() {
        accountNameTV.setText(account);
    }

    private void fetchingViews() {
        accountNameTV = findViewById(R.id.accountNameTV);
    }

    private void gettingIntentExtras() {
        //Receiving intent Extras from LoginActivity
        Intent intent = getIntent();
        if (intent.getStringExtra("account") != null) {
            account = intent.getStringExtra("account");
        }
    }

}
