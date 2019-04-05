package com.example.minimoneybox.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.minimoneybox.Api.Api;
import com.example.minimoneybox.Models.InverstorProducts;
import com.example.minimoneybox.Models.ProductResponse;
import com.example.minimoneybox.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class UserAccountActivity extends AppCompatActivity {

    /////////////// Views \\\\\\\\\\\\\\\\
    //Textviews
    TextView nameTV;

    TextView totalPlanValueTV;

    TextView pensionMoneyBoxTV;
    TextView pensionPlanValueTV;

    TextView lisaMoneyBoxTV;
    TextView lisaPlanValueTV;

    TextView isaMoneyBoxTV;
    TextView isaPlanValueTV;

    TextView giaMoneyBoxTV;
    TextView giaPlanValueTV;


    //Cardviews
    CardView isaCV;
    CardView giaCV;
    CardView lisaCV;
    CardView pensionCV;

    ////////////// Variables \\\\\\\\\\\\\\\
    String name;

    //Value for API response
    Integer totalPlanValue;

    Double isaPlanValue;
    Integer isaMoneyBox;
    Integer isaInvestorProductId;

    Double giaPlanValue;
    Integer giaMoneyBox;
    Integer giaInvestorProductId;

    Double lisaPlanValue;
    Integer lisaMoneyBox;
    Integer lisaInvestorProductId;

    Double pensionPlanValue;
    Integer pensionMoneyBox;
    Integer pensionInvestorProductId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account);

        gettingDataForUser();
        gettingIntentExtras();
        fetchingViews();
        displayingTVs();
        settingOnClickListeners();
    }

    private void gettingDataForUser() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        Api api = retrofit.create(Api.class);
        SharedPreferences mPrefs = getSharedPreferences("shared_prefs", MODE_PRIVATE);
        Call<InverstorProducts> call = api.getInvestorProducts("Bearer " + mPrefs.getString("bearer", ""),
                "3a97b932a9d449c981b595",
                "application/json",
                "5.10.0",
                "3.0.0");

        call.enqueue(new Callback<InverstorProducts>() {
            @Override
            public void onResponse(Call<InverstorProducts> call, Response<InverstorProducts> response) {
                if (response.body() != null) {
                    InverstorProducts responseObject = response.body();
                    List<ProductResponse> listResponse = responseObject.getProductResponses();
                    SharedPreferences mPrefs = getSharedPreferences("shared_prefs", MODE_PRIVATE);

                    totalPlanValue = responseObject.getTotalPlanValue();
                    mPrefs.edit().putInt("totalPlanValue", responseObject.getTotalPlanValue()).apply();

                    for (int i = 0; i < listResponse.size(); i++) {

                        switch (listResponse.get(i).getProduct().getName()) {

                            case "ISA":
                                isaPlanValue = listResponse.get(i).getPlanValue();
                                isaMoneyBox = listResponse.get(i).getMoneybox();
                                isaInvestorProductId = listResponse.get(i).getId();
                                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1);
                                params.setMargins(20,20,20,20);
                                isaCV.setLayoutParams(params);
                                break;

                            case "LISA":
                                lisaPlanValue = listResponse.get(i).getPlanValue();
                                lisaMoneyBox = listResponse.get(i).getMoneybox();
                                lisaInvestorProductId = listResponse.get(i).getId();
                                LinearLayout.LayoutParams lisaParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1);
                                lisaParams.setMargins(20,20,20,20);
                                lisaCV.setLayoutParams(lisaParams);
                                break;

                            case "GIA":
                                giaPlanValue = listResponse.get(i).getPlanValue();
                                giaMoneyBox = listResponse.get(i).getMoneybox();
                                giaInvestorProductId = listResponse.get(i).getId();
                                LinearLayout.LayoutParams giaParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1);
                                giaParams.setMargins(20,20,20,20);
                                giaCV.setLayoutParams(giaParams);
                                break;

                            case "PENSION":
                                pensionPlanValue = listResponse.get(i).getPlanValue();
                                pensionMoneyBox = listResponse.get(i).getMoneybox();
                                pensionInvestorProductId = listResponse.get(i).getId();
                                LinearLayout.LayoutParams pensionParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1);
                                pensionParams.setMargins(20,20,20,20);
                                pensionCV.setLayoutParams(pensionParams);
                                break;
                        }
                    }

                    totalPlanValueTV.setText("Total Plan Value: £" + totalPlanValue);

                    isaPlanValueTV.setText("Plan Value: £" + isaPlanValue);
                    isaMoneyBoxTV.setText("MoneyBox: £" + isaMoneyBox);

                    lisaPlanValueTV.setText("Plan Value: £" + lisaPlanValue);
                    lisaMoneyBoxTV.setText("MoneyBox: £" + lisaMoneyBox);

                    giaPlanValueTV.setText("Plan Value: £" + giaPlanValue);
                    giaMoneyBoxTV.setText("MoneyBox: £" + giaMoneyBox);

                    pensionPlanValueTV.setText("Plan Value: £" + pensionPlanValue);
                    pensionMoneyBoxTV.setText("MoneyBox: £" + pensionMoneyBox);

                    //Making part of the TextView bold and a different colour
                    final SpannableStringBuilder sbTPV = new SpannableStringBuilder(totalPlanValueTV.getText().toString());
                    final ForegroundColorSpan fcsTPV = new ForegroundColorSpan(Color.parseColor("#516272"));
                    final StyleSpan bssTPV = new StyleSpan(android.graphics.Typeface.BOLD);
                    sbTPV.setSpan(fcsTPV, 0, 17, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                    sbTPV.setSpan(bssTPV, 18, sbTPV.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);

                    totalPlanValueTV.setText(sbTPV);
                }
            }

            @Override
            public void onFailure(Call<InverstorProducts> call, Throwable t) {
                Toast.makeText(UserAccountActivity.this, "Failure " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void settingOnClickListeners() {
        isaCV.setOnClickListener((View v) -> startIndividualAccountActivity("Stocks and Shares ISA", isaMoneyBox, isaPlanValue, isaInvestorProductId));
        giaCV.setOnClickListener((View v) -> startIndividualAccountActivity("General Investment Account", giaMoneyBox, giaPlanValue, giaInvestorProductId));
        lisaCV.setOnClickListener((View v) -> startIndividualAccountActivity("Lifetime ISA", lisaMoneyBox, lisaPlanValue, lisaInvestorProductId));
        pensionCV.setOnClickListener((View v) -> startIndividualAccountActivity("Pension", pensionMoneyBox, pensionPlanValue, pensionInvestorProductId));

    }

    private void startIndividualAccountActivity(String account, Integer moneyBox, Double planValue, Integer investorProductId) {
        Intent intent = new Intent(UserAccountActivity.this, IndividualAccount.class);
        intent.putExtra("account", account);
        intent.putExtra("moneyBox", moneyBox);
        intent.putExtra("planValue", planValue);
        intent.putExtra("investorProductId", investorProductId);
        startActivity(intent);

    }

    private void displayingTVs() {

        //Making part of the TextView bold and a different colour
        final SpannableStringBuilder sbName = new SpannableStringBuilder("Hello " + name + "!");
        final ForegroundColorSpan fcsName = new ForegroundColorSpan(Color.parseColor("#516272"));
        final StyleSpan bss = new StyleSpan(android.graphics.Typeface.BOLD);
        //For testing only
        if (name == null){
            name = "Benjamin";
        }
        if (name.equals("")) {
            sbName.setSpan(fcsName, 0, 0, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            sbName.setSpan(bss, 0, sbName.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);

        } else {
            sbName.setSpan(fcsName, 0, 5, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            sbName.setSpan(bss, 6, sbName.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        }

        nameTV.setText(sbName);
    }

    private void fetchingViews() {
        nameTV = findViewById(R.id.accountNameTV);
        totalPlanValueTV = findViewById(R.id.totalPlanValueTV);
        isaCV = findViewById(R.id.isaCV);
        giaCV = findViewById(R.id.giaCV);
        lisaCV = findViewById(R.id.lisaCV);
        pensionCV = findViewById(R.id.pensionCV);

        pensionMoneyBoxTV = findViewById(R.id.pensionMoneyBox);
        pensionPlanValueTV = findViewById(R.id.pensionPlanValue);
        lisaMoneyBoxTV = findViewById(R.id.lisaMoneyBox);
        lisaPlanValueTV = findViewById(R.id.lisaPlanValue);
        isaMoneyBoxTV = findViewById(R.id.isaMoneyBox);
        isaPlanValueTV = findViewById(R.id.isaPlanValue);
        giaMoneyBoxTV = findViewById(R.id.giaMoneyBox);
        giaPlanValueTV = findViewById(R.id.giaPlanValue);
    }

    private void gettingIntentExtras() {
        //Receiving intent Extras from LoginActivity
        Intent intent = getIntent();
        if (intent.getStringExtra("name") != null) {
            name = intent.getStringExtra("name");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        gettingDataForUser();
        settingOnClickListeners();
    }
}
