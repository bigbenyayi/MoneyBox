package com.example.minimoneybox;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.TextView;

public class UserAccountActivity extends AppCompatActivity {

    /////////////// Views \\\\\\\\\\\\\\\\
    //Textviews
    TextView nameTV;
    TextView totalPlanValueTV;

    //Cardviews
    CardView isaCV;
    CardView giaCV;
    CardView lisaCV;
    CardView pensionCV;

    ////////////// Variables \\\\\\\\\\\\\\\
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account);

        gettingIntentExtras();
        fetchingViews();
        displayingTVs();
        settingOnClickListeners();
    }

    private void settingOnClickListeners() {
        isaCV.setOnClickListener((View v) -> startIndividualAccountActivity("Stocks and Shares ISA"));
        giaCV.setOnClickListener((View v) -> startIndividualAccountActivity("General Investment Account"));
        lisaCV.setOnClickListener((View v) -> startIndividualAccountActivity("Lifetime ISA"));
        pensionCV.setOnClickListener((View v) -> startIndividualAccountActivity("Pension"));
    }

    private void startIndividualAccountActivity(String account) {
        Intent intent = new Intent(UserAccountActivity.this, IndividualAccount.class);
        intent.putExtra("account", account);
        startActivity(intent);

    }

    private void displayingTVs() {
        //Making part of the TextView bold and a different colour
        final SpannableStringBuilder sbName = new SpannableStringBuilder("Hello " + name + "!");
        final ForegroundColorSpan fcsName = new ForegroundColorSpan(Color.parseColor("#516272"));
        final StyleSpan bss = new StyleSpan(android.graphics.Typeface.BOLD);
        if (name.equals("")) {
            sbName.setSpan(fcsName, 0, 0, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            sbName.setSpan(bss, 0, sbName.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);

        } else {
            sbName.setSpan(fcsName, 0, 5, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            sbName.setSpan(bss, 6, sbName.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        }

        nameTV.setText(sbName);

        //Making part of the TextView bold and a different colour
        final SpannableStringBuilder sbTPV = new SpannableStringBuilder("Total Plan Value: 7000£");
        final ForegroundColorSpan fcsTPV = new ForegroundColorSpan(Color.parseColor("#516272"));
        final StyleSpan bssTPV = new StyleSpan(android.graphics.Typeface.BOLD);
        sbTPV.setSpan(fcsTPV, 0, 17, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        sbTPV.setSpan(bssTPV, 18, sbTPV.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);

        totalPlanValueTV.setText(sbTPV);
    }

    private void fetchingViews() {
        nameTV = findViewById(R.id.accountNameTV);
        totalPlanValueTV = findViewById(R.id.totalPlanValueTV);
        isaCV = findViewById(R.id.isaCV);
        giaCV = findViewById(R.id.giaCV);
        lisaCV = findViewById(R.id.lisaCV);
        pensionCV = findViewById(R.id.pensionCV);
    }

    private void gettingIntentExtras() {
        //Receiving intent Extras from LoginActivity
        Intent intent = getIntent();
        if (intent.getStringExtra("name") != null) {
            name = intent.getStringExtra("name");
        }
    }

//    private String ApiCall(){
//        String email = emailText.getText().toString();
//        // Do some validation here
//
//        try {
//            URL url = new URL("https://api-test01.moneyboxapp.com/" + "email=" + email + "&password=" + password);
//            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//            try {
//                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
//                StringBuilder stringBuilder = new StringBuilder();
//                String line;
//                while ((line = bufferedReader.readLine()) != null) {
//                    stringBuilder.append(line).append("\n");
//                }
//                bufferedReader.close();
//                return stringBuilder.toString();
//            }
//            finally{
//                urlConnection.disconnect();
//            }
//        }
//        catch(Exception e) {
//            Log.e("ERROR", e.getMessage(), e);
//            return null;
//        }
//    }
}
