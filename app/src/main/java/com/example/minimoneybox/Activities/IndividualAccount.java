package com.example.minimoneybox.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.example.minimoneybox.Api.Api;
import com.example.minimoneybox.Models.OneOffPaymentRequest;
import com.example.minimoneybox.Models.OneOffPayments;
import com.example.minimoneybox.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class IndividualAccount extends AppCompatActivity {

    /////////////// Views \\\\\\\\\\\\\\\\
    //Textviews
    TextView accountNameTV;
    TextView planValueValueTV;
    TextView moneyBoxValueTV;
    //Button
    Button addMoneyButton;
    //ProgressBar
    ProgressBar progressBar;

    ////////////// Variables \\\\\\\\\\\\\\\
    String account;
    Integer moneyBox;
    Double planValue;
    Integer investorProductId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_account);

        gettingIntentExtras();
        fetchingViews();
        displayingValuesInTVs();
        dealingWithButtonClick();
    }

    private void dealingWithButtonClick() {
        addMoneyButton.setOnClickListener(v -> {

            progressBar.setVisibility(View.VISIBLE);
            SharedPreferences mPrefs = getSharedPreferences("shared_prefs", MODE_PRIVATE);
            Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
            Api api = retrofit.create(Api.class);
            Call<OneOffPayments> call1 = api.postOneOffPayments("Bearer " + mPrefs.getString("bearer", ""),
                    "3a97b932a9d449c981b595",
                    "application/json",
                    "5.10.0",
                    "3.0.0", new OneOffPaymentRequest(10, investorProductId));

            call1.enqueue(new Callback<OneOffPayments>() {
                @Override
                public void onResponse(Call<OneOffPayments> call, Response<OneOffPayments> response) {
                    if (response.body() != null) {
                        moneyBoxValueTV = findViewById(R.id.moneyBoxValueTV);
                        moneyBoxValueTV.setText("£" + response.body().getMoneybox());
                        progressBar.setVisibility(View.INVISIBLE);

                    }
                }

                @Override
                public void onFailure(Call<OneOffPayments> call, Throwable t) {
                    Toast.makeText(IndividualAccount.this, "Failure " + t.getMessage(), Toast.LENGTH_LONG).show();

                }
            });
        });
    }

    private void displayingValuesInTVs() {
        accountNameTV.setText(account);
        planValueValueTV.setText("£" + planValue);
        moneyBoxValueTV.setText("£" + moneyBox);
    }

    private void fetchingViews() {
        accountNameTV = findViewById(R.id.accountNameTV);
        planValueValueTV = findViewById(R.id.planValueValueTV);
        moneyBoxValueTV = findViewById(R.id.moneyBoxValueTV);
        addMoneyButton = findViewById(R.id.addMoneyButton);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);
    }

    private void gettingIntentExtras() {
        //Receiving intent Extras from LoginActivity
        Intent intent = getIntent();
        if (intent.getStringExtra("account") != null) {
            account = intent.getStringExtra("account");
            moneyBox = intent.getIntExtra("moneyBox", 0);
            planValue = intent.getDoubleExtra("planValue", 0);
            investorProductId = intent.getIntExtra("investorProductId", 0);
        }
    }

}
